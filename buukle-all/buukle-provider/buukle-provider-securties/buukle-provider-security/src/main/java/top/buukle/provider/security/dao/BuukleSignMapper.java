package top.buukle.provider.security.dao;

import top.buukle.provider.security.entity.BuukleSign;

import java.util.List;

public interface BuukleSignMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BuukleSign record);

    int insertSelective(BuukleSign record);

    BuukleSign selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BuukleSign record);

    int updateByPrimaryKeyWithBLOBs(BuukleSign record);

    int updateByPrimaryKey(BuukleSign record);

    List<BuukleSign> getBuukleSignByParas(BuukleSign buukleSign);
}