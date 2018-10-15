/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.service;

import top.buukle.common.request.BaseRequest;
import top.buukle.common.response.BaseResponse;
import top.buukle.provider.security.entity.Button;
import top.buukle.provider.security.entity.Module;
import top.buukle.provider.security.entity.Role;
import top.buukle.provider.security.entity.User;
import top.buukle.provider.security.vo.query.PageBounds;
import top.buukle.provider.security.vo.query.UserQuery;
import top.buukle.provider.security.vo.response.PageResponse;

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

	PageResponse<User> getUserList(UserQuery userQuery, PageBounds pageBounds);
}
