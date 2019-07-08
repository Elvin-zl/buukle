package top.buukle.consumer.www.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.consumer.www.entity.TimelineComment;
import top.buukle.consumer.www.entity.TimelineCommentExample;

@Mapper
public interface TimelineCommentMapper {
    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    long countByExample(TimelineCommentExample example);

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    int deleteByExample(TimelineCommentExample example);

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    int insert(TimelineComment record);

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    int insertSelective(TimelineComment record);

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    List<TimelineComment> selectByExample(TimelineCommentExample example);

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    TimelineComment selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    int updateByExampleSelective(@Param("record") TimelineComment record, @Param("example") TimelineCommentExample example);

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    int updateByExample(@Param("record") TimelineComment record, @Param("example") TimelineCommentExample example);

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    int updateByPrimaryKeySelective(TimelineComment record);

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    int updateByPrimaryKey(TimelineComment record);

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    int batchInsert(@Param("list") List<TimelineComment> list);

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    int batchInsertSelective(@Param("list") List<TimelineComment> list, @Param("selective") TimelineComment.Column ... selective);
}