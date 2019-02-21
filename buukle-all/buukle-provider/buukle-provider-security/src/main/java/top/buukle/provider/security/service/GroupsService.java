/*
 * Powered By [rapid-framework]
 * Web Site: http:// www.rapid-framework.org.cn
 * Google Code: http:// code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.service;

import top.buukle.common.response.BaseResponse;
import top.buukle.plugin.security.entity.Groups;
import top.buukle.plugin.security.vo.query.GroupsQuery;
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
public interface GroupsService {
	
	/**
	 * @Description:	添加Groups
	 * @param groups
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:49 
	 */
	public void save(Groups groups) throws Exception;
	/** 
	 * @Description:	更新Groups
	 * @param groups
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:29:56 
	 */
	public void update(Groups groups) throws Exception;
	/** 
	 * @Description:	删除Groups
	 * @param groups
	 * @throws Exception
	 * @return	void
	 * @Date	2015年6月12日 上午10:30:05 
	 */
	public void delete(Groups groups) throws Exception;


	/**
	 * 分页获取组别信息列表
	 * @param query
	 * @param pageBounds
	 * @return
	 */
	PageResponse<Groups> getGroupsList(GroupsQuery query, PageBounds pageBounds);

    /**
     * 模糊搜索
     * @param fuzzyText
     * @return
     */
    List<FuzzySearchListVo> fuzzySearchByName(String fuzzyText);

    /**
     * 添加组别
     * @param request
     * @param query
     * @return
     */
     BaseResponse addGroups(HttpServletRequest request, GroupsQuery query) throws InvocationTargetException, IllegalAccessException;

    /**
     * 查询组别详情
     * @param query
     * @return
     */
     Groups getGroupsDetail(GroupsQuery query);

    /**
     * 编辑组别
     * @param request
     * @param id
     *@param query
     * @return
     */
     BaseResponse editGroups(HttpServletRequest request, Integer id, GroupsQuery query) throws InvocationTargetException, IllegalAccessException ;

    /**
     * 起停用组别
     * @param request
     * @param query
     * @return
     */
    BaseResponse doBanOrRelease(HttpServletRequest request, GroupsQuery query) throws InvocationTargetException, IllegalAccessException;
}
