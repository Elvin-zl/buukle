package top.buukle.consumer.cms.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.consumer.cms.entity.UserAlbum;
import top.buukle.consumer.cms.entity.UserAlbumExample;

@Mapper
public interface UserAlbumMapper {
    /**
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    long countByExample(UserAlbumExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    int deleteByExample(UserAlbumExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    int insert(UserAlbum record);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    int insertSelective(UserAlbum record);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    List<UserAlbum> selectByExample(UserAlbumExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    UserAlbum selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    int updateByExampleSelective(@Param("record") UserAlbum record, @Param("example") UserAlbumExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    int updateByExample(@Param("record") UserAlbum record, @Param("example") UserAlbumExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    int updateByPrimaryKeySelective(UserAlbum record);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    int updateByPrimaryKey(UserAlbum record);
}