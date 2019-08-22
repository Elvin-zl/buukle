/**
 * Copyright (C), 2015-2019  http://www.buukle.top
 * FileName: Logout
 * Author:   elvin
 * Date:     2019/8/15 1:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.security.plugin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.common.call.CommonResponse;
import top.buukle.security.plugin.cache.SecuritySessionContext;
import top.buukle.security.plugin.util.SessionUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description 〈〉
 * @author elvin
 * @create 2019/8/15
 * @since 1.0.0
 */
@Controller
public class SecurityDefaultController {

    @Autowired
    private Environment env;
    @Autowired
    private SecuritySessionContext sessionContext;


    @RequestMapping("/logout")
    public void logout(HttpServletRequest request , HttpServletResponse response) throws IOException {
        sessionContext.removeFromSessionContext(SessionUtil.getUser(request,response).getUserId());
        SessionUtil.logout(request,response);
        response.sendRedirect(env.getProperty("security.passport.host"));
    }
    @RequestMapping("/getOnlineCount")
    @ResponseBody
    public CommonResponse getOnlineCount(){
        return sessionContext.countSessionContext();
    }
}