package top.buukle.plugin.security.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;
import top.buukle.common.request.BaseRequest;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.common.StringUtil;
import top.buukle.common.util.logger.BaseLogger;
import top.buukle.plugin.security.constants.SecurityConstants;
import top.buukle.plugin.security.entity.Button;
import top.buukle.plugin.security.entity.ButtonType;
import top.buukle.plugin.security.vo.query.UserLoginPermissionQuery;
import top.buukle.plugin.security.business.SecurityBusiness;
import top.buukle.plugin.security.invoker.SecurityInvoker;
import top.buukle.plugin.security.plugins.SecurityInterceptor;
import top.buukle.plugin.security.util.CookieUtil;
import org.springframework.stereotype.Component;
import top.buukle.plugin.security.entity.User;
import top.buukle.plugin.security.vo.response.ModuleNavigationVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/6/10.
 * @Description :
 */
@Component()
public class SecurityBusinessImpl implements SecurityBusiness {

    private static final BaseLogger LOGGER = BaseLogger.getLogger(SecurityBusinessImpl.class);

    @Autowired
    private  SecurityInvoker securityInvoker;


    /**
     * 登录
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    public BaseResponse doLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 关闭验证码
        if(StringUtil.isNotEmpty(SecurityInterceptor.CLOSE_VERIFICATION) && SecurityInterceptor.CLOSE_VERIFICATION.equals(SecurityConstants.CLOSE_VERIFY_TRUE)){
            // 登录
            return this.doLogin(request, SecurityInterceptor.CACHE_CATEGORY_KEY, SecurityInterceptor.SSO_DEFAULT_AGE, response, SecurityInterceptor.SSO_DOMAIN, SecurityInterceptor.LOGIN_OUT_STRATEGY, SecurityInterceptor.APPLICATION_NAME);
        }
        // 开启验证码
        // 缓存request验证码
        String requestVerificationCode = request.getParameter(SecurityInterceptor.VERIFICATION_CODE_KEY);
        if(StringUtil.isEmpty(requestVerificationCode)){
            return new BaseResponse.Builder().buildFailedInner(BaseResponseCode.USER_LOGIN_VERIFY_CODE_NULL);
        }
        // 缓存session验证码
        String sessionVerificationCode = (String) request.getSession().getAttribute(SecurityConstants.VERIFY_CODE_KEY_PREFIX + SecurityInterceptor.VERIFICATION_CODE_KEY);
        // 移除session验证码
        request.getSession().removeAttribute(SecurityConstants.VERIFY_CODE_KEY_PREFIX+ SecurityInterceptor.VERIFICATION_CODE_KEY);
        // 验证码错误
        if(!requestVerificationCode.equals(sessionVerificationCode)){
            return new BaseResponse.Builder().buildFailedInner(BaseResponseCode.USER_LOGIN_VERIFY_CODE_WRONG);
        }
        // 登录
        return this.doLogin(request, SecurityInterceptor.CACHE_CATEGORY_KEY, SecurityInterceptor.SSO_DEFAULT_AGE,response, SecurityInterceptor.SSO_DOMAIN, SecurityInterceptor.LOGIN_OUT_STRATEGY, SecurityInterceptor.APPLICATION_NAME);
    }

    /**
     * 登录
     * @param request
     * @param cacheCategoryKey
     * @param ssoDefaultAge
     * @param response
     * @param ssoDomain
     * @param loginOutStrategy
     * @param applicationName
     * @return
     * @throws Exception
     */
    private BaseResponse doLogin(HttpServletRequest request, String cacheCategoryKey, String ssoDefaultAge, HttpServletResponse response, String ssoDomain, String loginOutStrategy, String applicationName) throws Exception {
        // 校验参数
        User user = this.validateLoginParam(request,cacheCategoryKey);
        BaseRequest baseRequest = new BaseRequest.Builder().build(applicationName,SecurityInterceptor.APPLICATION_NAME);
        baseRequest.setInfo(user);
        baseRequest.setExpandParameterString(ssoDefaultAge);
        BaseResponse baseResponse = securityInvoker.doLogin(baseRequest);
        // 成功,回写cookie
        if(baseResponse ==null){
            return new BaseResponse.Builder().buildFailedInner(BaseResponseCode.USER_AUTHENTICATION_FAILED_REQUEST_WRONG);
        }
        if(baseResponse.isSuccess()){
            String userCookie = (String) baseResponse.getDataWithIndex(String.class,0);
            CookieUtil.addLocalCookieWithAWeekTime(userCookie,response,ssoDomain);
        }
        return baseResponse;
    }

