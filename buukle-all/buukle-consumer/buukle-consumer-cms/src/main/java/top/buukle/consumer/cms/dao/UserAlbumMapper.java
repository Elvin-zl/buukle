package top.buukle.consumer.cms.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.consumer.cms.entity.UserAlbum;
import top.buukle.consumer.cms.entity.UserAlbumExample;

@Mapper
public interface UserAlbumMapper {
    /**
     */
    long countByExample(UserAlbumExample example);

    /**
     */
    int deleteByExample(UserAlbumExample example);

    /**
     */
    int deleteByPrimaryKey(Integer id);

    /**
     */
    int insert(UserAlbum record);

    /**
     */
    int insertSelective(UserAlbum record);

    /**
     */
    List<UserAlbum> selectByExample(UserAlbumExample example);

    /**
     */
    UserAlbum selectByPrimaryKey(Integer id);

    /**
     */
    int updateByExampleSelective(@Param("record") UserAlbum record, @Param("example") UserAlbumExample example);

    /**
     */
    int updateByExample(@Param("record") UserAlbum record, @Param("example") UserAlbumExample example);

    /**
     */
    int updateByPrimaryKeySelective(UserAlbum record);

    /**
     */
    int updateByPrimaryKey(UserAlbum record);
}