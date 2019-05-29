package top.buukle.consumer.www.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;
import top.buukle.common.exception.ViewException;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.common.DateUtil;
import top.buukle.common.util.common.JsonUtil;
import top.buukle.common.util.common.StringUtil;
import top.buukle.common.util.jedis.RedisString;
import top.buukle.common.util.logger.BaseLogger;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.consumer.www.constants.ArticleInfoConstants;
import top.buukle.consumer.www.constants.StatusConstants;
import top.buukle.consumer.www.dao.ArticleCatMapper;
import top.buukle.consumer.www.dao.ArticleCommentMapper;
import top.buukle.consumer.www.dao.ArticleInfoMapper;
import top.buukle.consumer.www.entity.*;
import top.buukle.consumer.www.entity.vo.*;
import top.buukle.consumer.www.service.*;
import top.buukle.consumer.www.vo.ArticleInformationVo;
import top.buukle.consumer.www.vo.ArticlePublishVo;
import top.buukle.plugin.security.client.SecurityClient;
import top.buukle.plugin.security.constants.SecurityConstants;
import top.buukle.plugin.security.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

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
    private ArticleCatMapper articleCatMapper;

    @Autowired
    private SecurityClient securityClient;

    @Autowired
    private UserArticlePraiseRelationService userArticlePraiseRelationService;

    @Autowired
    private ArticleCommentMapper articleCommentMapper;

    /**
    * 分页获取列表
    * @param query
    * @param pageBounds
    * @return
    */
    @Override
    public PageResponse<ArticleInformationVo> getArticleInfoList(ArticleInfoQuery query, PageBounds pageBounds) throws InvocationTargetException, IllegalAccessException {
        // 初始化文章分类列表
        List<Integer> catList = new ArrayList<>();
        // 查询文章分类总列表
        ArticleCatExample articleCatExample = new ArticleCatExample();
        ArticleCatExample.Criteria criteria = articleCatExample.createCriteria();
        criteria.andStatusNotEqualTo(StatusConstants.STATUS_DELETED_CONCEALABLE);
        List<ArticleCat> articleCats = articleCatMapper.selectByExample(articleCatExample);
        if(query.getArticleCatId() != null){
            this.getArticleCatIdList(query.getArticleCatId(),catList,articleCats);
        }
        // 开启分页
        PageHelper.startPage(pageBounds.getPage(), pageBounds.getLimit());
        List<ArticleInfo> articleInfos = articleInfoMapper.selectByExample(this.assExampleForWwwList(query,catList));
        PageResponse<ArticleInfo> infoPageResponse = new PageResponse.Builder().build(new PageInfo<>(articleInfos));
        List<ArticleInformationVo> voList = new ArrayList<>();
        // 查询文章摘要和分类信息 TODO 优化成一条sql
        for (ArticleInfo articleInfo: articleInfos) {
            ArticleInformationVo articleInformationVo = new ArticleInformationVo();
            String currentVistors = RedisString.get(ArticleInfoConstants.VISIT_PREFIX + articleInfo.getId());
            // 组装articleInfo
            articleInfo.setBak01(Integer.parseInt(StringUtil.isEmpty(articleInfo.getBak01()) ? "0" : articleInfo.getBak01())+(StringUtil.isEmpty(currentVistors) ? 0 : Integer.parseInt(currentVistors)) + StringUtil.EMPTY);
            articleInformationVo.setArticleInfo(articleInfo);
            // 查询并组装articleDesc
            ArticleDescQuery articleDescQuery = new ArticleDescQuery();
            articleDescQuery.setArticleInfoId(articleInfo.getId());
            articleInformationVo.setArticleDesc(null == articleDescService.getArticleDescDetail(articleDescQuery) ? StringUtil.EMPTY:articleDescService.getArticleDescDetail(articleDescQuery).getArticleDesc());
            // 查询并组装 articleCat
            if(articleInfo.getArticleCatId() != null){
                ArticleCatQuery articleCatQuery = new ArticleCatQuery();
                articleCatQuery.setId(articleInfo.getArticleCatId());
                articleInformationVo.setArticleCat(articleCatService.getArticleCatDetail(articleCatQuery));
            }
            voList.add(articleInformationVo);
        }
        // 复制分页参数
        PageResponse<ArticleInformationVo> voPageResponse = new PageResponse.Builder().build(new PageInfo<>());
        BeanUtils.copyProperties(voPageResponse,infoPageResponse);
        voPageResponse.setData(voList);
        return voPageResponse;
    }

    /**
     * 查询文章分类列表
     *
     * @param articleCatId
     * @param catList
     * @param articleCatList
     * @return
     */
    private void getArticleCatIdList(Integer articleCatId, List<Integer> catList, List<ArticleCat> articleCatList) {
        catList.add(articleCatId);
        for (ArticleCat articleCat: articleCatList) {
            if(articleCatId.equals(Integer.parseInt(articleCat.getPid()+StringUtil.EMPTY))){
                this.getArticleCatIdList(articleCat.getId(),catList,articleCatList);
            }
        }
    }

    /**
    * 模糊搜素
    * @param fuzzyText 模糊文本
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
    public BaseResponse doPublish(ArticlePublishVo publishVo, HttpServletRequest request) throws Exception {
        User operator = securityClient.getUserInfo(request);
        if(operator.getUserId().equals(SecurityConstants.USER_ID_OFFLINE)){
            throw new BaseException(BaseResponseCode.ARTICLE_ADD_EXCEPTION);
        }
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
     *
     * @param idStr
     * @param request TODO 将访问,点赞,评论 缓存
     * @param query
     * @param isPortal
     * @return
     */
    @Override
    public ArticleInformationVo getArticleAllInformation(String idStr, HttpServletRequest request, ArticleInfoQuery query, Boolean isPortal) {
        // 查询文章主表记录
        try {
            query.setId(Integer.parseInt(new String(Base64.getDecoder().decode(idStr))));
        } catch (Exception e) {
            e.printStackTrace();
            if(isPortal){
                throw new ViewException(BaseResponseCode.ARTICLE_QUERY_FAILED).setInfo(JsonUtil.toJSONString(e.getStackTrace()));
            }else{
                throw new BaseException(BaseResponseCode.ARTICLE_QUERY_FAILED);
            }
        }
        ArticleInfo articleInfo = articleInfoMapper.selectByPrimaryKey(query.getId());
        if(null == articleInfo){
            if(isPortal){
                throw new ViewException(BaseResponseCode.ARTICLE_QUERY_ID_NOT_EXIST);
            }else{
                throw new BaseException(BaseResponseCode.ARTICLE_QUERY_ID_NOT_EXIST);
            }
        }else{
            // 被封禁,删除直接抛出异常
            if(isPortal && !StatusConstants.ARTICLE_VERSION_STATUS_LIST_WWW.contains(articleInfo.getStatus())){
                throw new ViewException(BaseResponseCode.ARTICLE_DETAIL_EXCEPTION_BANED);
            }
        }
        ArticleInformationVo informationVo = new ArticleInformationVo();
        informationVo.setArticleInfo(articleInfo);
        // 统计文章总评论数
        long articleCommentSum = articleCommentMapper.selectCountOfArticle(query.getId());
        informationVo.setArticleCommentSum(articleCommentSum);
        // 查询前台相关记录
        if(isPortal){
            // 查询用户文章点赞关系记录
            User userInfo = null;
            try{
                // 查询文章作者记录
                informationVo.setArticleAuthor(securityClient.getArticleAuthor(articleInfo.getUserId()));
                userInfo = securityClient.getUserInfo(request);
            }
            catch(Exception e){
                // 查询用户信息失败
                LOGGER.info("查询用户信息失败!不能正确显示用户登录信息,原因 : {}",e.getMessage());
                e.fillInStackTrace();
            }
            if(null != userInfo){
                UserArticlePraiseRelationQuery userArticlePraiseRelation = new UserArticlePraiseRelationQuery();
                userArticlePraiseRelation.setUserId(userInfo.getUserId());
                userArticlePraiseRelation.setArticleId(articleInfo.getId());
                informationVo.setPraiseRelation(userArticlePraiseRelationService.getUserArticlePraiseRelation(userArticlePraiseRelation));
            }
            // 判断是否是有效访问 (ArticleInfoConstants.VISIT_EXPIRE_TIME_ZONE_SECONDED 秒内的重复访问即为无效)
            if( RedisString.setIfAbsent(ArticleInfoConstants.VISIT_EXPIRE_PREFIX + query.getId(),"0",ArticleInfoConstants.VISIT_EXPIRE_TIME_ZONE_SECONDED)){
               // 添加文章访问记录到redis缓存,解决并发访问问题
               Long currentCacheVisit = RedisString.incre(ArticleInfoConstants.VISIT_PREFIX + query.getId());
               // 本条记录达到缓存上限后落到数据库
               if(currentCacheVisit >= ArticleInfoConstants.VISIT_CACHE_LIMIT){
                   // 清空redis缓存访问量
                   RedisString.set(ArticleInfoConstants.VISIT_PREFIX + query.getId(),"0");
                   ArticleInfo articleInfo1 = new ArticleInfo();
                   articleInfo1.setId(query.getId());
                   // 合并访问量更新数据库
                   articleInfo1.setBak01(Integer.parseInt(StringUtil.isEmpty(articleInfo.getBak01()) ? "0" : articleInfo.getBak01())+currentCacheVisit +"");
                   articleInfoMapper.updateByPrimaryKeySelective(articleInfo1);
               }
               // 组装页面访问量并返回
               articleInfo.setBak01(Integer.parseInt(StringUtil.isEmpty(articleInfo.getBak01()) ? "0" : articleInfo.getBak01())+currentCacheVisit + "");
           }
            // 无效访问
            else{
                // 组装页面访问量并返回
                articleInfo.setBak01(Integer.parseInt(StringUtil.isEmpty(articleInfo.getBak01()) ? "0" : articleInfo.getBak01())+(StringUtil.isEmpty(RedisString.get(ArticleInfoConstants.VISIT_PREFIX + query.getId())) ? 0 : Integer.parseInt(RedisString.get(ArticleInfoConstants.VISIT_PREFIX + query.getId()))) + "");
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
        if(operator == null ||  operator.getUserId().equals(SecurityConstants.USER_ID_OFFLINE)){
            throw new BaseException(BaseResponseCode.ARTICLE_ADD_EXCEPTION);
        }
        query.setArticleAuthor(operator.getUsername());
        query.setGmtCreated(new Date());
        query.setCreator(operator.getUsername());
        query.setCreatorCode(operator.getUserId());
        query.setPlatformId(operator.getPlatformId());
        query.setUserId(operator.getUserId());
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
    * @param catList
     * @return
    */
    private ArticleInfoExample assExampleForWwwList(ArticleInfoQuery query, List<Integer> catList) {
        ArticleInfoExample example = new ArticleInfoExample();
        ArticleInfoExample.Criteria criteria = example.createCriteria();
        if(CollectionUtils.isNotEmpty(catList)){
            criteria.andArticleCatIdIn(catList);
        }
//        if(query.getArticleCatId() != null){
//            criteria.andArticleCatIdEqualTo(query.getArticleCatId());
//        }
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
            criteria.andStatusIn(StatusConstants.ARTICLE_VERSION_STATUS_LIST_WWW);
        }
        if(query.getOrderFlag() == null || query.getOrderFlag().equals(ArticleInfoConstants.ORDER_BY_DEFAULT) || query.getOrderFlag().equals(ArticleInfoConstants.ORDER_BY_GMT_MODIFIED)){
            example.orderBy("gmt_created desc");
        }
        if(query.getOrderFlag().equals(ArticleInfoConstants.ORDER_BY_PRAISE)){
            example.orderBy("like_number+0 desc");
        }
        if(query.getOrderFlag().equals(ArticleInfoConstants.ORDER_BY_SCAN)){
            example.orderBy("bak01+0 desc");
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