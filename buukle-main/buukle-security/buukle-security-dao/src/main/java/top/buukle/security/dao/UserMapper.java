package top.buukle.security.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.common.call.vo.FuzzyVo;
import top.buukle.security.entity.User;
import top.buukle.security.entity.UserExample;
import top.buukle.security.plugin.annotation.DataIsolationAnnotation;

@Mapper
public interface UserMapper {
    /**
     *
     * @mbg.generated Tue Aug 06 17:36:57 CST 2019
     */
    long countByExample(UserExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 17:36:57 CST 2019
     */
    int deleteByExample(UserExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 17:36:57 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Tue Aug 06 17:36:57 CST 2019
     */
    int insert(User record);

    /**
     *
     * @mbg.generated Tue Aug 06 17:36:57 CST 2019
     */
    int insertSelective(User record);

    /**
     *
     * @mbg.generated Tue Aug 06 17:36:57 CST 2019
     */
    @DataIsolationAnnotation(tableName="user",roleFieldName = "creator_role_id",queryDimension = DataIsolationAnnotation.DIMENSION_ROLE)
    List<User> selectByExample(UserExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 17:36:57 CST 2019
     */
    User selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Tue Aug 06 17:36:57 CST 2019
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 17:36:57 CST 2019
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 17:36:57 CST 2019
     */
    int updateByPrimaryKeySelective(User record);

    /**
     *
     * @mbg.generated Tue Aug 06 17:36:57 CST 2019
     */
    int updateByPrimaryKey(User record);

    List<FuzzyVo> fuzzySearch(FuzzyVo fuzzyVo);

    List<User> selectByUsernamePwd(@Param("username") String username, @Param("password") String password);
}