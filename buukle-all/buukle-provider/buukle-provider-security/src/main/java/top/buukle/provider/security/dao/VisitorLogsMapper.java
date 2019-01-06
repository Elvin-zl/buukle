package top.buukle.provider.security.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.plugin.security.entity.VisitorLogs;
import top.buukle.plugin.security.entity.VisitorLogsExample;

@Mapper
public interface VisitorLogsMapper {
    /**
     */
    long countByExample(VisitorLogsExample example);

    /**
     */
    int deleteByExample(VisitorLogsExample example);

    /**
     */
    int deleteByPrimaryKey(Integer id);

    /**
     */
    int insert(VisitorLogs record);

    /**
     */
    int insertSelective(VisitorLogs record);

    /**
     */
    List<VisitorLogs> selectByExample(VisitorLogsExample example);

    /**
     */
    VisitorLogs selectByPrimaryKey(Integer id);

    /**
     */
    int updateByExampleSelective(@Param("record") VisitorLogs record, @Param("example") VisitorLogsExample example);

    /**
     */
    int updateByExample(@Param("record") VisitorLogs record, @Param("example") VisitorLogsExample example);

    /**
     */
    int updateByPrimaryKeySelective(VisitorLogs record);

    /**
     */
    int updateByPrimaryKey(VisitorLogs record);
}