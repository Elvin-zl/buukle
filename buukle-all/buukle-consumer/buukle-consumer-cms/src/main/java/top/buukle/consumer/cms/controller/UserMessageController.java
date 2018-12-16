package top.buukle.consumer.cms .controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.plugin.security.vo.query.PageBounds;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.consumer.cms .service.UserMessageService;
import top.buukle.consumer.cms .entity.UserMessage;
import top.buukle.consumer.cms .entity.vo.UserMessageQuery;

@Controller
public class UserMessageController{

    @Autowired
    UserMessageService service;

    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/getUserMessageList")
    @ResponseBody
    public PageResponse<UserMessage> getUserList(UserMessageQuery query,PageBounds pageBounds) throws Exception {
        return service.getUserMessageList(query,pageBounds);
    }

}