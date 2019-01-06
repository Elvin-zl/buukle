package top.buukle.consumer.cms .controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.response.PageResponse;

import top.buukle.consumer.cms .service.UserAlbumService;
import top.buukle.consumer.cms .entity.UserAlbum;
import top.buukle.consumer.cms .entity.vo.UserAlbumQuery;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author elvin
* @description UserAlbum controller
*/
@Controller
@RequestMapping("/userAlbum")
public class UserAlbumController{

    @Autowired
    UserAlbumService userAlbumService;

    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/getUserAlbumList")
    @ResponseBody
    public PageResponse<UserAlbum> getUserList(UserAlbumQuery query,PageBounds pageBounds) throws Exception {
        return userAlbumService.getUserAlbumList(query,pageBounds);
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
        return userAlbumService.fuzzySearchByText(fuzzyText);
    }

    /**
    * 删除记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/deleteUserAlbum")
    @ResponseBody
    public BaseResponse deleteUserAlbum(UserAlbumQuery query, HttpServletRequest request) throws Exception {
        return userAlbumService.deleteUserAlbum(query,request);
    }

    /**
    * 查看记录详情
    * @param query
    * @return
    * @throws Exception
    */
    @RequestMapping("/getUserAlbumDetail")
    @ResponseBody
    public UserAlbum getUserAlbumDetail(UserAlbumQuery query) throws Exception {
        return userAlbumService.getUserAlbumDetail(query);
    }

    /**
    * 新增记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/saveUserAlbum")
    @ResponseBody
    public BaseResponse saveUserAlbum(UserAlbumQuery query, HttpServletRequest request) throws Exception {
        return userAlbumService.saveUserAlbum(query,request);
    }

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/updateUserAlbum")
    @ResponseBody
    public BaseResponse updateUserAlbum(UserAlbumQuery query, HttpServletRequest request) throws Exception {
        return userAlbumService.updateUserAlbum(query,request);
    }

}