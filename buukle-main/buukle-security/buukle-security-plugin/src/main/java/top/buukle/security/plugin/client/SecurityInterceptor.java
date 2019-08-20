package top.buukle.security.plugin.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.buukle.common.call.AppResourceResponse;
import top.buukle.security.entity.User;
import top.buukle.security.plugin.cache.SecurityInterceptorCache;
import top.buukle.security.plugin.cache.SecuritySessionContext;
import top.buukle.security.plugin.constants.SecurityInterceptorConstants;
import top.buukle.security.plugin.enums.SecurityExceptionEnum;
import top.buukle.security.plugin.exception.SecurityPluginException;
import top.buukle.security.plugin.invoker.SecurityInterceptorInvoker;
import top.buukle.security.plugin.util.CookieUtil;
import top.buukle.security.plugin.util.SessionUtil;
import top.buukle.util.NumberUtil;
import top.buukle.util.StringUtil;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @description  认证授权插件
 * @Author elvin
 * @Date 2019/8/2
 */
public class SecurityInterceptor implements HandlerInterceptor {

    @Autowired
    private Environment env;
    @Autowired
    private SecurityInterceptorInvoker invoker;
    @Autowired
    private SecuritySessionContext sessionContext;

    @PostConstruct
    private void beforeInit() throws ExecutionException {
        // 加载app资源列表
        SecurityInterceptorCache.loadAppResourceCache(invoker,env.getProperty("spring.application.name"));
    }

    /**
     * @description 前置处理
     * @param request
     * @param response
     * @param handler
     * @return boolean
     * @Author zhanglei1102
     * @Date 2019/8/2
     */
    @Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 认证
        boolean authentic = !SecurityInterceptorConstants.OPEN_AUTH_TRUE.equals(env.getProperty("security.openAuth")) || this.authentic(request, response);
        // 授权
        return authentic ? ( !SecurityInterceptorConstants.OPEN_PERM_TRUE.equals(env.getProperty("security.openPerm")) || this.permission(request, response)  ): authentic;
    }

    /**
     * @description 认证
     * @param request
     * @param response
     * @return void
     * @Author zhanglei1102
     * @Date 2019/8/2
     */
    private boolean authentic(HttpServletRequest request, HttpServletResponse response) throws ExecutionException, IOException {
        if(StringUtil.isEmpty(CookieUtil.getUserCookie(request))){
            this.writeNoticePage(response,SecurityInterceptorConstants.NO_AUTH_RETURN_HTML_TEMPLATE.replace(SecurityInterceptorConstants.BUUKLE_NO_AUTH_CONTENT_TEMPLATE,"未登录!").replace("security.passport.host",env.getProperty("security.passport.host")));
            return false;
        }
        User user = SessionUtil.getUser(request, response);
        if(null == user){
            CookieUtil.delUserCookie(response,SecurityInterceptorConstants.LOGIN_COOKIE_DOMAIN);
            this.writeNoticePage(response,SecurityInterceptorConstants.NO_AUTH_RETURN_HTML_TEMPLATE.replace(SecurityInterceptorConstants.BUUKLE_NO_AUTH_CONTENT_TEMPLATE,"该账户已在其他设备登录!").replace("security.passport.host",env.getProperty("security.passport.host")));
            return false;
        }
        // 更新用户活跃域
        sessionContext.registerInSessionContext(request,user.getUserId(),user.getLoginStrategy() ==null ? NumberUtil.INTEGER_ONE_MINUTES_SECOND * 3 : NumberUtil.INTEGER_ONE_WEEK_SECOND);
        // 刷新cookie超时时间
        CookieUtil.refreshCookie(request,response,user.getLoginStrategy() ==null ? NumberUtil.INTEGER_ONE_MINUTES_SECOND * 3 : NumberUtil.INTEGER_ONE_WEEK_SECOND);
        // 刷新session超时时间
        sessionContext.refreshDDL(user.getUserId(),user.getLoginStrategy() ==null ? NumberUtil.INTEGER_ONE_MINUTES_SECOND * 3 : NumberUtil.INTEGER_ONE_WEEK_SECOND);
        return true;
    }

    /**
     * @description 回写提示页面
     * @param response
     * @param html
     * @return void
     * @Author elvin
     * @Date 2019/8/3
     */
    private void writeNoticePage(HttpServletResponse response, String html) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.write(html);
        out.close();
    }

    /**
     * @description 授权
     * @param request
     * @param response
     * @return boolean
     * @Author zhanglei1102
     * @Date 2019/8/2
     */
    private boolean permission(HttpServletRequest request, HttpServletResponse response) throws ExecutionException, IOException {
        AppResourceResponse appResourceResponse = SecurityInterceptorCache.get();
        String uri = request.getRequestURI().replace("//", "/");
        // 注册验证
        if(SecurityInterceptorConstants.OPEN_REGS_TRUE.equals(env.getProperty("security.openRegs")) ){
            if( null == appResourceResponse ||
                    CollectionUtils.isEmpty(appResourceResponse.getRegisteredResourceList()) ||
                    !appResourceResponse.getRegisteredResourceList().contains(uri)
                    ){
                this.writeNoticePage(response,SecurityInterceptorConstants.NO_PERM_RETURN_HTML_TEMPLATE.replace("noPerm",SecurityExceptionEnum.APP_NO_REG.getMsg()));
                return false;
            }
        }
        // 授权验证
        List<String> list = (List<String>) SessionUtil.get(request,SessionUtil.USER_URL_LIST_KEY);
        if(CollectionUtils.isEmpty(list) || !list.contains(uri)){
            if("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))){
                throw new SecurityPluginException(SecurityExceptionEnum.USER_NO_PERM);
            }else{
                this.writeNoticePage(response,SecurityInterceptorConstants.NO_PERM_RETURN_HTML_TEMPLATE.replace("noPerm",SecurityExceptionEnum.USER_NO_PERM.getMsg()));
            }
            return false;
        }
        return true;
    }

    @Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {}
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {}

}

