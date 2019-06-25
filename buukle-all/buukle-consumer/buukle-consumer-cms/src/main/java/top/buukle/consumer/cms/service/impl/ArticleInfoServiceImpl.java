package top.buukle.consumer.cms.service.impl;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;
import top.buukle.common.exception.ViewException;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.common.DateUtil;
import top.buukle.common.util.common.NumberUtil;
import top.buukle.common.util.common.StringUtil;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.consumer.cms .constants.StatusConstants;
import top.buukle.consumer.cms.entity.*;
import top.buukle.consumer.cms.entity.vo.ArticleCatQuery;
import top.buukle.consumer.cms.entity.vo.ArticleContentQuery;
import top.buukle.consumer.cms.entity.vo.ArticleDescQuery;
import top.buukle.consumer.cms.service.ArticleCatService;
import top.buukle.consumer.cms.service.ArticleContentService;
import top.buukle.consumer.cms.service.ArticleDescService;
import top.buukle.consumer.cms.vo.ArticleInformationVo;
import top.buukle.consumer.cms.vo.ArticlePublishVo;
import top.buukle.plugin.security.client.SecurityClient;
import top.buukle.plugin.security.entity.User;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.lang.reflect.InvocationTargetException;
import java.util.*;


import top.buukle.consumer.cms .service.ArticleInfoService;
import top.buukle.consumer.cms .dao.ArticleInfoMapper;
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
    private ArticleDescService articleDescService;

    @Autowired
    private ArticleContentService articleContentService;

    @Autowired
    private ArticleCatService articleCatService;

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
        if(articleInfoMapper.updateByPrimaryKeySelective(this.assQueryForUpdateStatus(query,StatusConstants.STATUS_DELETED_CONCEALABLE,request)) != 1){
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
        statusList.add(StatusConstants.STATUS_WAITING_FOR_AUDIT_PUBLISH);
        statusList.add(StatusConstants.STATUS_NOT_RELEASED);
        statusList.add(StatusConstants.STATUS_WAITING_FOR_AUDIT_RELEASE);
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
        List<Integer> statusList = new ArrayList<>();
        statusList.add(StatusConstants.STATUS_PUBLISHED);
        statusList.add(StatusConstants.STATUS_BANED);
        statusList.add(StatusConstants.STATUS_WAITING_FOR_AUDIT_PUBLISH);
        statusList.add(StatusConstants.STATUS_WAITING_FOR_AUDIT_RELEASE);
        statusList.add(StatusConstants.STATUS_NOT_RELEASED);
        statusList.add(StatusConstants.STATUS_AUDITING);
        PageHelper.startPage(pageBounds.getPage(), pageBounds.getLimit());
        return new PageResponse.Builder().build(new PageInfo<>(articleInfoMapper.selectByExample(this.assExampleForList(query,statusList))));
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
     * 查看文章 -- 审核
     * @param query
     * @param request
     * @return
     */
    @Override
    public ArticleInformationVo getArticleInformationForAudit(ArticleInfoQuery query, HttpServletRequest request) {
        ArticleInfo articleInfo = articleInfoMapper.selectByPrimaryKey(query.getId());
        if(!StatusConstants.STATUS_AUDIT_AVAILABLE.contains(articleInfo.getStatus())){
            throw new BaseException(BaseResponseCode.ARTICLE_AUDIT_FAILED_STATUS_WRONG);
        }
        articleInfoMapper.updateByPrimaryKeySelective(this.assArticleInfoForAuditing(query,request));
        return getArticleAllInformation(query);
    }

    /**
     * 组装审核实体
     * @param query
     * @param request
     * @return
     */
    private ArticleInfo assArticleInfoForAuditing(ArticleInfoQuery query, HttpServletRequest request) {
        ArticleInfo articleInfo = new ArticleInfo();
        articleInfo.setId(query.getId());
        articleInfo.setStatus(StatusConstants.STATUS_AUDITING);
        User operator = securityClient.getUserInfo(request);
        articleInfo.setModifierCode(operator.getUserId());
        articleInfo.setGmtModified(new Date());
        articleInfo.setModifier(operator.getUsername());
        articleInfo.setBak02(operator.getUsername());
        return articleInfo;
    }

    /**
     * 查看文章详情
     * @param query
     * @return
     */
    @Override
    public ArticleInformationVo getArticleAllInformation(ArticleInfoQuery query) {
        // 查询文章主表记录
        ArticleInfo articleInfo = articleInfoMapper.selectByPrimaryKey(query.getId());
        if(null == articleInfo){
            return null;
        }
        ArticleInformationVo informationVo = new ArticleInformationVo();
        informationVo.setArticleInfo(articleInfo);
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
     * 审核文章
     * @param articleInfo
     * @param request
     * @return
     */
    @Override
    public BaseResponse auditArticle(ArticleInfo articleInfo, HttpServletRequest request) {
        ArticleInfo articleInfoDB = articleInfoMapper.selectByPrimaryKey(articleInfo.getId());
        if(!articleInfoDB.getStatus().equals(StatusConstants.STATUS_AUDITING)){
            throw new BaseException(BaseResponseCode.ARTICLE_AUDIT_FAILED_STATUS_WRONG);
        }
        User operator = securityClient.getUserInfo(request);
        articleInfo.setModifier(operator.getUsername());
        articleInfo.setGmtModified(new Date());
        articleInfo.setModifierCode(operator.getUserId());
        articleInfo.setBak02(operator.getUsername());
        articleInfoMapper.updateByPrimaryKeySelective(articleInfo);
        return new BaseResponse.Builder().buildSuccess();
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
    private ArticleInfoExample assExampleForList(ArticleInfoQuery query, List<Integer> statusList) {
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
        User operator = securityClient.getUserInfo(request);
        query.setGmtCreated(new Date());
        query.setCreator(operator.getUsername());
        query.setCreatorCode(operator.getUserId());
        query.setArticleAuthor(operator.getUsername());
        query.setUserId(operator.getUserId());
        query.setLikeNumber(NumberUtil.LONG_ZERO);
        query.setBak01(NumberUtil.LONG_ZERO.toString());
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