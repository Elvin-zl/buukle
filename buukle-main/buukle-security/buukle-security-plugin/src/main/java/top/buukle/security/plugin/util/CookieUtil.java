package top.buukle.security.plugin.util;

import top.buukle.security.plugin.constants.SecurityInterceptorConstants;
import top.buukle.util.NumberUtil;
import top.buukle.util.StringUtil;
import top.buukle.util.log.BaseLogger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * buukle cookie 工具
 * Created by elvin on 2018/1/26.
 */
public class CookieUtil{

    /**
     * @description 获取cookie
     * @param request
     * @return java.lang.String
     * @Author elvin
     * @Date 2019/8/3
     */
    public static String getUserCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if( null != cookies){
            for (int i = 0; i < cookies.length; i++) {
                String cookieName = cookies[i].getName();
                if(cookieName.equals(SecurityInterceptorConstants.LOGIN_COOKIE_NAME)){
                    if(cookies[i].getValue()!=null && cookies[i].getValue()!=""){
                        String value = cookies[i].getValue();
                        return value;
                    }
                }
            }
        }
        return null;
    }

    /**
     * @description 清除cookie
     * @param response
     * @param domainHostAndPort
     * @return void
     * @Author elvin
     * @Date 2019/8/3
     */
    public static void delUserCookie(HttpServletResponse response, String domainHostAndPort){
        Cookie cookie = new Cookie(SecurityInterceptorConstants.LOGIN_COOKIE_NAME, ".");
        cookie.setMaxAge(NumberUtil.INTEGER_ZERO);
        cookie.setDomain(domainHostAndPort);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     * @description 写入cookie
     * @param cookieValue
     * @param response
     * @param domainHostAndPort
     * @param expireTime
     * @return void
     * @Author elvin
     * @Date 2019/8/3
     */
    public static void writeUserCookie(String cookieValue,HttpServletResponse response,String domainHostAndPort,Integer expireTime){
        Cookie cookie = new Cookie(SecurityInterceptorConstants.LOGIN_COOKIE_NAME,cookieValue);
        cookie.setMaxAge(expireTime);
        cookie.setDomain(domainHostAndPort);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     * @description 刷新cookie
     * @param request
     * @param response
     * @param expireTime
     * @return void
     * @Author elvin
     * @Date 2019/8/3
     */
    public static void refreshCookie(HttpServletRequest request, HttpServletResponse response, int expireTime) {
        Cookie cookie = new Cookie(SecurityInterceptorConstants.LOGIN_COOKIE_NAME,getUserCookie(request));
        cookie.setMaxAge(expireTime);
        cookie.setDomain(SecurityInterceptorConstants.LOGIN_COOKIE_DOMAIN);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
