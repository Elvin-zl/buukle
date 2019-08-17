package top.buukle.security .controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.buukle.common.call.CommonResponse;
import top.buukle.common.call.PageResponse;
import top.buukle.security .entity.vo.ApplicationQuery;
import top.buukle.security .service.ApplicationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author elvin
* @description  Application controller
*/
@Controller
@RequestMapping("/application")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/{pageName}")
    public ModelAndView getPage(@PathVariable("pageName") String pageName, ApplicationQuery query, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("response", applicationService.getPage(query));
        modelAndView.setViewName("application/" + pageName);
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
    public CommonResponse saveOrEdit(ApplicationQuery query, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return applicationService.saveOrEdit(query,request,response);
    }

    /**
     * @description 获取应用树
     * @param request
     * @param response
     * @return top.buukle.common.call.CommonResponse
     * @Author zhanglei1102
     * @Date 2019/8/9
     */
    @RequestMapping("/getApplicationTree")
    @ResponseBody
    public PageResponse getApplicationTree(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return applicationService.getApplicationTree(request, response);
    }
}