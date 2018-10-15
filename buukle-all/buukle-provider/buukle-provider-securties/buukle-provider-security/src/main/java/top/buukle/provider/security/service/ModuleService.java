/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.service;

import top.buukle.provider.security.entity.Module;
import top.buukle.provider.security.vo.result.ModuleNavigationVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 
 * @author elvin
 *
 */
public interface ModuleService {
	

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
	public List<Module> getModuleByParas(Module module) throws Exception;
	/** 
	 * @Description:	添加Module
	 * @param module
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public void save(Module module) throws Exception;
	/** 
	 * @Description:	更新Module
	 * @param module
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public void update(Module module) throws Exception;
	/** 
	 * @Description:	删除Module
	 * @param module
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public void delete(Module module) throws Exception;
	/** 
	 * @Description:	获取Module信息 不带分页
	 * @param module
	 * @return
	 * @throws Exception
	 * @return	List<Module>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public List<Module> getModulesByParasNoPage(Module module) throws Exception;


    List<ModuleNavigationVo> getUserModuleTree(HttpServletRequest httpServletRequest, String applicationName);
}
