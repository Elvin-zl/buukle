package top.buukle.consumer.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.consumer.portal.entity.ArticleContent;
import top.buukle.consumer.portal.entity.vo.ArticleContentQuery;
import top.buukle.consumer.portal.service.ArticleContentService;
import top.buukle.plugin.security.vo.query.PageBounds;
import top.buukle.plugin.security.vo.response.FuzzySearchListVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author elvin
* @description ArticleContent controller
*/
@Controller
@RequestMapping("/articleContent")
public class ArticleContentController{

    @Autowired
    ArticleContentService articleContentService;

    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/getArticleContentList")
    @ResponseBody
    public PageResponse<ArticleContent> getUserList(ArticleContentQuery query, PageBounds pageBounds) throws Exception {
        return articleContentService.getArticleContentList(query,pageBounds);
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
        return articleContentService.fuzzySearchByText(fuzzyText);
    }

    /**
    * 删除记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/deleteArticleContent")
    @ResponseBody
    public BaseResponse deleteArticleContent(ArticleContentQuery query, HttpServletRequest request) throws Exception {
        return articleContentService.deleteArticleContent(query,request);
    }

    /**
    * 查看记录详情
    * @param query
    * @return
    * @throws Exception
    */
    @RequestMapping("/getArticleContentDetail")
    @ResponseBody
    public ArticleContent getArticleContentDetail(ArticleContentQuery query) throws Exception {
        return articleContentService.getArticleContentDetail(query);
    }

    /**
    * 新增记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/saveArticleContent")
    @ResponseBody
    public BaseResponse saveArticleContent(ArticleContentQuery query, HttpServletRequest request) throws Exception {
        return articleContentService.saveArticleContent(query,request);
    }

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/updateArticleContent")
    @ResponseBody
    public BaseResponse updateArticleContent(ArticleContentQuery query, HttpServletRequest request) throws Exception {
        return articleContentService.updateArticleContent(query,request);
    }

}