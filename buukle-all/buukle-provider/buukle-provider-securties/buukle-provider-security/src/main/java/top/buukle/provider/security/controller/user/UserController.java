package top.buukle.provider.security.controller.user;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.provider.security.entity.User;
import top.buukle.provider.security.service.UserService;

import java.util.List;

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

    @RequestMapping("/updateUserById/{id}")
    @ResponseBody
    public  boolean updateUserById(@PathVariable("id") Integer id) throws Exception {
        User user = new User();
        user.setId(id);
        user.setUsername("1");
        userService.update(user);
        return true;
    }
    @RequestMapping("/getInPage/{page}")
    @ResponseBody
    public  List<User> getInPage(@PathVariable("page") Integer page) throws Exception {
        User user = new User();
        PageBounds pageBounds = new PageBounds();
        pageBounds.setLimit(10);
        pageBounds.setPage(page);
        List<User> userByParas = userService.getUserByParas(user, pageBounds);
        return userByParas;
    }
}
