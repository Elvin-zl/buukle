package top.buukle.security.plugin.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.buukle.common.call.AppResourceResponse;
import top.buukle.common.call.CommonResponse;
import top.buukle.common.call.code.BaseReturnEnum;
import top.buukle.common.exception.CommonException;
import top.buukle.security.entity.User;
import top.buukle.security.plugin.cache.SecurityInterceptorCache;
import top.buukle.security.plugin.cache.SecuritySessionContext;
import top.buukle.security.plugin.constants.SecurityInterceptorConstants;
import top.buukle.security.plugin.enums.SecurityExceptionEnum;
import top.buukle.security.plugin.invoker.SecurityInterceptorInvoker;
import top.buukle.security.plugin.util.CookieUtil;
import top.buukle.security.plugin.util.SessionUtil;
import top.buukle.util.JsonUtil;
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

    private static final String SECURITY_PASSPORT_HOST = "security.passport.host";
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
    private boolean authentic(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 未登录
        if(StringUtil.isEmpty(CookieUtil.getUserCookie(request))){
            this.writeNoticePage(request,response,SecurityInterceptorConstants.NO_AUTH_RETURN_HTML_TEMPLATE.replace(SecurityInterceptorConstants.BUUKLE_NO_AUTH_CONTENT_TEMPLATE,SecurityExceptionEnum.AUTH_WRONG_NO_COOKIE.getMsg()).replace(SECURITY_PASSPORT_HOST,env.getProperty(SECURITY_PASSPORT_HOST)),
                    SecurityExceptionEnum.AUTH_WRONG_NO_COOKIE.getCode(),SecurityExceptionEnum.AUTH_WRONG_NO_COOKIE.getMsg());
            return false;
        }
        User user = SessionUtil.getUser(request, response);
        // 登录超时
        if(null == user){
            CookieUtil.delUserCookie(response,SecurityInterceptorConstants.LOGIN_COOKIE_DOMAIN);
            this.writeNoticePage(request,response,SecurityInterceptorConstants.NO_AUTH_RETURN_HTML_TEMPLATE.replace(SecurityInterceptorConstants.BUUKLE_NO_AUTH_CONTENT_TEMPLATE,SecurityExceptionEnum.AUTH_WRONG_OUT_OF_TIME.getMsg()).replace(SECURITY_PASSPORT_HOST,env.getProperty(SECURITY_PASSPORT_HOST)),
                    SecurityExceptionEnum.AUTH_WRONG_OUT_OF_TIME.getCode(),
                    SecurityExceptionEnum.AUTH_WRONG_OUT_OF_TIME.getMsg());
            return false;
        }
        // 登录已经被挤掉
        if(user.getUserId().equals( SecurityExceptionEnum.AUTH_WRONG_COOKIE_OTHER.getCode())){
            CookieUtil.delUserCookie(response,SecurityInterceptorConstants.LOGIN_COOKIE_DOMAIN);
            this.writeNoticePage(request,response,SecurityInterceptorConstants.NO_AUTH_RETURN_HTML_TEMPLATE.replace(SecurityInterceptorConstants.BUUKLE_NO_AUTH_CONTENT_TEMPLATE,SecurityExceptionEnum.AUTH_WRONG_COOKIE_OTHER.getMsg()).replace(SECURITY_PASSPORT_HOST,env.getProperty(SECURITY_PASSPORT_HOST)),
                    SecurityExceptionEnum.AUTH_WRONG_COOKIE_OTHER.getCode(),
                    SecurityExceptionEnum.AUTH_WRONG_COOKIE_OTHER.getMsg());
            return false;
        }
        // 更新用户活跃域
        sessionContext.registerInSessionContext(request,user.getUserId(),SessionUtil.getUserExpire(user));
        // 刷新cookie超时时间
        CookieUtil.refreshCookie(request,response,SessionUtil.getUserExpire(user));
        // 刷新session超时时间
        sessionContext.refreshDDL(user.getUserId(),SessionUtil.getUserExpire(user));
        return true;
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
                this.writeNoticePage(request, response,SecurityInterceptorConstants.NO_PERM_RETURN_HTML_TEMPLATE.replace("noPerm",SecurityExceptionEnum.AUTH_WRONG_APP_NO_REG.getMsg()),
                        SecurityExceptionEnum.AUTH_WRONG_APP_NO_REG.getCode(),
                        SecurityExceptionEnum.AUTH_WRONG_APP_NO_REG.getMsg());
                return false;
            }
        }
        // 授权验证
        List<String> list = (List<String>) SessionUtil.get(request,SessionUtil.USER_URL_LIST_KEY);
        if(CollectionUtils.isEmpty(list) || !list.contains(uri)){
            this.writeNoticePage(request, response,SecurityInterceptorConstants.NO_PERM_RETURN_HTML_TEMPLATE.replace("noPerm",SecurityExceptionEnum.AUTH_WRONG_NO_PERM.getMsg()),
                    SecurityExceptionEnum.AUTH_WRONG_NO_PERM.getCode(),
                    SecurityExceptionEnum.AUTH_WRONG_NO_PERM.getMsg());
            return false;
        }
        return true;
    }

    /**
     * @description 回写提示
     * @param request
     * @param response
     * @param html
     * @param msg
     * @return void
     * @Author elvin
     * @Date 2019/8/3
     */
    private void writeNoticePage(HttpServletRequest request, HttpServletResponse response, String html,String code, String msg) throws IOException {
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        // 非 ajax 写页面返回
        if(!"XMLHttpRequest".equals(request.getHeader("X-Requested-With"))){
            response.setContentType("text/html");
            out.write(html);
            out.close();
        }
        // ajax 写json返回
        else{
            out.write(JsonUtil.toJSONString(new CommonResponse.Builder().buildFailedInner(new CommonException(BaseReturnEnum.FAILED,code, msg))));
            out.close();
        }
    }
    @Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)  {}
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)  {}

}

