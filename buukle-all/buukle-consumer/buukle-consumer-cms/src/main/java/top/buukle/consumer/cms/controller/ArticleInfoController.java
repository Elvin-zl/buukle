package top.buukle.consumer.cms .controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.plugin.security.vo.query.PageBounds;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.consumer.cms .service.ArticleInfoService;
import top.buukle.consumer.cms .entity.ArticleInfo;
import top.buukle.consumer.cms .entity.vo.ArticleInfoQuery;

@Controller
public class ArticleInfoController{

    @Autowired
    ArticleInfoService service;

    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/getArticleInfoList")
    @ResponseBody
    public PageResponse<ArticleInfo> getUserList(ArticleInfoQuery query,PageBounds pageBounds) throws Exception {
        return service.getArticleInfoList(query,pageBounds);
    }

}