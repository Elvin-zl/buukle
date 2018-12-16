package top.buukle.provider.security.util;

import top.buukle.plugin.security.util.CookieUtil;
import top.buukle.plugin.security.entity.User;
import top.buukle.provider.security.invoker.UserInvoker;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/12/6.
 * @Description :
 */
public class SessionUtil {
    /**
     * 获取当前用户信息
     * @param request
     * @return
     */
    public static User getOperator(HttpServletRequest request) {
        return UserInvoker.getUser(CookieUtil.getUserCookie(request));
    }
}