    /**
     * 登出
     * @param request
     * @param response
     */
    @Override
    public BaseResponse logout(HttpServletRequest request, HttpServletResponse response) {
        String userCookie = CookieUtil.getUserCookie(request);
        if(null == request || StringUtil.isEmpty(userCookie)){
            return new BaseResponse();
        }
        return this.logout(userCookie, response, SecurityInterceptor.SSO_DOMAIN, SecurityInterceptor.LOGIN_OUT_STRATEGY, SecurityInterceptor.APPLICATION_NAME);
    }

    /**
     * 登出
     * @param userCookie
     * @param response
     */
    public BaseResponse logout(String userCookie, HttpServletResponse response, String ssoDomain, String loginOutStrategy, String applicationName) {
        BaseRequest baseRequest = new BaseRequest.Builder().build(applicationName,SecurityInterceptor.APPLICATION_NAME);
        baseRequest.setInfo(userCookie);
        BaseResponse baseResponse = securityInvoker.logout(baseRequest);
        if(baseResponse ==null){
            return new BaseResponse.Builder().buildFailedInner(BaseResponseCode.USER_AUTHENTICATION_FAILED_REQUEST_WRONG);
        }
        // 删除cookie
        if(baseResponse.isSuccess()){
            CookieUtil.delLocalCookie(response,ssoDomain);
        }
        return baseResponse;
    }


    /**
     * 认证&授权
     * @param request
     * @param response
     * @param uri
     * @param ssoDefaultAge
     * @param applicationName
     * @return
     */
    @Override
    public BaseResponse authAndSetPermission(HttpServletRequest request, HttpServletResponse response, String uri, String ssoDefaultAge,  String applicationName) throws Exception {
        // 无cookie
        if(StringUtil.isEmpty(CookieUtil.getUserCookie(request))){
            return new BaseResponse.Builder().buildFailed(SecurityConstants.NO_LOGIN);
        }
        // 无来源url
        if(StringUtil.isEmpty(request.getHeader(SecurityInterceptor.REQUEST_HEADER_REFEREE)) && !uri.equals(SecurityInterceptor.INDEX_PATH)){
            return new BaseResponse.Builder().buildFailed(SecurityConstants.NO_REEFER_PATH);
        }
        // 认证
        BaseResponse authResponse = this.authentication(request, ssoDefaultAge, applicationName);
        if(null == authResponse){
            return new BaseResponse.Builder().buildFailedInner(BaseResponseCode.USER_AUTHENTICATION_FAILED_REQUEST_WRONG);
        }
        if(!authResponse.isSuccess()){
            authResponse.setMsg(SecurityInterceptor.NO_AUTHENTICATION_PATH);
            return authResponse;
        }
        // 授权
        BaseResponse baseResponse = this.setPermission(uri, request, SecurityInterceptor.APPLICATION_NAME, authResponse);
        if(!baseResponse.isSuccess()){
            baseResponse.setMsg(SecurityInterceptor.NO_PERMISSION_PATH);
        }
        return baseResponse;
    }

    /**
     * 获取用户菜单树
     * @param httpServletRequest
     * @return
     */
    @Override
    public List<ModuleNavigationVo> getUserModuleTree(HttpServletRequest httpServletRequest) {
        // 校验参数
        String userCookie = this.validateAuthenticationParam(httpServletRequest,SecurityInterceptor.APPLICATION_NAME);
        BaseRequest baseRequest = new BaseRequest.Builder().build(SecurityInterceptor.APPLICATION_NAME, SecurityInterceptor.APPLICATION_NAME);
        baseRequest.setInfo(userCookie);
        return securityInvoker.getUserModuleTree(baseRequest);
    }

