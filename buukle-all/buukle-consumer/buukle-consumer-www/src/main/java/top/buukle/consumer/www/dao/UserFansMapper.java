package top.buukle.consumer.www.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.consumer.www.entity.UserFans;
import top.buukle.consumer.www.entity.UserFansExample;

import java.util.List;

@Mapper
public interface UserFansMapper {
    /**
     */
    long countByExample(UserFansExample example);

    /**
     */
    int deleteByExample(UserFansExample example);

    /**
     */
    int deleteByPrimaryKey(Integer id);

    /**
     */
    int insert(UserFans record);

    /**
     */
    int insertSelective(UserFans record);

    /**
     */
    List<UserFans> selectByExample(UserFansExample example);

    /**
     */
    UserFans selectByPrimaryKey(Integer id);

    /**
     */
    int updateByExampleSelective(@Param("record") UserFans record, @Param("example") UserFansExample example);

    /**
     */
    int updateByExample(@Param("record") UserFans record, @Param("example") UserFansExample example);

    /**
     */
    int updateByPrimaryKeySelective(UserFans record);

    /**
     */
    int updateByPrimaryKey(UserFans record);
}