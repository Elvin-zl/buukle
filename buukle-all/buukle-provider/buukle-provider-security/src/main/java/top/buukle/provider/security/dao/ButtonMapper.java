package top.buukle.provider.security.dao;

import org.apache.ibatis.annotations.Param;
import top.buukle.common.annotation.DataIsolationAnnotation;
import top.buukle.plugin.security.entity.Button;
import top.buukle.plugin.security.entity.Module;
import top.buukle.plugin.security.vo.query.ButtonQuery;

import java.util.List;

public interface ButtonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Button record);

    int insertSelective(Button record);

    Button selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Button record);

    int updateByPrimaryKey(Button record);

    /**
     * 根据用户菜单列表获取用户按钮列表
     * @param userModuleList
     * @return
     */
    List<Button> getUserButtonListByUserModuleList(@Param("userModuleList") List<Module> userModuleList);

    /**
     * 获取全局按钮列表
     * @return
     */
    List<Button> getGlobalButtonList();

    /**
     * 分页获取按钮列表
     * @param query
     * @return
     */
    @DataIsolationAnnotation(tableName = "button")
    List<Button> getButtonList(ButtonQuery query);

    /**
     * 根据获取菜单id获取按钮
     * @param moduleId
     * @return
     */
    List<Button> getModuleButtons(@Param("moduleId") Integer moduleId);

    /**
     * 启用禁用
     * @param query
     */
    void doBanOrRelease(ButtonQuery query);

    /**
     * 模糊搜索
     * @param fuzzyText
     * @return
     */
    @DataIsolationAnnotation(tableName = "button")
    List<Button> fuzzySearchByName(@Param("fuzzyText") String fuzzyText);
}