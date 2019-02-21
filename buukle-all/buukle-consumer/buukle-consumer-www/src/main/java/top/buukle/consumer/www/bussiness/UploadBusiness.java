package top.buukle.consumer.www.bussiness;

import org.springframework.web.multipart.MultipartFile;
import top.buukle.common.response.BaseResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/1/29.
 * @Description :
 */
public interface UploadBusiness {

    /**
     * 上传图片
     * @param request
     * @param multipartFile
     * @return
     */
    BaseResponse uploadImage(HttpServletRequest request, MultipartFile multipartFile);
}
