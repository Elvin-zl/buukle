/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.dao;

import top.buukle.provider.security.entity.RoleModule;

/**
 * 
 * @author elvin
 *
 */

public interface RoleModuleMapper {

	/** 
	 * @Description:	根据id获取RoleModule
	 * @return
	 * @throws Exception
	 * @return	RoleModule
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public RoleModule getRoleModuleById(Integer id) throws Exception;
	
	/**
	 * @Description:	添加RoleModule
	 * @param roleModule
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public Integer save(RoleModule roleModule) throws Exception;
	/** 
	 * @Description:	更新RoleModule
	 * @param roleModule
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public Integer update(RoleModule roleModule) throws Exception;
	/** 
	 * @Description:	删除RoleModule
	 * @param roleModule
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public Integer delete(RoleModule roleModule) throws Exception;
}
