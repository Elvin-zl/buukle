/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;
import top.buukle.common.request.BaseRequest;
import top.buukle.common.request.RequestHead;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.common.StringUtil;
import top.buukle.common.util.common.ThreadLocalUtil;
import top.buukle.common.vo.ThreadParam;
import top.buukle.provider.security.vo.query.UserLoginPermissionQuery;
import top.buukle.provider.security.dao.*;
import top.buukle.provider.security.entity.Button;
import top.buukle.provider.security.entity.Module;
import top.buukle.provider.security.entity.Role;
import top.buukle.provider.security.entity.User;
import top.buukle.provider.security.invoker.UserInvoker;
import top.buukle.provider.security.service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author elvin
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	UserMapper userMapper;
	@Resource
	ButtonMapper buttonMapper;
	@Resource
	ModuleMapper moduleMapper;
	@Resource
	RoleMapper roleMapper;

	private static final String AUTHENTICATION_WRONG = "认证失败";

	@Override
	public List<User> getUserByParas(User user, PageBounds pageBounds) throws Exception {
		return userMapper.getUserByParas(user, pageBounds);
	}
	@Override
	public User getUserById(Integer id) throws Exception{
		return userMapper.getUserById(id);
	}
	
	@Override
	public List<User> getUserByParas(User user) throws Exception {
		return userMapper.getUserByParas(user);
	}
	@Override
	public void save(User user) throws Exception {
		userMapper.save(user);
	}
	@Override
	public void update(User user) throws Exception {
		userMapper.update(user);
        int i = 1/0;
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
			UserInvoker.saveUser(user,ssoDefault,request.getRequestHead());
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
		String userCookie = userLoginPermissionQuery.getUserCookie();
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
		List<Role> userRoleList = this.getUserRole(userCookie,user,request);
		if(CollectionUtils.isEmpty(userRoleList)){
			throw new BaseException(BaseResponseCode.USER_PERMISSION_USER_ROLE_LIST_NULL);
		}
		//获取用户菜单列表缓存
		List<Module> userModuleList = this.getUserModule(userCookie,userRoleList,request);
		if(CollectionUtils.isEmpty(userModuleList)){
			throw new BaseException(BaseResponseCode.USER_PERMISSION_USER_MODULE_LIST_NULL);
		}
		//获取用户按钮列表缓存
		List<Button> userButtonList = this.getUserButton(userCookie,userModuleList,request);
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
	 * @param userCookie
	 * @param userModuleList
	 *@param request  @return
	 */
	private List<Button> getUserButton(String userCookie, List<Module> userModuleList, BaseRequest request) throws Exception {
		List<Button> userButtonList =  UserInvoker.getUserButton(userCookie);
		if(CollectionUtils.isEmpty(userButtonList)){
			userButtonList = buttonMapper.getUserButtonListByUserModuleList(userModuleList);
			if(CollectionUtils.isNotEmpty(userButtonList)){
				//缓存用户按钮列表缓存
				UserInvoker.saveUserButton(userButtonList,userCookie, request.getRequestHead());
			}
		}
		return userButtonList;
	}
	/**
	 * 获取用户菜单列表缓存
	 * @param userCookie
	 * @param userRoleList
	 *@param request  @return
	 */
	private List<Module> getUserModule(String userCookie, List<Role> userRoleList, BaseRequest request) throws Exception {
		List<Module> userModuleList =  UserInvoker.getUserModule(userCookie);
		request.setInfo(userRoleList);
		if(CollectionUtils.isEmpty(userModuleList)){
			userModuleList = moduleMapper.getUserModuleListByUserRoleList(userRoleList);
			if(CollectionUtils.isNotEmpty(userModuleList)){
				//缓存用户菜单列表缓存
				UserInvoker.saveUserModule(userModuleList,userCookie, request.getRequestHead());
			}
		}
		return userModuleList;
	}

	/**
	 * 获取用户角色列表缓存
	 * @param userCookie
	 * @param user
	 * @param request
	 * @return
	 */
	private List<Role> getUserRole(String userCookie, User user, BaseRequest request) throws Exception {
		List<Role> userRoleList =  UserInvoker.getUserRole(userCookie);
		if(CollectionUtils.isEmpty(userRoleList)){
			userRoleList = roleMapper.getUserRoleListByUserId(user.getUserId());
			if(CollectionUtils.isNotEmpty(userRoleList)){
				//绑定用户登录策略到线程本地
				ThreadLocalUtil.set(new ThreadParam.Biulder().setLoginStrategy(user.getLoginStrategy()).build());
				//缓存用户角色列表缓存
				UserInvoker.saveUserRole(userRoleList,userCookie, request.getRequestHead());
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
