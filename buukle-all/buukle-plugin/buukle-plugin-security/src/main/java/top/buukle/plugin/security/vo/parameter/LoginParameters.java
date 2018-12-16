package top.buukle.plugin.security.vo.parameter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/8/30.
 * @Description :
 */

@Component
public class LoginParameters {
    /*---------------------------------------------设置应用相关--------------------------------------------*/
    /** 应用名*/
    @Value("${security.applicationName:}")
    private String applicationName;

    /** security 发现服务应用名*/
    @Value("${security.server.name:}")
    private String serverName;

    /** 默认超时时间*/
    @Value("${security.defaultMaxAge:}")
    private String defaultMaxAge;

    /** cookie跨域的domain*/
    @Value("${security.ssoDomain:}")
    private String ssoDomain;

    /** 用户登出策略(1 : 单点登出 0 : 多点登出)*/
    @Value("${security.loginOutStrategy:}")
    private String loginOutStrategy;
    /*-----------------------------------------------设置key-----------------------------------------------*/

    /** 获取验证码key*/
    @Value("${security.verificationCodeKey:}")
    private String verificationCodeKey;

    /** 用户登录策略key*/
    @Value("${security.caCheStrategyKey:}")
    private String caCheStrategyKey;

    /*-----------------------------------------------设置开关-----------------------------------------------*/

    /** 授权开关(1 : 开启 0 : 关闭)*/
    @Value("${security.openAuth:}")
    private String openAuth;

    /** 验证码验证开关(1 : 关闭 无 : 开启)*/
    @Value("${security.closeVerification:}")
    private String closeVerification;
    /*--------------------------------设置指定返回json，stram 等非视图资源的Path 路径---------------------------*/

    /** 获取验证码路径*/
    @Value("${security.verificationImgPath:}")
    private String verificationImgPath;

    /** 执行登陆路径*/
    @Value("${security.doLoginPath:}")
    private String doLoginPath;

    /** 未开启授权应用获取用户信息路径*/
    @Value("${security.autoLoginPath:}")
    private String autoLoginPath;
    /*-------------------------------设置指定跳转视图的Path映射 (requestMapping) 路径---------------------------*/

    /** 去往登录页面路径*/
    @Value("${security.loginPath:}")
    private String loginPath;

    /** 去往首页页面路径*/
    @Value("${security.indexPath:}")
    private String indexPath;

    /** 去往超时页面路径*/
    @Value("${security.outOfTimePath:}")
    private String outOfTimePath;

    /** 去往越权页面路径*/
    @Value("${security.noPermissionPath:}")
    private String noPermissionPath;

    /** 去往越权页面路径*/
    @Value("${security.errorPagePath:}")
    private String errorPagePath;

    /** 去往登出操作路径*/
    @Value("${security.logoutPath:}")
    private String logoutPath;
    /*---------------------------------设置指定跳转视图的Path的跳转视图 (view) 名称------------------------------*/

    /** 登录页面跳转视图名*/
    @Value("${security.loginViewName:}")
    private String loginViewName;

    /** 首页页面跳转视图名*/
    @Value("${security.indexViewName:}")
    private String indexViewName;

    /** 超时页面跳转视图名*/
    @Value("${security.outOfTimeViewName:}")
    private String outOfTimeViewName;

    /** 越权页面跳转视图名*/
    @Value("${security.noPermissionViewName:}")
    private String noPermissionViewName;

    /** 错误页面跳转视图名*/
    @Value("${security.errorPageViewName:}")
    private String errorPageViewName;

    /** 登出完成跳转视图名*/
    @Value("${security.logoutViewName:}")
    private String logoutViewName;

    /*----------------------------------------设置免授权路径数组------------------------------------------------*/

    /** 开启授权后，指定免授权的路径数组集合*/
    private List<String> freePermissionPathList = new ArrayList<>();
    //end

