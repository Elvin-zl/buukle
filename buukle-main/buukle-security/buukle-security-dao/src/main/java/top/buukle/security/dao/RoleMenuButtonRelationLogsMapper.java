package top.buukle.security.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.security.entity.RoleMenuButtonRelationLogs;
import top.buukle.security.entity.RoleMenuButtonRelationLogsExample;

@Mapper
public interface RoleMenuButtonRelationLogsMapper {
    /**
     *
     * @mbg.generated Tue Aug 06 18:32:59 CST 2019
     */
    long countByExample(RoleMenuButtonRelationLogsExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 18:32:59 CST 2019
     */
    int deleteByExample(RoleMenuButtonRelationLogsExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 18:32:59 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Tue Aug 06 18:32:59 CST 2019
     */
    int insert(RoleMenuButtonRelationLogs record);

    /**
     *
     * @mbg.generated Tue Aug 06 18:32:59 CST 2019
     */
    int insertSelective(RoleMenuButtonRelationLogs record);

    /**
     *
     * @mbg.generated Tue Aug 06 18:32:59 CST 2019
     */
    List<RoleMenuButtonRelationLogs> selectByExample(RoleMenuButtonRelationLogsExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 18:32:59 CST 2019
     */
    RoleMenuButtonRelationLogs selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Tue Aug 06 18:32:59 CST 2019
     */
    int updateByExampleSelective(@Param("record") RoleMenuButtonRelationLogs record, @Param("example") RoleMenuButtonRelationLogsExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 18:32:59 CST 2019
     */
    int updateByExample(@Param("record") RoleMenuButtonRelationLogs record, @Param("example") RoleMenuButtonRelationLogsExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 18:32:59 CST 2019
     */
    int updateByPrimaryKeySelective(RoleMenuButtonRelationLogs record);

    /**
     *
     * @mbg.generated Tue Aug 06 18:32:59 CST 2019
     */
    int updateByPrimaryKey(RoleMenuButtonRelationLogs record);
}