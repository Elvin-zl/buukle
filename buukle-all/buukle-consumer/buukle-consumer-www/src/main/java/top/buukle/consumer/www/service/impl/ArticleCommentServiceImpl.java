package top.buukle.consumer.www.service.impl;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.common.DateUtil;
import top.buukle.common.util.common.StringUtil;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.consumer.www.constants.ArticleCommentConstants;
import top.buukle.consumer.www.constants.StatusConstants;
import top.buukle.consumer.www.dao.ArticleInfoMapper;
import top.buukle.consumer.www.entity.ArticleCommentExample;
import top.buukle.consumer.www.entity.ArticleInfo;
import top.buukle.consumer.www.entity.vo.ArticleCommentResponseVo;
import top.buukle.plugin.security.client.SecurityClient;
import top.buukle.plugin.security.entity.User;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import top.buukle.consumer.www.service.ArticleCommentService;
import top.buukle.consumer.www.dao.ArticleCommentMapper;
import top.buukle.consumer.www.entity.ArticleComment;
import top.buukle.consumer.www.entity.vo.ArticleCommentQuery;

import javax.servlet.http.HttpServletRequest;

/**
* @author elvin
* @description ArticleCommentService实现类
*/
@Service
public class ArticleCommentServiceImpl implements ArticleCommentService{

    @Autowired
    private ArticleCommentMapper articleCommentMapper;
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
    public PageResponse<ArticleComment> getArticleCommentList(ArticleCommentQuery query, PageBounds pageBounds) {
    PageHelper.startPage(pageBounds.getPage(), pageBounds.getLimit());
        return new PageResponse.Builder().build(new PageInfo<>(articleCommentMapper.selectByExample(this.assExampleForList(query))));
    }

