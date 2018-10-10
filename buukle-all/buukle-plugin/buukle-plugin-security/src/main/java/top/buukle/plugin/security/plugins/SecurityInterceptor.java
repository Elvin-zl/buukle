package top.buukle.plugin.security.plugins;

import com.alibaba.fastjson.JSON;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.common.SpringEnvironmentUtil;
import top.buukle.common.util.common.StringUtil;
import top.buukle.common.util.logger.BaseLogger;
import top.buukle.plugin.security.business.SecurityBusiness;
import top.buukle.plugin.security.constants.SecurityConstants;
import top.buukle.plugin.security.util.VerificationCodeImageUtil;
import top.buukle.plugin.security.vo.LoginParameters;
import top.buukle.plugin.security.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author elvin
 */
public class SecurityInterceptor implements HandlerInterceptor {

    private static final BaseLogger LOGGER = BaseLogger.getLogger(SecurityInterceptor.class);

    /** 请求头来源 常量*/
    final public static String REQUEST_HEADER_REFEREE = "Referer";
    public static final String NO_AUTHENTICATION_PATH = "/noAuthentication";

    @Autowired
    private SecurityBusiness authAndPermBusiness;

    @Autowired
    private LoginParameters loginParameters;

    @PostConstruct
    public void init(){
        authAndPermInterceptor(this.loginParameters);
    }

    /**
     * 请求处理
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //初始化参数
        String uri = request.getRequestURI();
        //特殊uri处理
        Boolean uriHandle = this.uriHandle(request, response,uri);
        if(null != uriHandle){
            return uriHandle;
        }
        //一般uri授权
        Boolean permissionHandle = this.permissionHandle(request, response, uri);
        if(null != permissionHandle){
            return permissionHandle;
        }
        return false;
    }

    @Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {}
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {}

    /**
     * 处理指定uri
     * @param request
     * @param response
     * @param uri
     * @return
     * @throws Exception
     */
    private Boolean uriHandle(HttpServletRequest request, HttpServletResponse response, String uri) throws Exception {
        //生成验证码
        if(uri.equals(GET_VERIFICATION_IMG_PATH)){
            VerificationCodeImageUtil.getCode3(request,response, SecurityConstants.VERIFY_CODE_KEY_PREFIX+VERIFICATION_CODE_KEY);
            return false;
        }
        //放行页面 (登录页&错页&超时页&越权页面)
        if(uri.equals(LOGIN_PATH) || uri.equals(ERROR_PAGE_PATH) || uri.equals(OUT_OF_TIME_PATH) || uri.equals(NO_PERMISSION_PATH) || uri.equals(SecurityConstants.NO_REEFER_PATH)){
            return true;
        }
        //执行登录
        if(uri.equals(DO_LOGIN_PATH)){
            this.isSuccess(request, response, authAndPermBusiness.doLogin(request,response),true);
            return false;
        }
        //执行登出
        if(uri.equals(LOGOUT_PATH)){
            authAndPermBusiness.logout(request,response);
        }
        return null;
    }
    /**
     * 处理授权
     * @param request
     * @param response
     * @param uri
     * @return
     * @throws Exception
     */
    private Boolean permissionHandle(HttpServletRequest request, HttpServletResponse response, String uri) throws Exception {

        //接口验签

        //开启授权
        if(StringUtil.isNotEmpty(OPEN_AUTH) && OPEN_AUTH.equals(SecurityConstants.OPEN_AUTH_TRUE)){
            //免授权 uri
            if(isFreePermission(uri)){
                return true;
            }
            BaseResponse baseResponse = authAndPermBusiness.authAndSetPermission(request, response, uri, SSO_DEFAULT_AGE, APPLICATION_NAME);
            return this.isSuccess(request,response,baseResponse, false);
        }
        //关闭授权
        if(StringUtil.isNotEmpty(OPEN_AUTH) && OPEN_AUTH.equals(SecurityConstants.OPEN_AUTH_FALSE)){
            return true;
        }
        throw new BaseException(BaseResponseCode.USER_PERMISSION_OPEN_AUTH_NULL);
    }

