package top.buukle.consumer.cms .controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.plugin.security.vo.query.PageBounds;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.consumer.cms .service.FriendLinkService;
import top.buukle.consumer.cms .entity.FriendLink;
import top.buukle.consumer.cms .entity.vo.FriendLinkQuery;

@Controller
public class FriendLinkController{

    @Autowired
    FriendLinkService service;

    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/getFriendLinkList")
    @ResponseBody
    public PageResponse<FriendLink> getUserList(FriendLinkQuery query,PageBounds pageBounds) throws Exception {
        return service.getFriendLinkList(query,pageBounds);
    }

}