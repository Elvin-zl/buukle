package top.buukle.consumer.cms .controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.common.response.BaseResponse;
import top.buukle.plugin.security.vo.query.PageBounds;
import top.buukle.common.vo.response.PageResponse;

import top.buukle.consumer.cms .service.UserImageService;
import top.buukle.consumer.cms .entity.UserImage;
import top.buukle.consumer.cms .entity.vo.UserImageQuery;
import top.buukle.plugin.security.vo.response.FuzzySearchListVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author elvin
* @description UserImage controller
*/
@Controller
@RequestMapping("/userImage")
public class UserImageController{

    @Autowired
    UserImageService userImageService;

    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/getUserImageList")
    @ResponseBody
    public PageResponse<UserImage> getUserList(UserImageQuery query,PageBounds pageBounds) throws Exception {
        return userImageService.getUserImageList(query,pageBounds);
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
        return userImageService.fuzzySearchByText(fuzzyText);
    }

    /**
    * 删除记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/deleteUserImage")
    @ResponseBody
    public BaseResponse deleteUserImage(UserImageQuery query, HttpServletRequest request) throws Exception {
        return userImageService.deleteUserImage(query,request);
    }

    /**
    * 查看记录详情
    * @param query
    * @return
    * @throws Exception
    */
    @RequestMapping("/getUserImageDetail")
    @ResponseBody
    public UserImage getUserImageDetail(UserImageQuery query) throws Exception {
        return userImageService.getUserImageDetail(query);
    }

    /**
    * 新增记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/saveUserImage")
    @ResponseBody
    public BaseResponse saveUserImage(UserImageQuery query, HttpServletRequest request) throws Exception {
        return userImageService.saveUserImage(query,request);
    }

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/updateUserImage")
    @ResponseBody
    public BaseResponse updateUserImage(UserImageQuery query, HttpServletRequest request) throws Exception {
        return userImageService.updateUserImage(query,request);
    }

}