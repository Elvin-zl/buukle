package top.buukle.provider.security.daos;

import top.buukle.provider.security.entity.Groups;

public interface GroupsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Groups record);

    int insertSelective(Groups record);

    Groups selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Groups record);

    int updateByPrimaryKey(Groups record);
}