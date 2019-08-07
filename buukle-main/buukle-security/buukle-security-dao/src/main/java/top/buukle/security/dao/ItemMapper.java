package top.buukle.security.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.security.entity.Item;
import top.buukle.security.entity.ItemExample;
import top.buukle.security.entity.vo.DynamicCondition;

@Mapper
public interface ItemMapper {
    /**
     *
     * @mbg.generated Wed Aug 07 11:06:51 CST 2019
     */
    long countByExample(ItemExample example);

    /**
     *
     * @mbg.generated Wed Aug 07 11:06:51 CST 2019
     */
    int deleteByExample(ItemExample example);

    /**
     *
     * @mbg.generated Wed Aug 07 11:06:51 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Wed Aug 07 11:06:51 CST 2019
     */
    int insert(Item record);

    /**
     *
     * @mbg.generated Wed Aug 07 11:06:51 CST 2019
     */
    int insertSelective(Item record);

    /**
     *
     * @mbg.generated Wed Aug 07 11:06:51 CST 2019
     */
    List<Item> selectByExampleWithBLOBs(ItemExample example);

    /**
     *
     * @mbg.generated Wed Aug 07 11:06:51 CST 2019
     */
    List<Item> selectByExample(ItemExample example);

    /**
     *
     * @mbg.generated Wed Aug 07 11:06:51 CST 2019
     */
    Item selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Wed Aug 07 11:06:51 CST 2019
     */
    int updateByExampleSelective(@Param("record") Item record, @Param("example") ItemExample example);

    /**
     *
     * @mbg.generated Wed Aug 07 11:06:51 CST 2019
     */
    int updateByExampleWithBLOBs(@Param("record") Item record, @Param("example") ItemExample example);

    /**
     *
     * @mbg.generated Wed Aug 07 11:06:51 CST 2019
     */
    int updateByExample(@Param("record") Item record, @Param("example") ItemExample example);

    /**
     *
     * @mbg.generated Wed Aug 07 11:06:51 CST 2019
     */
    int updateByPrimaryKeySelective(Item record);

    /**
     *
     * @mbg.generated Wed Aug 07 11:06:51 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(Item record);

    /**
     *
     * @mbg.generated Wed Aug 07 11:06:51 CST 2019
     */
    int updateByPrimaryKey(Item record);

    List<Item> itemList(@Param("condition") String condition);
}