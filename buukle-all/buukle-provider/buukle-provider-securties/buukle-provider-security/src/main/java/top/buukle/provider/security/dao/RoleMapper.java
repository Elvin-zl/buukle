package top.buukle.provider.security.dao;

import top.buukle.provider.security.entity.Role;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    /**
     * 根据用户id获取角色列表
     * @param userId
     * @return
     */
    List<Role> getUserRoleListByUserId(String userId);
}