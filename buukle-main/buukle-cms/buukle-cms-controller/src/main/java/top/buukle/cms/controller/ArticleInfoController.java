package top.buukle.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.buukle.cms.entity.ArticleInfo;
import top.buukle.cms.entity.vo.ArticleInfoQuery;
import top.buukle.cms.service.ArticleInfoService;
import top.buukle.common.call.PageResponse;

/**
* @author elvin
* @description ArticleInfo controller
*/
@Controller
@RequestMapping("/articleInfo")
public class ArticleInfoController{

    @Autowired
    private ArticleInfoService articleInfoService;

    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/getPageList")
    public ModelAndView getPageList(ArticleInfoQuery query,ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("response",articleInfoService.getPageList(query));
        modelAndView.setViewName("article/articleData");
        return modelAndView;
    }
}