package top.buukle.consumer.cms.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.consumer.cms.service.UserService;
import top.buukle.provider.security.entity.User;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/19.
 * @Description :
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserById/{id}")
    @ResponseBody
    public User getUserById(@PathVariable("id") Integer id) throws Exception {
        return userService.getUserById(id);
    }

    /**
     * 获取完成认证的用户信息
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public User getUserInfo(@PathVariable("id") Integer id) throws Exception {
        return userService.getUserById(id);
    }

}
