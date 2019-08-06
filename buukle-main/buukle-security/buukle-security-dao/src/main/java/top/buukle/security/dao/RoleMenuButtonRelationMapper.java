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
     * @mbg.generated Tue Aug 06 21:36:53 CST 2019
     */
    long countByExample(RoleMenuButtonRelationExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:53 CST 2019
     */
    int deleteByExample(RoleMenuButtonRelationExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:53 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:53 CST 2019
     */
    int insert(RoleMenuButtonRelation record);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:53 CST 2019
     */
    int insertSelective(RoleMenuButtonRelation record);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:53 CST 2019
     */
    List<RoleMenuButtonRelation> selectByExample(RoleMenuButtonRelationExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:53 CST 2019
     */
    RoleMenuButtonRelation selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:53 CST 2019
     */
    int updateByExampleSelective(@Param("record") RoleMenuButtonRelation record, @Param("example") RoleMenuButtonRelationExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:53 CST 2019
     */
    int updateByExample(@Param("record") RoleMenuButtonRelation record, @Param("example") RoleMenuButtonRelationExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:53 CST 2019
     */
    int updateByPrimaryKeySelective(RoleMenuButtonRelation record);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:53 CST 2019
     */
    int updateByPrimaryKey(RoleMenuButtonRelation record);
}