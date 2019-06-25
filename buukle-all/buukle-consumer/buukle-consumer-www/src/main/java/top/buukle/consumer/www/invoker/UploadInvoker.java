package top.buukle.consumer.www.invoker;

import org.springframework.web.multipart.MultipartFile;
import top.buukle.common.request.BaseRequest;
import top.buukle.common.response.BaseResponse;
import top.buukle.plugin.security.entity.User;
import top.buukle.plugin.security.plugins.SecurityInterceptor;
import top.buukle.plugin.upload.client.UploadCinent;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/1/29.
 * @Description :
 */
public class UploadInvoker {

    /**
     * 调用图片上传接口
     * @param userInfo
     * @param multipartFile
     * @param applicationName
     * @return
     */
    public static BaseResponse uploadImage(User userInfo, MultipartFile multipartFile, String applicationName) {
        BaseRequest baseRequest = new BaseRequest.Builder()
                .setOperationId(SecurityInterceptor.APPLICATION_NAME)
                .setOperationLoginName(userInfo.getUsername())
                .setOperationName(userInfo.getFullNameCn()).build(applicationName);
        return UploadCinent.uploadImage(baseRequest,multipartFile);
    }
}
