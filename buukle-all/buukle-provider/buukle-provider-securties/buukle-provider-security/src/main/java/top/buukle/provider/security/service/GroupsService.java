/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.service;

import top.buukle.provider.security.entity.Groups;

import java.util.List;

/**
 * 
 * @author elvin
 *
 */
public interface GroupsService {
	

	/** 
	 * @Description:	根据id获取Groups
	 * @return
	 * @throws Exception
	 * @return	Groups
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public Groups getGroupsById(Integer id) throws Exception;
	
	/** 
	 * @Description:	根据条件获取Groups
	 * @param groups
	 * @return
	 * @throws Exception
	 * @return	Groups
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public List<Groups> getGroupsByParas(Groups groups) throws Exception;
	/** 
	 * @Description:	添加Groups
	 * @param groups
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public void save(Groups groups) throws Exception;
	/** 
	 * @Description:	更新Groups
	 * @param groups
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public void update(Groups groups) throws Exception;
	/** 
	 * @Description:	删除Groups
	 * @param groups
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public void delete(Groups groups) throws Exception;
	/** 
	 * @Description:	获取Groups信息 不带分页
	 * @param groups
	 * @return
	 * @throws Exception
	 * @return	List<Groups>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public List<Groups> getGroupssByParasNoPage(Groups groups) throws Exception;
	

}
