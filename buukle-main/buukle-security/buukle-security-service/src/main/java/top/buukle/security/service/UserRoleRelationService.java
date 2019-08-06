package top.buukle.security .service;

import top.buukle.common.call.CommonResponse;
import top.buukle.security.entity.vo.UserRoleRelationQuery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author elvin
* @description UserRoleRelationService 接口类
*/
public interface UserRoleRelationService extends BaseService{

    CommonResponse saveOrEdit(UserRoleRelationQuery query, HttpServletRequest request, HttpServletResponse response);

}