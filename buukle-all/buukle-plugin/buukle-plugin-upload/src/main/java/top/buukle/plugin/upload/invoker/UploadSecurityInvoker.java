package top.buukle.plugin.upload.invoker;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import top.buukle.common.request.BaseRequest;
import top.buukle.common.response.BaseResponse;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/1.
 * @Description :
 */
@FeignClient(name = "http://${security.server.name}")
public interface UploadSecurityInvoker {
    /**
     * 基础验签
     * @return
     * @param request
     */
    @PostMapping(value =  "/api/securityRest/baseSignVerify")
    BaseResponse baseSignVerify(BaseRequest request);
}
