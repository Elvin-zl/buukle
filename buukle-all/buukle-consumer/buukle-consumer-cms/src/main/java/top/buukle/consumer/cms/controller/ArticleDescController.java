package top.buukle.consumer.cms .controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.plugin.security.vo.query.PageBounds;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.consumer.cms .service.ArticleDescService;
import top.buukle.consumer.cms .entity.ArticleDesc;
import top.buukle.consumer.cms .entity.vo.ArticleDescQuery;

@Controller
public class ArticleDescController{

    @Autowired
    ArticleDescService service;

    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/getArticleDescList")
    @ResponseBody
    public PageResponse<ArticleDesc> getUserList(ArticleDescQuery query,PageBounds pageBounds) throws Exception {
        return service.getArticleDescList(query,pageBounds);
    }

}