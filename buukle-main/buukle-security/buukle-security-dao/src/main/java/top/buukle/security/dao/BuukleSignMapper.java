package top.buukle.security.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.security.entity.BuukleSign;
import top.buukle.security.entity.BuukleSignExample;

@Mapper
public interface BuukleSignMapper {
    /**
     *
     * @mbg.generated Tue Aug 06 21:36:40 CST 2019
     */
    long countByExample(BuukleSignExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:40 CST 2019
     */
    int deleteByExample(BuukleSignExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:40 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:40 CST 2019
     */
    int insert(BuukleSign record);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:40 CST 2019
     */
    int insertSelective(BuukleSign record);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:40 CST 2019
     */
    List<BuukleSign> selectByExampleWithBLOBs(BuukleSignExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:40 CST 2019
     */
    List<BuukleSign> selectByExample(BuukleSignExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:40 CST 2019
     */
    BuukleSign selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:40 CST 2019
     */
    int updateByExampleSelective(@Param("record") BuukleSign record, @Param("example") BuukleSignExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:40 CST 2019
     */
    int updateByExampleWithBLOBs(@Param("record") BuukleSign record, @Param("example") BuukleSignExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:40 CST 2019
     */
    int updateByExample(@Param("record") BuukleSign record, @Param("example") BuukleSignExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:40 CST 2019
     */
    int updateByPrimaryKeySelective(BuukleSign record);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:40 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(BuukleSign record);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:40 CST 2019
     */
    int updateByPrimaryKey(BuukleSign record);
}