/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;
import top.buukle.common.request.BaseRequest;
import top.buukle.common.request.RequestHead;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.common.NumberUtil;
import top.buukle.common.util.common.StringUtil;
import top.buukle.common.util.common.ThreadLocalUtil;
import top.buukle.common.vo.ThreadParam;
import top.buukle.provider.security.constants.SecurityStatusConstants;
import top.buukle.provider.security.entity.*;
import top.buukle.provider.security.vo.query.PageBounds;
import top.buukle.provider.security.vo.query.RoleQuery;
import top.buukle.provider.security.vo.query.UserLoginPermissionQuery;
import top.buukle.provider.security.dao.*;
import top.buukle.provider.security.invoker.UserInvoker;
import top.buukle.provider.security.service.UserService;
import top.buukle.provider.security.vo.query.UserQuery;
import top.buukle.provider.security.vo.response.FuzzySearchListVo;
import top.buukle.provider.security.vo.response.PageResponse;
import top.buukle.provider.security.vo.response.UserRoleListVo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author elvin
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
    private UserMapper userMapper;
	@Resource
    private ButtonMapper buttonMapper;
	@Resource
    private ModuleMapper moduleMapper;
	@Resource
    private RoleMapper roleMapper;
	@Resource
    private UserRoleMapper userRoleMapper;

    @Autowired
    private Environment env;

	private static final String AUTHENTICATION_WRONG = "认证失败";

	@Override
	public User getUserById(Integer id) throws Exception{
		return userMapper.selectByPrimaryKey(id);
	}

    @Override
    public List<User> getUserByParas(User user) throws Exception {
        return null;
    }

    @Override
	public void save(User user) throws Exception {
		userMapper.insert(user);
	}
	@Override
	public void update(User user) throws Exception {
		userMapper.updateByPrimaryKeySelective(user);
    }
	@Override
	public void delete(User user) throws Exception {
	}
	@Override
	public List<User> getUsersByParasNoPage(User user) throws Exception {
		return null;
	}
	/**
	 * 用户认证
	 * @param request
	 * @return
	 */
	@Override
	public BaseResponse authentication(BaseRequest request) {
		//初始化认证参数
		String userCookie = (String) request.getInfo(String.class);
        User user = UserInvoker.getUser(userCookie);
        String ssoDefault = request.getExpandParameterString();
		if(null != user){
			//刷新用户缓存失效时间
			UserInvoker.saveUser(user,ssoDefault,request.getRequestHead(),userCookie);
			return new BaseResponse.Builder().buildSuccess(user);
		}
		return new BaseResponse.Builder().buildFailed(AUTHENTICATION_WRONG);
	}

	/**
	 * 用户授权
	 * @param request
	 * @return
	 */
	@Override
	public BaseResponse setPermission(BaseRequest request) throws Exception {
		UserLoginPermissionQuery userLoginPermissionQuery = (UserLoginPermissionQuery)request.getInfo(UserLoginPermissionQuery.class);
		//参数检验
		this.validatePermissionParam(userLoginPermissionQuery,request.getRequestHead());
		//初始化认证参数
		String url = userLoginPermissionQuery.getUrl();
		User user = (User) userLoginPermissionQuery.getUser();
		//获取全局菜单缓存
		List<Module> globalModuleList = this.getGlobalModule();
		if(CollectionUtils.isEmpty(globalModuleList)){
			throw new BaseException(BaseResponseCode.USER_PERMISSION_GLOBAL_MODULE_LIST_NULL);
		}
		//获取全局按钮缓存
		List<Button> globalButtonList = this.getGlobalButton();
		if(CollectionUtils.isEmpty(globalButtonList)){
			throw new BaseException(BaseResponseCode.USER_PERMISSION_GLOBAL_BUTTON_LIST_NULL);
		}
		//判断请求url是否在全局菜单+按钮 列表里
		Boolean isUnderPermission = this.isUnderPermission(url,globalModuleList,globalButtonList);
		if(!isUnderPermission){
			return new BaseResponse.Builder().buildSuccess();
		}
		//获取用户角色列表缓存
		List<Role> userRoleList = this.getUserRole(user.getUserId(),user,request);
		if(CollectionUtils.isEmpty(userRoleList)){
			throw new BaseException(BaseResponseCode.USER_PERMISSION_USER_ROLE_LIST_NULL);
		}
		//获取用户菜单列表缓存
		List<Module> userModuleList = this.getUserModule(user.getUserId(),userRoleList,request);
		if(CollectionUtils.isEmpty(userModuleList)){
			throw new BaseException(BaseResponseCode.USER_PERMISSION_USER_MODULE_LIST_NULL);
		}
		//获取用户按钮列表缓存
		List<Button> userButtonList = this.getUserButton(user.getUserId(),userModuleList,request);
		//判断当前用户是否拥有当前请求url菜单(菜单 + 按钮)
		if(!this.hasPermission(url,userModuleList,userButtonList)){
			throw new BaseException(BaseResponseCode.USER_PERMISSION_USER_NO_PERMISSION);
		}
		return new BaseResponse.Builder().buildSuccess();
	}

	/**
	 * 判断当前用户是否有当前url请求菜单
	 * @param url
	 * @param userModuleList
	 * @param userButtonList
	 * @return
	 */
	private Boolean hasPermission(String url, List<Module> userModuleList, List<Button> userButtonList) {
		for (Module module:  userModuleList) {
			if(StringUtil.isNotEmpty(module.getUrl()) && module.getUrl().equals(url)){
				return true;
			}
		}
		if(CollectionUtils.isNotEmpty(userButtonList)){
			for (Button button:  userButtonList) {
				if(StringUtil.isNotEmpty(button.getUrl()) && button.getUrl().equals(url)){
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 获取用户按钮列表缓存
	 * @param userId
	 * @param userModuleList
	 *@param request  @return
	 */
	@Override
    public List<Button> getUserButton(String userId, List<Module> userModuleList, BaseRequest request) throws Exception {
		List<Button> userButtonList =  UserInvoker.getUserButton(userId);
		if(CollectionUtils.isEmpty(userButtonList)){
			userButtonList = buttonMapper.getUserButtonListByUserModuleList(userModuleList);
			if(CollectionUtils.isNotEmpty(userButtonList)){
				//缓存用户按钮列表缓存
				UserInvoker.saveUserButton(userButtonList,userId, request.getRequestHead());
			}
		}
		return userButtonList;
	}

    /**
     * 分页查询用户列表
     * @param userQuery
     * @param pageBounds
     * @return
     */
    @Override
    public PageResponse<User> getUserList(UserQuery userQuery, PageBounds pageBounds) {
        PageHelper.startPage(pageBounds.getPage(), pageBounds.getLimit());
        List<User> list = userMapper.getUserList(userQuery);
        return new PageResponse.Builder().build(new PageInfo<>(list));
    }

    /**
     * 根据类型获取用户相应类型的缓存信息
     * @param clazz
     * @param userCookie
     * @return
     * @throws Exception
     */
    @Override
    public List getUserCacheInfoByType(Class clazz, String userCookie) throws Exception {
        User userCache = UserInvoker.getUser(userCookie);
        if(null == userCache){
            return null;
        }
        BaseRequest baseRequest = new BaseRequest.Builder().build(env.getProperty("spring.application.name"), userCache.getUserId());
        List<Role> userRole = this.getUserRole(userCache.getUserId(), userCache, baseRequest);
        if(clazz.equals(Role.class)){
            return userRole;
        }
        List<Module> userModule = this.getUserModule(userCache.getUserId(), userRole, baseRequest);
        if(clazz.equals(Module.class)){
            return userModule;
        }
        List<Button> userButton = this.getUserButton(userCache.getUserId(), userModule, baseRequest);
        if(clazz.equals(Button.class)){
            return userButton;
        }
        return null;
    }

    /**
     * 启用/停用 用户
     * @param userQuery
     * @return
     */
    @Override
    public BaseResponse doBanOrRelease(UserQuery userQuery) {
        if(null != userQuery.getStatus() && userQuery.getStatus().equals(SecurityStatusConstants.STATUS_OPEN)){
            userQuery.setStatus(SecurityStatusConstants.STATUS_CLOSE);
        }else{
            userQuery.setStatus(SecurityStatusConstants.STATUS_OPEN);
        }
        userMapper.doBanOrRelease(userQuery);
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
     * 执行分配角色
     * @param ids
     * @param userQuery
     * @return
     */
    @Override
    public BaseResponse doSetUserRole(String ids, UserQuery userQuery) {
        User user = userMapper.selectByPrimaryKey(userQuery.getId());
        userRoleMapper.deleteUserRole(user.getUserId());
        if(StringUtil.isEmpty(ids)){
            //更新用户缓存信息
            UserInvoker.clearUserCacheInfoByType(null ,user.getUserId());
            return new BaseResponse.Builder().buildSuccess();
        }
        String[] idsArr = ids.split(",");
        if(null== idsArr || idsArr.length < 1){
            return new BaseResponse.Builder().buildSuccess();
        }
        for (String idStr : idsArr) {
        	if(StringUtil.isNotEmpty(idStr)){
                UserRole userRole = new UserRole(Integer.parseInt(idStr),user.getUserId());
                userRoleMapper.insert(userRole);
            }
        }
        //更新用户缓存信息
        UserInvoker.clearUserCacheInfoByType(null ,user.getUserId());
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
	 * 获取用户菜单列表缓存
	 * @param userId
	 * @param userRoleList
	 *@param request  @return
	 */
    @Override
    public List<Module> getUserModule(String userId, List<Role> userRoleList, BaseRequest request) throws Exception {
		List<Module> userModuleList =  UserInvoker.getUserModule(userId);
		request.setInfo(userRoleList);
		if(CollectionUtils.isEmpty(userModuleList)){
			userModuleList = moduleMapper.getUserModuleListByUserRoleList(userRoleList);
			if(CollectionUtils.isNotEmpty(userModuleList)){
				//缓存用户菜单列表缓存
				UserInvoker.saveUserModule(userModuleList,userId, request.getRequestHead());
			}
		}
		return userModuleList;
	}


	/**
	 * 获取用户角色列表缓存
	 * @param userId
	 * @param user
	 * @param request
	 * @return
	 */
    @Override
	public List<Role> getUserRole(String userId, User user, BaseRequest request) throws Exception {
		List<Role> userRoleList =  UserInvoker.getUserRole(userId);
		if(CollectionUtils.isEmpty(userRoleList)){
			userRoleList = roleMapper.getUserRoleListByUserId(user.getUserId());
			if(CollectionUtils.isNotEmpty(userRoleList)){
				//绑定用户登录策略到线程本地
				ThreadLocalUtil.set(new ThreadParam.Biulder().setLoginStrategy(user.getLoginStrategy()).build());
				//缓存用户角色列表缓存
				UserInvoker.saveUserRole(userRoleList,userId, request.getRequestHead());
			}
		}
		return userRoleList;
	}

    /**
	 * 获取全局按钮缓存
	 * @return
	 */
	private List<Button> getGlobalButton() throws Exception {
		List<Button> globalButtonList =  UserInvoker.getGlobalButton();
		if(CollectionUtils.isEmpty(globalButtonList)){
			globalButtonList = buttonMapper.getGlobalButtonList();
			if(CollectionUtils.isNotEmpty(globalButtonList)){
				//缓存全局按钮列表缓存
				UserInvoker.saveGlobalButton(globalButtonList);
			}
		}
		return globalButtonList;
	}

	/**
	 * 获取全局菜单列表缓存
	 * @return
	 */
	private List<Module> getGlobalModule() throws Exception {
		List<Module> globalModuleList =  UserInvoker.getGlobalModule();
		if(CollectionUtils.isEmpty(globalModuleList)){
			globalModuleList = moduleMapper.getGlobalModuleList();
			if(CollectionUtils.isNotEmpty(globalModuleList)){
				//缓存全局菜单列表缓存
				UserInvoker.saveGlobalModule(globalModuleList);
			}
		}
		return globalModuleList;
	}

    /**
     * 获取全局菜角色列表缓存
     */
    @Override
    public List<Role> getGlobalRole() {
        List<Role> roleList = UserInvoker.getGlobalRole();
        if(CollectionUtils.isEmpty(roleList)){
            RoleQuery roleQuery = new RoleQuery();
            roleQuery.setStatus(SecurityStatusConstants.STATUS_OPEN);
            roleList = roleMapper.getRoleList(roleQuery);
            UserInvoker.saveGlobalRole(roleList);
        }
        return roleList;
    }

    /**
     * 根据类型获取全局缓存信息
     * @param clazz
     * @return
     */
    @Override
    public List getGlobalCacheByType(Class clazz) throws Exception {
        if(clazz.equals(Role.class)){
            return this.getGlobalRole();
        }
        if(clazz.equals(Module.class)){
            return this.getGlobalModule();
        }
        if(clazz.equals(Button.class)){
            return this.getGlobalButton();
        }
        return null;
    }

    /**
     * 页面获取用户角色信息
     * @return
     */
    @Override
    public List<UserRoleListVo> getUserRoleForPage(HttpServletRequest request, Integer id) throws Exception {

        //获取全局角色列表
        List<Role> globalRoleList = this.getGlobalCacheByType(Role.class);
        if(CollectionUtils.isEmpty(globalRoleList)){
            return new ArrayList<>();
        }
        //获取用户角色列表
        List<Role> userRoleList = new ArrayList<>();
        User user = userMapper.selectByPrimaryKey(id);
        if(null != user){
            userRoleList = roleMapper.getUserRoleListByUserId(user.getUserId());
        }
        List<Integer> userRoleIdList = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(userRoleList)){
            for (Role uRole: userRoleList) {
                userRoleIdList.add(uRole.getId());
            }
        }
        List<UserRoleListVo> userRoleListVoList = new ArrayList<>();
        //设置指定用户角色选中标识
        for (Role gRole: globalRoleList) {
            UserRoleListVo userRoleListVo = new UserRoleListVo();
            BeanUtils.copyProperties(userRoleListVo,gRole);
            if(userRoleIdList.contains(gRole.getId())){
                userRoleListVo.setIsSelected(NumberUtil.INTEGER_ONE);
            }
            userRoleListVoList.add(userRoleListVo);
        }
        return userRoleListVoList;
    }

	/**
	 *
	 * 模糊搜索
	 * @param fuzzyText
	 * @return
	 */
	@Override
	public List<FuzzySearchListVo> fuzzySearchByName(String fuzzyText) {
        List<User> roleList = userMapper.fuzzySearchByName("%" + fuzzyText + "%");
        List<FuzzySearchListVo> fuzzySearchListVos = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(roleList)){
            for (User user: roleList) {
                FuzzySearchListVo fuzzySearchListVo = new FuzzySearchListVo();
                fuzzySearchListVo.setText(user.getUsername());
                fuzzySearchListVos.add(fuzzySearchListVo);
            }
        }
        return fuzzySearchListVos;
	}


	/**
	 * 判断url是否在全局菜单+按钮 管理列表
	 * @param url
	 * @param globalModuleList
	 * @param globalButtonList
	 * @return
	 */
	private Boolean isUnderPermission(String url, List<Module> globalModuleList, List<Button> globalButtonList) {
		for (Module module: globalModuleList) {
			if(StringUtil.isNotEmpty(module.getUrl()) && module.getUrl().equals(url)){
				return true;
			}
		}
		for (Button button: globalButtonList) {
			if(StringUtil.isNotEmpty(button.getUrl()) && button.getUrl().equals(url)){
				return true;
			}
		}
		return false;
	}

	/**
	 * 校验授权参数
	 * @param userLoginPermissionQuery
	 * @param requestHead
	 * @return
	 */
	private void validatePermissionParam(UserLoginPermissionQuery userLoginPermissionQuery, RequestHead requestHead) {
		if(null == requestHead){
			throw new BaseException(BaseResponseCode.BASE_REQUEST_NULL);
		}

		if(StringUtil.isEmpty(requestHead.getApplicationName())){
			throw new BaseException(BaseResponseCode.BASE_REQUEST_APPLICATION_NAME_NULL);
		}

		if(null == userLoginPermissionQuery || (StringUtil.isEmpty(userLoginPermissionQuery.getUserCookie()) && null == userLoginPermissionQuery.getUrl()) || StringUtil.isEmpty(userLoginPermissionQuery.getUrl())){
			throw new BaseException(BaseResponseCode.USER_PERMISSION_PARAM_WRONG);
		}
	}
}
