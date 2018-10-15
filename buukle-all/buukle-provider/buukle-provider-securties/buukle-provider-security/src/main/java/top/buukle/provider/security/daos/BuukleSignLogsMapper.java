package top.buukle.provider.security.daos;

import top.buukle.provider.security.entity.BuukleSignLogs;

public interface BuukleSignLogsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BuukleSignLogs record);

    int insertSelective(BuukleSignLogs record);

    BuukleSignLogs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BuukleSignLogs record);

    int updateByPrimaryKey(BuukleSignLogs record);
}