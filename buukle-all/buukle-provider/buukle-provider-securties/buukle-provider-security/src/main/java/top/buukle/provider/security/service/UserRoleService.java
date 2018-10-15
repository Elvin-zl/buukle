/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.service;

import top.buukle.provider.security.entity.UserRole;

import java.util.List;

/**
 * 
 * @author elvin
 *
 */
public interface UserRoleService {
	

	/** 
	 * @Description:	根据id获取UserRole
	 * @return
	 * @throws Exception
	 * @return	UserRole
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public UserRole getUserRoleById(Integer id) throws Exception;
	
	/** 
	 * @Description:	根据条件获取UserRole
	 * @param userRole
	 * @return
	 * @throws Exception
	 * @return	UserRole
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public List<UserRole> getUserRoleByParas(UserRole userRole) throws Exception;
	/** 
	 * @Description:	添加UserRole
	 * @param userRole
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public void save(UserRole userRole) throws Exception;
	/** 
	 * @Description:	更新UserRole
	 * @param userRole
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public void update(UserRole userRole) throws Exception;
	/** 
	 * @Description:	删除UserRole
	 * @param userRole
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public void delete(UserRole userRole) throws Exception;
	/** 
	 * @Description:	获取UserRole信息 不带分页
	 * @param userRole
	 * @return
	 * @throws Exception
	 * @return	List<UserRole>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public List<UserRole> getUserRolesByParasNoPage(UserRole userRole) throws Exception;
	

}
