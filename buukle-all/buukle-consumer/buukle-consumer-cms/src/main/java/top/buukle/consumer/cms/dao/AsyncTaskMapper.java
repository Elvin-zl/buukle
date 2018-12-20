package top.buukle.consumer.cms.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.consumer.cms.entity.AsyncTask;
import top.buukle.consumer.cms.entity.AsyncTaskExample;

@Mapper
public interface AsyncTaskMapper {
    /**
     */
    long countByExample(AsyncTaskExample example);

    /**
     */
    int deleteByExample(AsyncTaskExample example);

    /**
     */
    int deleteByPrimaryKey(Integer id);

    /**
     */
    int insert(AsyncTask record);

    /**
     */
    int insertSelective(AsyncTask record);

    /**
     */
    List<AsyncTask> selectByExample(AsyncTaskExample example);

    /**
     */
    AsyncTask selectByPrimaryKey(Integer id);

    /**
     */
    int updateByExampleSelective(@Param("record") AsyncTask record, @Param("example") AsyncTaskExample example);

    /**
     */
    int updateByExample(@Param("record") AsyncTask record, @Param("example") AsyncTaskExample example);

    /**
     */
    int updateByPrimaryKeySelective(AsyncTask record);

    /**
     */
    int updateByPrimaryKey(AsyncTask record);
}