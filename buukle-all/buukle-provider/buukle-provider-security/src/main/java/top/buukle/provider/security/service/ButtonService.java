/*
 * Powered By [rapid-framework]
 * Web Site: http:// www.rapid-framework.org.cn
 * Google Code: http:// code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.service;

import top.buukle.common.response.BaseResponse;
import top.buukle.plugin.security.entity.Button;
import top.buukle.plugin.security.entity.ButtonType;
import top.buukle.plugin.security.vo.query.ButtonQuery;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;
import top.buukle.common.vo.response.PageResponse;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * 
 * @author elvin
 *
 */
 public interface ButtonService {
	

	/** 
	 * @Description:	根据id获取Button
	 * @return
	 * @throws Exception
	 * @return	Button
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	 Button getButtonById(Integer id) throws Exception;
	
	/** 
	 * @Description:	根据条件获取Button
	 * @param button
	 * @return
	 * @throws Exception
	 * @return	Button
	 * @Date	2015年6月12日 上午10:29:35 
	 */
	 List<Button> getButtonByParas(Button button) throws Exception;
	/** 
	 * @Description:	添加Button
	 * @param button
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	 void save(Button button) throws Exception;
	/** 
	 * @Description:	更新Button
	 * @param button
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	 void update(Button button) throws Exception;
	/** 
	 * @Description:	删除Button
	 * @param button
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	 void delete(Button button) throws Exception;
	/** 
	 * @Description:	获取Button信息 不带分页
	 * @param button
	 * @return
	 * @throws Exception
	 * @return	List<Button>
	 * @Date	2015年6月12日 上午10:30:13 
	 */
	 List<Button> getButtonsByParasNoPage(Button button) throws Exception;


	/**
	 * 获取全局按钮类型
	 * @return
	 */
    List<ButtonType> getButtonTypes();

	/**
	 * 获取菜单下按钮列表
	 * @param httpServletRequest
	 * @param moduleId
	 * @return
	 * @throws Exception
	 */
    List<Button> getModuleButtons(HttpServletRequest httpServletRequest, Integer moduleId) throws Exception;

	/**
	 * 分页获取列表
	 * @param query
	 * @param pageBounds
	 * @return
	 */
    PageResponse<Button> getButtonList(ButtonQuery query, PageBounds pageBounds);

	/**
	 * 启用停用
	 *
     * @param request
     * @param query
     * @return
	 */
	BaseResponse doBanOrRelease(HttpServletRequest request, ButtonQuery query) throws InvocationTargetException, IllegalAccessException;

	/**
	 * 添加按钮
	 *
	 * @param request
	 * @param query
	 * @return
	 */
	BaseResponse addButton(HttpServletRequest request, ButtonQuery query) throws InvocationTargetException, IllegalAccessException;

	/**
	 * 获取详情
	 * @param request
	 * @param query
	 * @return
	 */
    Button getButtonDetail(HttpServletRequest request, ButtonQuery query);

	/**
	 * 修改按钮
	 * @param request
	 * @param query
	 * @param id
	 * @return
	 */
    BaseResponse editButton(HttpServletRequest request, ButtonQuery query, Integer id) throws InvocationTargetException, IllegalAccessException;

    /**
     * 模糊搜索
     * @param fuzzyText
     * @return
     */
    List<FuzzySearchListVo> fuzzySearchByName(String fuzzyText);

	List<Button> getModuleButtons(Integer moduleId);
}
