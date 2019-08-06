package top.buukle.security.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.security.entity.UserLogs;
import top.buukle.security.entity.UserLogsExample;

@Mapper
public interface UserLogsMapper {
    /**
     *
     * @mbg.generated Tue Aug 06 21:36:58 CST 2019
     */
    long countByExample(UserLogsExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:58 CST 2019
     */
    int deleteByExample(UserLogsExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:58 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:58 CST 2019
     */
    int insert(UserLogs record);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:58 CST 2019
     */
    int insertSelective(UserLogs record);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:58 CST 2019
     */
    List<UserLogs> selectByExample(UserLogsExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:58 CST 2019
     */
    UserLogs selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:58 CST 2019
     */
    int updateByExampleSelective(@Param("record") UserLogs record, @Param("example") UserLogsExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:58 CST 2019
     */
    int updateByExample(@Param("record") UserLogs record, @Param("example") UserLogsExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:58 CST 2019
     */
    int updateByPrimaryKeySelective(UserLogs record);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:58 CST 2019
     */
    int updateByPrimaryKey(UserLogs record);
}