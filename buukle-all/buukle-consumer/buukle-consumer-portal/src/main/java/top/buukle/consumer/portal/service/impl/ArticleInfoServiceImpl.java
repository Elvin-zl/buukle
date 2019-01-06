package top.buukle.consumer.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.common.DateUtil;
import top.buukle.common.util.common.NumberUtil;
import top.buukle.common.util.common.StringUtil;
import top.buukle.common.util.jedis.RedisZSet;
import top.buukle.common.util.logger.BaseLogger;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.consumer.portal.constants.ArticleInfoConstants;
import top.buukle.consumer.portal.constants.CacheConstants;
import top.buukle.consumer.portal.constants.StatusConstants;
import top.buukle.consumer.portal.dao.ArticleInfoMapper;
import top.buukle.consumer.portal.entity.*;
import top.buukle.consumer.portal.entity.vo.*;
import top.buukle.consumer.portal.invoker.RedisInvoker;
import top.buukle.consumer.portal.service.*;
import top.buukle.consumer.portal.vo.ArticleInformationVo;
import top.buukle.consumer.portal.vo.ArticlePublishVo;
import top.buukle.consumer.portal.vo.MapKeyComparator;
import top.buukle.plugin.security.client.SecurityClient;
import top.buukle.plugin.security.entity.User;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
* @author elvin
* @description ArticleInfoService实现类
*/
@Service
public class ArticleInfoServiceImpl implements ArticleInfoService {

    private static final BaseLogger LOGGER = BaseLogger.getLogger(ArticleInfoServiceImpl.class);
    @Autowired
    private ArticleInfoMapper articleInfoMapper;

    @Autowired
    private ArticleDescService articleDescService;

    @Autowired
    private ArticleContentService articleContentService;

    @Autowired
    private ArticleCatService articleCatService;

    @Autowired
    private SecurityClient securityClient;

    @Autowired
    private UserArticlePraiseRelationService userArticlePraiseRelationService;

    /**
    * 分页获取列表
    * @param query
    * @param pageBounds
    * @return
    */
    @Override
    public PageResponse<ArticleInformationVo> getArticleInfoList(ArticleInfoQuery query, PageBounds pageBounds) throws InvocationTargetException, IllegalAccessException {
        PageHelper.startPage(pageBounds.getPage(), pageBounds.getLimit());
        List<ArticleInfo> articleInfos = articleInfoMapper.selectByExample(this.assExampleForList(query));
        PageResponse<ArticleInfo> infoPageResponse = new PageResponse.Builder().build(new PageInfo<>(articleInfos));
        List<ArticleInformationVo> voList = new ArrayList<>();
        // 查询文章摘要和分类信息 TODO 优化成一条sql
        for (ArticleInfo articleInfo: articleInfos) {
            ArticleInformationVo articleInformationVo = new ArticleInformationVo();
            //组装articleInfo
            articleInformationVo.setArticleInfo(articleInfo);
            //查询并组装articleDesc
            ArticleDescQuery articleDescQuery = new ArticleDescQuery();
            articleDescQuery.setArticleInfoId(articleInfo.getId());
            articleInformationVo.setArticleDesc(null == articleDescService.getArticleDescDetail(articleDescQuery) ? StringUtil.EMPTY:articleDescService.getArticleDescDetail(articleDescQuery).getArticleDesc());
            //查询并组装 articleCat
            if(articleInfo.getArticleCatId() != null){
                ArticleCatQuery articleCatQuery = new ArticleCatQuery();
                articleCatQuery.setId(articleInfo.getArticleCatId());
                articleInformationVo.setArticleCat(articleCatService.getArticleCatDetail(articleCatQuery));
            }
            voList.add(articleInformationVo);
        }
        //复制分页参数
        PageResponse<ArticleInformationVo> voPageResponse = new PageResponse.Builder().build(new PageInfo<>());
        BeanUtils.copyProperties(voPageResponse,infoPageResponse);
        voPageResponse.setData(voList);
        return voPageResponse;
    }

    /**
     * 查询文章点赞数目
     * @param id
     * @return
     */
    private Long getArticleLikeNumber(Integer id) {
        return null;
    }

