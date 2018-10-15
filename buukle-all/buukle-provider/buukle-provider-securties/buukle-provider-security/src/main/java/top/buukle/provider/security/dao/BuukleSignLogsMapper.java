/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.dao;

import top.buukle.provider.security.entity.BuukleSignLogs;
/**
 * 
 * @author tengbx
 *
 */

public interface BuukleSignLogsMapper {

	/** 
	 * @Description:	根据id获取BuukleSignLogs
	 * @return
	 * @throws Exception
	 * @return	BuukleSignLogs
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public BuukleSignLogs getBuukleSignLogsById(Integer id) throws Exception;
	
	/**
	 * @Description:	添加BuukleSignLogs
	 * @param buukleSignLogs
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public Integer save(BuukleSignLogs buukleSignLogs) throws Exception;
	/** 
	 * @Description:	更新BuukleSignLogs
	 * @param buukleSignLogs
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public Integer update(BuukleSignLogs buukleSignLogs) throws Exception;
	/** 
	 * @Description:	删除BuukleSignLogs
	 * @param buukleSignLogs
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public Integer delete(BuukleSignLogs buukleSignLogs) throws Exception;
}
