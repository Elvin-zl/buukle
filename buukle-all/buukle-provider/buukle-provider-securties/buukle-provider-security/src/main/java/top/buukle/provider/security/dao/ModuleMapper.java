package top.buukle.provider.security.dao;

import org.apache.ibatis.annotations.Param;
import top.buukle.provider.security.entity.Module;
import top.buukle.provider.security.entity.Role;
import top.buukle.provider.security.entity.User;
import top.buukle.provider.security.vo.query.ModuleQuery;

import java.util.List;

public interface ModuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Module record);

    int insertSelective(Module record);

    Module selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);

    /**
     * 根据用户角色列表查询用户菜单列表
     * @param userRoleList
     * @return
     */
    List<Module> getUserModuleListByUserRoleList(@Param("userRoleList") List<Role> userRoleList);

    /**
     * 获取全局角色列表
     * @return
     */
    List<Module> getGlobalModuleList();

    /**
     * 根据用户user_id获取用户权限列表
     * @param user
     * @return
     */
    List<Module> getUserModuleListByUserId(User user);

    /**
     * 分页获取角色列表
     * @param query
     * @return
     */
    List<Module> getModuleList(ModuleQuery query);

    void doBanOrRelease(ModuleQuery query);

    List<Module> fuzzySearchByName(@Param("fuzzyText") String fuzzyText);
}