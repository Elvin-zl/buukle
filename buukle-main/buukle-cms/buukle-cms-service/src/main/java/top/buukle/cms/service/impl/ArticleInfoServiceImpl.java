package top.buukle.cms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import top.buukle.cms.dao.ArticleInfoMapper;
import top.buukle.cms.entity.ArticleInfo;
import top.buukle.cms.entity.ArticleInfoExample;
import top.buukle.cms.entity.vo.ArticleInfoQuery;
import top.buukle.cms.service.ArticleInfoService;
import top.buukle.cms.service.constants.ArticleEnums;
import top.buukle.cms.service.constants.SystemReturnEnum;
import top.buukle.cms.service.exception.SystemException;
import top.buukle.common.call.CommonResponse;
import top.buukle.common.call.FuzzyResponse;
import top.buukle.common.call.PageResponse;
import top.buukle.util.DateUtil;
import top.buukle.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
* @author elvin
* @description ArticleInfoService实现类
*/
@Service
public class ArticleInfoServiceImpl implements ArticleInfoService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private ArticleInfoMapper articleInfoMapper;

    /**
     * 分页获取列表
     * @param query 查询对象
     * @return PageResponse
     */
    @Override
    public PageResponse getPageList(ArticleInfoQuery query) {
        PageHelper.startPage(query.getPage(),query.getPageSize());
        List<ArticleInfo> articleInfoList = articleInfoMapper.selectByExample(this.assExampleForList(query));
        stringRedisTemplate.opsForValue().set("test","11111");
        PageInfo<ArticleInfo> pageInfo = new PageInfo<>(articleInfoList);
        return new PageResponse.Builder().build(articleInfoList,pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getTotal());
    }

    /**
     * 模糊搜素
     * @param fuzzyText 模糊的字符
     * @param fieldName 模糊字段名
     * @return FuzzyResponse
     */
    @Override
    public FuzzyResponse fuzzySearch(String fuzzyText, String fieldName) {
        // TODO 先暂时需要手动实现mybatis的mapper文件sql
        // return new FuzzyResponse.Builder().build(articleInfoMapper.fuzzySearch(fuzzyText,fieldName));
        return null;
    }

    /**
     * 保存记录
     * @param query  查询实体
     * @param request httpServletRequest
     * @return
     */
    @Override
    public CommonResponse save(ArticleInfoQuery query, HttpServletRequest request) {
        articleInfoMapper.insert(this.assQueryForInsert(query,request));
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * 根据id删除记录状态数据
     * @param query 更新数据实例
     * @param request httpServletRequest
     * @return
     */
    @Override
    public CommonResponse delete(ArticleInfoQuery query, HttpServletRequest request) {
        if(articleInfoMapper.updateByPrimaryKeySelective(this.assQueryForUpdateStatus(query, ArticleEnums.status.DELETED.value(),request)) != 1){
            throw new SystemException(SystemReturnEnum.DELETE_INFO_EXCEPTION);
        }
        return new CommonResponse.Builder().buildSuccess();
    }


    /**
     * 更新记录
     * @param query
     * @param request
     * @return
     */
    @Override
    public CommonResponse update(ArticleInfoQuery query, HttpServletRequest request) {
        ArticleInfoExample articleInfoExample = new ArticleInfoExample();
        ArticleInfoExample.Criteria criteria = articleInfoExample.createCriteria();
        criteria.andIdEqualTo(query.getId());
//        User operator = securityClient.getUserInfo(request);
        query.setGmtModified(new Date());
//        query.setModifier(operator.getUsername());
//        query.setModifierCode(operator.getUserId());
        articleInfoMapper.updateByExampleSelective(query,articleInfoExample);
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * 查询记录详情
     * @param query 查询实体
     * @return ArticleInfo
     */
    @Override
    public ArticleInfo getById(ArticleInfoQuery query) {
        return articleInfoMapper.selectByPrimaryKey(query.getId());
    }

    /**
     * 组装文章查询Example实体
     * @param query
     * @param statusList
     * @return
     */
    private ArticleInfoExample assExampleForList(ArticleInfoQuery query, List<Integer> statusList) {
        ArticleInfoExample example = new ArticleInfoExample();
        ArticleInfoExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotEmpty(query.getStartTime())){
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
        example.orderBy("gmt_created desc");
        return example;
    }


    /**
     * 组装新增实体
     * @param query
     * @param request
     * @return
     */
    private ArticleInfo assQueryForInsert(ArticleInfoQuery query, HttpServletRequest request) {
////        User operator = securityClient.getUserInfo(request);
////        query.setGmtCreated(new Date());
////        query.setCreator(operator.getUsername());
////        query.setCreatorCode(operator.getUserId());
////        query.setArticleAuthor(operator.getUsername());
////        query.setUserId(operator.getUserId());
////        query.setLikeNumber(NumberUtil.LONG_ZERO);
////        query.setBak01(NumberUtil.LONG_ZERO.toString());
////        query.setPlatformId(operator.getPlatformId());
////        query.setAgentId(operator.getAgentId());
////        query.setGroupId(operator.getGroupId());
//        query.setSalesmanId(operator.getSalesmanId());
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
//        User operator = securityClient.getUserInfo(request);
        ArticleInfoQuery infoQuery = new ArticleInfoQuery();
        infoQuery.setId(query.getId());
        infoQuery.setStatus(status);
        infoQuery.setGmtModified(new Date());
//        infoQuery.setModifier(operator.getUsername());
//        infoQuery.setModifierCode(operator.getUserId());
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
        }
        return example;
    }
}