/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.dao;

import top.buukle.provider.security.entity.UserGroup;

/**
 * 
 * @author elvin
 *
 */

public interface UserGroupMapper {

	/** 
	 * @Description:	根据id获取UserGroup
	 * @return
	 * @throws Exception
	 * @return	UserGroup
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public UserGroup getUserGroupById(Integer id) throws Exception;
	
	/**
	 * @Description:	添加UserGroup
	 * @param userGroup
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public Integer save(UserGroup userGroup) throws Exception;
	/** 
	 * @Description:	更新UserGroup
	 * @param userGroup
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public Integer update(UserGroup userGroup) throws Exception;
	/** 
	 * @Description:	删除UserGroup
	 * @param userGroup
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public Integer delete(UserGroup userGroup) throws Exception;
}
