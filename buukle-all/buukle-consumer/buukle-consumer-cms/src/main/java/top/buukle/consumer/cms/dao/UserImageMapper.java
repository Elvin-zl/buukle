package top.buukle.consumer.cms.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.consumer.cms.entity.UserImage;
import top.buukle.consumer.cms.entity.UserImageExample;

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