    /**
     * 获取用户信息
     * @param request
     * @return
     */
    @Override
    public User getUserInfo(HttpServletRequest request) {
        // 校验参数
        String userCookie = this.validateAuthenticationParam(request,SecurityInterceptor.APPLICATION_NAME);
        BaseRequest baseRequest = new BaseRequest.Builder().build(SecurityInterceptor.APPLICATION_NAME, SecurityInterceptor.APPLICATION_NAME);
        baseRequest.setInfo(userCookie);
        return securityInvoker.getUserInfo(baseRequest);
    }

    /**
     * 获取全局按钮类型
     * @return
     */
    @Override
    public List<ButtonType> getButtonTypes() {
        BaseRequest baseRequest = new BaseRequest.Builder().build(SecurityInterceptor.APPLICATION_NAME, SecurityInterceptor.APPLICATION_NAME);
        return securityInvoker.getButtonTypes(baseRequest);
    }

    /**
     * 获取菜单下的按钮
     * @param request
     * @param moduleId
     * @return
     */
    @Override
    public List<Button> getModuleButtons(HttpServletRequest request, Integer moduleId) {
        // 校验参数
        this.validateAuthenticationParam(request,SecurityInterceptor.APPLICATION_NAME);
        BaseRequest baseRequest = new BaseRequest.Builder().build(SecurityInterceptor.APPLICATION_NAME, SecurityInterceptor.APPLICATION_NAME);
        baseRequest.setInfo(moduleId);
        return securityInvoker.getModuleButtons(baseRequest);
    }

    /**
     * 获取用户下辖信息列表
     * @param userId
     * @return
     */
    @Override
    public List<String> getUserSubordinate(String userId) {
        BaseRequest baseRequest = new BaseRequest.Builder().build(SecurityInterceptor.APPLICATION_NAME, SecurityInterceptor.APPLICATION_NAME);
        baseRequest.setInfo(userId);
        return securityInvoker.getUserSubordinate(baseRequest);
    }

    /**
     * 获取文章作者信息
     * @param userId
     * @return
     */
    @Override
    public User getArticleAuthor(String userId) {
        BaseRequest baseRequest = new BaseRequest.Builder().build(SecurityInterceptor.APPLICATION_NAME, SecurityInterceptor.APPLICATION_NAME);
        baseRequest.setInfo(userId);
        return securityInvoker.getArticleAuthor(baseRequest);
    }

    /**
     * 更新用户基本信息
     * @param user
     * @param httpServletRequest
     * @return
     */
    @Override
    public BaseResponse updateUserBasicResource(User user, HttpServletRequest httpServletRequest) {
        BaseRequest baseRequest = new BaseRequest.Builder().build(SecurityInterceptor.APPLICATION_NAME, SecurityInterceptor.APPLICATION_NAME);
        user.setGender(user.getGender().equals("男") ? "1" : "0");
        baseRequest.setInfo(user);
        String userCookie = CookieUtil.getUserCookie(httpServletRequest);
        baseRequest.setExpandParameterString(userCookie);
        return securityInvoker.updateUserBasicResource(baseRequest);
    }

    /**
     * 注册新用户
     * @param request
     * @param response
     * @return
     */
    @Override
    public BaseResponse doRegister(HttpServletRequest request, HttpServletResponse response) {
        // 校验参数
        User user = this.validateLoginParamForRegister(request);
        BaseRequest baseRequest = new BaseRequest.Builder().build(SecurityInterceptor.APPLICATION_NAME, SecurityInterceptor.APPLICATION_NAME);
        baseRequest.setInfo(user);
        return securityInvoker.doRegister(baseRequest);
    }

