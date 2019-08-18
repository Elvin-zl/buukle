package top.buukle.security.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.security.entity.Menu;
import top.buukle.security.entity.MenuExample;
import top.buukle.security.plugin.annotation.DataIsolationAnnotation;

@Mapper
public interface MenuMapper {
    /**
     *
     * @mbg.generated Thu Aug 15 14:43:20 CST 2019
     */
    long countByExample(MenuExample example);

    /**
     *
     * @mbg.generated Thu Aug 15 14:43:20 CST 2019
     */
    int deleteByExample(MenuExample example);

    /**
     *
     * @mbg.generated Thu Aug 15 14:43:20 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Thu Aug 15 14:43:20 CST 2019
     */
    int insert(Menu record);

    /**
     *
     * @mbg.generated Thu Aug 15 14:43:20 CST 2019
     */
    int insertSelective(Menu record);

    /**
     *
     * @mbg.generated Thu Aug 15 14:43:20 CST 2019
     */
    @DataIsolationAnnotation(tableName="menu")
    List<Menu> selectByExample(MenuExample example);

    /**
     *
     * @mbg.generated Thu Aug 15 14:43:20 CST 2019
     */
    Menu selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Thu Aug 15 14:43:20 CST 2019
     */
    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    /**
     *
     * @mbg.generated Thu Aug 15 14:43:20 CST 2019
     */
    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

    /**
     *
     * @mbg.generated Thu Aug 15 14:43:20 CST 2019
     */
    int updateByPrimaryKeySelective(Menu record);

    /**
     *
     * @mbg.generated Thu Aug 15 14:43:20 CST 2019
     */
    int updateByPrimaryKey(Menu record);

    List<Menu> getUserMenuListByUserId(@Param("userId") String userId);

    List<Menu> getRoleMenuListByRoleId(@Param("roleId") Integer roleId, @Param("applicationId")Integer applicationId);
}