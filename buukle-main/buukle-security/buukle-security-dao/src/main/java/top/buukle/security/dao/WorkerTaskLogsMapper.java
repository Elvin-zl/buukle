package top.buukle.security.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.security.entity.WorkerTaskLogs;
import top.buukle.security.entity.WorkerTaskLogsExample;

@Mapper
public interface WorkerTaskLogsMapper {
    /**
     *
     * @mbg.generated Tue Aug 27 01:14:50 CST 2019
     */
    long countByExample(WorkerTaskLogsExample example);

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:50 CST 2019
     */
    int deleteByExample(WorkerTaskLogsExample example);

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:50 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:50 CST 2019
     */
    int insert(WorkerTaskLogs record);

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:50 CST 2019
     */
    int insertSelective(WorkerTaskLogs record);

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:50 CST 2019
     */
    List<WorkerTaskLogs> selectByExample(WorkerTaskLogsExample example);

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:50 CST 2019
     */
    WorkerTaskLogs selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:50 CST 2019
     */
    int updateByExampleSelective(@Param("record") WorkerTaskLogs record, @Param("example") WorkerTaskLogsExample example);

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:50 CST 2019
     */
    int updateByExample(@Param("record") WorkerTaskLogs record, @Param("example") WorkerTaskLogsExample example);

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:50 CST 2019
     */
    int updateByPrimaryKeySelective(WorkerTaskLogs record);

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:50 CST 2019
     */
    int updateByPrimaryKey(WorkerTaskLogs record);
}