    /**
     * 判断请求uri是否在免授权列表
     * @param uri
     * @return
     */
    private boolean isFreePermission(String uri) {
        return FREE_PERMISSION_PATH_LIST.contains(uri) ? true : false;
    }

    /**
     * 组织返回
     *
     * @param request
     * @param response
     * @param baseResponse
     * @param isLogin
     * @return
     */
    private boolean isSuccess(HttpServletRequest request, HttpServletResponse response, BaseResponse baseResponse, boolean isLogin) throws IOException {
        if(baseResponse.isSuccess()){
            if(isLogin){
                this.successHandle(request,response,baseResponse,isLogin);
            }
            return true;
        }
        this.errorHandle(request,response,baseResponse,isLogin);
        return false;
    }

    /**
     * 积极处理
     * @param request
     * @param response
     * @param baseResponse
     * @param isLogin
     */
    private void successHandle(HttpServletRequest request, HttpServletResponse response, BaseResponse baseResponse, boolean isLogin) throws IOException {
        if(isLogin){
            this.sendJson(response,baseResponse);
            return;
        }
    }

    /**
     * 消极处理
     * @param request
     * @param response
     * @param baseResponse
     * @param isLogin
     */
    private void errorHandle(HttpServletRequest request, HttpServletResponse response, BaseResponse baseResponse, boolean isLogin) throws IOException {
        //登录失败
        if(isLogin){
            this.sendJson(response,baseResponse);
            return;
        }
        //未登录
        if(baseResponse.getMsg().equals(SecurityConstants.NO_LOGIN)){
            response.sendRedirect(request.getContextPath() + SecurityConstants.NO_LOGIN);
            return;
        }
        //来源非法
        if(baseResponse.getMsg().equals(SecurityConstants.NO_REEFER_PATH)){
            response.sendRedirect(request.getContextPath() + SecurityConstants.NO_REEFER_VIEW_NAME);
            return;
        }
        //认证失败(登录超时)
        if(baseResponse.getMsg().equals(SecurityInterceptor.NO_AUTHENTICATION_PATH)){
            baseResponse.setMsg(SecurityConstants.NO_AUTHENTICATION_WORD);
            //清除老cookie
            CookieUtil.delLocalCookie(response,SSO_DOMAIN);
//            返回json 暂时不用,后期可优化成配置
//            this.sendJson(response,baseResponse);
//            return;
            //返回页面
            response.sendRedirect(request.getContextPath() + SecurityInterceptor.OUT_OF_TIME_PATH);
            return;
        }
        //授权失败（越权）
        if(baseResponse.getMsg().equals(SecurityInterceptor.NO_PERMISSION_PATH)){
            baseResponse.setMsg(SecurityConstants.NO_PERMISSION_WORD);
//            返回json 暂时不用,后期可优化成配置
//            this.sendJson(response,baseResponse);
//            return;
            //返回页面
            response.sendRedirect(request.getContextPath() + SecurityInterceptor.NO_PERMISSION_PATH);
            return;
        }
        //异常
        response.sendRedirect(request.getContextPath() + SecurityInterceptor.ERROR_PAGE_PATH);
    }

    /**
     * 頁面返回json
     * @param response
     * @param baseResponse
     */
    private void sendJson(HttpServletResponse response, BaseResponse baseResponse) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.append(JSON.toJSONString(baseResponse));
            LOGGER.info("返回頁面信息: {}",JSON.toJSONString(baseResponse));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /*---------------------------------------------设置应用相关--------------------------------------------*/
    /** 应用名*/
    public static String APPLICATION_NAME ;
    /** 默认超时时间*/
    public static String SSO_DEFAULT_AGE ;
    /** cookie跨域的domain*/
    public static String SSO_DOMAIN ;
    /** 用户登出策略(1 : 单点登出 0 : 多点登出)*/
    public static String LOGIN_OUT_STRATEGY ;
    /*-----------------------------------------------设置key-----------------------------------------------*/
    /** 获取验证码key*/
    public static String VERIFICATION_CODE_KEY ;
    /** 用户登录策略key*/
    public static String CACHE_CATEGORY_KEY ;
    /*-----------------------------------------------设置开关-----------------------------------------------*/
    /** 授权开关(1 : 开启 0 : 关闭)*/
    public static String OPEN_AUTH ;
    /** 验证码验证开关(1 : 关闭 无 : 开启)*/
    public static String CLOSE_VERIFICATION ;
    /*--------------------------------设置指定返回json，stram 等非视图资源的Path 路径---------------------------*/
    /** 获取验证码路径*/
    public static String GET_VERIFICATION_IMG_PATH ;
    /** 执行登陆路径*/
    public static String DO_LOGIN_PATH ;
    /** 未开启授权应用获取用户信息路径*/

