package top.buukle.security .service;

import top.buukle.common.call.CommonResponse;
import top.buukle.security.entity.vo.UserQuery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author elvin
* @description UserService 接口类
*/
public interface UserService extends BaseService{

    CommonResponse saveOrEdit(UserQuery query, HttpServletRequest request, HttpServletResponse response);

    CommonResponse userRoleSet(Integer applicationId, String ids, UserQuery query, HttpServletRequest request, HttpServletResponse response);
}