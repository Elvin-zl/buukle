/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.service;

import top.buukle.common.request.BaseRequest;
import top.buukle.common.response.BaseResponse;
import top.buukle.provider.security.entity.*;
import top.buukle.provider.security.vo.query.PageBounds;
import top.buukle.provider.security.vo.query.UserQuery;
import top.buukle.provider.security.vo.response.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * 
 * @author elvin
 *
 */
public interface UserService {
	

	/** 
	 * @Description:	根据id获取User
	 * @return
	 * @throws Exception
	 * @return	User
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public User getUserById(Integer id) throws Exception;
	
	/** 
	 * @Description:	根据条件获取User
	 * @param user
	 * @return
	 * @throws Exception
	 * @return	User
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public List<User> getUserByParas(User user) throws Exception;
	/** 
	 * @Description:	添加User
	 * @param user
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public void save(User user) throws Exception;
	/** 
	 * @Description:	更新User
	 * @param user
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public void update(User user) throws Exception;
	/** 
	 * @Description:	删除User
	 * @param user
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public void delete(User user) throws Exception;
	/** 
	 * @Description:	获取User信息 不带分页
	 * @param user
	 * @return
	 * @throws Exception
	 * @return	List<User>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public List<User> getUsersByParasNoPage(User user) throws Exception;

	public BaseResponse authentication(BaseRequest request);

	public BaseResponse setPermission(BaseRequest request) throws Exception;

	public List<Button> getUserButton(String userCookie, List<Module> userModuleList, BaseRequest request) throws Exception;

	public List<Module> getUserModule(String userCookie, List<Role> userRoleList, BaseRequest request) throws Exception;

	public List<Role> getUserRole(String userCookie, User user, BaseRequest request) throws Exception;

	/**
	 * 分页获取用户列表
	 * @param userQuery
	 * @param pageBounds
	 * @return
	 */
	PageResponse<User> getUserList(UserQuery userQuery, PageBounds pageBounds);

	/**
	 * 个根据类型获取不同的用户缓存信息
	 * @param clazz
	 * @param userCookie
	 * @return
	 * @throws Exception
	 */
	List getUserCacheInfoByType(Class clazz, String userCookie) throws Exception;

	/**
	 * 起停用
	 *
     * @param request
     * @param userQuery
     * @return
	 */
    BaseResponse doBanOrRelease(HttpServletRequest request, UserQuery userQuery) throws InvocationTargetException, IllegalAccessException;

	/**
	 * 执行设置角色
	 * @param ids
	 * @param userQuery
	 * @param roleLevel
     * @param request
     * @return
	 */
    BaseResponse doSetUserRole(String ids, UserQuery userQuery, Integer roleLevel, HttpServletRequest request);

	/**
	 * 获取全局角色列表
	 * @return
	 */
	List<Role> getGlobalRole();

	/**
	 * 获取全局组别列表
	 * @return
	 */
	List<Groups> getGlobalGroups();

	/**
	 * 根据类型获取全局缓存信息
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
    List getGlobalCacheByType(Class clazz) throws Exception;


	/**
	 * 分配角色前页面回显查询
	 * @param request
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<UserRoleListVo> getUserRoleForPage(HttpServletRequest request, UserQuery query) throws Exception;

	/**
	 * 模糊搜索
	 * @param fuzzyText
	 * @return
	 */
    List<FuzzySearchListVo> fuzzySearchByName(String fuzzyText);

	/**
	 * 添加用户
	 *
	 * @param request
	 * @param userQuery
	 * @return
	 */
    BaseResponse addUser(HttpServletRequest request, UserQuery userQuery) throws InvocationTargetException, IllegalAccessException;

	/**
	 * 获取用户详情
	 * @param userQuery
	 * @return
	 */
	User getUserDetail(UserQuery userQuery);

	/**
	 * 修改用户
	 * @param request
	 * @param userQuery
	 * @param userId
	 * @return
	 */
    BaseResponse editUser(HttpServletRequest request, UserQuery userQuery, String userId) throws InvocationTargetException, IllegalAccessException;

	/**
	 * 获取组别成员列表
	 * @param groupsId
	 * @param userQuery
	 * @param pageBounds
	 * @return
	 */
    PageResponse<UserMemberVo> getMemberList(Integer groupsId, UserQuery userQuery, PageBounds pageBounds) throws InvocationTargetException, IllegalAccessException;

	/**
	 * 获取下拉框列表
	 * @param request
	 * @param selectType
	 * @param superCode
	 * @return
	 */
	List<SelectSearchItemVo> getSelectItemByType(HttpServletRequest request, Integer selectType, String superCode);
}
