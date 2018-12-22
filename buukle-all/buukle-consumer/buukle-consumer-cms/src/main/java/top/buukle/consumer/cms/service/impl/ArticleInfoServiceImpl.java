package top.buukle.consumer.cms.service.impl;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.common.DateUtil;
import top.buukle.common.util.common.StringUtil;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.consumer.cms .constants.StatusConstants;
import top.buukle.consumer.cms .entity.ArticleInfoExample;
import top.buukle.plugin.security.client.SecurityClient;
import top.buukle.plugin.security.entity.User;
import top.buukle.plugin.security.vo.query.PageBounds;
import top.buukle.plugin.security.vo.response.FuzzySearchListVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.*;


import top.buukle.consumer.cms .service.ArticleInfoService;
import top.buukle.consumer.cms .dao.ArticleInfoMapper;
import top.buukle.consumer.cms .entity.ArticleInfo;
import top.buukle.consumer.cms .entity.vo.ArticleInfoQuery;

import javax.servlet.http.HttpServletRequest;

/**
* @author elvin
* @description ArticleInfoService实现类
*/
@Service
public class ArticleInfoServiceImpl implements ArticleInfoService{

    @Autowired
    private ArticleInfoMapper articleInfoMapper;

    @Autowired
    private SecurityClient securityClient;

    /**
    * 分页获取列表
    * @param query
    * @param pageBounds
    * @return
    */
    @Override
    public PageResponse<ArticleInfo> getArticleInfoList(ArticleInfoQuery query, PageBounds pageBounds) {
        PageHelper.startPage(pageBounds.getPage(), pageBounds.getLimit());
        return new PageResponse.Builder().build(new PageInfo<>(articleInfoMapper.selectByExample(this.assExampleForList(query))));
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
        if(articleInfoMapper.updateByPrimaryKeySelective(this.assQueryForUpdateStatus(query,StatusConstants.STATUS_DELETED_CONCELABLE,request)) != 1){
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
        List<Integer> statusList = new ArrayList();
        statusList.add(StatusConstants.STATUS_BANED);
        statusList.add(StatusConstants.STATUS_PUBLISHED);
        statusList.add(StatusConstants.STATUS_WAITTING_FOR_AUDIT_PUBLISH);
        statusList.add(StatusConstants.STATUS_NOT_RELESED);
        statusList.add(StatusConstants.STATUS_WAITTING_FOR_AUDIT_RELEASE);
        PageHelper.startPage(pageBounds.getPage(), pageBounds.getLimit());
        return new PageResponse.Builder().build(new PageInfo<>(articleInfoMapper.selectByExample(this.assExampleForList(query,statusList))));
    }

    /**
     * 获取文章审核列表
     * @param query
     * @param pageBounds
     * @return
     */
    @Override
    public PageResponse<ArticleInfo> getAuditArticleInfoList(ArticleInfoQuery query, PageBounds pageBounds) {
        List<Integer> statusList = new ArrayList();
        statusList.add(StatusConstants.STATUS_PUBLISHED);
        statusList.add(StatusConstants.STATUS_BANED);
        statusList.add(StatusConstants.STATUS_WAITTING_FOR_AUDIT_PUBLISH);
        statusList.add(StatusConstants.STATUS_WAITTING_FOR_AUDIT_RELEASE);
        statusList.add(StatusConstants.STATUS_NOT_RELESED);
        PageHelper.startPage(pageBounds.getPage(), pageBounds.getLimit());
        return new PageResponse.Builder().build(new PageInfo<>(articleInfoMapper.selectByExample(this.assExampleForList(query,statusList))));
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