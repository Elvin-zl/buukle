package top.buukle.consumer.portal.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.consumer.portal.entity.AsyncTask;
import top.buukle.consumer.portal.entity.AsyncTaskExample;

import java.util.List;

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