    /**
    * 模糊搜素
    * @param fuzzyText
    * @return
    */
    @Override
    public List<FuzzySearchListVo> fuzzySearchByText(String fuzzyText) {
        List<ArticleInfo> list = articleInfoMapper.selectByExample(this.assFuzzyExample(fuzzyText));
        List<FuzzySearchListVo> fuzzySearchListVos = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(list)){
            for (ArticleInfo item: list) {
                FuzzySearchListVo fuzzySearchListVo = new FuzzySearchListVo();
                fuzzySearchListVo.setText(item.getTitle());
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
    public BaseResponse deleteArticleInfo(ArticleInfoQuery query, HttpServletRequest request) {
        if(articleInfoMapper.updateByPrimaryKeySelective(this.assQueryForUpdateStatus(query, StatusConstants.STATUS_DELETED_CONCEALABLE,request)) != 1){
            throw new BaseException(BaseResponseCode.STATUS_UPDATE_FAIL);
        }
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
    * 查询记录详情
    * @param query
    * @return
    */
    @Override
    public ArticleInfo getArticleInfoDetail(ArticleInfoQuery query) {
        return articleInfoMapper.selectByPrimaryKey(query.getId());
    }

    /**
    * 保存记录
    * @param query
    * @param request
    * @return
    */
    @Override
    public BaseResponse saveArticleInfo(ArticleInfoQuery query, HttpServletRequest request) {
        articleInfoMapper.insert(this.assQueryForInsert(query,request));
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    */
    @Override
    public BaseResponse updateArticleInfo(ArticleInfoQuery query, HttpServletRequest request) {
        ArticleInfoExample articleInfoExample = new ArticleInfoExample();
        ArticleInfoExample.Criteria criteria = articleInfoExample.createCriteria();
        criteria.andIdEqualTo(query.getId());
        criteria.andLikeNumberEqualTo(query.getLikeNumber());
        User operator = securityClient.getUserInfo(request);
        query.setGmtModified(new Date());
        query.setModifier(operator.getUsername());
        query.setModifierCode(operator.getUserId());
        articleInfoMapper.updateByExampleSelective(query,articleInfoExample);
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
     * 获取我的文章列表
     * @param query
     * @param pageBounds
     * @return
     */
    @Override
    public PageResponse<ArticleInfo> getUserArticleInfoList(ArticleInfoQuery query, PageBounds pageBounds) {
        PageHelper.startPage(pageBounds.getPage(), pageBounds.getLimit());
        return new PageResponse.Builder().build(new PageInfo<>(articleInfoMapper.selectByExample(this.assExampleForList(query,StatusConstants.ARTICLE_VERSION_STATUS_LIST_CMS))));
    }

    /**
     * 获取文章审核列表
     * @param query
     * @param pageBounds
     * @return
     */
    @Override
    public PageResponse<ArticleInfo> getAuditArticleInfoList(ArticleInfoQuery query, PageBounds pageBounds) {
        PageHelper.startPage(pageBounds.getPage(), pageBounds.getLimit());
        return new PageResponse.Builder().build(new PageInfo<>(articleInfoMapper.selectByExample(this.assExampleForList(query,StatusConstants.ARTICLE_VERSION_STATUS_LIST_CMS))));
    }

    /**
     * 发布文章
     * @param publishVo
     * @param request
     * @return
     */
    @Override
    public BaseResponse doPublish(ArticlePublishVo publishVo, HttpServletRequest request) throws InvocationTargetException, IllegalAccessException {
        this.paramValidate(publishVo);
        // 组装并保存文章
        ArticleInfoQuery articleInfoQuery = new ArticleInfoQuery();
        BeanUtils.copyProperties(articleInfoQuery,publishVo);
        articleInfoQuery.setStatus(StatusConstants.STATUS_WAITING_FOR_AUDIT_PUBLISH);
        articleInfoMapper.insert(this.assQueryForInsert(articleInfoQuery,request));
        // 组装并保存摘要
        ArticleDescQuery articleDescQuery = new ArticleDescQuery();
        articleDescQuery.setArticleDesc(publishVo.getArticleDesc());
        articleDescQuery.setArticleInfoId(articleInfoQuery.getId());
        articleDescService.saveArticleDesc(articleDescQuery,request);
        // 组装并保存内容
        ArticleContentQuery articleContentQuery = new ArticleContentQuery();
        articleContentQuery.setArticleContent(publishVo.getArticleContent());
        articleContentQuery.setArticleInfoId(articleInfoQuery.getId());
        articleContentService.saveArticleContent(articleContentQuery,request);
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
     * 草稿文章
     * @param publishVo
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public BaseResponse doDraft(ArticlePublishVo publishVo, HttpServletRequest request) throws Exception {
        this.paramValidate(publishVo);
        // 组装并保存文章
        ArticleInfoQuery articleInfoQuery = new ArticleInfoQuery();
        BeanUtils.copyProperties(articleInfoQuery,publishVo);
        articleInfoQuery.setStatus(StatusConstants.STATUS_DRAFT);
        articleInfoMapper.insert(this.assQueryForInsert(articleInfoQuery,request));
        // 组装并保存摘要
        ArticleDescQuery articleDescQuery = new ArticleDescQuery();
        articleDescQuery.setArticleDesc(publishVo.getArticleDesc());
        articleDescQuery.setArticleInfoId(articleInfoQuery.getId());
        articleDescService.saveArticleDesc(articleDescQuery,request);
        // 组装并保存内容
        ArticleContentQuery articleContentQuery = new ArticleContentQuery();
        articleContentQuery.setArticleContent(publishVo.getArticleContent());
        articleContentQuery.setArticleInfoId(articleInfoQuery.getId());
        articleContentService.saveArticleContent(articleContentQuery,request);
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
     * 查看文章详情
     *
     * @param request
     * @param query
     * @param isPortal
     * @return
     */
    @Override
    public ArticleInformationVo getArticleAllInformation(HttpServletRequest request, ArticleInfoQuery query, Boolean isPortal) {
        // 查询文章主表记录
        ArticleInfo articleInfo = articleInfoMapper.selectByPrimaryKey(query.getId());
        if(null == articleInfo){
            return null;
        }
        ArticleInformationVo informationVo = new ArticleInformationVo();
        informationVo.setArticleInfo(articleInfo);
        // 发送消息,用于异步统计访问量
        // 查询前台相关记录
        if(isPortal){
            // 查询文章作者记录
            informationVo.setArticleAuthor(securityClient.getArticleAuthor(articleInfo.getUserId()));
            // 查询用户文章点赞关系记录
            User userInfo = null;
            try{
                userInfo = securityClient.getUserInfo(request);
            }
            catch(Exception e){
                //查询用户信息失败
                LOGGER.info("查询用户信息失败!不能正确显示用户登录信息,原因 : {}",e.getMessage());
            }
            if(null != userInfo){
            }

        }
        // 查询文章摘要记录
        ArticleDescQuery articleDescQuery = new ArticleDescQuery();
        articleDescQuery.setArticleInfoId(query.getId());
        ArticleDesc articleDescDetail = articleDescService.getArticleDescDetail(articleDescQuery);
        informationVo.setArticleDesc(null == articleDescDetail ? "" : articleDescDetail.getArticleDesc());

        // 查询文章内容记录
        ArticleContentQuery articleContentQuery = new ArticleContentQuery();
        articleContentQuery.setArticleInfoId(query.getId());
        ArticleContent articleContentDetail = articleContentService.getArticleContentDetail(articleContentQuery);
        informationVo.setArticleContent(null == articleContentDetail? "" : articleContentDetail.getArticleContent());

        // 查询文章分类记录
        ArticleCatQuery articleCatQuery = new ArticleCatQuery();
        articleCatQuery.setId(articleInfo.getArticleCatId());
        informationVo.setArticleCat(articleCatService.getArticleCatDetail(articleCatQuery));
        return informationVo;
    }

    /**
     * 提/降赞
     * @param articleInfoQuery
     * @param request
     */
    @Override
    public void updateLikeNumber(ArticleInfoQuery articleInfoQuery, HttpServletRequest request) {
        if(articleInfoMapper.updateByPrimaryKeySelective(this.assQueryForUpdateAddLikeNumber(articleInfoQuery)) != 1){
            throw new BaseException(BaseResponseCode.STATUS_UPDATE_FAIL);
        }
    }

    /**
     * 组装提赞参数
     * @param articleInfoQuery
     * @return
     */
    private ArticleInfo assQueryForUpdateAddLikeNumber(ArticleInfoQuery articleInfoQuery) {
        ArticleInfo articleInfo = new ArticleInfo();
        articleInfo.setId(articleInfoQuery.getId());
        articleInfo.setLikeNumber(articleInfoQuery.getLikeNumber());
        return articleInfo;
    }

    /**
     * 校验发布参数
     * @param publishVo
     */
    private void paramValidate(ArticlePublishVo publishVo) {
        if(StringUtil.isEmpty(publishVo.getTitle())){
            throw new BaseException(BaseResponseCode.ARTICLE_PUBLISH_FAILED_TITLE_NULL);
        }
        if(StringUtil.isEmpty(publishVo.getArticleDesc())){
            throw new BaseException(BaseResponseCode.ARTICLE_PUBLISH_FAILED_DESC_NULL);
        }
        if(StringUtil.isEmpty(publishVo.getArticleContent())){
            throw new BaseException(BaseResponseCode.ARTICLE_PUBLISH_FAILED_CONTENT_NULL);
        }
        if(null == publishVo.getArticleCatId()){
            throw new BaseException(BaseResponseCode.ARTICLE_PUBLISH_FAILED_PID_NULL);
        }
    }

    /**
     * 组装文章查询Example实体
     * @param query
     * @param statusList
     * @return
     */
    private ArticleInfoExample assExampleForList(ArticleInfoQuery query, List statusList) {
        ArticleInfoExample example = new ArticleInfoExample();
        ArticleInfoExample.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(query.getStartTime())){
            criteria.andGmtCreatedGreaterThanOrEqualTo(DateUtil.parse(query.getStartTime()));
        }
        if(StringUtil.isNotEmpty(query.getEndTime())){
            criteria.andGmtCreatedLessThanOrEqualTo(DateUtil.parse(query.getEndTime()));
        }
        if(StringUtil.isNotEmpty(query.getTitle())){
            criteria.andTitleEqualTo(query.getTitle());
        }
        if(null == query.getStatus()){
            criteria.andStatusIn(statusList);
        }else{
            criteria.andStatusEqualTo(query.getStatus());
        }
        return example;
    }


    /**
    * 组装新增实体
    * @param query
    * @param request
    * @return
    */
    private ArticleInfo assQueryForInsert(ArticleInfoQuery query, HttpServletRequest request) {
        User operator = securityClient.getUserInfo(request);
        query.setGmtCreated(new Date());
        query.setCreator(operator.getUsername());
        query.setCreatorCode(operator.getUserId());
        query.setPlatformId(operator.getPlatformId());
        query.setAgentId(operator.getAgentId());
        query.setGroupId(operator.getGroupId());
        query.setSalesmanId(operator.getSalesmanId());
        return query;
    }

    /**
    * 组装更新状态实体
    * @param query
    * @param status
    * @param request
    * @return
    */
    private ArticleInfo assQueryForUpdateStatus(ArticleInfoQuery query, Integer status, HttpServletRequest request) {
        User operator = securityClient.getUserInfo(request);
        ArticleInfoQuery infoQuery = new ArticleInfoQuery();
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
    private ArticleInfoExample assExampleForList(ArticleInfoQuery query) {
        ArticleInfoExample example = new ArticleInfoExample();
        ArticleInfoExample.Criteria criteria = example.createCriteria();
        if(query.getArticleCatId() != null){
            criteria.andArticleCatIdEqualTo(query.getArticleCatId());
        }
        if(StringUtil.isNotEmpty(query.getStartTime())){
            criteria.andGmtCreatedGreaterThanOrEqualTo(DateUtil.parse(query.getStartTime()));
        }
        if(StringUtil.isNotEmpty(query.getEndTime())){
            criteria.andGmtCreatedLessThanOrEqualTo(DateUtil.parse(query.getEndTime()));
        }
        if(StringUtil.isNotEmpty(query.getTitle())){
            criteria.andTitleEqualTo(query.getTitle());
        }
        if(null != query.getStatus()){
            criteria.andStatusEqualTo(query.getStatus());
        }else{
            criteria.andStatusIn(StatusConstants.ARTICLE_VERSION_STATUS_LIST_PORTAL);
        }
        if(query.getOrderFlag() == null || query.getOrderFlag().equals(ArticleInfoConstants.ORDER_BY_DEFAULT) || query.getOrderFlag().equals(ArticleInfoConstants.ORDER_BY_GMT_MODIFIED)){
            example.orderBy("gmt_created desc");
        }
        if(query.getOrderFlag().equals(ArticleInfoConstants.ORDER_BY_PRAISE)){
            example.orderBy("like_number desc");
        }
        if(query.getOrderFlag().equals(ArticleInfoConstants.ORDER_BY_SCAN)){
            example.orderBy("bak01 desc");
        }
        return example;
    }

    /**
    * 组装模糊搜索Example
    * @param fuzzyText
    * @return
    */
    private ArticleInfoExample assFuzzyExample(String fuzzyText) {
        ArticleInfoExample example = new ArticleInfoExample();
        ArticleInfoExample.Criteria criteria = example.createCriteria();
        criteria.andTitleLike("%" + fuzzyText + "%");
        return example;
    }
}