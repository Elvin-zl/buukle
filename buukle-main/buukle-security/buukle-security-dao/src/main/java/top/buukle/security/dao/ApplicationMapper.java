package top.buukle.security.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.security.entity.Application;
import top.buukle.security.entity.ApplicationExample;

@Mapper
public interface ApplicationMapper {
    /**
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    long countByExample(ApplicationExample example);

    /**
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    int deleteByExample(ApplicationExample example);

    /**
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    int insert(Application record);

    /**
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    int insertSelective(Application record);

    /**
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    List<Application> selectByExample(ApplicationExample example);

    /**
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    Application selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    int updateByExampleSelective(@Param("record") Application record, @Param("example") ApplicationExample example);

    /**
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    int updateByExample(@Param("record") Application record, @Param("example") ApplicationExample example);

    /**
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    int updateByPrimaryKeySelective(Application record);

    /**
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    int updateByPrimaryKey(Application record);
}