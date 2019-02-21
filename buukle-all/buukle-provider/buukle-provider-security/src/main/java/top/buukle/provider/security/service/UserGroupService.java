/*
 * Powered By [rapid-framework]
 * Web Site: http:// www.rapid-framework.org.cn
 * Google Code: http:// code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.service;

import top.buukle.plugin.security.entity.UserGroup;

import java.util.List;

/**
 * 
 * @author elvin
 *
 */
public interface UserGroupService {
	

	/** 
	 * @Description:	根据id获取UserGroup
	 * @return
	 * @throws Exception
	 * @return	UserGroup
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public UserGroup getUserGroupById(Integer id) throws Exception;
	
	/** 
	 * @Description:	根据条件获取UserGroup
	 * @param userGroup
	 * @return
	 * @throws Exception
	 * @return	UserGroup
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public List<UserGroup> getUserGroupByParas(UserGroup userGroup) throws Exception;
	/** 
	 * @Description:	添加UserGroup
	 * @param userGroup
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public void save(UserGroup userGroup) throws Exception;
	/** 
	 * @Description:	更新UserGroup
	 * @param userGroup
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public void update(UserGroup userGroup) throws Exception;
	/** 
	 * @Description:	删除UserGroup
	 * @param userGroup
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public void delete(UserGroup userGroup) throws Exception;
	/** 
	 * @Description:	获取UserGroup信息 不带分页
	 * @param userGroup
	 * @return
	 * @throws Exception
	 * @return	List<UserGroup>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public List<UserGroup> getUserGroupsByParasNoPage(UserGroup userGroup) throws Exception;
	

}
