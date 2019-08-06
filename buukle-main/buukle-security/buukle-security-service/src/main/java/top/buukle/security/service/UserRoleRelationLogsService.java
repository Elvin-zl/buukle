package top.buukle.security .service;

import top.buukle.common.call.CommonResponse;
import top.buukle.security.entity.vo.UserRoleRelationLogsQuery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author elvin
* @description UserRoleRelationLogsService 接口类
*/
public interface UserRoleRelationLogsService extends BaseService{

    CommonResponse saveOrEdit(UserRoleRelationLogsQuery query, HttpServletRequest request, HttpServletResponse response);

}