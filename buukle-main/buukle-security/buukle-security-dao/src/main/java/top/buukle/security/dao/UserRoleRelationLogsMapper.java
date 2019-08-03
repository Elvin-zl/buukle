package top.buukle.security.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.security.entity.UserRoleRelationLogs;
import top.buukle.security.entity.UserRoleRelationLogsExample;

@Mapper
public interface UserRoleRelationLogsMapper {
    /**
     *
     * @mbg.generated Sat Aug 03 21:36:54 CST 2019
     */
    long countByExample(UserRoleRelationLogsExample example);

    /**
     *
     * @mbg.generated Sat Aug 03 21:36:54 CST 2019
     */
    int deleteByExample(UserRoleRelationLogsExample example);

    /**
     *
     * @mbg.generated Sat Aug 03 21:36:54 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Sat Aug 03 21:36:54 CST 2019
     */
    int insert(UserRoleRelationLogs record);

    /**
     *
     * @mbg.generated Sat Aug 03 21:36:54 CST 2019
     */
    int insertSelective(UserRoleRelationLogs record);

    /**
     *
     * @mbg.generated Sat Aug 03 21:36:54 CST 2019
     */
    List<UserRoleRelationLogs> selectByExample(UserRoleRelationLogsExample example);

    /**
     *
     * @mbg.generated Sat Aug 03 21:36:54 CST 2019
     */
    UserRoleRelationLogs selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Sat Aug 03 21:36:54 CST 2019
     */
    int updateByExampleSelective(@Param("record") UserRoleRelationLogs record, @Param("example") UserRoleRelationLogsExample example);

    /**
     *
     * @mbg.generated Sat Aug 03 21:36:54 CST 2019
     */
    int updateByExample(@Param("record") UserRoleRelationLogs record, @Param("example") UserRoleRelationLogsExample example);

    /**
     *
     * @mbg.generated Sat Aug 03 21:36:54 CST 2019
     */
    int updateByPrimaryKeySelective(UserRoleRelationLogs record);

    /**
     *
     * @mbg.generated Sat Aug 03 21:36:54 CST 2019
     */
    int updateByPrimaryKey(UserRoleRelationLogs record);
}