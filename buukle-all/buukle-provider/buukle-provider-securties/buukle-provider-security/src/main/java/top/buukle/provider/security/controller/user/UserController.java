package top.buukle.provider.security.controller.user;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.common.NumberUtil;
import top.buukle.common.util.logger.BaseLogger;
import top.buukle.plugin.security.util.CookieUtil;
import top.buukle.provider.security.entity.Role;
import top.buukle.provider.security.vo.query.PageBounds;
import top.buukle.provider.security.vo.response.PageResponse;
import top.buukle.provider.security.business.UserBusiness;
import top.buukle.provider.security.entity.User;
import top.buukle.provider.security.service.UserService;
import top.buukle.provider.security.vo.query.UserQuery;
import top.buukle.provider.security.vo.response.UserRoleListVo;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
    public BaseResponse doBanOrRelease(UserQuery userQuery) throws Exception {
        return userService.doBanOrRelease(userQuery);
    }

    /**
     * 获取用户角色信息
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/getUserRoleForPage")
    @ResponseBody
    public List<UserRoleListVo> getUserRoleForPage(HttpServletRequest request,Integer id) throws Exception {
        return userService.getUserRoleForPage(request,id);
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
    public BaseResponse doSetUserRole(String ids,UserQuery userQuery) throws Exception {
        return userService.doSetUserRole(ids,userQuery);
    }
}
