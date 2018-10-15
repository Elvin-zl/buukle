package top.buukle.plugin.security.invoker;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import top.buukle.common.annotation.InvokerLogging;
import top.buukle.common.request.BaseRequest;
import top.buukle.common.response.BaseResponse;
import top.buukle.plugin.security.constants.SecurityConstants;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/1.
 * @Description : 登录登出认证授权 FeignClient代理执行层对象
 */
@FeignClient(value = "${security.server.name}")
public interface SecurityInvoker{

    /**
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/api/security/user/doLogin")
    BaseResponse doLogin(BaseRequest request);

    /**
     *
     * @param request
     * @return
     */
    @InvokerLogging(InvokerLogging.PRINT_FALSE)
    @PostMapping(value = "/api/security/user/authentication")
    BaseResponse authentication(BaseRequest request);

    /**
     *
     * @param request
     * @return
     */
    @InvokerLogging(InvokerLogging.PRINT_FALSE)
    @PostMapping(value = "/api/security/user/setPermission")
    BaseResponse setPermission(BaseRequest request);
}
