package top.buukle.security.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.common.call.vo.FuzzyVo;
import top.buukle.security.entity.User;
import top.buukle.security.entity.UserExample;

@Mapper
public interface UserMapper {
    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    long countByExample(UserExample example);

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    int deleteByExample(UserExample example);

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    int insert(User record);

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    int insertSelective(User record);

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    List<User> selectByExample(UserExample example);

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    User selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    int updateByPrimaryKeySelective(User record);

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    int updateByPrimaryKey(User record);

    List<FuzzyVo> fuzzySearch(FuzzyVo fuzzyVo);
}