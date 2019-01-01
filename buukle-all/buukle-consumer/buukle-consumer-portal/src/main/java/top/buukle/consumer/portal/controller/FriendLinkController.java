package top.buukle.consumer.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.consumer.portal.entity.FriendLink;
import top.buukle.consumer.portal.entity.vo.FriendLinkQuery;
import top.buukle.consumer.portal.service.FriendLinkService;
import top.buukle.plugin.security.vo.query.PageBounds;
import top.buukle.plugin.security.vo.response.FuzzySearchListVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author elvin
* @description FriendLink controller
*/
@Controller
@RequestMapping("/friendLink")
public class FriendLinkController{

    @Autowired
    FriendLinkService friendLinkService;

    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/getFriendLinkList")
    @ResponseBody
    public PageResponse<FriendLink> getUserList(FriendLinkQuery query, PageBounds pageBounds) throws Exception {
        return friendLinkService.getFriendLinkList(query,pageBounds);
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
        return friendLinkService.fuzzySearchByText(fuzzyText);
    }

    /**
    * 删除记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/deleteFriendLink")
    @ResponseBody
    public BaseResponse deleteFriendLink(FriendLinkQuery query, HttpServletRequest request) throws Exception {
        return friendLinkService.deleteFriendLink(query,request);
    }

    /**
    * 查看记录详情
    * @param query
    * @return
    * @throws Exception
    */
    @RequestMapping("/getFriendLinkDetail")
    @ResponseBody
    public FriendLink getFriendLinkDetail(FriendLinkQuery query) throws Exception {
        return friendLinkService.getFriendLinkDetail(query);
    }

    /**
    * 新增记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/saveFriendLink")
    @ResponseBody
    public BaseResponse saveFriendLink(FriendLinkQuery query, HttpServletRequest request) throws Exception {
        return friendLinkService.saveFriendLink(query,request);
    }

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/updateFriendLink")
    @ResponseBody
    public BaseResponse updateFriendLink(FriendLinkQuery query, HttpServletRequest request) throws Exception {
        return friendLinkService.updateFriendLink(query,request);
    }

}