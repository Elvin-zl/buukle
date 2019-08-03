package top.buukle.security.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.security.entity.RoleMenuButtonRelation;
import top.buukle.security.entity.RoleMenuButtonRelationExample;

@Mapper
public interface RoleMenuButtonRelationMapper {
    /**
     *
     * @mbg.generated Sat Aug 03 21:36:44 CST 2019
     */
    long countByExample(RoleMenuButtonRelationExample example);

    /**
     *
     * @mbg.generated Sat Aug 03 21:36:44 CST 2019
     */
    int deleteByExample(RoleMenuButtonRelationExample example);

    /**
     *
     * @mbg.generated Sat Aug 03 21:36:44 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Sat Aug 03 21:36:44 CST 2019
     */
    int insert(RoleMenuButtonRelation record);

    /**
     *
     * @mbg.generated Sat Aug 03 21:36:44 CST 2019
     */
    int insertSelective(RoleMenuButtonRelation record);

    /**
     *
     * @mbg.generated Sat Aug 03 21:36:44 CST 2019
     */
    List<RoleMenuButtonRelation> selectByExample(RoleMenuButtonRelationExample example);

    /**
     *
     * @mbg.generated Sat Aug 03 21:36:44 CST 2019
     */
    RoleMenuButtonRelation selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Sat Aug 03 21:36:44 CST 2019
     */
    int updateByExampleSelective(@Param("record") RoleMenuButtonRelation record, @Param("example") RoleMenuButtonRelationExample example);

    /**
     *
     * @mbg.generated Sat Aug 03 21:36:44 CST 2019
     */
    int updateByExample(@Param("record") RoleMenuButtonRelation record, @Param("example") RoleMenuButtonRelationExample example);

    /**
     *
     * @mbg.generated Sat Aug 03 21:36:44 CST 2019
     */
    int updateByPrimaryKeySelective(RoleMenuButtonRelation record);

    /**
     *
     * @mbg.generated Sat Aug 03 21:36:44 CST 2019
     */
    int updateByPrimaryKey(RoleMenuButtonRelation record);
}