package top.buukle.security.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.security.entity.WorkerJobLogs;
import top.buukle.security.entity.WorkerJobLogsExample;

@Mapper
public interface WorkerJobLogsMapper {
    /**
     *
     * @mbg.generated Tue Aug 27 01:14:43 CST 2019
     */
    long countByExample(WorkerJobLogsExample example);

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:43 CST 2019
     */
    int deleteByExample(WorkerJobLogsExample example);

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:43 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:43 CST 2019
     */
    int insert(WorkerJobLogs record);

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:43 CST 2019
     */
    int insertSelective(WorkerJobLogs record);

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:43 CST 2019
     */
    List<WorkerJobLogs> selectByExample(WorkerJobLogsExample example);

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:43 CST 2019
     */
    WorkerJobLogs selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:43 CST 2019
     */
    int updateByExampleSelective(@Param("record") WorkerJobLogs record, @Param("example") WorkerJobLogsExample example);

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:43 CST 2019
     */
    int updateByExample(@Param("record") WorkerJobLogs record, @Param("example") WorkerJobLogsExample example);

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:43 CST 2019
     */
    int updateByPrimaryKeySelective(WorkerJobLogs record);

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:43 CST 2019
     */
    int updateByPrimaryKey(WorkerJobLogs record);
}