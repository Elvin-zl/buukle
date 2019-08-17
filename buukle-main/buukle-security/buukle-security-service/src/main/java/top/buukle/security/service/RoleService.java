package top.buukle.security .service;

import top.buukle.common.call.CommonResponse;
import top.buukle.common.call.PageResponse;
import top.buukle.security.entity.Role;
import top.buukle.security.entity.vo.RoleQuery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
* @author elvin
* @description RoleService 接口类
*/
public interface RoleService extends BaseService{

    CommonResponse saveOrEdit(RoleQuery query, HttpServletRequest request, HttpServletResponse response);

    PageResponse getRoleTree(Integer applicationId, HttpServletRequest request, HttpServletResponse response);

    PageResponse getAppUserRole(Integer applicationId, String userId, HttpServletRequest request);

    void getUserSubRoles(List<Integer> userSubRoleIds, Role operatorRole, List<Role> appRoles);

    PageResponse getRoleMenuTree(Integer id, HttpServletRequest request);

    CommonResponse roleMenuSet(String ids, Integer id, HttpServletRequest request, HttpServletResponse response);

    Role getUserRole(String userId, Integer applicationId);
}