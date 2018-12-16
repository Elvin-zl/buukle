package top.buukle.consumer.cms .controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.plugin.security.vo.query.PageBounds;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.consumer.cms .service.UserImageService;
import top.buukle.consumer.cms .entity.UserImage;
import top.buukle.consumer.cms .entity.vo.UserImageQuery;

@Controller
public class UserImageController{

    @Autowired
    UserImageService service;

    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/getUserImageList")
    @ResponseBody
    public PageResponse<UserImage> getUserList(UserImageQuery query,PageBounds pageBounds) throws Exception {
        return service.getUserImageList(query,pageBounds);
    }

}