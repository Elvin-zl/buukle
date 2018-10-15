package top.buukle.provider.security.dao;

import top.buukle.provider.security.entity.Groups;

import java.util.List;

public interface GroupsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Groups record);

    int insertSelective(Groups record);

    Groups selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Groups record);

    int updateByPrimaryKey(Groups record);

    /**
     * 根据用户id获取用户组别
     * @param userId
     * @return
     */
    List<Groups> getUserGroupsByUserId(String userId);
}