    /*-------------------------------设置指定跳转视图的Path映射 (requestMapping) 路径---------------------------*/
    /** 去往登录页面路径*/
    public static String LOGIN_PATH ;

    /** 去往首页页面路径*/
    public static String INDEX_PATH ;

    /** 去往超时页面路径*/
    public static String OUT_OF_TIME_PATH ;

    /** 去往越权页面路径*/
    public static String NO_PERMISSION_PATH ;

    /** 去往错误页面路径*/
    public static String ERROR_PAGE_PATH ;

    /** 去往登出操作路径*/
    public static String LOGOUT_PATH ;

    /*---------------------------------设置指定跳转视图的Path的跳转视图 (view) 名称------------------------------*/
    /** 登录页面跳转视图名*/
    public static String LOGIN_VIEW_NAME ;

    /** 首页页面跳转视图名*/
    public static String INDEX_VIEW_NAME;

    /** 超时页面跳转视图名*/
    public static String OUT_OF_TIME_VIEW_NAME ;

    /** 越权页面跳转视图名*/
    public static String NO_PERMISSION_VIEW_NAME ;

    /** 错误页面跳转视图名*/
    public static String ERROR_PAGE_VIEW_NAME ;

    /** 登出完成跳转视图名*/
    public static String LOGOUT_VIEW_NAME ;

    /*----------------------------------------设置免授权路径数组------------------------------------------------*/
    /** 开启授权后，指定免授权的路径数组集合*/
    public static List<String> FREE_PERMISSION_PATH_LIST ;

