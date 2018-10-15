/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.dao;

import top.buukle.provider.security.entity.UserExp;

/**
 * 
 * @author elvin
 *
 */

public interface UserExpMapper {

	/** 
	 * @Description:	根据id获取UserExp
	 * @return
	 * @throws Exception
	 * @return	UserExp
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public UserExp getUserExpById(Integer id) throws Exception;
	
	/**
	 * @Description:	添加UserExp
	 * @param userExp
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public Integer save(UserExp userExp) throws Exception;
	/** 
	 * @Description:	更新UserExp
	 * @param userExp
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public Integer update(UserExp userExp) throws Exception;
	/** 
	 * @Description:	删除UserExp
	 * @param userExp
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public Integer delete(UserExp userExp) throws Exception;


    UserExp getUserExpByUserId(String userId);
}
