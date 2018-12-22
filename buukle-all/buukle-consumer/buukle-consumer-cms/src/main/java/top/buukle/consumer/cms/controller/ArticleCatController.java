package top.buukle.consumer.cms .controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.common.response.BaseResponse;
import top.buukle.consumer.cms.vo.ArticleCatTreeNodeVo;
import top.buukle.plugin.security.vo.query.PageBounds;
import top.buukle.common.vo.response.PageResponse;

import top.buukle.consumer.cms .service.ArticleCatService;
import top.buukle.consumer.cms .entity.ArticleCat;
import top.buukle.consumer.cms .entity.vo.ArticleCatQuery;
import top.buukle.plugin.security.vo.response.FuzzySearchListVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author elvin
* @description ArticleCat controller
*/
@Controller
@RequestMapping("/articleCat")
public class ArticleCatController{

    @Autowired
    ArticleCatService articleCatService;

    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/getArticleCatList")
    @ResponseBody
    public PageResponse<ArticleCat> getUserList(ArticleCatQuery query,PageBounds pageBounds) throws Exception {
        return articleCatService.getArticleCatList(query,pageBounds);
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
        return articleCatService.fuzzySearchByText(fuzzyText);
    }

    /**
    * 删除记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/deleteArticleCat")
    @ResponseBody
    public BaseResponse deleteArticleCat(ArticleCatQuery query, HttpServletRequest request) throws Exception {
        return articleCatService.deleteArticleCat(query,request);
    }

    /**
    * 查看记录详情
    * @param query
    * @return
    * @throws Exception
    */
    @RequestMapping("/getArticleCatDetail")
    @ResponseBody
    public ArticleCat getArticleCatDetail(ArticleCatQuery query) throws Exception {
        return articleCatService.getArticleCatDetail(query);
    }

    /**
    * 新增记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/saveArticleCat")
    @ResponseBody
    public BaseResponse saveArticleCat(ArticleCatQuery query, HttpServletRequest request) throws Exception {
        return articleCatService.saveArticleCat(query,request);
    }

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/updateArticleCat")
    @ResponseBody
    public BaseResponse updateArticleCat(ArticleCatQuery query, HttpServletRequest request) throws Exception {
        return articleCatService.updateArticleCat(query,request);
    }

    /**
    * 获取文章分类树
    * @return
    * @throws Exception
    */
    @RequestMapping("/getArticleCatTree")
    @ResponseBody
    public List<ArticleCatTreeNodeVo> getArticleCatTree() throws Exception {
        return articleCatService.getArticleCatTree();
    }

}