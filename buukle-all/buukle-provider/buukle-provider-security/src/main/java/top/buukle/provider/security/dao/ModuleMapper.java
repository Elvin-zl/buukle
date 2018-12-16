package top.buukle.provider.security.dao;

import org.apache.ibatis.annotations.Param;
import top.buukle.common.annotation.DataIsolationAnnotation;
import top.buukle.plugin.security.entity.Module;
import top.buukle.plugin.security.entity.ModuleExample;
import top.buukle.plugin.security.entity.Role;
import top.buukle.plugin.security.entity.User;
import top.buukle.plugin.security.vo.query.ModuleQuery;

import java.util.List;

public interface ModuleMapper {
    int countByExample(ModuleExample example);

    int deleteByExample(ModuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Module record);

    int insertSelective(Module record);

    List<Module> selectByExample(ModuleExample example);

    Module selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Module record, @Param("example") ModuleExample example);

    int updateByExample(@Param("record") Module record, @Param("example") ModuleExample example);

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
    @DataIsolationAnnotation(tableName = "module")
    List<Module> getModuleList(ModuleQuery query);

    void doBanOrRelease(ModuleQuery query);

    /**
     * 模糊搜索
     * @param fuzzyText
     * @return
     */
    @DataIsolationAnnotation(tableName = "module")
    List<Module> fuzzySearchByName(@Param("fuzzyText") String fuzzyText);
}