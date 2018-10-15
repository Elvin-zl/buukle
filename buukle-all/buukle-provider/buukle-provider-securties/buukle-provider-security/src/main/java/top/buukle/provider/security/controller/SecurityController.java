package top.buukle.provider.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/9.
 * @Description : security 控制类
 */
@Controller
public class SecurityController {

    /**
     * buukle security 系统内部页面跳转控制器
     * @param parent
     * @param target
     * @param modelAndView
     * @return
     */
    @RequestMapping("/toMain/{grandParent}/{parent}/{target}")
    public  ModelAndView toMain(@PathVariable("grandParent")String grandParent ,@PathVariable("parent")String parent,@PathVariable("target")String target,ModelAndView modelAndView ) {
        modelAndView.setViewName(grandParent + "/" +parent +"/"+ target );
        return modelAndView;
    }
}
