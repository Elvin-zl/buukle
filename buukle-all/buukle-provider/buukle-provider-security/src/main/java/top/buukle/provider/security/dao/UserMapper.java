package top.buukle.provider.security.dao;

import org.apache.ibatis.annotations.Param;
import top.buukle.common.annotation.DataIsolationAnnotation;
import top.buukle.plugin.security.entity.Groups;
import top.buukle.plugin.security.entity.User;
import top.buukle.plugin.security.vo.query.UserQuery;

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
    @DataIsolationAnnotation(tableName = "user")
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
    @DataIsolationAnnotation(tableName = "user")
    List<User> fuzzySearchByName(@Param("fuzzyText") String fuzzyText);


    /**
     * 根据userId 获取用户
     * @param userId
     * @return
     */
    User getUserByUserId(String userId);

    /**
     * 根据组别id 以及查询条件 获取组别成员
     * @param userQuery
     * @return
     */
    List<User> getUserByGroupsIdWithQuery(UserQuery userQuery);

    /**
     * 根据用户身份获取用户下级
     * @param userQuery
     * @return
     */
    List<String> getUserSubordinateByUserLevel(UserQuery userQuery);

    /**
     * 获取boss下platform列表
     * @return
     */
    List<User> getSubPlatformSelectItemsForLevelBoss();

    /**
     * 获取平台下agent列表
     * @return
     */
    List<User> getSubAgentSelectItemsForLevelPlatform(@Param("superCode") String superCode);

    /**
     * 获取代理下区域列表
     * @param superCode
     * @return
     */
    List<User> getSubGroupSelectItemsForLevelAgent(@Param("superCode") String superCode);

    /**
     * 获取区域下业务员列表
     * @param superCode
     * @return
     */
    List<User> getSubSalesmanSelectItemsForLevelGroup(@Param("superCode") String superCode);

    /**
     * 根据主键id更新用户所属关系
     * @param userQuery
     * @return
     */
    int updateByPrimaryKeyForRelation(UserQuery userQuery);

    /**
     * 用户名查重
     * @param username
     * @return
     */
    List<User> getUserByUsername(@Param("username") String username);
}