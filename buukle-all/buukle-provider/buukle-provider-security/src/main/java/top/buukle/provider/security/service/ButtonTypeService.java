/*
 * Powered By [rapid-framework]
 * Web Site: http:// www.rapid-framework.org.cn
 * Google Code: http:// code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.service;
import java.util.List;
import top.buukle.plugin.security.entity.ButtonType;

/**
 * 
 * @author tengbx
 *
 */
public interface ButtonTypeService {
	

	/** 
	 * @Description:	根据id获取ButtonType
	 * @return
	 * @throws Exception
	 * @return	ButtonType
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public ButtonType getButtonTypeById(Integer id) throws Exception;
	
	/** 
	 * @Description:	根据条件获取ButtonType
	 * @param buttonType
	 * @return
	 * @throws Exception
	 * @return	ButtonType
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public List<ButtonType> getButtonTypeByParas(ButtonType buttonType) throws Exception;
	/** 
	 * @Description:	添加ButtonType
	 * @param buttonType
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public void save(ButtonType buttonType) throws Exception;
	/** 
	 * @Description:	更新ButtonType
	 * @param buttonType
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public void update(ButtonType buttonType) throws Exception;
	/** 
	 * @Description:	删除ButtonType
	 * @param buttonType
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public void delete(ButtonType buttonType) throws Exception;
	/** 
	 * @Description:	获取ButtonType信息 不带分页
	 * @param buttonType
	 * @return
	 * @throws Exception
	 * @return	List<ButtonType>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	public List<ButtonType> getButtonTypesByParasNoPage(ButtonType buttonType) throws Exception;
	

}
