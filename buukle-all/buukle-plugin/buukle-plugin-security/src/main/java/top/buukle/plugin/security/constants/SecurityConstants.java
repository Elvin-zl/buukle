package top.buukle.plugin.security.constants;

import top.buukle.plugin.security.plugins.SecurityInterceptor;
import top.buukle.plugin.security.vo.parameter.ViewNameParameters;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/8/30.
 * @Description :
 */
public class SecurityConstants {


    /*----------------------------------------系统设置---------------------------------------------------------*/
    /** 系统登录cookie key*/
    public static final String COOKIE_LOGIN_KEY = "BUUKLE";

    /*------------------------------------用户自定义设置-------------------------------------------------------*/
    /** 用户登录关闭验证码*/
    public static final String CLOSE_VERIFY_TRUE = "1";
    /** 用户获取session中验证码的key前缀*/
    public static final String VERIFY_CODE_KEY_PREFIX = "VERIFY_CODE_KEY_PREFIX_";
    /** 开启认证*/
    public static final String OPEN_AUTH_TRUE = "1";
    /** 关闭认证*/
    public static final String OPEN_AUTH_FALSE = "0";

    /*-----------------------------------系统返回--------------------------------------------------------------------*/
    /** 没有cookie,未登录*/
    public static final String NO_LOGIN = SecurityInterceptor.LOGIN_PATH;
    /** 没有来源页面*/
    public static final String NO_REEFER_PATH = "/noReefer";
    public static final String NO_REEFER_VIEW_NAME = "noReefer";
    public static final String NO_REEFER_WORD = "当前页面访问来源非法!请通过正规方式访问目标页面!";

    /** 认证失败*/
    public static final String NO_AUTHENTICATION_WORD = "登录超时，请重新登陆 ！";
    /** 没有权限*/
    public static final String NO_PERMISSION_WORD = "抱歉！您无此操作权限！请联系网站管理员！";

    /*-----------------------------------常量设置--------------------------------------------------------------------*/

    public static final String LOGIN_PATH_ENVIRONMENT_KEY = "LOGIN_PATH_ENVIRONMENT_KEY";
    public static final String LOGIN_VERIFY_ENVIRONMENT_KEY = "LOGIN_VERIFY_ENVIRONMENT_KEY";
    public static final String INDEX_PATH_ENVIRONMENT_KEY = "INDEX_PATH_ENVIRONMENT_KEY";
    public static final String OUT_OF_TIME_PATH_LOGIN_PATH_ENVIRONMENT_KEY = "OUT_OF_TIME_PATH_LOGIN_PATH_ENVIRONMENT_KEY";
    public static final String NO_PERMISSION_PATH_ENVIRONMENT_KEY = "NO_PERMISSION_PATH_ENVIRONMENT_KEY";
    public static final String ERROR_PAGE_PATH_ENVIRONMENT_KEY = "ERROR_PAGE_PATH_ENVIRONMENT_KEY";
    public static final String LOGOUT_PATH_ENVIRONMENT_KEY = "LOGOUT_PATH_ENVIRONMENT_KEY";
    public static final String DOLOGIN_PATH_ENVIRONMENT_KEY = "DOLOGIN_PATH_ENVIRONMENT_KEY";
    public static final String DOREGISTER_PATH_ENVIRONMENT_KEY = "DOREGISTER_PATH_ENVIRONMENT_KEY";

    /** 用户指定视图缓存对象 (通过securityController动态返回用户配置的指定sso视图名称)*/
    public static final ViewNameParameters VIEW_NAME_PARAMETERS = new ViewNameParameters();

    /** 空的用户名*/
    public static final String USER_ID_OFFLINE = "-1";
}
