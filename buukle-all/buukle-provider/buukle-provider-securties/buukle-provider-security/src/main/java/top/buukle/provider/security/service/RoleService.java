/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.service;

import top.buukle.common.response.BaseResponse;
import top.buukle.provider.security.entity.Role;
import top.buukle.provider.security.vo.query.PageBounds;
import top.buukle.provider.security.vo.query.RoleQuery;
import top.buukle.provider.security.vo.response.FuzzySearchListVo;
import top.buukle.provider.security.vo.response.PageResponse;
import top.buukle.provider.security.vo.response.RoleModuleListVo;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * 
 * @author elvin
 *
 */
public interface RoleService {
	/**
	 * @Description:	根据id获取Role
	 * @return
	 * @throws Exception
	 * @return	Role
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public Role getRoleById(Integer id) throws Exception;
	
	/** 
	 * @Description:	根据条件获取Role
	 * @param role
	 * @return
	 * @throws Exception
	 * @return	Role
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public List<Role> getRoleByParas(Role role) throws Exception;
	/** 
	 * @Description:	添加Role
	 * @param role
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public void save(Role role) throws Exception;
	/** 
	 * @Description:	更新Role
	 * @param role
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public void update(Role role) throws Exception;
	/** 
	 * @Description:	删除Role
	 * @param role
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public void delete(Role role) throws Exception;
	/** 
	 * @Description:	获取Role信息 不带分页
	 * @param role
	 * @return
	 * @throws Exception
	 * @return	List<Role>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public List<Role> getRolesByParasNoPage(Role role) throws Exception;


	/**
	 * 查询角色列表
	 * @param roleQuery
	 * @param pageBounds
	 * @return
	 */
    PageResponse<Role> getRoleList(RoleQuery roleQuery, PageBounds pageBounds);

	/**
	 * 启用禁用
	 *
     * @param request
     * @param query
     * @return
	 */
	BaseResponse doBanOrRelease(HttpServletRequest request, RoleQuery query) throws InvocationTargetException, IllegalAccessException;

	/**
	 * 分配菜单前回显
	 * @param request
	 * @param id
	 * @return
	 * @throws Exception
	 */
    List<RoleModuleListVo> getRoleModuleForPage(HttpServletRequest request, Integer id) throws Exception;

	/**
	 * 分配菜单
	 * @param ids
	 * @param userQuery
	 * @return
	 */
    BaseResponse setRoleModule(String ids, RoleQuery userQuery);

	/**
	 * 模糊查询
	 * @param fuzzyText
	 * @return
	 */
	List<FuzzySearchListVo> fuzzySearchByName(String fuzzyText);
}
