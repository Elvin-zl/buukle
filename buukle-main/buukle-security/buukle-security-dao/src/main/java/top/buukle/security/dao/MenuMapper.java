package top.buukle.security.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.security.entity.Menu;
import top.buukle.security.entity.MenuExample;

@Mapper
public interface MenuMapper {
    /**
     *
     * @mbg.generated Tue Aug 06 18:32:51 CST 2019
     */
    long countByExample(MenuExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 18:32:51 CST 2019
     */
    int deleteByExample(MenuExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 18:32:51 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Tue Aug 06 18:32:51 CST 2019
     */
    int insert(Menu record);

    /**
     *
     * @mbg.generated Tue Aug 06 18:32:51 CST 2019
     */
    int insertSelective(Menu record);

    /**
     *
     * @mbg.generated Tue Aug 06 18:32:51 CST 2019
     */
    List<Menu> selectByExample(MenuExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 18:32:51 CST 2019
     */
    Menu selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Tue Aug 06 18:32:51 CST 2019
     */
    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 18:32:51 CST 2019
     */
    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 18:32:51 CST 2019
     */
    int updateByPrimaryKeySelective(Menu record);

    /**
     *
     * @mbg.generated Tue Aug 06 18:32:51 CST 2019
     */
    int updateByPrimaryKey(Menu record);

    List<Menu> getUserMenuListByUserId(String userId);
}