    /**
    * 模糊搜素
    * @param fuzzyText
    * @return
    */
    @Override
    public List<FuzzySearchListVo> fuzzySearchByText(String fuzzyText) {
        List<ArticleComment> list = articleCommentMapper.selectByExample(this.assFuzzyExample(fuzzyText));
        List<FuzzySearchListVo> fuzzySearchListVos = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(list)){
            for (ArticleComment item: list) {
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
    public BaseResponse deleteArticleComment(ArticleCommentQuery query, HttpServletRequest request) {
        if(articleCommentMapper.updateByPrimaryKeySelective(this.assQueryForUpdateStatus(query,StatusConstants.STATUS_DELETED_CONCEALABLE,request)) != 1){
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
    public ArticleComment getArticleCommentDetail(ArticleCommentQuery query) {
        return articleCommentMapper.selectByPrimaryKey(query.getId());
    }

    /**
    * 保存记录
    * @param query
    * @param request
    * @return
    */
    @Override
    public BaseResponse saveArticleComment(ArticleCommentQuery query, HttpServletRequest request) {
        query.setStatus(StatusConstants.STATUS_OPEN);
        articleCommentMapper.insert(this.assQueryForInsert(query,request));
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    */
    @Override
    public BaseResponse updateArticleComment(ArticleCommentQuery query, HttpServletRequest request) {
        ArticleCommentExample articleCommentExample = new ArticleCommentExample();
        ArticleCommentExample.Criteria criteria = articleCommentExample.createCriteria();
        criteria.andIdEqualTo(query.getId());
        User operator = securityClient.getUserInfo(request);
        query.setGmtModified(new Date());
        query.setModifier(operator.getUsername());
        query.setModifierCode(operator.getUserId());
        articleCommentMapper.updateByExampleSelective(query,articleCommentExample);
        return new BaseResponse.Builder().buildSuccess();
    }


    /**
     * 查询文章评论树
     * @param query
     * @param pageBounds
     * @return
     */
    @Override
    public BaseResponse getArticleComments(ArticleCommentQuery query, PageBounds pageBounds,HttpServletRequest request) {
        ArticleCommentExample articleCommentExample = new ArticleCommentExample();
        ArticleCommentExample.Criteria criteria = articleCommentExample.createCriteria();
        criteria.andArticleInfoIdEqualTo(query.getArticleInfoId());
        criteria.andPidTypeEqualTo(ArticleCommentConstants.PID_TYPE_COMMENT);
        ArticleInfo articleInfo = articleInfoMapper.selectByPrimaryKey(query.getArticleInfoId());
//        PageHelper.startPage(pageBounds.getPage(), pageBounds.getLimit());
        // 查询文章评论
        List<ArticleComment> articleCommentList = articleCommentMapper.selectByExample(articleCommentExample);
        List<ArticleCommentResponseVo> responseVoList = new ArrayList<>();
        if(org.springframework.util.CollectionUtils.isEmpty(articleCommentList)){
            return new BaseResponse.Builder().buildSuccess();
        }
        // 组装返回实体
        this.assSonComments(responseVoList,articleCommentList,pageBounds,articleInfo != null && securityClient.getUserInfo(request).getUserId().equals(articleInfo.getUserId()));
        return new BaseResponse.Builder().buildSuccess(responseVoList);
    }


    /**
     * 保存回复 / 评论
     * @param query
     * @param request
     * @return
     */
    @Override
    public BaseResponse saveComment(ArticleCommentQuery query, HttpServletRequest request) {
        return this.saveArticleComment(query, request);
    }

    /**
     * 删除回复
     * @param query
     * @param request
     * @return
     */
    @Override
    public BaseResponse deleteComment(ArticleCommentQuery query, HttpServletRequest request) {
        return this.deleteArticleComment(query,request);
    }

    /**
     * 组装子列表,并递归调用查询回复列表
     * @param responseVoList
     * @param articleCommentList
     * @param pageBounds
     * @param isAuthor
     */
    private void assSonComments(List<ArticleCommentResponseVo> responseVoList, List<ArticleComment> articleCommentList, PageBounds pageBounds, Boolean isAuthor) {
        for (ArticleComment articleComment: articleCommentList) {
            ArticleCommentResponseVo responseVo = new ArticleCommentResponseVo();
            BeanUtils.copyProperties(articleComment,responseVo);
            responseVo.setAuthorFlag(isAuthor);
            responseVoList.add(responseVo);
            this.getSonComments(responseVo,pageBounds,isAuthor);
        }
    }

    /**
     * 查询回复
     * @param responseVo
     * @param pageBounds
     * @param isAuthor
     */
    private void getSonComments(ArticleCommentResponseVo responseVo, PageBounds pageBounds, Boolean isAuthor) {
        ArticleCommentExample articleCommentExample = new ArticleCommentExample();
        ArticleCommentExample.Criteria criteria = articleCommentExample.createCriteria();
        criteria.andPidEqualTo(responseVo.getId());
        PageHelper.startPage(pageBounds.getPage(), pageBounds.getLimit());
        List<ArticleComment> sonCommentList = articleCommentMapper.selectByExample(articleCommentExample);
        if(org.springframework.util.CollectionUtils.isEmpty(sonCommentList)){
            return;
        }
        List<ArticleCommentResponseVo> responseVoList = new ArrayList<>();
        this.assSonComments(responseVoList,sonCommentList,pageBounds, isAuthor);
        responseVo.setSons(responseVoList);
    }

    /**
    * 组装新增实体
    * @param query
    * @param request
    * @return
    */
    private ArticleComment assQueryForInsert(ArticleCommentQuery query, HttpServletRequest request) {
        User operator = securityClient.getUserInfo(request);
        query.setGmtCreated(new Date());
        query.setCreator(operator.getUsername());
        query.setCreatorCode(operator.getUserId());
        return query;
    }

    /**
    * 组装更新状态实体
    * @param query
    * @param status
    * @param request
    * @return
    */
    private ArticleComment assQueryForUpdateStatus(ArticleCommentQuery query, Integer status, HttpServletRequest request) {
        User operator = securityClient.getUserInfo(request);
        ArticleCommentQuery infoQuery = new ArticleCommentQuery();
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
    private ArticleCommentExample assExampleForList(ArticleCommentQuery query) {
        ArticleCommentExample example = new ArticleCommentExample();
        ArticleCommentExample.Criteria criteria = example.createCriteria();
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
    private ArticleCommentExample assFuzzyExample(String fuzzyText) {
        ArticleCommentExample example = new ArticleCommentExample();
        ArticleCommentExample.Criteria criteria = example.createCriteria();
        //TODO
        //criteria.andTitleLike("%" + fuzzyText + "%");
        return example;
    }
}