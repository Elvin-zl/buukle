package top.buukle.consumer.cms.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.consumer.cms.entity.UserImage;
import top.buukle.consumer.cms.entity.UserImageExample;

@Mapper
public interface UserImageMapper {
    /**
     *
     * @mbg.generated Mon Dec 17 00:04:27 CST 2018
     */
    long countByExample(UserImageExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:27 CST 2018
     */
    int deleteByExample(UserImageExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:27 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:27 CST 2018
     */
    int insert(UserImage record);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:27 CST 2018
     */
    int insertSelective(UserImage record);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:27 CST 2018
     */
    List<UserImage> selectByExample(UserImageExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:27 CST 2018
     */
    UserImage selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:27 CST 2018
     */
    int updateByExampleSelective(@Param("record") UserImage record, @Param("example") UserImageExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:27 CST 2018
     */
    int updateByExample(@Param("record") UserImage record, @Param("example") UserImageExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:27 CST 2018
     */
    int updateByPrimaryKeySelective(UserImage record);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:27 CST 2018
     */
    int updateByPrimaryKey(UserImage record);
}