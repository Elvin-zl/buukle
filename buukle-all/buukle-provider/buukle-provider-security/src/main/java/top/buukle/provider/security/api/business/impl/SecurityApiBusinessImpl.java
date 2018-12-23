package top.buukle.provider.security.api.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.dataIsolation.IsolationConstants;
import top.buukle.common.exception.BaseException;
import top.buukle.common.request.BaseRequest;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.common.StringUtil;
import top.buukle.common.util.logger.BaseLogger;
import top.buukle.plugin.security.entity.*;
import top.buukle.plugin.security.vo.query.UserQuery;
import top.buukle.plugin.security.vo.response.ModuleNavigationVo;
import top.buukle.provider.security.api.business.SecurityApiBusiness;
import top.buukle.provider.security.constants.SecurityConstants;
import top.buukle.provider.security.constants.SecurityStatusConstants;
import top.buukle.provider.security.dao.UserExpMapper;
import top.buukle.provider.security.dao.UserMapper;
import top.buukle.provider.security.invoker.UserInvoker;
import top.buukle.provider.security.service.ButtonService;
import top.buukle.provider.security.service.ModuleService;
import top.buukle.provider.security.service.UserService;

import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/21.
 * @Description :
 */
@Component
public class SecurityApiBusinessImpl implements SecurityApiBusiness {

    final private static BaseLogger LOGGER = BaseLogger.getLogger(SecurityApiBusinessImpl.class);

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserExpMapper userExpMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private ModuleService moduleService;
    @Autowired
    private ButtonService buttonService;

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
            throw new BaseException(BaseResponseCode.USER_LOGIN_USERNAME_PASSWORD_WRONG);
        }
        // 用户被禁用
        if(userInfoForLogin.getStatus().equals(SecurityStatusConstants.STATUS_CLOSE)){
            throw new BaseException(BaseResponseCode.LOGIN_FAILED_USER_BANED);
        }
        // 查询用户扩展信息
        UserExp userExp = userExpMapper.getUserExpByUserId(userInfoForLogin.getUserId());
        // 查询用户下级信息
        List<String> userSubordinateList = this.getUserSubordinateByUserLevel(userInfoForLogin);

        // 缓存用户基本信息
        String userCookie = UserInvoker.saveUser(userInfoForLogin ,baseRequest.getExpandParameterString(),baseRequest.getRequestHead(), null);
        // 清除用户缓存信息
        UserInvoker.clearUserCacheInfoByType(null,userInfoForLogin.getUserId());
        // 缓存用户扩展信息
        UserInvoker.saveUserExp(userExp ,userInfoForLogin.getUserId(),baseRequest.getRequestHead());
        // 缓存用户下级信息
        UserInvoker.saveUserSubordinate(userSubordinateList ,userInfoForLogin.getUserId(),baseRequest.getRequestHead());
        // 缓存用户角色信息
        List<Role> userRole = userService.getUserRole(userInfoForLogin.getUserId(), userInfoForLogin, baseRequest);
        // 缓存用户菜单信息
        List<Module> userModule = userService.getUserModule(userInfoForLogin.getUserId(), userRole, baseRequest);
        // 缓存用户按钮信息
        userService.getUserButton(userInfoForLogin.getUserId(),userModule,baseRequest);
        LOGGER.info(SecurityConstants.LOGIN_SUCCESS,user.getUsername());
        // 组织返回并回写cookie
        return new BaseResponse.Builder().buildSuccess(userCookie);
    }

    /**
     * 根据身份获取用户下级信息
     * @param userInfoForLogin
     * @return
     */
    private List<String> getUserSubordinateByUserLevel(User userInfoForLogin) {
        UserQuery userQuery = new UserQuery();
        //0 boss级别
        if(userInfoForLogin.getUserLevel().equals(IsolationConstants.USER_LEVEL_BOSS)){
            return userMapper.getUserSubordinateByUserLevel(userQuery);
        }
        //1 平台级别
        if(userInfoForLogin.getUserLevel().equals(IsolationConstants.USER_LEVEL_PLATFORM)){
            userQuery.setPlatformId(userInfoForLogin.getPlatformId());
            List<String> userSubordinateByUserLevel = userMapper.getUserSubordinateByUserLevel(userQuery);
            userSubordinateByUserLevel.add(userInfoForLogin.getUserId());
            return userSubordinateByUserLevel;
        }
        //2 代理级别
        if(userInfoForLogin.getUserLevel().equals(IsolationConstants.USER_LEVEL_AGENT)){
            userQuery.setAgentId(userInfoForLogin.getAgentId());
            List<String> userSubordinateByUserLevel = userMapper.getUserSubordinateByUserLevel(userQuery);
            userSubordinateByUserLevel.add(userInfoForLogin.getUserId());
            return userSubordinateByUserLevel;
        }
        //3 区域/组别级别
        if(userInfoForLogin.getUserLevel().equals(IsolationConstants.USER_LEVEL_GROUP)){
            userQuery.setGroupId(userInfoForLogin.getGroupId());
            List<String> userSubordinateByUserLevel = userMapper.getUserSubordinateByUserLevel(userQuery);
            userSubordinateByUserLevel.add(userInfoForLogin.getUserId());
            return userSubordinateByUserLevel;
        }
        //4 业务员级别
        if(userInfoForLogin.getUserLevel().equals(IsolationConstants.USER_LEVEL_SALESMAN)){
            userQuery.setSalesmanId(userInfoForLogin.getSalesmanId());
            List<String> userSubordinateByUserLevel = userMapper.getUserSubordinateByUserLevel(userQuery);
            userSubordinateByUserLevel.add(userInfoForLogin.getUserId());
            return userSubordinateByUserLevel;
        }
        //5 小白级别
        if(userInfoForLogin.getUserLevel().equals(IsolationConstants.USER_LEVEL_CREATOR)){
            userQuery.setCreatorCode(userInfoForLogin.getUserId());
            List<String> userSubordinateByUserLevel = userMapper.getUserSubordinateByUserLevel(userQuery);
            userSubordinateByUserLevel.add(userInfoForLogin.getUserId());
            return userSubordinateByUserLevel;
        }
        return null;
    }

    /**
     * 获取用户菜单树
     * @param baseRequest
     * @return
     */
    @Override
    public List<ModuleNavigationVo> getUserModuleTree(BaseRequest baseRequest) throws Exception {
        return moduleService.getUserModuleTree((String) baseRequest.getInfo(String.class),baseRequest.getRequestHead().getApplicationName());
    }

    /**
     * 获取已完成认证的用户获取用户信息
     * @param baseRequest
     * @return
     */
    @Override
    public User getUserInfo(BaseRequest baseRequest) {
        return UserInvoker.getUser((String) baseRequest.getInfo(String.class));
    }

    /**
     * 获取全局按钮类型
     * @return
     */
    @Override
    public List<ButtonType> getButtonTypes() {
        return buttonService.getButtonTypes();
    }

    /**
     * 获取菜单下的按钮信息
     * @param baseRequest
     * @return
     */
    @Override
    public List<Button> getModuleButtons(BaseRequest baseRequest) {
        Integer moduleId = (Integer) baseRequest.getInfo(Integer.class);
        return buttonService.getModuleButtons(moduleId);
    }

    /**
     * 获取用户下辖信息列表
     * @param baseRequest
     * @return
     */
    @Override
    public List<String> getUserSubordinate(BaseRequest baseRequest) {
        return UserInvoker.getUserSubordinate((String) baseRequest.getInfo());
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
