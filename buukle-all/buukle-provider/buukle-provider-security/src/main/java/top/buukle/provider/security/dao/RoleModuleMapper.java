package top.buukle.provider.security.dao;

import org.apache.ibatis.annotations.Param;
import top.buukle.plugin.security.entity.RoleModule;

public interface RoleModuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleModule record);

    int insertSelective(RoleModule record);

    RoleModule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleModule record);

    int updateByPrimaryKey(RoleModule record);

    void deleteRoleModule(@Param("roleId") Integer roleId);
}