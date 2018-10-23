/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.service;
import java.util.List;
import top.buukle.provider.security.entity.BuukleSign;

/**
 * 
 * @author tengbx
 *
 */
public interface BuukleSignService {

	/** 
	 * @Description:	根据id获取BuukleSign
	 * @return
	 * @throws Exception
	 * @return	BuukleSign
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public BuukleSign getBuukleSignById(Integer id) throws Exception;
	
	/** 
	 * @Description:	根据条件获取BuukleSign
	 * @param buukleSign
	 * @return
	 * @throws Exception
	 * @return	BuukleSign
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public List<BuukleSign> getUserBuukleSign(BuukleSign buukleSign) throws Exception;
	/** 
	 * @Description:	添加BuukleSign
	 * @param buukleSign
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public void save(BuukleSign buukleSign) throws Exception;
	/** 
	 * @Description:	更新BuukleSign
	 * @param buukleSign
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public void update(BuukleSign buukleSign) throws Exception;
	/** 
	 * @Description:	删除BuukleSign
	 * @param buukleSign
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public void delete(BuukleSign buukleSign) throws Exception;
	/** 
	 * @Description:	获取BuukleSign信息 不带分页
	 * @param buukleSign
	 * @return
	 * @throws Exception
	 * @return	List<BuukleSign>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public List<BuukleSign> getBuukleSignsByParasNoPage(BuukleSign buukleSign) throws Exception;
	

}
