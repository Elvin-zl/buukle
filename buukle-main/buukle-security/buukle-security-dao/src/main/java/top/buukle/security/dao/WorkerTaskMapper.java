package top.buukle.security.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.security.entity.WorkerTask;
import top.buukle.security.entity.WorkerTaskExample;

@Mapper
public interface WorkerTaskMapper {
    /**
     *
     * @mbg.generated Tue Aug 27 01:14:46 CST 2019
     */
    long countByExample(WorkerTaskExample example);

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:46 CST 2019
     */
    int deleteByExample(WorkerTaskExample example);

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:46 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:46 CST 2019
     */
    int insert(WorkerTask record);

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:46 CST 2019
     */
    int insertSelective(WorkerTask record);

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:46 CST 2019
     */
    List<WorkerTask> selectByExample(WorkerTaskExample example);

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:46 CST 2019
     */
    WorkerTask selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:46 CST 2019
     */
    int updateByExampleSelective(@Param("record") WorkerTask record, @Param("example") WorkerTaskExample example);

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:46 CST 2019
     */
    int updateByExample(@Param("record") WorkerTask record, @Param("example") WorkerTaskExample example);

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:46 CST 2019
     */
    int updateByPrimaryKeySelective(WorkerTask record);

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:46 CST 2019
     */
    int updateByPrimaryKey(WorkerTask record);
}