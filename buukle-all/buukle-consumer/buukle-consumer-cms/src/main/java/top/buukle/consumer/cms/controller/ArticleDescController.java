package top.buukle.consumer.cms .controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.common.response.BaseResponse;
import top.buukle.plugin.security.vo.query.PageBounds;
import top.buukle.common.vo.response.PageResponse;

import top.buukle.consumer.cms .service.ArticleDescService;
import top.buukle.consumer.cms .entity.ArticleDesc;
import top.buukle.consumer.cms .entity.vo.ArticleDescQuery;
import top.buukle.plugin.security.vo.response.FuzzySearchListVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author elvin
* @description ArticleDesc controller
*/
@Controller
@RequestMapping("/articleDesc")
public class ArticleDescController{

    @Autowired
    ArticleDescService articleDescService;

    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/getArticleDescList")
    @ResponseBody
    public PageResponse<ArticleDesc> getUserList(ArticleDescQuery query,PageBounds pageBounds) throws Exception {
        return articleDescService.getArticleDescList(query,pageBounds);
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
        return articleDescService.fuzzySearchByText(fuzzyText);
    }

    /**
    * 删除记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/deleteArticleDesc")
    @ResponseBody
    public BaseResponse deleteArticleDesc(ArticleDescQuery query, HttpServletRequest request) throws Exception {
        return articleDescService.deleteArticleDesc(query,request);
    }

    /**
    * 查看记录详情
    * @param query
    * @return
    * @throws Exception
    */
    @RequestMapping("/getArticleDescDetail")
    @ResponseBody
    public ArticleDesc getArticleDescDetail(ArticleDescQuery query) throws Exception {
        return articleDescService.getArticleDescDetail(query);
    }

    /**
    * 新增记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/saveArticleDesc")
    @ResponseBody
    public BaseResponse saveArticleDesc(ArticleDescQuery query, HttpServletRequest request) throws Exception {
        return articleDescService.saveArticleDesc(query,request);
    }

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/updateArticleDesc")
    @ResponseBody
    public BaseResponse updateArticleDesc(ArticleDescQuery query, HttpServletRequest request) throws Exception {
        return articleDescService.updateArticleDesc(query,request);
    }

}