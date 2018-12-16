package top.buukle.provider.security.dao;

import feign.Param;
import top.buukle.common.annotation.DataIsolationAnnotation;
import top.buukle.plugin.security.entity.Role;
import top.buukle.plugin.security.vo.query.RoleQuery;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    /**
     * 根据用户自定义id获取角色列表
     * @param userId
     * @return
     */
    List<Role> getUserRoleListByUserId(String userId);

    /**
     * 分页获取角色列表
     * @param roleQuery
     * @return
     */
    @DataIsolationAnnotation(tableName = "role")
    List<Role> getRoleList(RoleQuery roleQuery);

    /**
     * 起停用
     * @param query
     */
    void doBanOrRelease(RoleQuery query);

    /**
     * 模糊搜索
     * @param fuzzyText
     * @return
     */
    @DataIsolationAnnotation(tableName = "role")
    List<Role> fuzzySearchByName(@Param("fuzzyText") String fuzzyText);

    /**
     * 获取全局角色列表
     * @param roleQuery
     * @return
     */
    List<Role> getRoleListWithNoIsolation(RoleQuery roleQuery);
}