package top.buukle.consumer.cms .controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.response.PageResponse;

import top.buukle.consumer.cms .service.UserFansService;
import top.buukle.consumer.cms .entity.UserFans;
import top.buukle.consumer.cms .entity.vo.UserFansQuery;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author elvin
* @description UserFans controller
*/
@Controller
@RequestMapping("/userFans")
public class UserFansController{

    @Autowired
    UserFansService userFansService;

    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/getUserFansList")
    @ResponseBody
    public PageResponse<UserFans> getUserList(UserFansQuery query,PageBounds pageBounds) throws Exception {
        return userFansService.getUserFansList(query,pageBounds);
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
        return userFansService.fuzzySearchByText(fuzzyText);
    }

    /**
    * 删除记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/deleteUserFans")
    @ResponseBody
    public BaseResponse deleteUserFans(UserFansQuery query, HttpServletRequest request) throws Exception {
        return userFansService.deleteUserFans(query,request);
    }

    /**
    * 查看记录详情
    * @param query
    * @return
    * @throws Exception
    */
    @RequestMapping("/getUserFansDetail")
    @ResponseBody
    public UserFans getUserFansDetail(UserFansQuery query) throws Exception {
        return userFansService.getUserFansDetail(query);
    }

    /**
    * 新增记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/saveUserFans")
    @ResponseBody
    public BaseResponse saveUserFans(UserFansQuery query, HttpServletRequest request) throws Exception {
        return userFansService.saveUserFans(query,request);
    }

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/updateUserFans")
    @ResponseBody
    public BaseResponse updateUserFans(UserFansQuery query, HttpServletRequest request) throws Exception {
        return userFansService.updateUserFans(query,request);
    }

}