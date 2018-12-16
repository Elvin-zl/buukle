package top.buukle.provider.security.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.logger.BaseLogger;
import top.buukle.plugin.security.vo.query.PageBounds;
import top.buukle.plugin.security.vo.response.FuzzySearchListVo;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.provider.security.business.UserBusiness;
import top.buukle.plugin.security.entity.User;
import top.buukle.provider.security.service.UserService;
import top.buukle.plugin.security.vo.query.UserQuery;
import top.buukle.plugin.security.vo.response.UserMemberVo;
import top.buukle.plugin.security.vo.response.UserRoleListVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/8.
 * @Description :
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static final BaseLogger LOGGER = BaseLogger.getLogger(UserController.class);
    @Autowired
    UserService userService;
    @Autowired
    private UserBusiness userBusiness;

    /**
     * 获取完成认证的用户信息
     * @return
     * @throws Exception
     */
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public User getUserInfo(HttpServletRequest request) throws Exception {
        return userBusiness.getUserInfo(request);
    }
    /**
     * 获取用户信息列表
     * @return
     * @throws Exception
     */
    @RequestMapping("/getUserList")
    @ResponseBody
    public PageResponse<User> getUserList(UserQuery userQuery,PageBounds pageBounds) throws Exception {
        return userService.getUserList(userQuery,pageBounds);
    }
    /**
     * 启用/停用用户
     * @return
     * @throws Exception
     */
    @RequestMapping("/doBanOrRelease")
    @ResponseBody
    public BaseResponse doBanOrRelease(HttpServletRequest request,UserQuery userQuery) throws Exception {
        return userService.doBanOrRelease(request,userQuery);
    }

    /**
     * 获取用户角色信息
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/getUserRoleForPage")
    @ResponseBody
    public List<UserRoleListVo> getUserRoleForPage(HttpServletRequest request,UserQuery userQuery) throws Exception {
        return userService.getUserRoleForPage(request,userQuery);
    }

    /**
     * 分配角色
     * @param ids
     * @param userQuery
     * @return
     * @throws Exception
     */
    @RequestMapping("/doSetUserRole")
    @ResponseBody
    public BaseResponse doSetUserRole(String ids,UserQuery userQuery,Integer roleLevel,HttpServletRequest request) throws Exception {
        return userService.doSetUserRole(ids,userQuery,roleLevel,request);
    }

    /**
     * 模糊搜索
     * @return
     * @throws Exception
     */
    @RequestMapping("/fuzzySearchByName")
    @ResponseBody
    public List<FuzzySearchListVo> fuzzySearchByName(String fuzzyText) throws Exception {
        return userService.fuzzySearchByName(fuzzyText);
    }

    /**
     * 添加用户
     * @param userQuery
     * @return
     * @throws Exception
     */
    @RequestMapping("/addUser")
    @ResponseBody
    public BaseResponse addUser(HttpServletRequest request,UserQuery userQuery) throws Exception {
        return userService.addUser(request,userQuery);
    }

    /**
     * 修改用户
     * @param request
     * @param userQuery
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping("/editUser/{userId}")
    @ResponseBody
    public BaseResponse editUser(HttpServletRequest request, UserQuery userQuery, @PathVariable String userId) throws Exception {
        return userService.editUser(request,userQuery,userId);
    }

    /**
     * 获取用户详情
     * @param userQuery
     * @return
     * @throws Exception
     */
    @RequestMapping("/getUserDetail")
    @ResponseBody
    public User getUserDetail(UserQuery userQuery) throws Exception {
        return userService.getUserDetail(userQuery);
    }

    /**
     * 获取组别成员列表
     * @param groupsId
     * @param userQuery
     * @param pageBounds
     * @return
     * @throws Exception
     */
    @RequestMapping("/getMemberList/{groupsId}")
    @ResponseBody
    public PageResponse<UserMemberVo> getMemberList(@PathVariable("groupsId") Integer groupsId, UserQuery userQuery, PageBounds pageBounds) throws Exception {
        return userService.getMemberList(groupsId, userQuery, pageBounds);
    }
}
