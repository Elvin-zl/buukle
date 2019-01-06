package top.buukle.consumer.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.common.DateUtil;
import top.buukle.common.util.common.NumberUtil;
import top.buukle.common.util.common.StringUtil;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.consumer.portal.constants.ArticleCatConstants;
import top.buukle.consumer.portal.constants.StatusConstants;
import top.buukle.consumer.portal.dao.ArticleCatMapper;
import top.buukle.consumer.portal.entity.ArticleCat;
import top.buukle.consumer.portal.entity.ArticleCatExample;
import top.buukle.consumer.portal.entity.vo.ArticleCatQuery;
import top.buukle.consumer.portal.invoker.RedisInvoker;
import top.buukle.consumer.portal.service.ArticleCatService;
import top.buukle.consumer.portal.vo.ArticleCatTreeNodeVo;
import top.buukle.plugin.security.client.SecurityClient;
import top.buukle.plugin.security.entity.User;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* @author elvin
* @description ArticleCatService实现类
*/
@Service
public class ArticleCatServiceImpl implements ArticleCatService {

    @Autowired
    private ArticleCatMapper articleCatMapper;

    @Autowired
    private SecurityClient securityClient;

    /**
    * 分页获取列表
    * @param query
    * @param pageBounds
    * @return
    */
    @Override
    public PageResponse<ArticleCat> getArticleCatList(ArticleCatQuery query, PageBounds pageBounds) {
    PageHelper.startPage(pageBounds.getPage(), pageBounds.getLimit());
        return new PageResponse.Builder().build(new PageInfo<>(articleCatMapper.selectByExample(this.assExampleForList(query))));
    }

