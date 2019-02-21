package top.buukle.plugin.upload.business;

import org.springframework.web.multipart.MultipartFile;
import top.buukle.common.request.BaseRequest;
import top.buukle.common.response.BaseResponse;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/1/29.
 * @Description :
 */
public interface UploadPluginBusiness {

    /**
     * 上传图片
     * @param request
     * @param multipartFile
     * @return
     */
    BaseResponse uploadImage(BaseRequest request, MultipartFile multipartFile);
}
