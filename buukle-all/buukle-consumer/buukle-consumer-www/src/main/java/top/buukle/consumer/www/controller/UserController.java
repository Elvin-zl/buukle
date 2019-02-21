package top.buukle.consumer.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import top.buukle.common.response.BaseResponse;
import top.buukle.plugin.security.client.SecurityClient;
import top.buukle.plugin.security.entity.User;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/12/31.
 * @Description : userController
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private SecurityClient securityClient;

    /**
     * 跳转用户中心
     * @param request
     * @return
     */
    @RequestMapping("/toUserCenter")
    public ModelAndView toUserCenter(HttpServletRequest request) {
        return new ModelAndView("user/userCenter","userInfo",securityClient.getUserInfo(request));
    }

    /**
     * 更改用户信息
     * @param user
     * @return
     */
    @RequestMapping("/editUserInfo")
    public BaseResponse editUserInfo(User user) {
        
        return null;
    }
}
