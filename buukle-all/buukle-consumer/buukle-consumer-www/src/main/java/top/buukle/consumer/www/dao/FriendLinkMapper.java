package top.buukle.consumer.www.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.consumer.www.entity.FriendLink;
import top.buukle.consumer.www.entity.FriendLinkExample;

import java.util.List;

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