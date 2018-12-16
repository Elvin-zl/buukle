package top.buukle.consumer.cms.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.consumer.cms.entity.FriendLink;
import top.buukle.consumer.cms.entity.FriendLinkExample;

@Mapper
public interface FriendLinkMapper {
    /**
     *
     * @mbg.generated Mon Dec 17 00:04:17 CST 2018
     */
    long countByExample(FriendLinkExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:17 CST 2018
     */
    int deleteByExample(FriendLinkExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:17 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:17 CST 2018
     */
    int insert(FriendLink record);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:17 CST 2018
     */
    int insertSelective(FriendLink record);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:17 CST 2018
     */
    List<FriendLink> selectByExample(FriendLinkExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:17 CST 2018
     */
    FriendLink selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:17 CST 2018
     */
    int updateByExampleSelective(@Param("record") FriendLink record, @Param("example") FriendLinkExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:17 CST 2018
     */
    int updateByExample(@Param("record") FriendLink record, @Param("example") FriendLinkExample example);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:17 CST 2018
     */
    int updateByPrimaryKeySelective(FriendLink record);

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:17 CST 2018
     */
    int updateByPrimaryKey(FriendLink record);
}