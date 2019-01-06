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
import top.buukle.common.dataIsolation.IsolationConstants;
import top.buukle.common.exception.BaseException;
import top.buukle.common.request.BaseRequest;
import top.buukle.common.request.RequestHead;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.common.MD5Util;
import top.buukle.common.util.common.NumberUtil;
import top.buukle.common.util.common.StringUtil;
import top.buukle.common.util.common.ThreadLocalUtil;
import top.buukle.common.vo.ThreadParam;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.provider.security.constants.CommonControllerConstants;
import top.buukle.provider.security.constants.SecurityConstants;
import top.buukle.provider.security.constants.SecurityStatusConstants;
import top.buukle.plugin.security.entity.*;
import top.buukle.provider.security.util.SessionUtil;
import top.buukle.provider.security.util.StringGeneratorUtil;
import top.buukle.plugin.security.vo.query.*;
import top.buukle.provider.security.dao.*;
import top.buukle.provider.security.invoker.UserInvoker;
import top.buukle.provider.security.service.UserService;
import top.buukle.plugin.security.vo.response.*;
import top.buukle.common.vo.response.PageResponse;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    private GroupsMapper groupsMapper;
	@Resource
    private UserRoleMapper userRoleMapper;
	@Resource
    private UserGroupMapper userGroupMapper;

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
     *
     * @param request
     * @param userQuery
     * @return
     */
    @Override
    public BaseResponse doBanOrRelease(HttpServletRequest request, UserQuery userQuery) throws InvocationTargetException, IllegalAccessException {
        User user = this.getUserByUserId(userQuery);
        if(user.getBak02().equals(SecurityConstants.DELETE_LEVEL_SYSTEM) && userQuery.getStatus() != null && userQuery.getStatus().equals(SecurityStatusConstants.STATUS_CLOSE)){
            throw new BaseException(BaseResponseCode.EDIT_FORBIDDEN);
        }
        if(null != userQuery.getStatus() && userQuery.getStatus().equals(SecurityStatusConstants.STATUS_OPEN)){
            userQuery.setStatus(SecurityStatusConstants.STATUS_CLOSE);
        }else{
            userQuery.setStatus(SecurityStatusConstants.STATUS_OPEN);
        }
        userQuery.setId(user.getId());
        userMapper.updateByPrimaryKeySelective(this.assUser(request,userQuery,false));
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
     * 组装用户
     * @param request
     * @param userQuery
     * @param isAdd
     * @return
     */
    private User assUser(HttpServletRequest request, UserQuery userQuery, boolean isAdd) throws InvocationTargetException, IllegalAccessException {
        User user = new User();
        BeanUtils.copyProperties(user,userQuery);
        User operator = SessionUtil.getOperator(request);
        if(isAdd){
            user.setGmtCreated(new Date());
            user.setCreatorCode(operator.getUserId());
            user.setCreator(operator.getUsername());
            user.setGmtModified(new Date());
            user.setModifier(operator.getUsername());
            user.setModifierCode(operator.getUserId());
            user.setUserId(StringGeneratorUtil.generateUserID());
            user.setPassword(MD5Util.MD5WithUTF8(user.getPassword()));
            user.setBak02(SecurityConstants.DELETE_LEVEL_TRUE);
            //初始化用户的等级
            user.setUserLevel(operator.getUserLevel());
            //初始化用户的归属关系

            //platform
            if(operator.getUserLevel().equals(IsolationConstants.USER_LEVEL_PLATFORM)){
                user.setPlatformId(operator.getPlatformId());
            }
            //agent
            if(operator.getUserLevel().equals(IsolationConstants.USER_LEVEL_AGENT)){
                user.setPlatformId(operator.getPlatformId());
                user.setAgentId(operator.getAgentId());
            }
            //group
            if(operator.getUserLevel().equals(IsolationConstants.USER_LEVEL_GROUP)){
                user.setPlatformId(operator.getPlatformId());
                user.setAgentId(operator.getAgentId());
                user.setGroupId(operator.getGroupId());
            }
            //salesman
            if(operator.getUserLevel().equals(IsolationConstants.USER_LEVEL_GROUP)){
                user.setPlatformId(operator.getPlatformId());
                user.setAgentId(operator.getAgentId());
                user.setGroupId(operator.getGroupId());
                user.setSalesmanId(operator.getSalesmanId());
            }

        }else{
            user.setGmtModified(new Date());
            user.setModifier(operator.getUsername());
            user.setModifierCode(operator.getUserId());
        }
        return user;
    }

    /**
     * 执行分配角色
     * @param ids
     * @param userQuery
     * @param roleLevel
     * @param request
     * @return
     */
    @Override
    public BaseResponse doSetUserRole(String ids, UserQuery userQuery, Integer roleLevel, HttpServletRequest request) {
        userQuery.setUserLevel(roleLevel);
        // 校验参数和归属关系
        User user = validateSetUserRoleParam(userQuery,ids,request);
        // 更新用户等级归属等信息
        if(userMapper.updateByPrimaryKeyForRelation(userQuery) != 1){
            throw new BaseException(BaseResponseCode.USER_SET_ROLE_UPDATE_USER_LEVEL_INFO_WRONG);
        }
        // 更新用户角色关系表记录
        userRoleMapper.deleteUserRole(user.getUserId());
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
        // 更新用户缓存信息
        UserInvoker.clearUserCacheInfoByType(null ,user.getUserId());
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
     * 校验参数
     * @param userQuery
     * @param ids
     * @param request
     */
    private User validateSetUserRoleParam(UserQuery userQuery, String ids, HttpServletRequest request) {
        User user = this.getUserByUserId(userQuery);
        if(null == user){
            throw new BaseException(BaseResponseCode.USER_SET_ROLE_USER_NULL);
        }
        if(StringUtil.isEmpty(ids)){
            throw new BaseException(BaseResponseCode.USER_SET_ROLE_LIST_NULL);
        }

        User operator = SessionUtil.getOperator(request);
        //操作人的级别要低于将要设置的级别,返回错误
        if(operator.getUserLevel() > userQuery.getUserLevel()){
            throw new BaseException(BaseResponseCode.USER_SET_ROLE_OPERATOR_PERMISSION_NOT_ENOUGH);
        }
        // 校验用户等级和归属关系

        // boss
        if(userQuery.getUserLevel().equals(IsolationConstants.USER_LEVEL_BOSS)){
            if(StringUtil.isNotEmpty(userQuery.getPlatformId()) || StringUtil.isNotEmpty(userQuery.getAgentId()) || StringUtil.isNotEmpty(userQuery.getGroupId()) || StringUtil.isNotEmpty(userQuery.getSalesmanId())){
                throw new BaseException(BaseResponseCode.USER_SET_ROLE_USER_LEVEL_BELONGING_RELATION_WRONG);
            }
        }
        // 平台
        if(userQuery.getUserLevel().equals(IsolationConstants.USER_LEVEL_PLATFORM)){
            if(StringUtil.isNotEmpty(userQuery.getPlatformId()) || StringUtil.isNotEmpty(userQuery.getAgentId()) || StringUtil.isNotEmpty(userQuery.getGroupId()) || StringUtil.isNotEmpty(userQuery.getSalesmanId())){
                throw new BaseException(BaseResponseCode.USER_SET_ROLE_USER_LEVEL_BELONGING_RELATION_WRONG);
            }
            //处理将下级提升为当前用户同级的情况
            if(operator.getUserLevel().equals(userQuery.getUserLevel())){
                userQuery.setPlatformId(operator.getPlatformId());
            }
        }
        // 代理
        if(userQuery.getUserLevel().equals(IsolationConstants.USER_LEVEL_AGENT)){
            if(StringUtil.isEmpty(userQuery.getPlatformId()) || StringUtil.isNotEmpty(userQuery.getAgentId()) || StringUtil.isNotEmpty(userQuery.getGroupId()) || StringUtil.isNotEmpty(userQuery.getSalesmanId())){
                throw new BaseException(BaseResponseCode.USER_SET_ROLE_USER_LEVEL_BELONGING_RELATION_WRONG);
            }
            //处理将下级提升为当前用户同级的情况
            if(operator.getUserLevel().equals(userQuery.getUserLevel())){
                userQuery.setAgentId(operator.getAgentId());
            }
        }
        // 区域
        if(userQuery.getUserLevel().equals(IsolationConstants.USER_LEVEL_GROUP)){
            if(StringUtil.isEmpty(userQuery.getPlatformId()) || StringUtil.isEmpty(userQuery.getAgentId()) || StringUtil.isNotEmpty(userQuery.getGroupId()) || StringUtil.isNotEmpty(userQuery.getSalesmanId())){
                throw new BaseException(BaseResponseCode.USER_SET_ROLE_USER_LEVEL_BELONGING_RELATION_WRONG);
            }
            //处理将下级提升为当前用户同级的情况
            if(operator.getUserLevel().equals(userQuery.getUserLevel())){
                userQuery.setGroupId(operator.getGroupId());
            }
        }
        // 业务员
        if(userQuery.getUserLevel().equals(IsolationConstants.USER_LEVEL_SALESMAN)){
            if(StringUtil.isEmpty(userQuery.getPlatformId()) || StringUtil.isEmpty(userQuery.getAgentId()) || StringUtil.isEmpty(userQuery.getGroupId()) || StringUtil.isNotEmpty(userQuery.getSalesmanId())){
                throw new BaseException(BaseResponseCode.USER_SET_ROLE_USER_LEVEL_BELONGING_RELATION_WRONG);
            }
            //处理将下级提升为当前用户同级的情况
            if(operator.getUserLevel().equals(userQuery.getUserLevel())){
                userQuery.setSalesmanId(operator.getSalesmanId());
            }
        }
        // 普通用户
        if(userQuery.getUserLevel().equals(IsolationConstants.USER_LEVEL_CREATOR)){
            if(StringUtil.isEmpty(userQuery.getPlatformId()) || StringUtil.isEmpty(userQuery.getAgentId()) || StringUtil.isEmpty(userQuery.getGroupId()) || StringUtil.isEmpty(userQuery.getSalesmanId())){
                throw new BaseException(BaseResponseCode.USER_SET_ROLE_USER_LEVEL_BELONGING_RELATION_WRONG);
            }
        }
        //设置用户id
        userQuery.setId(user.getId());
        return user;
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
     * 获取全局角色列表缓存
     */
    @Override
    public List<Role> getGlobalRole() {
        List<Role> roleList = UserInvoker.getGlobalRole();
        if(CollectionUtils.isEmpty(roleList)){
            RoleQuery roleQuery = new RoleQuery();
            roleQuery.setStatus(SecurityStatusConstants.STATUS_OPEN);
            roleList = roleMapper.getRoleListWithNoIsolation(roleQuery);
            UserInvoker.saveGlobalRole(roleList);
        }
        return roleList;
    }

    /**
     * 获取全局组别列表缓存
     */
    @Override
    public List<Groups> getGlobalGroups() {
        List<Groups> groupsList = UserInvoker.getGlobalGroups();
        if(CollectionUtils.isEmpty(groupsList)){
            GroupsQuery groupsQuery = new GroupsQuery();
            groupsQuery.setStatus(SecurityStatusConstants.STATUS_OPEN);
            groupsList = groupsMapper.getGroupsListWithNoIsolation(groupsQuery);
            UserInvoker.saveGlobalGroups(groupsList);
        }
        return groupsList;
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
    public List<UserRoleListVo> getUserRoleForPage(HttpServletRequest request, UserQuery query) throws Exception {
        //获取全局角色列表
        List<Role> globalRoleList = this.getGlobalCacheByType(Role.class);
        if(CollectionUtils.isEmpty(globalRoleList)){
            return new ArrayList<>();
        }
        //获取用户角色列表
        List<Role> userRoleList = new ArrayList<>();
        User user = this.getUserByUserId(query);
        //获取用户角色等级,根据用户等级筛选其所能分配的所有角色列表
        List<Role> gRoleList = globalRoleList.stream().filter(role -> role.getRoleLevel() >= SessionUtil.getOperator(request).getUserLevel()).collect(Collectors.toList());
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
        for (Role gRole: gRoleList) {
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
	 * 添加用户
     * @param request
     * @param userQuery
     * @return
	 */
	@Override
	public BaseResponse addUser(HttpServletRequest request, UserQuery userQuery) throws InvocationTargetException, IllegalAccessException {
        //校验参数
        this.validateAddOrUpdateParam(userQuery,true);
        //组装user对象,并插入数据库
        userMapper.insert(this.assUser(request, userQuery, true));
        return new BaseResponse.Builder().buildSuccess();
	}


    /**
     * 获取用户详情
     * @param userQuery
     * @return
     */
    @Override
    public User getUserDetail(UserQuery userQuery) {
        return this.getUserByUserId(userQuery);
    }

    /**
     * 编辑用户
     * @param request
     * @param userQuery
     * @param userId
     * @return
     */
    @Override
    public BaseResponse editUser(HttpServletRequest request, UserQuery userQuery, String userId) throws InvocationTargetException, IllegalAccessException {
        //验证参数
        userQuery.setUserId(userId);
        User user = this.validateAddOrUpdateParam(userQuery, false);
        userQuery.setId(user.getId());
        //不予许修改用户名密码
        userQuery.setUsername(null);
        userQuery.setPassword(null);
        //判断删禁级别
        if(user.getBak02().equals(SecurityConstants.DELETE_LEVEL_SYSTEM) && userQuery.getStatus().equals(SecurityStatusConstants.STATUS_CLOSE)){
            throw new BaseException(BaseResponseCode.EDIT_FORBIDDEN);
        }
        //组装并更新用户
        userMapper.updateByPrimaryKeySelective(this.assUser(request, userQuery, false));
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
     * 获取组别成员列表
     * @param groupsId
     * @param userQuery
     * @param pageBounds
     * @return
     */
    @Override
    public PageResponse<UserMemberVo> getMemberList(Integer groupsId, UserQuery userQuery, PageBounds pageBounds) throws InvocationTargetException, IllegalAccessException {
        //查询用户列表
        List<UserMemberVo> voList = new ArrayList<>();
        PageHelper.startPage(pageBounds.getPage(), pageBounds.getLimit());
        userQuery.setGroupsId(groupsId);
        List<User> list = userMapper.getUserByGroupsIdWithQuery(userQuery);
        for (User user : list) {
            UserMemberVo userMemberVo = new UserMemberVo();
            BeanUtils.copyProperties(userMemberVo,user);
            //设置该用户的组别信息
            List<Groups> userGroupsByUserId = groupsMapper.getUserGroupsByUserId(user.getUserId());
            UserGroup userGroupRelation = userGroupMapper.getByUserId(user.getUserId());
            if(CollectionUtils.isNotEmpty(userGroupsByUserId)){
                Groups userGroup = userGroupsByUserId.get(0);
                userMemberVo.setCurrentGroupsId(userGroup.getId());
                userMemberVo.setCurrentGroupsName(userGroup.getName());
                userMemberVo.setIsBelong(userGroup.getId().equals(groupsId) ? UserMemberVo.IS_BELONG_TRUE : UserMemberVo.IS_BELONG_FALSE);
                userMemberVo.setIsAdmin((userGroupRelation.getType().equals(NumberUtil.INTEGER_ONE) && userGroupRelation.getGroupId().equals(groupsId)) ?  UserMemberVo.IS_ADMIN_TRUE :UserMemberVo.IS_ADMIN_FALSE );
            }
            voList.add(userMemberVo);
        }
        return new PageResponse.Builder().build(voList,new PageInfo<>(list));
    }

    /**
     * 根据级别获取用户下拉选项列表
     * @param request
     * @param selectType
     * @param superCode
     * @return
     */
    @Override
    public List<SelectSearchItemVo> getSelectItemByType(HttpServletRequest request, Integer selectType, String superCode) {
        User operator = SessionUtil.getOperator(request);
        Integer userLevel = operator.getUserLevel();
        List<SelectSearchItemVo> selectSearchItemVos = new ArrayList<>();
        //尝试为boss用户获取平台列表
        if(selectType.equals(CommonControllerConstants.SELECT_TYPE_PLATFORM)){
            if(userLevel.equals(IsolationConstants.USER_LEVEL_BOSS)){
                List<User> userList = userMapper.getSubPlatformSelectItemsForLevelBoss();
                return this.assSelectSearchItemVoList(userList);
            }else{
                SelectSearchItemVo selectSearchItemVo = new SelectSearchItemVo();
                selectSearchItemVo.setText(userMapper.getUserByUserId(operator.getPlatformId()).getUsername());
                selectSearchItemVo.setIdStr(operator.getPlatformId());
                selectSearchItemVos.add(selectSearchItemVo);
                return selectSearchItemVos;
            }
        }
        //尝试为platform用户获取代理商列表
        if(selectType.equals(CommonControllerConstants.SELECT_TYPE_AGENT)){
            if(StringUtil.isEmpty(superCode)){
                throw new BaseException(BaseResponseCode.COMMON_SELECT_TYPE_SUPER_CODE_NULL);
            }
            if(userLevel.equals(IsolationConstants.USER_LEVEL_PLATFORM) || userLevel.equals(IsolationConstants.USER_LEVEL_BOSS)){
                List<User> userList = userMapper.getSubAgentSelectItemsForLevelPlatform(superCode);
                return this.assSelectSearchItemVoList(userList);
            }else{
                SelectSearchItemVo selectSearchItemVo = new SelectSearchItemVo();
                selectSearchItemVo.setText(userMapper.getUserByUserId(operator.getAgentId()).getUsername());
                selectSearchItemVo.setIdStr(operator.getAgentId());
                selectSearchItemVos.add(selectSearchItemVo);
                return selectSearchItemVos;
            }
        }
        //尝试为agent用户获取区域/组别列表
        if(selectType.equals(CommonControllerConstants.SELECT_TYPE_GROUP)){
            if(StringUtil.isEmpty(superCode)){
                throw new BaseException(BaseResponseCode.COMMON_SELECT_TYPE_SUPER_CODE_NULL);
            }
            if(userLevel.equals(IsolationConstants.USER_LEVEL_AGENT) || userLevel.equals(IsolationConstants.USER_LEVEL_PLATFORM) || userLevel.equals(IsolationConstants.USER_LEVEL_BOSS)){
                List<User> userList = userMapper.getSubGroupSelectItemsForLevelAgent(superCode);
                return this.assSelectSearchItemVoList(userList);
            }else{
                SelectSearchItemVo selectSearchItemVo = new SelectSearchItemVo();
                selectSearchItemVo.setText(userMapper.getUserByUserId(operator.getPlatformId()).getUsername());
                selectSearchItemVo.setIdStr(operator.getGroupId());
                selectSearchItemVos.add(selectSearchItemVo);
                return selectSearchItemVos;
            }
        }
        //尝试为group用户获取业务员
        if(selectType.equals(CommonControllerConstants.SELECT_TYPE_SALESMAN)){
            if(StringUtil.isEmpty(superCode)){
                throw new BaseException(BaseResponseCode.COMMON_SELECT_TYPE_SUPER_CODE_NULL);
            }
            if(userLevel.equals(IsolationConstants.USER_LEVEL_GROUP) || userLevel.equals(IsolationConstants.USER_LEVEL_AGENT) || userLevel.equals(IsolationConstants.USER_LEVEL_PLATFORM) || userLevel.equals(IsolationConstants.USER_LEVEL_BOSS)){
                List<User> userList = userMapper.getSubSalesmanSelectItemsForLevelGroup(superCode);
                return this.assSelectSearchItemVoList(userList);
            }else{
                SelectSearchItemVo selectSearchItemVo = new SelectSearchItemVo();
                selectSearchItemVo.setText(userMapper.getUserByUserId(operator.getPlatformId()).getUsername());
                selectSearchItemVo.setIdStr(operator.getSalesmanId());
                selectSearchItemVos.add(selectSearchItemVo);
                return selectSearchItemVos;
            }
        }
        return null;
    }

    /**
     * 组装用户列表为下拉列表
     * @param userList
     * @return
     */
    private List<SelectSearchItemVo> assSelectSearchItemVoList(List<User> userList) {
        List<SelectSearchItemVo> list = new ArrayList<>();
        if(CollectionUtils.isEmpty(userList)){
            return list;
        }
        for (User user: userList) {
            SelectSearchItemVo selectSearchItemVo = new SelectSearchItemVo();
            selectSearchItemVo.setText(user.getUsername());
            selectSearchItemVo.setIdStr(user.getUserId());
            list.add(selectSearchItemVo);
        }
        return list;
    }

    /**
     * 校验添加/更新参数
     * @param userQuery
     * @param isAdd
     */
    private User validateAddOrUpdateParam(UserQuery userQuery, boolean isAdd) {
        if(!isAdd){
            User user = this.getUserByUserId(new UserQuery(userQuery.getUserId()));
            if(null == user){
                throw new BaseException(BaseResponseCode.FAILED);
            }
            if(user.getBak02().equals(SecurityConstants.DELETE_LEVEL_SYSTEM) && userQuery.getStatus() != null && userQuery.getStatus().equals(SecurityStatusConstants.STATUS_CLOSE)){
                throw new BaseException(BaseResponseCode.EDIT_FORBIDDEN);
            }
            if(user.getBak02().equals(SecurityConstants.DELETE_LEVEL_SYSTEM)){
                userQuery.setStatus(SecurityStatusConstants.STATUS_OPEN);
            }
            if(StringUtil.isEmpty(userQuery.getGender())){
                throw new BaseException(BaseResponseCode.USER_ADD_GENDER_NULL);
            }
            if(userQuery.getStatus() == null){
                throw new BaseException(BaseResponseCode.USER_ADD_STATUS_NULL);
            }
            return user;
        }
        else {
            if(StringUtil.isEmpty(userQuery.getUsername())){
                throw new BaseException(BaseResponseCode.USER_ADD_USERNAME_NULL);
            }
            UserQuery user = new UserQuery();
            user.setUsername(userQuery.getUsername());
            // 用户名查重
            List<User> userRepeat = userMapper.getUserByUsername(userQuery.getUsername());
            if(CollectionUtils.isNotEmpty(userRepeat)){
                throw new BaseException(BaseResponseCode.USER_ADD_USERNAME_EXIST);
            }
            if(StringUtil.isEmpty(userQuery.getPassword())){
                throw new BaseException(BaseResponseCode.USER_ADD_PASSWORD_NULL);
            }
            if(StringUtil.isEmpty(userQuery.getGender())){
                throw new BaseException(BaseResponseCode.USER_ADD_GENDER_NULL);
            }
            if(userQuery.getStatus() == null){
                throw new BaseException(BaseResponseCode.USER_ADD_STATUS_NULL);
            }
            return null;
        }
    }


    /**
	 * 判断url是否在全局菜单/按钮 管理列表
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

    /**
     * 根据userId获取user
     * @return
     * @param userQuery
     */
    public User getUserByUserId(UserQuery userQuery) {
        List<User> userList = userMapper.getUserList(new UserQuery(userQuery.getUserId()));
        return CollectionUtils.isEmpty(userList) ? null : userList.get(0);
    }
}
