package top.buukle.security .controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import top.buukle.security .entity.vo.UserQuery;
import top.buukle.security .service.UserService;

/**
* @author elvin
* @description User controller
*/
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/{pageName}")
    public ModelAndView userPage(@PathVariable("pageName") String pageName, UserQuery query, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("response", userService.userPage(query));
        modelAndView.setViewName("user/" + pageName);
        return modelAndView;
    }
}