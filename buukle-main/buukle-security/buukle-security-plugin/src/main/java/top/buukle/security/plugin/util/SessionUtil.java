/**
 * Copyright (C), 2015-2019  http://www.jd.com
 * FileName: SessionUtil
 * Author:   zhanglei1102
 * Date:     2019/8/2 17:33
 * Description: session 工具类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.security.plugin.util;

import top.buukle.security.entity.User;
import top.buukle.security.plugin.constants.SecurityInterceptorConstants;
import top.buukle.security.plugin.enums.SecurityExceptionEnum;
import top.buukle.security.plugin.exception.SecurityPluginException;
import top.buukle.util.JsonUtil;
import top.buukle.util.NumberUtil;
import top.buukle.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @description 〈session 工具类〉
 * @author zhanglei1102
 * @create 2019/8/2
 * @since 1.0.0
 */
public class SessionUtil {

    public static final String USER_MENU_TREE_KEY = "USER_MENU_TREE_KEY";
    public static final String USER_BUTTON_LIST_KEY = "USER_BUTTON_LIST_KEY";
    public static final String USER_URL_LIST_KEY = "USER_URL_LIST_KEY";

    /**
     * @description 缓存session用户信息
     * @param user
     * @param request
     * @param response
     * @return void
     * @Author elvin
     * @Date 2019/8/3
     */
    public static void cacheUser(User user, HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession(true);
        String cookieValue = session.getId();
        CookieUtil.writeUserCookie(cookieValue,response,SecurityInterceptorConstants.LOGIN_COOKIE_DOMAIN, user.getLoginStrategy() ==null ? NumberUtil.INTEGER_ONE_MINUTES_SECOND * 3 : NumberUtil.INTEGER_ONE_WEEK_SECOND);
        session.setAttribute(cookieValue,user);
    }

    /**
     * @description 获取session用户信息
     * @param request
     * @param response
     * @return top.buukle.security.entity.User
     * @Author zhanglei1102
     * @Date 2019/8/2
     */
    public static User getUser(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        String requestURI = request.getRequestURI();
        if(session!=null){
            String userCookie = CookieUtil.getUserCookie(request);
            if(StringUtil.isNotEmpty(userCookie)){
                User user = (User) session.getAttribute(userCookie);
                if(null == user){
                    CookieUtil.delUserCookie(response, SecurityInterceptorConstants.LOGIN_COOKIE_DOMAIN);
                    // 超时
                    throw new SecurityPluginException(SecurityExceptionEnum.SYSTEM_OUT_OF_TIME);
                }
                return user;
            }
        }
        return null;
    }

    /**
     * @description 获取session资源
     * @param request
     * @param key
     * @return java.util.List<java.lang.String>
     * @Author zhanglei1102
     * @Date 2019/8/2
     */
    public static Object get(HttpServletRequest request, String key) {
        HttpSession session = request.getSession(false);
        if(session!=null){
            return session.getAttribute(key);
        }
        return null;
    }

    /**
     * @description 缓存session资源
     * @param request
     * @param key
     * @param object
     * @return void
     * @Author elvin
     * @Date 2019/8/3
     */
    public static void cache(HttpServletRequest request, String key, Object object) {
        HttpSession session = request.getSession(false);
        if(session!=null){
            session.setAttribute(key,object);
        }
    }
}