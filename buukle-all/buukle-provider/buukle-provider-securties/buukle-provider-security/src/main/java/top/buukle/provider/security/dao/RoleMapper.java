/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.dao;

import top.buukle.provider.security.entity.Role;

import java.util.List;

/**
 * 
 * @author elvin
 *
 */

public interface RoleMapper {

	/** 
	 * @Description:	根据id获取Role
	 * @return
	 * @throws Exception
	 * @return	Role
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public Role getRoleById(Integer id) throws Exception;
	
	/**
	 * @Description:	添加Role
	 * @param role
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public Integer save(Role role) throws Exception;
	/** 
	 * @Description:	更新Role
	 * @param role
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public Integer update(Role role) throws Exception;
	/** 
	 * @Description:	删除Role
	 * @param role
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public Integer delete(Role role) throws Exception;

    List<Role> getUserRoleListByUserId(String userId);
}
