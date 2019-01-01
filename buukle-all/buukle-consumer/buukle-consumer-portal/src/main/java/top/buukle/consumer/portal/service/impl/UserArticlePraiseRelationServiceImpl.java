package top.buukle.consumer.portal .service.impl;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.common.DateUtil;
import top.buukle.common.util.common.JsonUtil;
import top.buukle.common.util.common.NumberUtil;
import top.buukle.common.util.common.StringUtil;
import top.buukle.common.util.logger.BaseLogger;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.consumer.portal.constants.ArticleInfoConstants;
import top.buukle.consumer.portal.constants.AsyncTaskConstants;
import top.buukle.consumer.portal .constants.StatusConstants;
import top.buukle.consumer.portal.entity.ArticleInfo;
import top.buukle.consumer.portal.entity.AsyncTask;
import top.buukle.consumer.portal .entity.UserArticlePraiseRelationExample;
import top.buukle.consumer.portal.entity.vo.ArticleInfoQuery;
import top.buukle.consumer.portal.invoker.RedisInvoker;
import top.buukle.consumer.portal.service.ArticleInfoService;
import top.buukle.consumer.portal.util.ThreadPool.FixedTaskPoolWorker;
import top.buukle.consumer.portal.util.redis.distributeLock.DistributeCallable;
import top.buukle.consumer.portal.util.redis.distributeLock.DistributeLock;
import top.buukle.plugin.security.client.SecurityClient;
import top.buukle.plugin.security.entity.User;
import top.buukle.plugin.security.vo.query.PageBounds;
import top.buukle.plugin.security.vo.response.FuzzySearchListVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import top.buukle.consumer.portal .service.UserArticlePraiseRelationService;
import top.buukle.consumer.portal .dao.UserArticlePraiseRelationMapper;
import top.buukle.consumer.portal .entity.UserArticlePraiseRelation;
import top.buukle.consumer.portal .entity.vo.UserArticlePraiseRelationQuery;

import javax.servlet.http.HttpServletRequest;

/**
* @author elvin
* @description UserArticlePraiseRelationService实现类
*/
@Service
public class UserArticlePraiseRelationServiceImpl implements UserArticlePraiseRelationService{

    private static final BaseLogger LOGGER = BaseLogger.getLogger(UserArticlePraiseRelationServiceImpl.class);
    @Autowired
    private UserArticlePraiseRelationMapper userArticlePraiseRelationMapper;

    @Autowired
    private ArticleInfoService articleInfoService;

    @Autowired
    private SecurityClient securityClient;

    /**
    * 分页获取列表
    * @param query
    * @param pageBounds
    * @return
    */
    @Override
    public PageResponse<UserArticlePraiseRelation> getUserArticlePraiseRelationList(UserArticlePraiseRelationQuery query, PageBounds pageBounds) {
    PageHelper.startPage(pageBounds.getPage(), pageBounds.getLimit());
        return new PageResponse.Builder().build(new PageInfo<>(userArticlePraiseRelationMapper.selectByExample(this.assExampleForList(query))));
    }

