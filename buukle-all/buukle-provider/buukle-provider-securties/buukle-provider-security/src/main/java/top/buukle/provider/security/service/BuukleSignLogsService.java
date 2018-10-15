/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.service;
import java.util.List;
import top.buukle.provider.security.entity.BuukleSignLogs;

/**
 * 
 * @author tengbx
 *
 */
public interface BuukleSignLogsService {
	

	/** 
	 * @Description:	根据id获取BuukleSignLogs
	 * @return
	 * @throws Exception
	 * @return	BuukleSignLogs
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public BuukleSignLogs getBuukleSignLogsById(Integer id) throws Exception;
	
	/** 
	 * @Description:	根据条件获取BuukleSignLogs
	 * @param buukleSignLogs
	 * @return
	 * @throws Exception
	 * @return	BuukleSignLogs
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public List<BuukleSignLogs> getBuukleSignLogsByParas(BuukleSignLogs buukleSignLogs) throws Exception;
	/** 
	 * @Description:	添加BuukleSignLogs
	 * @param buukleSignLogs
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public void save(BuukleSignLogs buukleSignLogs) throws Exception;
	/** 
	 * @Description:	更新BuukleSignLogs
	 * @param buukleSignLogs
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public void update(BuukleSignLogs buukleSignLogs) throws Exception;
	/** 
	 * @Description:	删除BuukleSignLogs
	 * @param buukleSignLogs
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public void delete(BuukleSignLogs buukleSignLogs) throws Exception;
	/** 
	 * @Description:	获取BuukleSignLogs信息 不带分页
	 * @param buukleSignLogs
	 * @return
	 * @throws Exception
	 * @return	List<BuukleSignLogs>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public List<BuukleSignLogs> getBuukleSignLogssByParasNoPage(BuukleSignLogs buukleSignLogs) throws Exception;
	

}
