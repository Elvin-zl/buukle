package top.buukle.consumer.portal.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.consumer.portal.entity.UserMessage;
import top.buukle.consumer.portal.entity.UserMessageExample;

import java.util.List;

@Mapper
public interface UserMessageMapper {
    /**
     */
    long countByExample(UserMessageExample example);

    /**
     */
    int deleteByExample(UserMessageExample example);

    /**
     */
    int deleteByPrimaryKey(Integer id);

    /**
     */
    int insert(UserMessage record);

    /**
     */
    int insertSelective(UserMessage record);

    /**
     */
    List<UserMessage> selectByExample(UserMessageExample example);

    /**
     */
    UserMessage selectByPrimaryKey(Integer id);

    /**
     */
    int updateByExampleSelective(@Param("record") UserMessage record, @Param("example") UserMessageExample example);

    /**
     */
    int updateByExample(@Param("record") UserMessage record, @Param("example") UserMessageExample example);

    /**
     */
    int updateByPrimaryKeySelective(UserMessage record);

    /**
     */
    int updateByPrimaryKey(UserMessage record);
}