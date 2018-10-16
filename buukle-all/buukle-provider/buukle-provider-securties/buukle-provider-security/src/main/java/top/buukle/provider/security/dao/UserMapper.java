package top.buukle.provider.security.dao;

import org.apache.ibatis.annotations.Param;
import top.buukle.provider.security.entity.Groups;
import top.buukle.provider.security.entity.User;
import top.buukle.provider.security.vo.query.UserQuery;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 为用户登录获取用户信息
     * @param user
     * @return
     */
    User getUserInfoForLogin(User user);

    /**
     * 根据用户组别获取当前用户所辖用户
     * @param groupsList
     * @return
     */
    List<User> getUserSubordinateByUserGroups(@Param("groupsList") List<Groups> groupsList);

    List<User> getUserList(UserQuery userQuery);
}