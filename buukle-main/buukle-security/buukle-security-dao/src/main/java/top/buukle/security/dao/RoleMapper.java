package top.buukle.security.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.security.entity.Role;
import top.buukle.security.entity.RoleExample;

@Mapper
public interface RoleMapper {
    /**
     *
     * @mbg.generated Tue Aug 06 18:32:54 CST 2019
     */
    long countByExample(RoleExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 18:32:54 CST 2019
     */
    int deleteByExample(RoleExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 18:32:54 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Tue Aug 06 18:32:54 CST 2019
     */
    int insert(Role record);

    /**
     *
     * @mbg.generated Tue Aug 06 18:32:54 CST 2019
     */
    int insertSelective(Role record);

    /**
     *
     * @mbg.generated Tue Aug 06 18:32:54 CST 2019
     */
    List<Role> selectByExample(RoleExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 18:32:54 CST 2019
     */
    Role selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Tue Aug 06 18:32:54 CST 2019
     */
    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 18:32:54 CST 2019
     */
    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 18:32:54 CST 2019
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     *
     * @mbg.generated Tue Aug 06 18:32:54 CST 2019
     */
    int updateByPrimaryKey(Role record);
}