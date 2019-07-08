package top.buukle.consumer.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.consumer.www.entity.UserMessage;
import top.buukle.consumer.www.entity.vo.UserMessageQuery;
import top.buukle.consumer.www.service.UserMessageService;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author elvin
* @description UserMessage controller
*/
@Controller
@RequestMapping("/userMessage")
public class UserMessageController{

    @Autowired
    UserMessageService userMessageService;

    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/getUserMessageList")
    @ResponseBody
    public PageResponse<UserMessage> getUserList(UserMessageQuery query, PageBounds pageBounds) throws Exception {
        return userMessageService.getUserMessageList(query,pageBounds);
    }

    /**
    * 模糊搜索
    * @param fuzzyText
    * @return
    * @throws Exception
    */
    @RequestMapping("/fuzzySearchByText")
    @ResponseBody
    public List<FuzzySearchListVo>  fuzzySearchByText(String fuzzyText) throws Exception {
        return userMessageService.fuzzySearchByText(fuzzyText);
    }

    /**
    * 删除记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/deleteUserMessage")
    @ResponseBody
    public BaseResponse deleteUserMessage(UserMessageQuery query, HttpServletRequest request) throws Exception {
        return userMessageService.deleteUserMessage(query,request);
    }

    /**
    * 查看记录详情
    * @param query
    * @return
    * @throws Exception
    */
    @RequestMapping("/getUserMessageDetail")
    @ResponseBody
    public UserMessage getUserMessageDetail(UserMessageQuery query) throws Exception {
        return userMessageService.getUserMessageDetail(query);
    }

    /**
    * 新增记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/saveUserMessage")
    @ResponseBody
    public BaseResponse saveUserMessage(UserMessageQuery query, HttpServletRequest request) throws Exception {
        return userMessageService.saveUserMessage(query,request);
    }

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/updateUserMessage")
    @ResponseBody
    public BaseResponse updateUserMessage(UserMessageQuery query, HttpServletRequest request) throws Exception {
        return userMessageService.updateUserMessage(query,request);
    }

}