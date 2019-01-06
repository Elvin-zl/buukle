package top.buukle.provider.security.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.plugin.security.entity.IpBlackList;
import top.buukle.plugin.security.entity.IpBlackListExample;

@Mapper
public interface IpBlackListMapper {
    /**
     */
    long countByExample(IpBlackListExample example);

    /**
     */
    int deleteByExample(IpBlackListExample example);

    /**
     */
    int deleteByPrimaryKey(Integer id);

    /**
     */
    int insert(IpBlackList record);

    /**
     */
    int insertSelective(IpBlackList record);

    /**
     */
    List<IpBlackList> selectByExample(IpBlackListExample example);

    /**
     */
    IpBlackList selectByPrimaryKey(Integer id);

    /**
     */
    int updateByExampleSelective(@Param("record") IpBlackList record, @Param("example") IpBlackListExample example);

    /**
     */
    int updateByExample(@Param("record") IpBlackList record, @Param("example") IpBlackListExample example);

    /**
     */
    int updateByPrimaryKeySelective(IpBlackList record);

    /**
     */
    int updateByPrimaryKey(IpBlackList record);
}