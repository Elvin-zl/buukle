package top.buukle.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;
import top.buukle.common.call.FuzzyResponse;
import top.buukle.common.call.PageResponse;
import top.buukle.security.entity.vo.BaseQuery;
import top.buukle.security.service.BaseService;
import top.buukle.util.JsonUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author: elvin
 * @Date: 2019/7/28/028 2:11
 */
@Controller
@RequestMapping("/security")
public class SecurityController {

    @Autowired
    private Environment env;

    private WebApplicationContext webApplicationContext ;

    /**
     * security 主页面控制器
     * @param modelAndView
     * @return
     */
    @RequestMapping("/home")
    public ModelAndView home(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView) {
        String applicationName = env.getProperty("spring.application.name");
        String nameSuffix = applicationName.split("-")[1];
        modelAndView.addObject("nameSuffix",nameSuffix);
        modelAndView.setViewName("home");
        return modelAndView;
    }
    /**
     * security 子页面控制器
     * @param entity
     * @param operationAndViewName
     * @param modelAndView
     * @return
     */
    @RequestMapping("/{entity}/{operationAndViewName}")
    public ModelAndView security(String ids ,Integer id, HttpServletRequest request, HttpServletResponse response, @PathVariable("entity") String entity , @PathVariable("operationAndViewName")  String operationAndViewName, ModelAndView modelAndView) throws IOException {
        Object o = null;
        if(operationAndViewName.endsWith("CrudView")){
            webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
            o = ((BaseService) webApplicationContext.getBean(entity + "Service")).selectByPrimaryKey(id);
        }
        if(operationAndViewName.endsWith("CrudJson")){
            webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
            o = ((BaseService) webApplicationContext.getBean(entity + "Service")).delete(id,request);
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(JsonUtil.toJSONString(o));
            return null;
        }
        if(operationAndViewName.endsWith("BatchDeleteJson")){
            webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
            o = ((BaseService) webApplicationContext.getBean(entity + "Service")).deleteBatch(ids,request);
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(JsonUtil.toJSONString(o));
            return null;
        }
        modelAndView.addObject("record",o).setViewName("/" + entity + "/" + operationAndViewName);
        return modelAndView;
    }

    /**
     * @description 模糊搜索
     * @param entity
     * @param text
     * @param fieldName
     * @param request
     * @return top.buukle.common.call.FuzzyResponse
     * @Author elvin
     * @Date 2019/8/4
     */
    @RequestMapping("/{entity}/fuzzy/search")
    @ResponseBody
    public FuzzyResponse fuzzySearch(@PathVariable("entity") String entity,String text, String fieldName,HttpServletRequest request) {
        webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
        return ((BaseService) webApplicationContext.getBean(entity + "Service")).fuzzySearch(text, fieldName);
    }

}
