package top.buukle.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author: elvin
 * @Date: 2019/7/28/028 2:11
 */
@Controller
@RequestMapping("/security")
public class SecurityController {

    @Autowired
    private Environment env;

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
     * @param parent
     * @param target
     * @param modelAndView
     * @return
     */
    @RequestMapping("/{parent}/{target}")
    public ModelAndView security(HttpServletRequest request, HttpServletResponse response, @PathVariable("parent") String parent , @PathVariable("target")  String target, ModelAndView modelAndView) {
//        HttpSession session = request.getSession(true);
//        session.setAttribute("system","security");
        modelAndView.setViewName("/" + parent + "/" + target);
        return modelAndView;
    }
}
