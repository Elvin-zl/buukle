package top.buukle.plugin.upload.client;

import org.springframework.web.multipart.MultipartFile;
import top.buukle.common.request.BaseRequest;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.common.SpringContextUtil;
import top.buukle.plugin.upload.business.UploadPluginBusiness;

/**
 * 上传插件
 */
public class UploadCinent {

    /**
     * 上传图片
     * @param request
     * @param multipartFile
     * @return
     */
    public static BaseResponse uploadImage(BaseRequest request,MultipartFile multipartFile) {
        UploadPluginBusiness uploadBusiness = SpringContextUtil.getBean(UploadPluginBusiness.class);
        return uploadBusiness.uploadImage(request,multipartFile);
    }
}
