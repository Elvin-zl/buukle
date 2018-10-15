/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.service;

import top.buukle.provider.security.entity.RoleModule;

import java.util.List;

/**
 * 
 * @author elvin
 *
 */
public interface RoleModuleService {
	/**
	 * @Description:	根据id获取RoleModule
	 * @return
	 * @throws Exception
	 * @return	RoleModule
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public RoleModule getRoleModuleById(Integer id) throws Exception;
	
	/** 
	 * @Description:	根据条件获取RoleModule
	 * @param roleModule
	 * @return
	 * @throws Exception
	 * @return	RoleModule
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public List<RoleModule> getRoleModuleByParas(RoleModule roleModule) throws Exception;
	/** 
	 * @Description:	添加RoleModule
	 * @param roleModule
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public void save(RoleModule roleModule) throws Exception;
	/** 
	 * @Description:	更新RoleModule
	 * @param roleModule
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public void update(RoleModule roleModule) throws Exception;
	/** 
	 * @Description:	删除RoleModule
	 * @param roleModule
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public void delete(RoleModule roleModule) throws Exception;
	/** 
	 * @Description:	获取RoleModule信息 不带分页
	 * @param roleModule
	 * @return
	 * @throws Exception
	 * @return	List<RoleModule>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public List<RoleModule> getRoleModulesByParasNoPage(RoleModule roleModule) throws Exception;
	

}
