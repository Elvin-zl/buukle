package top.buukle.security.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.security.entity.InterfaceRegisterLogs;
import top.buukle.security.entity.InterfaceRegisterLogsExample;

@Mapper
public interface InterfaceRegisterLogsMapper {
    /**
     *
     * @mbg.generated Tue Aug 06 21:36:45 CST 2019
     */
    long countByExample(InterfaceRegisterLogsExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:45 CST 2019
     */
    int deleteByExample(InterfaceRegisterLogsExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:45 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:45 CST 2019
     */
    int insert(InterfaceRegisterLogs record);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:45 CST 2019
     */
    int insertSelective(InterfaceRegisterLogs record);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:45 CST 2019
     */
    List<InterfaceRegisterLogs> selectByExample(InterfaceRegisterLogsExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:45 CST 2019
     */
    InterfaceRegisterLogs selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:45 CST 2019
     */
    int updateByExampleSelective(@Param("record") InterfaceRegisterLogs record, @Param("example") InterfaceRegisterLogsExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:45 CST 2019
     */
    int updateByExample(@Param("record") InterfaceRegisterLogs record, @Param("example") InterfaceRegisterLogsExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:45 CST 2019
     */
    int updateByPrimaryKeySelective(InterfaceRegisterLogs record);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:45 CST 2019
     */
    int updateByPrimaryKey(InterfaceRegisterLogs record);
}