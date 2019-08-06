package top.buukle.security .service;

import top.buukle.common.call.CommonResponse;
import top.buukle.security.entity.vo.RoleQuery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author elvin
* @description RoleService 接口类
*/
public interface RoleService extends BaseService{

    CommonResponse saveOrEdit(RoleQuery query, HttpServletRequest request, HttpServletResponse response);

}