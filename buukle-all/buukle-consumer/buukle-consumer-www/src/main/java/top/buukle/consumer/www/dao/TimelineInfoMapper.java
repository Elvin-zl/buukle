package top.buukle.consumer.www.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.consumer.www.entity.TimelineInfo;
import top.buukle.consumer.www.entity.TimelineInfoExample;

@Mapper
public interface TimelineInfoMapper {
    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    long countByExample(TimelineInfoExample example);

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    int deleteByExample(TimelineInfoExample example);

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    int insert(TimelineInfo record);

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    int insertSelective(TimelineInfo record);

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    List<TimelineInfo> selectByExampleWithBLOBs(TimelineInfoExample example);

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    List<TimelineInfo> selectByExample(TimelineInfoExample example);

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    TimelineInfo selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    int updateByExampleSelective(@Param("record") TimelineInfo record, @Param("example") TimelineInfoExample example);

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    int updateByExampleWithBLOBs(@Param("record") TimelineInfo record, @Param("example") TimelineInfoExample example);

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    int updateByExample(@Param("record") TimelineInfo record, @Param("example") TimelineInfoExample example);

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    int updateByPrimaryKeySelective(TimelineInfo record);

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(TimelineInfo record);

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    int updateByPrimaryKey(TimelineInfo record);

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    int batchInsert(@Param("list") List<TimelineInfo> list);

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    int batchInsertSelective(@Param("list") List<TimelineInfo> list, @Param("selective") TimelineInfo.Column ... selective);
}