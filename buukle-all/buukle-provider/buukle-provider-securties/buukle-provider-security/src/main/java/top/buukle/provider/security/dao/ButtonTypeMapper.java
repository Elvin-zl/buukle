/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.dao;

import top.buukle.provider.security.entity.ButtonType;

import java.util.List;

/**
 * 
 * @author tengbx
 *
 */

public interface ButtonTypeMapper {

	/** 
	 * @Description:	根据id获取ButtonType
	 * @return
	 * @throws Exception
	 * @return	ButtonType
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public ButtonType getButtonTypeById(Integer id) throws Exception;
	
	/**
	 * @Description:	添加ButtonType
	 * @param buttonType
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public Integer save(ButtonType buttonType) throws Exception;
	/** 
	 * @Description:	更新ButtonType
	 * @param buttonType
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public Integer update(ButtonType buttonType) throws Exception;
	/** 
	 * @Description:	删除ButtonType
	 * @param buttonType
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public Integer delete(ButtonType buttonType) throws Exception;

	/**
	 * 获取全局按钮类型缓存
	 * @return
	 */
	List<ButtonType> getButtonTypes();
}
