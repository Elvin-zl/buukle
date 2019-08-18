package top.buukle.security.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.security.entity.Application;
import top.buukle.security.entity.ApplicationExample;
import top.buukle.security.plugin.annotation.DataIsolationAnnotation;

@Mapper
public interface ApplicationMapper {
    /**
     *
     * @mbg.generated Tue Aug 06 21:36:30 CST 2019
     */
    long countByExample(ApplicationExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:30 CST 2019
     */
    int deleteByExample(ApplicationExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:30 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:30 CST 2019
     */
    int insert(Application record);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:30 CST 2019
     */
    int insertSelective(Application record);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:30 CST 2019
     */
    @DataIsolationAnnotation(tableName="application")
    List<Application> selectByExample(ApplicationExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:30 CST 2019
     */
    Application selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:30 CST 2019
     */
    int updateByExampleSelective(@Param("record") Application record, @Param("example") ApplicationExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:30 CST 2019
     */
    int updateByExample(@Param("record") Application record, @Param("example") ApplicationExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:30 CST 2019
     */
    int updateByPrimaryKeySelective(Application record);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:30 CST 2019
     */
    int updateByPrimaryKey(Application record);
}