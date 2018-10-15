/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.dao;

import org.apache.ibatis.annotations.Param;
import top.buukle.provider.security.entity.Groups;
import top.buukle.provider.security.entity.User;

import java.util.List;

/**
 * 
 * @author elvin
 *
 */

public interface UserMapper {

	/**
	 * @Description:	根据id获取User
	 * @return
	 * @throws Exception
	 * @return	User
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public User getUserById(Integer id) throws Exception;
	
	/**
	 * @Description:	添加User
	 * @param user
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public Integer save(User user) throws Exception;
	/** 
	 * @Description:	更新User
	 * @param user
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public Integer update(User user) throws Exception;
	/** 
	 * @Description:	删除User
	 * @param user
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public Integer delete(User user) throws Exception;

	/**
	 * 为用户登录获取用户信息
	 * @param user
	 * @return
	 */
    User getUserInfoForLogin(User user);

	List<User> getUserSubordinateByUserGroups(@Param("groupsList") List<Groups> groupsList);
}
