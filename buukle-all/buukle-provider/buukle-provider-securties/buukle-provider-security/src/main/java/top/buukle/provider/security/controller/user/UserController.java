package top.buukle.provider.security.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.provider.security.vo.query.PageBounds;
import top.buukle.provider.security.vo.response.PageResponse;
import top.buukle.provider.security.business.UserBusiness;
import top.buukle.provider.security.entity.User;
import top.buukle.provider.security.service.UserService;
import top.buukle.provider.security.vo.query.UserQuery;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/8.
 * @Description :
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    private UserBusiness userBusiness;

    @RequestMapping("/updateUserById/{id}")
    @ResponseBody
    public  boolean updateUserById(@PathVariable("id") Integer id) throws Exception {
        User user = new User();
        user.setId(id);
        user.setUsername("1");
        userService.update(user);
        return true;
    }
    /**
     * 获取完成认证的用户信息
     * @return
     * @throws Exception
     */
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public User getUserInfo(HttpServletRequest request) throws Exception {
        return userBusiness.getUserInfo(request);
    }
    /**
     * 获取完成认证的用户信息
     * @return
     * @throws Exception
     */
    @RequestMapping("/getUserList")
    @ResponseBody
    public PageResponse<User> getUserList(UserQuery userQuery,PageBounds pageBounds) throws Exception {
        return userService.getUserList(userQuery,pageBounds);
    }

}
