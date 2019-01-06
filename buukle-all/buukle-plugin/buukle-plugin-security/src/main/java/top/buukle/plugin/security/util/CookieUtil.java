package top.buukle.plugin.security.util;

import top.buukle.common.util.common.NumberUtil;
import top.buukle.common.util.logger.BaseLogger;
import top.buukle.plugin.security.constants.SecurityConstants;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.ConcurrentHashMap;

/**
 * buukle cookie 工具
 * Created by elvin on 2018/1/26.
 */
public class CookieUtil{

    private static final BaseLogger LOGGER = BaseLogger.getLogger(CookieUtil.class);

    /** 本地应用登录用户cookie缓存map */
    final public static ConcurrentHashMap<String,String> COOKIE_MAP = new ConcurrentHashMap<>();

    /** 本地应用登录用户cookie缓存map-value */
    final public static String COOKIE_MAP_VALUE_EMPTY = "";

    /** 本地应用登录用户cookie缓存map 初始化状态key */
    final public static String COOKIE_MAP_INITIALIZE_STATUS_KEY = "G";

    /** 本地应用登录用户cookie缓存map 初始化状态  真值,是初始化状态,需要从redis获取登录用户列表*/
    final public static String COOKIE_MAP_INITIALIZE_STATUS_VALUE_TRUE = "1";

    /** 本地应用登录用户cookie缓存map 初始化状态  真值,是初始化状态,不需要从redis获取登录用户列表*/
    final public static String COOKIE_MAP_INITIALIZE_STATUS_VALUE_FALSE = "0";

    static{
        //初始化本地COOKIE_MAP初始化状态值
        COOKIE_MAP.put(COOKIE_MAP_INITIALIZE_STATUS_KEY,COOKIE_MAP_INITIALIZE_STATUS_VALUE_TRUE);
    }
    /**
     * 获取所需cookie值
     * @param request
     * @return
     */
    public static String getUserCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if( null != cookies){
            for (int i = 0; i < cookies.length; i++) {
                String cookieName = cookies[i].getName();
                if(cookieName.equals(SecurityConstants.COOKIE_LOGIN_KEY)){
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
     * 清除本地cookie
     * @param response
     */
    public static void delLocalCookie(HttpServletResponse response, String domainHostAndPort){
        Cookie cookie = new Cookie(SecurityConstants.COOKIE_LOGIN_KEY, ".");
        cookie.setMaxAge(NumberUtil.INTEGER_ZERO);
        cookie.setDomain(domainHostAndPort);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
    /**
     * 写入本地cookie
     * @param token
     * @param response
     */
    public static void addLocalCookieWithAWeekTime(String token,HttpServletResponse response,String domainHostAndPort){
        LOGGER.info("调用 CookieUtil addLocalCookieWithAWeekTime  接口，请求参数 domainHostAndPort： {}",domainHostAndPort);
        Cookie cookie = new Cookie(SecurityConstants.COOKIE_LOGIN_KEY,token);
        cookie.setMaxAge(NumberUtil.INTEGER_ONE_WEEK_SECOND);
        LOGGER.info("domian 值 ： domain{} " ,domainHostAndPort);
        cookie.setDomain(domainHostAndPort);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
