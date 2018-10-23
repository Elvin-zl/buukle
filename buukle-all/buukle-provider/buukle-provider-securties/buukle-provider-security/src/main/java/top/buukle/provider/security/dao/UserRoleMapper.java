package top.buukle.provider.security.dao;

import org.apache.ibatis.annotations.Param;
import top.buukle.provider.security.entity.UserRole;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    void deleteUserRole(@Param("userId") String userId);
}