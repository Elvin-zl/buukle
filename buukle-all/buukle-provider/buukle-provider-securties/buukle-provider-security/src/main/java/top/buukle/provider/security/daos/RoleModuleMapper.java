package top.buukle.provider.security.daos;

import top.buukle.provider.security.entity.RoleModule;

public interface RoleModuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleModule record);

    int insertSelective(RoleModule record);

    RoleModule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleModule record);

    int updateByPrimaryKey(RoleModule record);
}