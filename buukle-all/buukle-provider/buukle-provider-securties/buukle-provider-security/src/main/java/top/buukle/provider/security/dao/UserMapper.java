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

    /**
     * 分页获取用户列表
     * @param userQuery
     * @return
     */
    List<User> getUserList(UserQuery userQuery);

    /**
     * 启用/停用用户
     * @param userQuery
     */
    void doBanOrRelease(UserQuery userQuery);


    /**
     * 根据菜单id获取响应用户
     * @param moduleId
     * @return
     */
    List<User> getUserByModuleId(@Param("moduleId") Integer moduleId);

    /**
     * 根据角色id获取相应用户
     * @param roleId
     * @return
     */
    List<User> getUserByRoleId(@Param("roleId") Integer roleId);

    /**
     * 根据组别id获取相应用户
     * @param groupsId
     * @return
     */
    List<User> getUserByGroupsId(@Param("groupsId") Integer groupsId);

    /**
     * 模糊搜索
     * @param fuzzyText
     * @return
     */
    List<User> fuzzySearchByName(@Param("fuzzyText") String fuzzyText);


}