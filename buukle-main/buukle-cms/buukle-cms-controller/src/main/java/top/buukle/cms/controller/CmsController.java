package top.buukle.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: elvin
 * @Date: 2019/7/28/028 2:11
 */
@Controller
@RequestMapping("/cms")
public class CmsController {

    /**
     * cms主页面控制器
     * @param parent
     * @param target
     * @param modelAndView
     * @return
     */
    @RequestMapping("/{parent}/{target}")
    public ModelAndView cms(HttpServletRequest request, @PathVariable("parent") String parent , @PathVariable("target")  String target, ModelAndView modelAndView) {
        HttpSession session = request.getSession();
        modelAndView.setViewName("/" + parent + "/" + target);
        return modelAndView;
    }
}