    public LoginParameters() {
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getDefaultMaxAge() {
        return defaultMaxAge;
    }

    public void setDefaultMaxAge(String defaultMaxAge) {
        this.defaultMaxAge = defaultMaxAge;
    }

    public String getSsoDomain() {
        return ssoDomain;
    }

    public void setSsoDomain(String ssoDomain) {
        this.ssoDomain = ssoDomain;
    }

    public String getLoginOutStrategy() {
        return loginOutStrategy;
    }

    public void setLoginOutStrategy(String loginOutStrategy) {
        this.loginOutStrategy = loginOutStrategy;
    }

    public String getVerificationCodeKey() {
        return verificationCodeKey;
    }

    public void setVerificationCodeKey(String verificationCodeKey) {
        this.verificationCodeKey = verificationCodeKey;
    }

    public String getCaCheStrategyKey() {
        return caCheStrategyKey;
    }

    public void setCaCheStrategyKey(String caCheStrategyKey) {
        this.caCheStrategyKey = caCheStrategyKey;
    }

    public String getOpenAuth() {
        return openAuth;
    }

    public void setOpenAuth(String openAuth) {
        this.openAuth = openAuth;
    }

    public String getCloseVerification() {
        return closeVerification;
    }

    public void setCloseVerification(String closeVerification) {
        this.closeVerification = closeVerification;
    }

    public String getVerificationImgPath() {
        return verificationImgPath;
    }

    public void setVerificationImgPath(String verificationImgPath) {
        this.verificationImgPath = verificationImgPath;
    }

    public String getDoLoginPath() {
        return doLoginPath;
    }

    public void setDoLoginPath(String doLoginPath) {
        this.doLoginPath = doLoginPath;
    }

    public String getAutoLoginPath() {
        return autoLoginPath;
    }

    public void setAutoLoginPath(String autoLoginPath) {
        this.autoLoginPath = autoLoginPath;
    }

    public String getLoginPath() {
        return loginPath;
    }

    public void setLoginPath(String loginPath) {
        this.loginPath = loginPath;
    }

    public String getIndexPath() {
        return indexPath;
    }

    public void setIndexPath(String indexPath) {
        this.indexPath = indexPath;
    }

    public String getOutOfTimePath() {
        return outOfTimePath;
    }

    public void setOutOfTimePath(String outOfTimePath) {
        this.outOfTimePath = outOfTimePath;
    }

    public String getNoPermissionPath() {
        return noPermissionPath;
    }

    public void setNoPermissionPath(String noPermissionPath) {
        this.noPermissionPath = noPermissionPath;
    }

    public String getErrorPagePath() {
        return errorPagePath;
    }

    public void setErrorPagePath(String errorPagePath) {
        this.errorPagePath = errorPagePath;
    }

    public String getLogoutPath() {
        return logoutPath;
    }

    public void setLogoutPath(String logoutPath) {
        this.logoutPath = logoutPath;
    }

    public String getLoginViewName() {
        return loginViewName;
    }

    public void setLoginViewName(String loginViewName) {
        this.loginViewName = loginViewName;
    }

    public String getIndexViewName() {
        return indexViewName;
    }

    public void setIndexViewName(String indexViewName) {
        this.indexViewName = indexViewName;
    }

    public String getOutOfTimeViewName() {
        return outOfTimeViewName;
    }

    public void setOutOfTimeViewName(String outOfTimeViewName) {
        this.outOfTimeViewName = outOfTimeViewName;
    }

    public String getNoPermissionViewName() {
        return noPermissionViewName;
    }

    public void setNoPermissionViewName(String noPermissionViewName) {
        this.noPermissionViewName = noPermissionViewName;
    }

    public String getErrorPageViewName() {
        return errorPageViewName;
    }

    public void setErrorPageViewName(String errorPageViewName) {
        this.errorPageViewName = errorPageViewName;
    }

    public String getLogoutViewName() {
        return logoutViewName;
    }

    public void setLogoutViewName(String logoutViewName) {
        this.logoutViewName = logoutViewName;
    }

    public List<String> getFreePermissionPathList() {
        return freePermissionPathList;
    }

    public void setFreePermissionPathList(List<String> freePermissionPathList) {
        this.freePermissionPathList = freePermissionPathList;
    }
}
