package top.buukle.consumer.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.consumer.www.service.ArticleCommentService;
import top.buukle.consumer.www.entity.ArticleComment;
import top.buukle.consumer.www.entity.vo.ArticleCommentQuery;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author elvin
* @description ArticleComment controller
*/
@Controller
@RequestMapping("/articleComment")
public class ArticleCommentController{

    @Autowired
    ArticleCommentService articleCommentService;

    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/getArticleCommentList")
    @ResponseBody
    public PageResponse<ArticleComment> getArticleCommentList(ArticleCommentQuery query,PageBounds pageBounds) throws Exception {
        return articleCommentService.getArticleCommentList(query,pageBounds);
    }

    /**
    * 模糊搜索
    * @param fuzzyText
    * @return
    * @throws Exception
    */
    @RequestMapping("/fuzzySearchByText")
    @ResponseBody
    public List<FuzzySearchListVo>  fuzzySearchByText(String fuzzyText) throws Exception {
        return articleCommentService.fuzzySearchByText(fuzzyText);
    }

    /**
    * 删除记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/deleteArticleComment")
    @ResponseBody
    public BaseResponse deleteArticleComment(ArticleCommentQuery query, HttpServletRequest request) throws Exception {
        return articleCommentService.deleteArticleComment(query,request);
    }

    /**
    * 查看记录详情
    * @param query
    * @return
    * @throws Exception
    */
    @RequestMapping("/getArticleCommentDetail")
    @ResponseBody
    public ArticleComment getArticleCommentDetail(ArticleCommentQuery query) throws Exception {
        return articleCommentService.getArticleCommentDetail(query);
    }

    /**
    * 新增记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/saveArticleComment")
    @ResponseBody
    public BaseResponse saveArticleComment(ArticleCommentQuery query, HttpServletRequest request) throws Exception {
        return articleCommentService.saveArticleComment(query,request);
    }

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/updateArticleComment")
    @ResponseBody
    public BaseResponse updateArticleComment(ArticleCommentQuery query, HttpServletRequest request) throws Exception {
        return articleCommentService.updateArticleComment(query,request);
    }

    /**
    * 跳转文章评论页面
    * @param query
    * @return
    * @throws Exception
    */
    @RequestMapping("/toArticleComments")
    public ModelAndView toArticleComments(ArticleCommentQuery query, PageBounds pageBounds,HttpServletRequest request) throws Exception {
        return new ModelAndView("article/articleComments","articleCommentList",articleCommentService.getArticleComments(query, pageBounds,request).getBusiness().getDataList());
    }

    /**
    * 新增回复
    * @param query
    * @return
    * @throws Exception
    */
    @RequestMapping("/saveComment")
    @ResponseBody
    public BaseResponse saveComment (ArticleCommentQuery query,HttpServletRequest request) throws Exception {
        return articleCommentService.saveComment(query ,request);
    }

    /**
    * 删除回复
    * @param query
    * @return
    * @throws Exception
    */
    @RequestMapping("/deleteComment")
    @ResponseBody
    public BaseResponse deleteComment (ArticleCommentQuery query,HttpServletRequest request) throws Exception {
        return articleCommentService.deleteComment(query ,request);
    }

}