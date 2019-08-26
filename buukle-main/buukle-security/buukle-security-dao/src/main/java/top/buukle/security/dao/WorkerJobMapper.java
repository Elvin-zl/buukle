package top.buukle.security.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.security.entity.WorkerJob;
import top.buukle.security.entity.WorkerJobExample;

@Mapper
public interface WorkerJobMapper {
    /**
     *
     * @mbg.generated Mon Aug 26 22:31:44 CST 2019
     */
    long countByExample(WorkerJobExample example);

    /**
     *
     * @mbg.generated Mon Aug 26 22:31:44 CST 2019
     */
    int deleteByExample(WorkerJobExample example);

    /**
     *
     * @mbg.generated Mon Aug 26 22:31:44 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Mon Aug 26 22:31:44 CST 2019
     */
    int insert(WorkerJob record);

    /**
     *
     * @mbg.generated Mon Aug 26 22:31:44 CST 2019
     */
    int insertSelective(WorkerJob record);

    /**
     *
     * @mbg.generated Mon Aug 26 22:31:44 CST 2019
     */
    List<WorkerJob> selectByExample(WorkerJobExample example);

    /**
     *
     * @mbg.generated Mon Aug 26 22:31:44 CST 2019
     */
    WorkerJob selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Mon Aug 26 22:31:44 CST 2019
     */
    int updateByExampleSelective(@Param("record") WorkerJob record, @Param("example") WorkerJobExample example);

    /**
     *
     * @mbg.generated Mon Aug 26 22:31:44 CST 2019
     */
    int updateByExample(@Param("record") WorkerJob record, @Param("example") WorkerJobExample example);

    /**
     *
     * @mbg.generated Mon Aug 26 22:31:44 CST 2019
     */
    int updateByPrimaryKeySelective(WorkerJob record);

    /**
     *
     * @mbg.generated Mon Aug 26 22:31:44 CST 2019
     */
    int updateByPrimaryKey(WorkerJob record);
}