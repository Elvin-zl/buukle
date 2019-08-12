package top.buukle.security .service;

import top.buukle.common.call.CommonResponse;
import top.buukle.common.call.PageResponse;
import top.buukle.security.entity.vo.ApplicationQuery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author elvin
* @description ApplicationService 接口类
*/
public interface ApplicationService extends BaseService{

    CommonResponse saveOrEdit(ApplicationQuery query, HttpServletRequest request, HttpServletResponse response);

    PageResponse getApplicationTree(HttpServletRequest request, HttpServletResponse response);
}