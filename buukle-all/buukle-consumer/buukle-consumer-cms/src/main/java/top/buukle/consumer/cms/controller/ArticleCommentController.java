package top.buukle.consumer.cms .controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.plugin.security.vo.query.PageBounds;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.consumer.cms .service.ArticleCommentService;
import top.buukle.consumer.cms .entity.ArticleComment;
import top.buukle.consumer.cms .entity.vo.ArticleCommentQuery;

@Controller
public class ArticleCommentController{

    @Autowired
    ArticleCommentService service;

    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/getArticleCommentList")
    @ResponseBody
    public PageResponse<ArticleComment> getUserList(ArticleCommentQuery query,PageBounds pageBounds) throws Exception {
        return service.getArticleCommentList(query,pageBounds);
    }

}