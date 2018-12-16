package top.buukle.consumer.cms.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.consumer.cms.entity.AsyncTask;
import top.buukle.consumer.cms.entity.AsyncTaskExample;

@Mapper
public interface AsyncTaskMapper {
    /**
     *
     * @mbg.generated Mon Dec 17 00:04:13 CST 2018
     */
    long countByExample(AsyncTaskExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:13 CST 2018
     */
    int deleteByExample(AsyncTaskExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:13 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:13 CST 2018
     */
    int insert(AsyncTask record);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:13 CST 2018
     */
    int insertSelective(AsyncTask record);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:13 CST 2018
     */
    List<AsyncTask> selectByExample(AsyncTaskExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:13 CST 2018
     */
    AsyncTask selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:13 CST 2018
     */
    int updateByExampleSelective(@Param("record") AsyncTask record, @Param("example") AsyncTaskExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:13 CST 2018
     */
    int updateByExample(@Param("record") AsyncTask record, @Param("example") AsyncTaskExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:13 CST 2018
     */
    int updateByPrimaryKeySelective(AsyncTask record);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:13 CST 2018
     */
    int updateByPrimaryKey(AsyncTask record);
}