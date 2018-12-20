package top.buukle.consumer.cms.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.consumer.cms.entity.FriendLink;
import top.buukle.consumer.cms.entity.FriendLinkExample;

@Mapper
public interface FriendLinkMapper {
    /**
     */
    long countByExample(FriendLinkExample example);

    /**
     */
    int deleteByExample(FriendLinkExample example);

    /**
     */
    int deleteByPrimaryKey(Integer id);

    /**
     */
    int insert(FriendLink record);

    /**
     */
    int insertSelective(FriendLink record);

    /**
     */
    List<FriendLink> selectByExample(FriendLinkExample example);

    /**
     */
    FriendLink selectByPrimaryKey(Integer id);

    /**
     */
    int updateByExampleSelective(@Param("record") FriendLink record, @Param("example") FriendLinkExample example);

    /**
     */
    int updateByExample(@Param("record") FriendLink record, @Param("example") FriendLinkExample example);

    /**
     */
    int updateByPrimaryKeySelective(FriendLink record);

    /**
     */
    int updateByPrimaryKey(FriendLink record);
}