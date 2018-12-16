package top.buukle.consumer.cms.dao;

import top.buukle.consumer.cms.entity.UserMessage;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.buukle.consumer.cms.entity.UserMessageExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMessageMapper {

    /**
     * @mbg.generated Mon Dec 17 00:08:17 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @mbg.generated Mon Dec 17 00:08:17 CST 2018
     */
    int updateByPrimaryKeySelective(UserMessage record);

    /**
     * @mbg.generated Mon Dec 17 00:08:17 CST 2018
     */
    UserMessage selectByPrimaryKey(Integer id);

    /**
     * @mbg.generated Mon Dec 17 00:08:17 CST 2018
     */
    List<UserMessage> selectByExample(UserMessageExample example);

    /**
     * @mbg.generated Mon Dec 17 00:08:17 CST 2018
     */
    int insertSelective(UserMessage record);

    /**
     * @mbg.generated Mon Dec 17 00:08:17 CST 2018
     */
    int updateByExample(@Param("record") UserMessage record, @Param("example") UserMessageExample example);

    /**
     * @mbg.generated Mon Dec 17 00:08:17 CST 2018
     */
    int insert(UserMessage record);

    /**
     * @mbg.generated Mon Dec 17 00:08:17 CST 2018
     */
    long countByExample(UserMessageExample example);

    /**
     * @mbg.generated Mon Dec 17 00:08:17 CST 2018
     */
    int updateByExampleSelective(@Param("record") UserMessage record, @Param("example") UserMessageExample example);

    /**
     * @mbg.generated Mon Dec 17 00:08:17 CST 2018
     */
    int updateByPrimaryKey(UserMessage record);

    /**
     * @mbg.generated Mon Dec 17 00:08:17 CST 2018
     */
    int deleteByExample(UserMessageExample example);
}
