package top.buukle.security .service;

import top.buukle.common.call.CommonResponse;
import top.buukle.security.entity.vo.RoleMenuButtonRelationLogsQuery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author elvin
* @description RoleMenuButtonRelationLogsService 接口类
*/
public interface RoleMenuButtonRelationLogsService extends BaseService{

    CommonResponse saveOrEdit(RoleMenuButtonRelationLogsQuery query, HttpServletRequest request, HttpServletResponse response);

}