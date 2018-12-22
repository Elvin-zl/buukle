package top.buukle.consumer.cms .service;

import top.buukle.common.response.BaseResponse;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.plugin.security.vo.query.PageBounds;
import top.buukle.plugin.security.vo.response.FuzzySearchListVo;
import java.util.List;
import top.buukle.consumer.cms .entity.ArticleComment;
import top.buukle.consumer.cms .entity.vo.ArticleCommentQuery;

import javax.servlet.http.HttpServletRequest;

/**
* @author elvin
* @description ArticleCommentService 接口类
*/
public interface ArticleCommentService{

    /**
    * 分页获取列表
    * @param query
    * @param pageBounds
    * @return
    */
    public PageResponse<ArticleComment> getArticleCommentList(ArticleCommentQuery query, PageBounds pageBounds);

    /**
    * 模糊搜索
    * @param fuzzyText
    * @return
    */
    public List<FuzzySearchListVo> fuzzySearchByText(String fuzzyText);

    /**
    * 逻辑删除单条数据
    * @param query
    * @param request
    * @return
    */
    BaseResponse deleteArticleComment(ArticleCommentQuery query, HttpServletRequest request);

    /**
    * 获取记录详情
    * @param query
    * @return
    */
    ArticleComment getArticleCommentDetail(ArticleCommentQuery query);


    /**
    * 保存记录
    * @param query
    * @param request
    * @return
    */
    BaseResponse saveArticleComment(ArticleCommentQuery query, HttpServletRequest request);

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    */
    BaseResponse updateArticleComment(ArticleCommentQuery query, HttpServletRequest request);
}