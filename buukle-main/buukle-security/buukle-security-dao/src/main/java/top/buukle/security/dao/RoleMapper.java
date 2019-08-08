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
     * @mbg.generated Thu Aug 08 11:42:39 CST 2019
     */
    long countByExample(RoleExample example);

    /**
     *
     * @mbg.generated Thu Aug 08 11:42:39 CST 2019
     */
    int deleteByExample(RoleExample example);

    /**
     *
     * @mbg.generated Thu Aug 08 11:42:39 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Thu Aug 08 11:42:39 CST 2019
     */
    int insert(Role record);

    /**
     *
     * @mbg.generated Thu Aug 08 11:42:39 CST 2019
     */
    int insertSelective(Role record);

    /**
     *
     * @mbg.generated Thu Aug 08 11:42:39 CST 2019
     */
    List<Role> selectByExample(RoleExample example);

    /**
     *
     * @mbg.generated Thu Aug 08 11:42:39 CST 2019
     */
    Role selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Thu Aug 08 11:42:39 CST 2019
     */
    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    /**
     *
     * @mbg.generated Thu Aug 08 11:42:39 CST 2019
     */
    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    /**
     *
     * @mbg.generated Thu Aug 08 11:42:39 CST 2019
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     *
     * @mbg.generated Thu Aug 08 11:42:39 CST 2019
     */
    int updateByPrimaryKey(Role record);
}