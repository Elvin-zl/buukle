package top.buukle.security.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.security.entity.InterfaceRegister;
import top.buukle.security.entity.InterfaceRegisterExample;

@Mapper
public interface InterfaceRegisterMapper {
    /**
     *
     * @mbg.generated Tue Aug 06 21:36:42 CST 2019
     */
    long countByExample(InterfaceRegisterExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:42 CST 2019
     */
    int deleteByExample(InterfaceRegisterExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:42 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:42 CST 2019
     */
    int insert(InterfaceRegister record);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:42 CST 2019
     */
    int insertSelective(InterfaceRegister record);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:42 CST 2019
     */
    List<InterfaceRegister> selectByExample(InterfaceRegisterExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:42 CST 2019
     */
    InterfaceRegister selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:42 CST 2019
     */
    int updateByExampleSelective(@Param("record") InterfaceRegister record, @Param("example") InterfaceRegisterExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:42 CST 2019
     */
    int updateByExample(@Param("record") InterfaceRegister record, @Param("example") InterfaceRegisterExample example);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:42 CST 2019
     */
    int updateByPrimaryKeySelective(InterfaceRegister record);

    /**
     *
     * @mbg.generated Tue Aug 06 21:36:42 CST 2019
     */
    int updateByPrimaryKey(InterfaceRegister record);
}