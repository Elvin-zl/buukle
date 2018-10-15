/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.dao;

import org.apache.ibatis.annotations.Param;
import top.buukle.provider.security.entity.Button;
import top.buukle.provider.security.entity.Module;

import java.util.List;

/**
 * 
 * @author elvin
 *
 */

public interface ButtonMapper {

	/** 
	 * @Description:	根据id获取Button
	 * @return
	 * @throws Exception
	 * @return	Button
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	public Button getButtonById(Integer id) throws Exception;
	
	/**
	 * @Description:	添加Button
	 * @param button
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public Integer save(Button button) throws Exception;
	/** 
	 * @Description:	更新Button
	 * @param button
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public Integer update(Button button) throws Exception;
	/** 
	 * @Description:	删除Button
	 * @param button
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public Integer delete(Button button) throws Exception;

    List<Button> getUserButtonListByUserModuleList(@Param("userModuleList") List<Module> userModuleList);

	List<Button> getGlobalButtonList();

}
