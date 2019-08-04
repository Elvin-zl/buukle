package top.buukle.security.plugin.invoker;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
//import top.buukle.common.annotation.InvokerLoggingAnnotation;
//import top.buukle.common.request.BaseRequest;
//import top.buukle.common.response.BaseResponse;
//import top.buukle.plugin.security.entity.Button;
//import top.buukle.plugin.security.entity.ButtonType;
//import top.buukle.plugin.security.entity.User;
//import top.buukle.plugin.security.plugins.SecurityInterceptor;
//import top.buukle.plugin.security.vo.response.ModuleNavigationVo;
import top.buukle.common.call.AppResourceResponse;
import top.buukle.common.call.CommonRequest;
import top.buukle.common.call.PageResponse;
import top.buukle.security.plugin.constants.SecurityInterceptorConstants;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/1.
 * @Description : security FeignClient代理执行层对象
 */
@FeignClient(name = "${security.server.name}")
public interface SecurityInterceptorInvoker {

    /**
     * @description 获取应用资源列表
     * @param request
     * @return top.buukle.common.call.PageResponse
     * @Author elvin
     * @Date 2019/8/2
     */
    @PostMapping(value = "${security.server.appResourceURI}")
    AppResourceResponse getApplicationResource(CommonRequest request);
}
