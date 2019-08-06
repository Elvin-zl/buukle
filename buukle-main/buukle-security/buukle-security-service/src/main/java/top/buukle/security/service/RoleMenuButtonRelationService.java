package top.buukle.security .service;

import top.buukle.common.call.CommonResponse;
import top.buukle.security.entity.vo.RoleMenuButtonRelationQuery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author elvin
* @description RoleMenuButtonRelationService 接口类
*/
public interface RoleMenuButtonRelationService extends BaseService{

    CommonResponse saveOrEdit(RoleMenuButtonRelationQuery query, HttpServletRequest request, HttpServletResponse response);

}