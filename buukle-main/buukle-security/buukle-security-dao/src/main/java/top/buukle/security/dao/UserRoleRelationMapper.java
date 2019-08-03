package top.buukle.security.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.security.entity.UserRoleRelation;
import top.buukle.security.entity.UserRoleRelationExample;

@Mapper
public interface UserRoleRelationMapper {
    /**
     *
     * @mbg.generated Sat Aug 03 21:36:52 CST 2019
     */
    long countByExample(UserRoleRelationExample example);

    /**
     *
     * @mbg.generated Sat Aug 03 21:36:52 CST 2019
     */
    int deleteByExample(UserRoleRelationExample example);

    /**
     *
     * @mbg.generated Sat Aug 03 21:36:52 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Sat Aug 03 21:36:52 CST 2019
     */
    int insert(UserRoleRelation record);

    /**
     *
     * @mbg.generated Sat Aug 03 21:36:52 CST 2019
     */
    int insertSelective(UserRoleRelation record);

    /**
     *
     * @mbg.generated Sat Aug 03 21:36:52 CST 2019
     */
    List<UserRoleRelation> selectByExample(UserRoleRelationExample example);

    /**
     *
     * @mbg.generated Sat Aug 03 21:36:52 CST 2019
     */
    UserRoleRelation selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Sat Aug 03 21:36:52 CST 2019
     */
    int updateByExampleSelective(@Param("record") UserRoleRelation record, @Param("example") UserRoleRelationExample example);

    /**
     *
     * @mbg.generated Sat Aug 03 21:36:52 CST 2019
     */
    int updateByExample(@Param("record") UserRoleRelation record, @Param("example") UserRoleRelationExample example);

    /**
     *
     * @mbg.generated Sat Aug 03 21:36:52 CST 2019
     */
    int updateByPrimaryKeySelective(UserRoleRelation record);

    /**
     *
     * @mbg.generated Sat Aug 03 21:36:52 CST 2019
     */
    int updateByPrimaryKey(UserRoleRelation record);
}