    /**
    * 模糊搜素
    * @param fuzzyText
    * @return
    */
    @Override
    public List<FuzzySearchListVo> fuzzySearchByText(String fuzzyText) {
        List<UserArticlePraiseRelation> list = userArticlePraiseRelationMapper.selectByExample(this.assFuzzyExample(fuzzyText));
        List<FuzzySearchListVo> fuzzySearchListVos = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(list)){
            for (UserArticlePraiseRelation item: list) {
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
    public BaseResponse deleteUserArticlePraiseRelation(UserArticlePraiseRelationQuery query, HttpServletRequest request) {
        if(userArticlePraiseRelationMapper.updateByPrimaryKeySelective(this.assQueryForUpdateStatus(query,StatusConstants.STATUS_DELETED_CONCEALABLE,request)) != 1){
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
    public UserArticlePraiseRelation getUserArticlePraiseRelationDetail(UserArticlePraiseRelationQuery query) {
        return userArticlePraiseRelationMapper.selectByPrimaryKey(query.getId());
    }

    /**
    * 保存记录
    * @param query
    * @param request
    * @return
    */
    @Override
    public BaseResponse saveUserArticlePraiseRelation(UserArticlePraiseRelationQuery query, HttpServletRequest request) {
        userArticlePraiseRelationMapper.insert(this.assQueryForInsert(query,request));
        BaseResponse baseResponse = new BaseResponse.Builder().buildSuccess();
        baseResponse.setMsg(query.getId().toString());
        return baseResponse;
    }

    /**
     * 点赞/取消赞
     * @param query
     * @param request
     * @return
     */
    @Override
    public BaseResponse doSwitchPraise(UserArticlePraiseRelationQuery query, HttpServletRequest request) {
        RedisInvoker.saveUserOperation(query);
        return new BaseResponse.Builder().buildSuccess();
    }

    public void updateArticlePraise(UserArticlePraiseRelationQuery query, HttpServletRequest request){
        // 查询文章记录
        ArticleInfoQuery articleInfoQuery = new ArticleInfoQuery();
        articleInfoQuery.setId(query.getArticleId());
        ArticleInfo articleInfoDetail = articleInfoService.getArticleInfoDetail(articleInfoQuery);
        // 查询点赞关系记录
        UserArticlePraiseRelation userArticlePraiseRelation = getUserArticlePraiseRelation(query);
        if(!query.getPraiseFlag()){
            // 赞数+1
            articleInfoQuery.setLikeNumber(articleInfoDetail.getLikeNumber() + NumberUtil.INTEGER_ONE);
            // 插入点赞关系记录
            saveUserArticlePraiseRelation(query, request);
        }else{
            // 赞数-1
            articleInfoQuery.setLikeNumber(articleInfoDetail.getLikeNumber() - NumberUtil.INTEGER_ONE);
            // 删除点赞关系记录
            userArticlePraiseRelationMapper.deleteByPrimaryKey(userArticlePraiseRelation.getId());
        }
        // 更新文章赞数统计
        articleInfoService.updateLikeNumber(articleInfoQuery,request);
    }

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    */
    @Override
    public BaseResponse updateUserArticlePraiseRelation(UserArticlePraiseRelationQuery query, HttpServletRequest request) {
        UserArticlePraiseRelationExample userArticlePraiseRelationExample = new UserArticlePraiseRelationExample();
        UserArticlePraiseRelationExample.Criteria criteria = userArticlePraiseRelationExample.createCriteria();
        criteria.andIdEqualTo(query.getId());
        userArticlePraiseRelationMapper.updateByExampleSelective(query,userArticlePraiseRelationExample);
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
     * 根据用户id和文章id查询点赞记录
     * @param relationQuery
     * @return
     */
    @Override
    public UserArticlePraiseRelation getUserArticlePraiseRelation(UserArticlePraiseRelationQuery relationQuery) {
        UserArticlePraiseRelationExample example = new UserArticlePraiseRelationExample();
        UserArticlePraiseRelationExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(relationQuery.getUserId());
        criteria.andArticleIdEqualTo(relationQuery.getArticleId());
        List<UserArticlePraiseRelation> relationList = userArticlePraiseRelationMapper.selectByExample(example);
        return CollectionUtils.isEmpty(relationList) ? null : relationList.get(0);
    }


    /**
    * 组装新增实体
    * @param query
    * @param request
    * @return
    */
    private UserArticlePraiseRelation assQueryForInsert(UserArticlePraiseRelationQuery query, HttpServletRequest request) {
        query.setGmtCreated(new Date());
        //TODO
        //query.setPlatformId(operator.getPlatformId());
        //query.setAgentId(operator.getAgentId());
        //query.setGroupId(operator.getGroupId());
        //query.setSalesmanId(operator.getSalesmanId());
        return query;
    }

    /**
    * 组装更新状态实体
    * @param query
    * @param status
    * @param request
    * @return
    */
    private UserArticlePraiseRelation assQueryForUpdateStatus(UserArticlePraiseRelationQuery query, Integer status, HttpServletRequest request) {
        User operator = securityClient.getUserInfo(request);
        UserArticlePraiseRelationQuery infoQuery = new UserArticlePraiseRelationQuery();
        infoQuery.setId(query.getId());
        infoQuery.setStatus(status);
        return infoQuery;
    }

    /**
    * 组装分页参数
    * @param query
    * @return
    */
    private UserArticlePraiseRelationExample assExampleForList(UserArticlePraiseRelationQuery query) {
        UserArticlePraiseRelationExample example = new UserArticlePraiseRelationExample();
        UserArticlePraiseRelationExample.Criteria criteria = example.createCriteria();
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
    private UserArticlePraiseRelationExample assFuzzyExample(String fuzzyText) {
        UserArticlePraiseRelationExample example = new UserArticlePraiseRelationExample();
        UserArticlePraiseRelationExample.Criteria criteria = example.createCriteria();
        //TODO
        //criteria.andTitleLike("%" + fuzzyText + "%");
        return example;
    }
}