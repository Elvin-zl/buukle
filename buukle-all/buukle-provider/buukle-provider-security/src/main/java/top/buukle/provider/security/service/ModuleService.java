/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.service;

import top.buukle.common.response.BaseResponse;
import top.buukle.plugin.security.entity.Module;
import top.buukle.plugin.security.vo.query.ModuleQuery;
import top.buukle.plugin.security.vo.query.PageBounds;
import top.buukle.plugin.security.vo.response.*;
import top.buukle.plugin.security.vo.response.ModuleNavigationVo;
import top.buukle.common.vo.response.PageResponse;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
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


	/**
	 * 获取用户权限树
	 * @param httpServletRequest
	 * @param applicationName
	 * @return
	 * @throws Exception
	 */
    List<ModuleNavigationVo> getUserModuleTree(HttpServletRequest httpServletRequest, String applicationName) throws Exception;

	/**
	 * 分页获取列表
	 * @param query
	 * @param pageBounds
	 * @return
	 */
    PageResponse<Module> getModuleList(ModuleQuery query, PageBounds pageBounds);

	/**
	 * 启用禁用
	 *
     * @param request
     * @param query
     * @return
	 */
	BaseResponse doBanOrRelease(HttpServletRequest request, ModuleQuery query) throws InvocationTargetException, IllegalAccessException;

	/**
	 * 分配按钮回显页面查询
	 * @param request
	 * @param id
	 * @return
	 * @throws Exception
	 */
    List<ModuleButtonListVo> getModuleButtonForPage(HttpServletRequest request, Integer id) throws Exception;

	/**
	 * 分配按钮
	 * @param ids
	 * @param query
	 * @return
	 */
	BaseResponse setModuleButton(String ids, ModuleQuery query);

	/**
	 * 模糊搜索
	 * @param fuzzyText
	 * @return
	 */
	List<FuzzySearchListVo> fuzzySearchByName(String fuzzyText);

	/**
	 * 查询父级菜单树
	 * @return
     * @param applicationName
     * @param callBack
     */
    List<RoleModuleListVo> getFatherModuleTree(String applicationName, String callBack) throws Exception;

    /**
     * 添加菜单
     *
     * @param request
     * @param query
     * @param applicationName
     * @return
     */
    BaseResponse addModule(HttpServletRequest request, ModuleQuery query, String applicationName) throws InvocationTargetException, IllegalAccessException;

	/**
	 * 查询菜单详情
	 * @param query
	 * @return
	 */
	ModuleDetailVo getModuleDetail(ModuleQuery query) throws InvocationTargetException, IllegalAccessException;

	/**
	 * 编辑菜单
	 *
	 * @param request
	 * @param id
	 * @param query
	 * @param applicationName
	 * @return
	 */
	BaseResponse editModule(HttpServletRequest request, Integer id, ModuleQuery query, String applicationName) throws InvocationTargetException, IllegalAccessException;

	/**
	 *
	 * @param cookie
	 * @param applicationName
	 * @return
	 */
    List<ModuleNavigationVo> getUserModuleTree(String cookie, String applicationName) throws Exception;
}
