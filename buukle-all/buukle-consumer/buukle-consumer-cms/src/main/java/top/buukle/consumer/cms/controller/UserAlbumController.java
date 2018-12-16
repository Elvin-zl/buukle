package top.buukle.consumer.cms .controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.plugin.security.vo.query.PageBounds;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.consumer.cms .service.UserAlbumService;
import top.buukle.consumer.cms .entity.UserAlbum;
import top.buukle.consumer.cms .entity.vo.UserAlbumQuery;

@Controller
public class UserAlbumController{

    @Autowired
    UserAlbumService service;

    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/getUserAlbumList")
    @ResponseBody
    public PageResponse<UserAlbum> getUserList(UserAlbumQuery query,PageBounds pageBounds) throws Exception {
        return service.getUserAlbumList(query,pageBounds);
    }

}