package top.buukle.plugin.upload.business.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;
import top.buukle.common.request.BaseRequest;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.common.StringUtil;
import top.buukle.common.util.logger.BaseLogger;
import top.buukle.plugin.upload.Util.FileUtil;
import top.buukle.plugin.upload.business.UploadPluginBusiness;
import top.buukle.plugin.upload.client.UploadCinent;
import top.buukle.plugin.upload.invoker.UploadSecurityInvoker;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/1/29.
 * @Description :
 */
@Component
public class UploadPluginBusinessImpl implements UploadPluginBusiness {


    @Autowired
    private UploadSecurityInvoker securityInvoker;

    private static final String OS_NAME = System.getProperty("os.name");

    /** 静态文件url 前缀*/
    private static final String STATIC_ROOT_URL_PREFIX = "http://static.buukle.top/static/";
    /** 静态文件url 前缀(测试环境)*/
    private static final String STATIC_ROOT_URL_PREFIX_TEST = "http://tstatic.buukle.top/static/";

    private static final BaseLogger LOGGER = BaseLogger.getLogger(UploadCinent.class);

    /**
     * 上传图片
     * @param request
     * @param multipartFile
     * @return
     */
    @Override
    public BaseResponse uploadImage(BaseRequest request, MultipartFile multipartFile) {
        BaseResponse baseResponse;
        try {
            // 校验参数
            String originalFileName = validateParam(request,multipartFile);
            // 应用验签
            BaseResponse response = securityInvoker.baseSignVerify(request);
            if(!response.isSuccess()){
                throw new BaseException(BaseResponseCode.UPLOAD_IMAGE_WRONG_SIGN_EXCEPTION,response.getMsg());
            }
            String path;
            String staticRootUrl;
            // 切换os
            if(OS_NAME.toLowerCase().startsWith("win")){
                path = "D:/static/";
                staticRootUrl = STATIC_ROOT_URL_PREFIX_TEST;
            }else{
                staticRootUrl = STATIC_ROOT_URL_PREFIX;
                path = "/static/";
            }
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            String[] split = originalFileName.split("\\.");
            String fileName = UUID.randomUUID().toString().replace(StringUtil.MIDDLE,StringUtil.EMPTY) + StringUtil.DOT +split[1];
            // 读写文件
            FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(path + File.separator + fileName));
            FileUtil.readWrite(fileInputStream,bufferedOutputStream);
            // 组织返回
            baseResponse = new BaseResponse.Builder().buildSuccess();
            baseResponse.setMsg(staticRootUrl + fileName);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseException(BaseResponseCode.UPLOAD_IMAGE_WRONG,e.getMessage());
        }
        return baseResponse;
    }
    /**
     * 校验参数
     * @param request
     * @param multipartFile
     */
    private static String validateParam(BaseRequest request, MultipartFile multipartFile) {
        // 校验文件
        if (multipartFile == null || multipartFile.isEmpty() || StringUtils.isBlank(multipartFile.getOriginalFilename())) {
            throw new BaseException(BaseResponseCode.UPLOAD_IMAGE_NULL);
        }
        // 校验类型
        String contentType = multipartFile.getContentType();
        if (!contentType.contains("")) {
            throw new BaseException(BaseResponseCode.UPLOAD_IMAGE_FORMAT_ERROR);
        }
        // 校验请求应用来源
        if(StringUtil.isEmpty(request.getRequestHead().getApplicationName())){
            throw new BaseException(BaseResponseCode.UPLOAD_IMAGE_WRONG_APPLICATION_NULL);
        }
        // 校验请求者信息
        if(StringUtil.isEmpty(request.getRequestHead().getOperationId()) || StringUtil.isEmpty(request.getRequestHead().getOperationLoginName())){
            throw new BaseException(BaseResponseCode.UPLOAD_IMAGE_WRONG_USER_INFO_NULL);
        }
        String originalFileName = multipartFile.getOriginalFilename();
        LOGGER.info("上传图片name= :{},type= :{}", originalFileName, contentType);
        return originalFileName;
    }
}
