package top.buukle.security.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.security.entity.UserTrail;
import top.buukle.security.entity.UserTrailExample;

@Mapper
public interface UserTrailMapper {
    /**
     *
     * @mbg.generated Tue Aug 06 21:37:07 CST 2019
     */
    long countByExample(UserTrailExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:37:07 CST 2019
     */
    int deleteByExample(UserTrailExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:37:07 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Tue Aug 06 21:37:07 CST 2019
     */
    int insert(UserTrail record);

    /**
     *
     * @mbg.generated Tue Aug 06 21:37:07 CST 2019
     */
    int insertSelective(UserTrail record);

    /**
     *
     * @mbg.generated Tue Aug 06 21:37:07 CST 2019
     */
    List<UserTrail> selectByExample(UserTrailExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:37:07 CST 2019
     */
    UserTrail selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Tue Aug 06 21:37:07 CST 2019
     */
    int updateByExampleSelective(@Param("record") UserTrail record, @Param("example") UserTrailExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:37:07 CST 2019
     */
    int updateByExample(@Param("record") UserTrail record, @Param("example") UserTrailExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:37:07 CST 2019
     */
    int updateByPrimaryKeySelective(UserTrail record);

    /**
     *
     * @mbg.generated Tue Aug 06 21:37:07 CST 2019
     */
    int updateByPrimaryKey(UserTrail record);
}