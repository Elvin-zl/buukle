/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.annotations.Param;
import top.buukle.provider.security.entity.Module;
import top.buukle.provider.security.entity.Role;
import top.buukle.provider.security.entity.User;

import java.util.List;

/**
 * 
 * @author elvin
 *
 */

public interface ModuleMapper {
	/** 
	 * @Description:	分页获取Module
	 * @param module
	 * @param pageBounds
	 * @return
	 * @return	PageList<Module>
	 * @Date	2015年6月12日 上午10:29:17 
	 */
	public PageList<Module> getModuleByParas(Module module, PageBounds pageBounds) throws Exception;
	
	/** 
	 * @Description:	根据id获取Module
	 * @param module
	 * @return
	 * @throws Exception
	 * @return	Module
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public Module getModuleById(Integer id) throws Exception;
	
	/** 
	 * @Description:	根据条件获取Module
	 * @param module
	 * @return
	 * @throws Exception
	 * @return	Module
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public PageList<Module> getModuleByParas(Module module) throws Exception;
	/** 
	 * @Description:	添加Module
	 * @param module
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public Integer save(Module module) throws Exception;
	/** 
	 * @Description:	更新Module
	 * @param module
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public Integer update(Module module) throws Exception;
	/** 
	 * @Description:	删除Module
	 * @param module
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public Integer delete(Module module) throws Exception;
	/** 
	 * @Description:	获取Module信息 不带分页
	 * @param module
	 * @return
	 * @throws Exception
	 * @return	PageList<Module>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public PageList<Module> getModulesByParasNoPage(Module module) throws Exception;

	/**
	 * 根据用户角色列表查询用户菜单列表
	 * @param userRoleList
	 * @return
	 */
	List<Module> getUserModuleListByUserRoleList(@Param("userRoleList") List<Role> userRoleList);

	/**
	 * 获取全局角色列表
	 * @return
	 */
	List<Module> getGlobalModuleList();

	/**
	 * 根据用户user_id获取用户权限列表
	 * @param user
	 * @return
	 */
    List<Module> getUserModuleListByUserId(User user);
}