    /*-----------------------------------------------构造-----------------------------------------------------*/
    /** 用户自定义配置文件-构造器*/
    public SecurityInterceptor() {
    }
    /**
     * 初始化插件参数
     * @param loginParameters
     */
    private void authAndPermInterceptor(LoginParameters loginParameters) {
        /*---------------------------------------------设置应用相关--------------------------------------------*/
        //应用名
        SecurityInterceptor.APPLICATION_NAME =
                StringUtil.isEmpty(
                loginParameters.getApplicationName()) ? getDefaultValueAndPrintLog("ApplicationName","default applicationName"):
                loginParameters.getApplicationName();
        //默认超时时间
        SecurityInterceptor.SSO_DEFAULT_AGE =
                StringUtil.isEmpty(
                loginParameters.getDefaultMaxAge()) ? getDefaultValueAndPrintLog("DefaultMaxAge","300"):
                loginParameters.getDefaultMaxAge();
        //cookie跨域的domain
        SecurityInterceptor.SSO_DOMAIN =
                StringUtil.isEmpty(
                loginParameters.getSsoDomain()) ? getDefaultValueAndPrintLog("SsoDomain","localhost"):
                loginParameters.getSsoDomain();
        //用户单点登出(1 : 开启 0 : 关闭(多点登出,异地登录不下线))
        SecurityInterceptor.LOGIN_OUT_STRATEGY =
                StringUtil.isEmpty(
                loginParameters.getLoginOutStrategy()) ? getDefaultValueAndPrintLog("LoginOutStrategy","1"):
                loginParameters.getLoginOutStrategy();
        /*-----------------------------------------------设置key-----------------------------------------------*/
        //获取验证码key
        SecurityInterceptor.VERIFICATION_CODE_KEY =
                StringUtil.isEmpty(
                loginParameters.getVerificationCodeKey()) ? getDefaultValueAndPrintLog("VerificationCodeKey","verificationCode"):
                loginParameters.getVerificationCodeKey();
        //用户登录策略key
        SecurityInterceptor.CACHE_CATEGORY_KEY =
                StringUtil.isEmpty(
                loginParameters.getCaCheStrategyKey()) ? getDefaultValueAndPrintLog("CaCheStrategyKey","caCheStrategy"):
                loginParameters.getCaCheStrategyKey();
        /*-----------------------------------------------设置开关-----------------------------------------------*/
        //授权开关(1 : 开启 0 : 关闭)
        SecurityInterceptor.OPEN_AUTH =
                StringUtil.isEmpty(
                loginParameters.getOpenAuth()) ? getDefaultValueAndPrintLog("OpenAuth","1"):
                loginParameters.getOpenAuth();
        //验证码验证开关(1 : 开启 0 : 关闭)
        SecurityInterceptor.CLOSE_VERIFICATION =
                StringUtil.isEmpty(
                loginParameters.getCloseVerification()) ? getDefaultValueAndPrintLog("CloseVerification","0"):
                loginParameters.getCloseVerification();
        /*--------------------------------设置指定返回json，stram 等非视图资源的Path 路径---------------------------*/
        //获取验证码路径
        SecurityInterceptor.GET_VERIFICATION_IMG_PATH =
                StringUtil.isEmpty(
                loginParameters.getVerificationImgPath()) ? getDefaultValueAndPrintLog("VerificationImgPath","/getVerificationImg"):
                loginParameters.getVerificationImgPath();
        //执行登陆路径
        SecurityInterceptor.DO_LOGIN_PATH =
                StringUtil.isEmpty(
                loginParameters.getDoLoginPath()) ? getDefaultValueAndPrintLog("DoLoginPath","/doLogin"):
                loginParameters.getDoLoginPath();
        //未开启授权应用获取用户信息路径

        /*-------------------------------设置指定跳转视图的Path映射 (requestMapping) 路径---------------------------*/
        //去往登录页面路径
        SecurityInterceptor.LOGIN_PATH =
                StringUtil.isEmpty(
                loginParameters.getLoginPath()) ? getDefaultValueAndPrintLog("LoginPath","/login"):
                loginParameters.getLoginPath();
        SpringEnvironmentUtil.setEnvironmentProperty(SecurityConstants.LOGIN_PATH_ENVIRONMENT_KEY, SecurityInterceptor.LOGIN_PATH);
        //去往首页页面路径
        SecurityInterceptor.INDEX_PATH =
                StringUtil.isEmpty(
                loginParameters.getIndexPath()) ? getDefaultValueAndPrintLog("IndexPath","/index"):
                loginParameters.getIndexPath();
        SpringEnvironmentUtil.setEnvironmentProperty(SecurityConstants.INDEX_PATH_ENVIRONMENT_KEY,INDEX_PATH);
        //去往超时页面路径
        SecurityInterceptor.OUT_OF_TIME_PATH =
                StringUtil.isEmpty(
                loginParameters.getOutOfTimePath()) ? getDefaultValueAndPrintLog("OutOfTimePath","/outOfTime"):
                loginParameters.getOutOfTimePath();
        SpringEnvironmentUtil.setEnvironmentProperty(SecurityConstants.OUT_OF_TIME_PATH_LOGIN_PATH_ENVIRONMENT_KEY,OUT_OF_TIME_PATH);
        //去往越权页面路径
        SecurityInterceptor.NO_PERMISSION_PATH =
                StringUtil.isEmpty(
                loginParameters.getNoPermissionPath()) ? getDefaultValueAndPrintLog("NoPermissionPath","/noPermission"):
                loginParameters.getNoPermissionPath();
        SpringEnvironmentUtil.setEnvironmentProperty(SecurityConstants.NO_PERMISSION_PATH_ENVIRONMENT_KEY,NO_PERMISSION_PATH);
        //去往错误页面路径
        SecurityInterceptor.ERROR_PAGE_PATH =
                StringUtil.isEmpty(
                loginParameters.getErrorPagePath()) ? getDefaultValueAndPrintLog("ErrorPagePath","/errors"):
                loginParameters.getErrorPagePath();
        SpringEnvironmentUtil.setEnvironmentProperty(SecurityConstants.ERROR_PAGE_PATH_ENVIRONMENT_KEY,ERROR_PAGE_PATH);
        //去往登出操作路径
        SecurityInterceptor.LOGOUT_PATH =
                StringUtil.isEmpty(
                loginParameters.getLogoutPath()) ? getDefaultValueAndPrintLog("LogoutPath","/logout"):
                loginParameters.getLogoutPath();
        SpringEnvironmentUtil.setEnvironmentProperty(SecurityConstants.LOGOUT_PATH_ENVIRONMENT_KEY,LOGOUT_PATH);

        /*---------------------------------设置指定跳转视图的Path的跳转视图 (view) 名称------------------------------*/
        //登录页面跳转视图名
        SecurityInterceptor.LOGIN_VIEW_NAME =
                StringUtil.isEmpty(
                loginParameters.getLoginViewName()) ? getDefaultValueAndPrintLog("LoginViewName","login"):
                loginParameters.getLoginViewName();
        SecurityConstants.VIEW_NAME_PARAMETERS.setLoginViewName(LOGIN_VIEW_NAME);
        //首页页面跳转视图名
        SecurityInterceptor.INDEX_VIEW_NAME =
                StringUtil.isEmpty(
                loginParameters.getIndexViewName()) ? getDefaultValueAndPrintLog("IndexViewName","index"):
                loginParameters.getIndexViewName();
        SecurityConstants.VIEW_NAME_PARAMETERS.setIndexViewName(INDEX_VIEW_NAME);
        //超时页面跳转视图名
        SecurityInterceptor.OUT_OF_TIME_VIEW_NAME =
                StringUtil.isEmpty(
                loginParameters.getOutOfTimeViewName()) ? getDefaultValueAndPrintLog("OutOfTimeViewName","outOfTime"):
                loginParameters.getOutOfTimeViewName();
        SecurityConstants.VIEW_NAME_PARAMETERS.setOutOfTimeViewName(OUT_OF_TIME_VIEW_NAME);
        //越权页面跳转视图名
        SecurityInterceptor.NO_PERMISSION_VIEW_NAME =
                StringUtil.isEmpty(
                loginParameters.getNoPermissionViewName()) ? getDefaultValueAndPrintLog("noPermissionViewName","noPermission"):
                loginParameters.getNoPermissionViewName();
        SecurityConstants.VIEW_NAME_PARAMETERS.setNoPermissionViewName(NO_PERMISSION_VIEW_NAME);
        //错误页面跳转视图名
        SecurityInterceptor.ERROR_PAGE_VIEW_NAME =
                StringUtil.isEmpty(
                loginParameters.getErrorPageViewName()) ? getDefaultValueAndPrintLog("ErrorPageViewName","error"):
                loginParameters.getErrorPageViewName();
        SecurityConstants.VIEW_NAME_PARAMETERS.setErrorViewName(ERROR_PAGE_VIEW_NAME);
        //登出完成跳转视图名
        SecurityInterceptor.LOGOUT_VIEW_NAME =
                StringUtil.isEmpty(
                loginParameters.getLogoutViewName()) ? getDefaultValueAndPrintLog("LogoutViewName","index"):
                loginParameters.getLogoutViewName();
        SecurityConstants.VIEW_NAME_PARAMETERS.setLogoutViewName(LOGOUT_VIEW_NAME);

        /*----------------------------------------设置免授权路径数组------------------------------------------------*/
        //开启授权后，指定免授权的路径数组集合
        SecurityInterceptor.FREE_PERMISSION_PATH_LIST = loginParameters.getFreePermissionPathList();
    }

    /**
     * 默认值采用日志
     * @param defaultKey
     * @param defaultValue
     * @return
     */
    private String getDefaultValueAndPrintLog(String defaultKey,String defaultValue) {
        LOGGER.info("buukle-security :{} 配置没有找到,将使用默认值:{}",defaultKey,defaultValue);
        return defaultValue;
    }
}