    /**
     * 校验注册参数
     * @param request
     * @return
     */
    private User validateLoginParamForRegister(HttpServletRequest request) {
        String username = request.getParameter("usernameRegister");
        String password = request.getParameter("passwordRegister");
        String passwordRegisterConfirm = request.getParameter("passwordRegisterConfirm");

        // 校验验证码
        String verificationCode = request.getParameter(SecurityInterceptor.VERIFICATION_CODE_KEY);
        if(StringUtil.isEmpty(verificationCode)){
            throw new BaseException(BaseResponseCode.USER_LOGIN_VERIFY_CODE_NULL);
        }
        // 缓存session验证码
        String sessionVerificationCode = (String) request.getSession().getAttribute(SecurityConstants.VERIFY_CODE_KEY_PREFIX + SecurityInterceptor.VERIFICATION_CODE_KEY);
        // 移除session验证码
        request.getSession().removeAttribute(SecurityConstants.VERIFY_CODE_KEY_PREFIX+ SecurityInterceptor.VERIFICATION_CODE_KEY);
        // 验证码错误
        if(!verificationCode.equals(sessionVerificationCode)){
            throw new BaseException(BaseResponseCode.USER_LOGIN_VERIFY_CODE_WRONG);
        }
        // 用户名,密码验空
        if(StringUtil.isEmpty(username) || StringUtil.isEmpty(password)){
            throw new BaseException(BaseResponseCode.USER_REGISTER_FAILED_USERNAME_OR_PWD_NULL);
        }
        // 校验密码与确认密码
        if(!password.equals(passwordRegisterConfirm)){
            throw new BaseException(BaseResponseCode.USER_REGISTER_FAILED_CONFIRM_PWD_WRONG);
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }

    /**
     * 认证
     * @param httpServletRequest
     * @param ssoDefaultAge
     * @param applicationName
     * @return
     */
    private BaseResponse authentication(HttpServletRequest httpServletRequest, String ssoDefaultAge, String applicationName) throws Exception {
        // 校验参数
        String userCookie = this.validateAuthenticationParam(httpServletRequest,applicationName);
        BaseRequest baseRequest = new BaseRequest.Builder().build(applicationName, SecurityInterceptor.APPLICATION_NAME);
        baseRequest.setInfo(userCookie);
        baseRequest.setExpandParameterString(ssoDefaultAge);
        return securityInvoker.authentication(baseRequest);
    }

    /**
     * 授权
     * @param uri
     * @param request
     * @param applicationName
     * @param authResponse
     * @return
     */
    private BaseResponse setPermission(String uri, HttpServletRequest request, String applicationName, BaseResponse authResponse) throws Exception {
        User user = (User) authResponse.getDataWithIndex(User.class, 0);
        BaseRequest baseRequest = new BaseRequest.Builder().setOperationId(user.getUserId()).setOperationLoginName(user.getUsername()).setOperationName(user.getNameCn()).build(applicationName, SecurityInterceptor.APPLICATION_NAME);
        UserLoginPermissionQuery userLoginPermissionQuery = new UserLoginPermissionQuery();
        userLoginPermissionQuery.setUrl(uri);
        userLoginPermissionQuery.setUser(user);
        userLoginPermissionQuery.setUserCookie(CookieUtil.getUserCookie(request));
        baseRequest.setInfo(userLoginPermissionQuery);
        return securityInvoker.setPermission(baseRequest);
    }
    /**
     * 校验登录参数
     * @param request
     * @param cacheCategoryKey
     * @return
     */
    private User validateLoginParam(HttpServletRequest request, String cacheCategoryKey) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String cacheCategory = request.getParameter(cacheCategoryKey);
        if(StringUtil.isEmpty(username) || StringUtil.isEmpty(password)){
            throw new BaseException(BaseResponseCode.USER_LOGIN_USERNAME_PASSWORD_NULL_SSO_PLUGIN);
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setLoginStrategy(cacheCategory ==null ? 0: Integer.parseInt(cacheCategory));
        return user;
    }
    /**
     * 校验认证参数
     * @param httpServletRequest
     * @param applicationName
     * @return
     */
    private String validateAuthenticationParam(HttpServletRequest httpServletRequest, String applicationName) {
        if(null == httpServletRequest){
            throw new BaseException(BaseResponseCode.BASE_REQUEST_NULL);
        }
        if(StringUtil.isEmpty(applicationName)){
            throw new BaseException(BaseResponseCode.BASE_REQUEST_APPLICATION_NAME_NULL);
        }
        String userCookie = CookieUtil.getUserCookie(httpServletRequest);
        if(StringUtil.isEmpty(userCookie)){
            throw new BaseException(BaseResponseCode.USER_AUTHENTICATION_FAILED_COOKIE_NULL);
        }
        return userCookie;
    }
}
