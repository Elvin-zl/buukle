package top.buukle.provider.security.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;
import top.buukle.common.request.BaseRequest;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.common.StringUtil;
import top.buukle.common.util.logger.BaseLogger;
import top.buukle.plugin.security.util.CookieUtil;
import top.buukle.provider.security.dao.GroupsMapper;
import top.buukle.provider.security.dao.UserExpMapper;
import top.buukle.provider.security.entity.*;
import top.buukle.provider.security.business.UserBusiness;
import top.buukle.provider.security.constants.SecurityConstants;
import org.springframework.stereotype.Component;
import top.buukle.provider.security.dao.UserMapper;
import top.buukle.provider.security.invoker.UserInvoker;
import top.buukle.provider.security.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/21.
 * @Description :
 */
@Component
public class UserBusinessImpl implements UserBusiness {

    final private static BaseLogger LOGGER = BaseLogger.getLogger(UserBusinessImpl.class);

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserExpMapper userExpMapper;
    @Autowired
    private GroupsMapper groupsMapper;
    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param baseRequest
     * @return
     */
    @Override
    public BaseResponse doLogin(BaseRequest baseRequest) throws Exception {
        // 校验参数
        User user = this.validateLoginParam(baseRequest);
        // 执行登录
        User userInfoForLogin = userMapper.getUserInfoForLogin(user);
        // 登录失败
        if(userInfoForLogin == null){
//            return new BaseResponse.Builder().buildFailed();
            throw new BaseException(BaseResponseCode.USER_LOGIN_USERNAME_PASSWORD_WRONG);
        }
        //查询用户扩展信息
        UserExp userExp = userExpMapper.getUserExpByUserId(userInfoForLogin.getUserId());
        //查询用户组别信息
        List<Groups> groupsList = groupsMapper.getUserGroupsByUserId(userInfoForLogin.getUserId());
        //查询用户成员信息
        List<User> userSubordinateList = userMapper.getUserSubordinateByUserGroups(groupsList);

        // 缓存用户基本信息
        String userCookie = UserInvoker.saveUser(userInfoForLogin ,baseRequest.getExpandParameterString(),baseRequest.getRequestHead());
        // 缓存用户扩展信息
        UserInvoker.saveUserExp(userExp ,baseRequest.getExpandParameterString(),baseRequest.getRequestHead());
        // 缓存用户组别信息
        UserInvoker.saveUserGroup(groupsList ,baseRequest.getExpandParameterString(),baseRequest.getRequestHead());
        // 缓存用户下级信息
        UserInvoker.saveUserSubordinate(userSubordinateList ,baseRequest.getExpandParameterString(),baseRequest.getRequestHead());
        // 清除用户权限缓存信息
        UserInvoker.clearUserSecurityInfo(userCookie);

        //缓存用户角色信息
        List<Role> userRole = userService.getUserRole(userCookie, userInfoForLogin, baseRequest);
        //缓存用户菜单信息
        List<Module> userModule = userService.getUserModule(userCookie, userRole, baseRequest);
        //缓存用户按钮信息
        userService.getUserButton(userCookie,userModule,baseRequest);
        LOGGER.info(SecurityConstants.LOGIN_SUCCESS,user.getUsername());
        //组织返回并回写cookie
        return new BaseResponse.Builder().buildSuccess(userCookie);
    }

    /**
     * 已完成认证的用户获取用户信息
     * @param request
     * @return
     */
    @Override
    public User getUserInfo(HttpServletRequest request) {
        return UserInvoker.getUser(CookieUtil.getUserCookie(request));
    }

    /**
     * 校验登录参数
     * @param request
     */
    private User validateLoginParam(BaseRequest request) {
        User user = (User)request.getInfo(User.class);
        if(user == null){
            throw new BaseException(BaseResponseCode.LOGIN_FAILED);
        }
        if(StringUtil.isEmpty(user.getUsername()) || StringUtil.isEmpty(user.getPassword())){
            throw new BaseException(BaseResponseCode.LOGIN_FAILED_USERNAME_PWD_NULL);
        }
        if(user.getLoginStrategy() == null && StringUtil.isEmpty(request.getExpandParameterString())){
            throw new BaseException(BaseResponseCode.LOGIN_FAILED_USER_LOGIN_STRATEGY_AND_DEFAULT_MAX_AGE_NULL);
        }
        return user;
    }
}
