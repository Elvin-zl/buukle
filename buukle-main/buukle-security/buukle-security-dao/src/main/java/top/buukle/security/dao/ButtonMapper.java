package top.buukle.security.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.security.entity.Button;
import top.buukle.security.entity.ButtonExample;
import top.buukle.security.plugin.annotation.DataIsolationAnnotation;

@Mapper
public interface ButtonMapper {
    /**
     *
     * @mbg.generated Tue Aug 06 21:36:38 CST 2019
     */
    long countByExample(ButtonExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:38 CST 2019
     */
    int deleteByExample(ButtonExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:38 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:38 CST 2019
     */
    int insert(Button record);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:38 CST 2019
     */
    int insertSelective(Button record);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:38 CST 2019
     */
    @DataIsolationAnnotation(tableName="button")
    List<Button> selectByExample(ButtonExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:38 CST 2019
     */
    Button selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:38 CST 2019
     */
    int updateByExampleSelective(@Param("record") Button record, @Param("example") ButtonExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:38 CST 2019
     */
    int updateByExample(@Param("record") Button record, @Param("example") ButtonExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:38 CST 2019
     */
    int updateByPrimaryKeySelective(Button record);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:38 CST 2019
     */
    int updateByPrimaryKey(Button record);

    List<Button> getRoleButtonListByRoleId(@Param("roleId") Integer roleId, @Param("applicationId")Integer applicationId);

    List<Button> getUserButtonList(@Param("roleIds") List<Integer> roleIds);
}