/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.service;

import top.buukle.plugin.security.entity.ModuleButton;

import java.util.List;

/**
 * 
 * @author elvin
 *
 */
public interface ModuleButtonService {
	
	/**
	 * @Description:	根据id获取ModuleButton
	 * @return
	 * @throws Exception
	 * @return	ModuleButton
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public ModuleButton getModuleButtonById(Integer id) throws Exception;
	
	/** 
	 * @Description:	根据条件获取ModuleButton
	 * @param moduleButton
	 * @return
	 * @throws Exception
	 * @return	ModuleButton
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public List<ModuleButton> getModuleButtonByParas(ModuleButton moduleButton) throws Exception;
	/** 
	 * @Description:	添加ModuleButton
	 * @param moduleButton
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public void save(ModuleButton moduleButton) throws Exception;
	/** 
	 * @Description:	更新ModuleButton
	 * @param moduleButton
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public void update(ModuleButton moduleButton) throws Exception;
	/** 
	 * @Description:	删除ModuleButton
	 * @param moduleButton
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public void delete(ModuleButton moduleButton) throws Exception;
	/** 
	 * @Description:	获取ModuleButton信息 不带分页
	 * @param moduleButton
	 * @return
	 * @throws Exception
	 * @return	List<ModuleButton>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public List<ModuleButton> getModuleButtonsByParasNoPage(ModuleButton moduleButton) throws Exception;
	

}
