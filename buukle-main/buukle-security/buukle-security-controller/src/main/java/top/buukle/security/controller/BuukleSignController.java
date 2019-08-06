package top.buukle.security .controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.buukle.common.call.CommonResponse;
import top.buukle.security .entity.vo.BuukleSignQuery;
import top.buukle.security .service.BuukleSignService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author elvin
* @description  BuukleSign controller
*/
@Controller
@RequestMapping("/buukleSign")
public class BuukleSignController {

    @Autowired
    private BuukleSignService buukleSignService;

    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/{pageName}")
    public ModelAndView getPage(@PathVariable("pageName") String pageName, BuukleSignQuery query, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("response", buukleSignService.getPage(query));
        modelAndView.setViewName("buukleSign/" + pageName);
        return modelAndView;
    }

    /**
    * @description 新增或者修改
    * @param query
    * @param request
    * @return top.buukle.common.call.CommonResponse
    * @Author elvin
    * @Date 2019/8/5
    */
    @RequestMapping("/saveOrEdit")
    @ResponseBody
    public CommonResponse saveOrEdit(BuukleSignQuery query, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return buukleSignService.saveOrEdit(query,request,response);
    }
}