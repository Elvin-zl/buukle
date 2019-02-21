package top.buukle.consumer.www.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.consumer.www.entity.UserImage;
import top.buukle.consumer.www.entity.UserImageExample;

import java.util.List;

@Mapper
public interface UserImageMapper {
    /**
     */
    long countByExample(UserImageExample example);

    /**
     */
    int deleteByExample(UserImageExample example);

    /**
     */
    int deleteByPrimaryKey(Integer id);

    /**
     */
    int insert(UserImage record);

    /**
     */
    int insertSelective(UserImage record);

    /**
     */
    List<UserImage> selectByExample(UserImageExample example);

    /**
     */
    UserImage selectByPrimaryKey(Integer id);

    /**
     */
    int updateByExampleSelective(@Param("record") UserImage record, @Param("example") UserImageExample example);

    /**
     */
    int updateByExample(@Param("record") UserImage record, @Param("example") UserImageExample example);

    /**
     */
    int updateByPrimaryKeySelective(UserImage record);

    /**
     */
    int updateByPrimaryKey(UserImage record);
}