    /**
    * 模糊搜素
    * @param fuzzyText
    * @return
    */
    @Override
    public List<FuzzySearchListVo> fuzzySearchByText(String fuzzyText) {
        List<ArticleCat> list = articleCatMapper.selectByExample(this.assFuzzyExample(fuzzyText));
        List<FuzzySearchListVo> fuzzySearchListVos = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(list)){
            for (ArticleCat item: list) {
                FuzzySearchListVo fuzzySearchListVo = new FuzzySearchListVo();
                //fuzzySearchListVo.setText(item.getTitle());
                fuzzySearchListVos.add(fuzzySearchListVo);
            }
        }
        return fuzzySearchListVos;
        }

    /**
    * 根据id更新记录状态数据
    * @param query
    * @param request
    * @return
    */
    @Override
    public BaseResponse deleteArticleCat(ArticleCatQuery query, HttpServletRequest request) {
        if(articleCatMapper.updateByPrimaryKeySelective(this.assQueryForUpdateStatus(query, StatusConstants.STATUS_DELETED_CONCEALABLE,request)) != 1){
            throw new BaseException(BaseResponseCode.STATUS_UPDATE_FAIL);
        }
        //更新分类树缓存
        RedisInvoker.saveArticleCatList(new ArrayList<>());
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
    * 查询记录详情
    * @param query
    * @return
    */
    @Override
    public ArticleCat getArticleCatDetail(ArticleCatQuery query) {
        return articleCatMapper.selectByPrimaryKey(query.getId());
    }

    /**
    * 保存记录
    * @param query
    * @param request
    * @return
    */
    @Override
    public BaseResponse saveArticleCat(ArticleCatQuery query, HttpServletRequest request) {
        //处理根分类
        if(query.getPid().intValue() == -1){
            query.setPid(0l);
        }
        articleCatMapper.insert(this.assQueryForInsert(query,request));
        //更新分类树缓存
        RedisInvoker.saveArticleCatList(new ArrayList<>());
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    */
    @Override
    public BaseResponse updateArticleCat(ArticleCatQuery query, HttpServletRequest request) {
        ArticleCatExample articleCatExample = new ArticleCatExample();
        ArticleCatExample.Criteria criteria = articleCatExample.createCriteria();
        criteria.andIdEqualTo(query.getId());
        User operator = securityClient.getUserInfo(request);
        query.setGmtModified(new Date());
        query.setModifier(operator.getUsername());
        query.setModifierCode(operator.getUserId());
        articleCatMapper.updateByExampleSelective(query,articleCatExample);
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
     * 获取文章分类树
     * @return
     */
    @Override
    public List<ArticleCatTreeNodeVo> getArticleCatTree() {
        // 查询缓存
        List<ArticleCatTreeNodeVo> list = RedisInvoker.getArticleCatList();
        if(CollectionUtils.isEmpty(list)){
            // 缓存没有,查询数据库
            ArticleCatExample articleCatExample = new ArticleCatExample();
            ArticleCatExample.Criteria criteria = articleCatExample.createCriteria();
            criteria.andStatusEqualTo(StatusConstants.STATUS_OPEN);
            List<ArticleCat> articleCats = articleCatMapper.selectByExample(articleCatExample);
            if(CollectionUtils.isEmpty(articleCats)){
                return new ArrayList<>();
            }
            // 转化成树节点对象列表
            List<ArticleCatTreeNodeVo> articleCatTreeNodeVoList = new ArrayList<>();
            // 找出一级节点
            for (ArticleCat articleCat: articleCats) {
                if(articleCat.getPid().intValue() == NumberUtil.INTEGER_ZERO.intValue()){
                    ArticleCatTreeNodeVo articleCatTreeNodeVo = new ArticleCatTreeNodeVo();
                    articleCatTreeNodeVo.setId(articleCat.getId());
                    articleCatTreeNodeVo.setPid(Math.toIntExact(articleCat.getPid()));
                    articleCatTreeNodeVo.setName(articleCat.getArticleCat());
                    articleCatTreeNodeVoList.add(articleCatTreeNodeVo);
                }
            }
            // 为一级节点找到子节点
            for (ArticleCatTreeNodeVo articleCatTreeNodeVo: articleCatTreeNodeVoList) {
                this.assArticleCatSonsForTree(articleCats,articleCatTreeNodeVo);
            }

            //将列表存入缓存
            RedisInvoker.saveArticleCatList(articleCatTreeNodeVoList);
            return articleCatTreeNodeVoList;
        }
        return list;
    }

    /**
     * 获取文章父分类树
     * @return
     */
    @Override
    public List<ArticleCatTreeNodeVo> getArticleCatFatherTree() {
        List<ArticleCatTreeNodeVo> articleCatFatherTree = new ArrayList<>();
        ArticleCatTreeNodeVo root = new ArticleCatTreeNodeVo();
        root.setId(-1);
        root.setName(ArticleCatConstants.ROOT_NAME);
        root.setChildren(getArticleCatTree());
        articleCatFatherTree.add(root);
        return articleCatFatherTree;
    }

    /**
     * 递归调用寻找子节点
     * @param articleCats
     * @param articleCatTreeNodeVo
     */
    private void assArticleCatSonsForTree(List<ArticleCat> articleCats, ArticleCatTreeNodeVo articleCatTreeNodeVo) {
        for (ArticleCat articleCat: articleCats) {
            if(articleCat.getPid().intValue()== articleCatTreeNodeVo.getId().intValue()){
                ArticleCatTreeNodeVo vo = new ArticleCatTreeNodeVo();
                vo.setId(articleCat.getId());
                vo.setPid(Math.toIntExact(articleCat.getPid()));
                vo.setName(articleCat.getArticleCat());
                List<ArticleCatTreeNodeVo> children = articleCatTreeNodeVo.getChildren();
                if(CollectionUtils.isEmpty(children)){children = new ArrayList<>();}
                children.add(vo);
                articleCatTreeNodeVo.setChildren(children);
                this.assArticleCatSonsForTree(articleCats,vo);
            }
        }
    }

    /**
    * 组装新增实体
    * @param query
    * @param request
    * @return
    */
    private ArticleCat assQueryForInsert(ArticleCatQuery query, HttpServletRequest request) {
        User operator = securityClient.getUserInfo(request);
        query.setGmtCreated(new Date());
        query.setCreatorCode(operator.getUserId());
        query.setCreator(operator.getUsername());
        query.setPlatformId(operator.getPlatformId());
        query.setAgentId(operator.getAgentId());
        query.setGroupId(operator.getGroupId());
        query.setSalesmanId(operator.getSalesmanId());
        query.setStatus(StatusConstants.STATUS_OPEN);
        return query;
    }

    /**
    * 组装更新状态实体
    * @param query
    * @param status
    * @param request
    * @return
    */
    private ArticleCat assQueryForUpdateStatus(ArticleCatQuery query, Integer status, HttpServletRequest request) {
        User operator = securityClient.getUserInfo(request);
        ArticleCatQuery infoQuery = new ArticleCatQuery();
        infoQuery.setId(query.getId());
        infoQuery.setStatus(status);
        infoQuery.setGmtModified(new Date());
        infoQuery.setModifier(operator.getUsername());
        infoQuery.setModifierCode(operator.getUserId());
        return infoQuery;
    }

    /**
    * 组装分页参数
    * @param query
    * @return
    */
    private ArticleCatExample assExampleForList(ArticleCatQuery query) {
        ArticleCatExample example = new ArticleCatExample();
        ArticleCatExample.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(query.getStartTime())){
            criteria.andGmtCreatedGreaterThanOrEqualTo(DateUtil.parse(query.getStartTime()));
        }
        if(StringUtil.isNotEmpty(query.getEndTime())){
            criteria.andGmtCreatedLessThanOrEqualTo(DateUtil.parse(query.getEndTime()));
        }
        //TODO
        //if(StringUtil.isNotEmpty(query.getTitle())){
        //    criteria.andTitleEqualTo(query.getTitle());
        //}
        if(null != query.getStatus()){
            criteria.andStatusEqualTo(query.getStatus());
        }
        return example;
    }

    /**
    * 组装模糊搜索Example
    * @param fuzzyText
    * @return
    */
    private ArticleCatExample assFuzzyExample(String fuzzyText) {
        ArticleCatExample example = new ArticleCatExample();
        ArticleCatExample.Criteria criteria = example.createCriteria();
        //TODO
        //criteria.andTitleLike("%" + fuzzyText + "%");
        return example;
    }
}