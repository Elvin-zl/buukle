package top.buukle.consumer.cms.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.consumer.cms.entity.UserFans;
import top.buukle.consumer.cms.entity.UserFansExample;

@Mapper
public interface UserFansMapper {
    /**
     *
     * @mbg.generated Mon Dec 17 00:04:24 CST 2018
     */
    long countByExample(UserFansExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:24 CST 2018
     */
    int deleteByExample(UserFansExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:24 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:24 CST 2018
     */
    int insert(UserFans record);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:24 CST 2018
     */
    int insertSelective(UserFans record);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:24 CST 2018
     */
    List<UserFans> selectByExample(UserFansExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:24 CST 2018
     */
    UserFans selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:24 CST 2018
     */
    int updateByExampleSelective(@Param("record") UserFans record, @Param("example") UserFansExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:24 CST 2018
     */
    int updateByExample(@Param("record") UserFans record, @Param("example") UserFansExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:24 CST 2018
     */
    int updateByPrimaryKeySelective(UserFans record);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:24 CST 2018
     */
    int updateByPrimaryKey(UserFans record);
}