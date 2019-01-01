package top.buukle.plugin.security.invoker;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import top.buukle.common.annotation.InvokerLoggingAnnotation;
import top.buukle.common.request.BaseRequest;
import top.buukle.common.response.BaseResponse;
import top.buukle.plugin.security.entity.Button;
import top.buukle.plugin.security.entity.ButtonType;
import top.buukle.plugin.security.entity.User;
import top.buukle.plugin.security.plugins.SecurityInterceptor;
import top.buukle.plugin.security.vo.response.ModuleNavigationVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/1.
 * @Description : 登录登出认证授权 FeignClient代理执行层对象
 */
@FeignClient(name = "${security.server.name}" ,url = "${security.server.url}")
public interface SecurityInvoker{
    /**
     * 执行登陆
     * @param request
     * @return
     */
    @PostMapping(value = SecurityInterceptor.API_URI_PREFIX + "/doLogin")
    BaseResponse doLogin(BaseRequest request);


    /**
     * 登出
     * @param request
     * @return
     */
    @PostMapping(value = SecurityInterceptor.API_URI_PREFIX + "/logout")
    BaseResponse logout(BaseRequest request);


    /**
     * 认证
     * @param request
     * @return
     */
    @InvokerLoggingAnnotation(InvokerLoggingAnnotation.PRINT_FALSE)
    @PostMapping(value = SecurityInterceptor.API_URI_PREFIX + "/authentication")
    BaseResponse authentication(BaseRequest request);

    /**
     * 授权
     * @param request
     * @return
     */
    @InvokerLoggingAnnotation(InvokerLoggingAnnotation.PRINT_FALSE)
    @PostMapping(value = SecurityInterceptor.API_URI_PREFIX + "/setPermission")
    BaseResponse setPermission(BaseRequest request);


    /**
     * 获取用户菜单树
     * @param baseRequest
     * @return
     */
    @InvokerLoggingAnnotation(InvokerLoggingAnnotation.PRINT_FALSE)
    @PostMapping(value = SecurityInterceptor.API_URI_PREFIX + "/getUserModuleTree")
    List<ModuleNavigationVo> getUserModuleTree(BaseRequest baseRequest);

    /**
     * 获取用户信息
     * @param baseRequest
     * @return
     */
    @InvokerLoggingAnnotation(InvokerLoggingAnnotation.PRINT_FALSE)
    @PostMapping(value = SecurityInterceptor.API_URI_PREFIX + "/getUserInfo")
    User getUserInfo(BaseRequest baseRequest);

    /**
     * 获取按钮类型
     * @param baseRequest
     * @return
     */
    @InvokerLoggingAnnotation(InvokerLoggingAnnotation.PRINT_FALSE)
    @PostMapping(value = SecurityInterceptor.API_URI_PREFIX + "/getButtonTypes")
    List<ButtonType> getButtonTypes(BaseRequest baseRequest);

    /**
     * 获取菜单下的按钮信息
     * @param baseRequest
     * @return
     */
    @InvokerLoggingAnnotation(InvokerLoggingAnnotation.PRINT_FALSE)
    @PostMapping(value = SecurityInterceptor.API_URI_PREFIX + "/getModuleButtons")
    List<Button> getModuleButtons(BaseRequest baseRequest);

    /**
     * 获取用户下辖列表信息
     * @param baseRequest
     * @return
     */
    @InvokerLoggingAnnotation(InvokerLoggingAnnotation.PRINT_FALSE)
    @PostMapping(value = SecurityInterceptor.API_URI_PREFIX + "/getUserSubordinate")
    List<String> getUserSubordinate(BaseRequest baseRequest);

    /**
     * 获取作者信息
     * @param baseRequest
     * @return
     */
    @InvokerLoggingAnnotation(InvokerLoggingAnnotation.PRINT_FALSE)
    @PostMapping(value = SecurityInterceptor.API_URI_PREFIX + "/getArticleAuthor")
    User getArticleAuthor(BaseRequest baseRequest);
}
