package top.buukle.consumer.www.bussiness.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import top.buukle.common.response.BaseResponse;
import top.buukle.consumer.www.bussiness.UploadBusiness;
import top.buukle.consumer.www.invoker.UploadInvoker;
import top.buukle.plugin.security.client.SecurityClient;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/1/29.
 * @Description :
 */
@Component
public class UploadBusinessImpl implements UploadBusiness{


    @Autowired
    private SecurityClient securityClient;
    @Autowired
    private Environment env;

    /**
     * 上传图片
     * @param request
     * @param multipartFile
     * @return
     */
    @Override
    public BaseResponse uploadImage(HttpServletRequest request, MultipartFile multipartFile) {
        // 调用图片上传接口
        return UploadInvoker.uploadImage(securityClient.getUserInfo(request), multipartFile, env.getProperty("spring.application.name"));
    }
}
