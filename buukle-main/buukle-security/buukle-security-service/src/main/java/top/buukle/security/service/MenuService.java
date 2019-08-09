package top.buukle.security .service;

import top.buukle.common.call.CommonResponse;
import top.buukle.common.call.PageResponse;
import top.buukle.security.entity.vo.MenuQuery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author elvin
* @description MenuService 接口类
*/
public interface MenuService extends BaseService{

    CommonResponse saveOrEdit(MenuQuery query, HttpServletRequest request, HttpServletResponse response);

    PageResponse getMenuTree(Integer applicationId, HttpServletRequest request, HttpServletResponse response);
}