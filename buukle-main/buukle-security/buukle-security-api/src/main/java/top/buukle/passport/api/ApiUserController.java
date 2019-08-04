/**
 * Copyright (C), 2015-2019  http://www.buukle.top
 * FileName: LoginController
 * Author:   elvin
 * Date:     2019/8/3 12:39
 * Description: 登录接口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.passport.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.common.call.CommonResponse;
import top.buukle.security.api.ApiUserService;
import top.buukle.security.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description 〈登录接口〉
 * @author elvin
 * @create 2019/8/3
 * @since 1.0.0
 */
@Controller
@RequestMapping("/api/user/")
public class ApiUserController {


    @Autowired
    private ApiUserService apiUserService;

    /**
     * @description 内部登陆
     * @param user
     * @param request
     * @param response
     * @return top.buukle.common.call.CommonResponse
     * @Author elvin
     * @Date 2019/8/3
     */
    @RequestMapping("/innerLogin")
    @ResponseBody
    public CommonResponse innerLogin(User user , HttpServletRequest request, HttpServletResponse response) {
        return apiUserService.innerLogin(user,request,response);
    }
}