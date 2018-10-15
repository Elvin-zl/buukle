/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.dao;

import top.buukle.provider.security.entity.UserRole;

/**
 * 
 * @author elvin
 *
 */

public interface UserRoleMapper {

	/** 
	 * @Description:	根据id获取UserRole
	 * @return
	 * @throws Exception
	 * @return	UserRole
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public UserRole getUserRoleById(Integer id) throws Exception;
	
	/**
	 * @Description:	添加UserRole
	 * @param userRole
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public Integer save(UserRole userRole) throws Exception;
	/** 
	 * @Description:	更新UserRole
	 * @param userRole
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public Integer update(UserRole userRole) throws Exception;
	/** 
	 * @Description:	删除UserRole
	 * @param userRole
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public Integer delete(UserRole userRole) throws Exception;
}
