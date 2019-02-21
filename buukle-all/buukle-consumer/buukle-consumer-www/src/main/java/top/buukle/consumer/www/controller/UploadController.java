package top.buukle.consumer.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.response.MarkdownResponse;
import top.buukle.common.util.logger.BaseLogger;
import top.buukle.consumer.www.bussiness.UploadBusiness;
import top.buukle.plugin.security.client.SecurityClient;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/1/26.
 * @Description : uploadController  上传controller
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private UploadBusiness uploadBusiness;

    /**
     * 上传图片
     * @param request
     * @param multipartFile
     * @return
     */
    @RequestMapping("/uploadImage")
    @ResponseBody
    public BaseResponse uploadImage(HttpServletRequest request, @RequestParam("file") MultipartFile multipartFile) {
        return uploadBusiness.uploadImage(request,multipartFile);
    }
    /**
     * 上传图片
     * @param request
     * @param multipartFile
     * @return
     */
    @RequestMapping("/uploadImageMarkdown")
    @ResponseBody
    public MarkdownResponse uploadImageMarkdown(HttpServletRequest request, @RequestParam("editormd-image-file") MultipartFile multipartFile) {
        BaseResponse response ;
        MarkdownResponse markdownResponse = new MarkdownResponse();
        try {
            response = uploadBusiness.uploadImage(request, multipartFile);
        } catch (Exception e) {
            e.printStackTrace();
            markdownResponse.setSuccess(MarkdownResponse.FAILD);
            markdownResponse.setMessage("上传图片出现异常,原因 : " + e.getMessage());
            return markdownResponse;
        }
        if(response.isSuccess()){
            markdownResponse.setSuccess(MarkdownResponse.SUCCESS);
            markdownResponse.setUrl(response.getMsg());
            return markdownResponse;
        }else{
            markdownResponse.setSuccess(MarkdownResponse.FAILD);
            markdownResponse.setMessage(response.getMsg());
            return markdownResponse;
        }
    }
}
