package top.buukle.provider.security.dao;

import top.buukle.plugin.security.entity.UserExp;

public interface UserExpMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserExp record);

    int insertSelective(UserExp record);

    UserExp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserExp record);

    int updateByPrimaryKey(UserExp record);

    /**
     * 根据用户id获取用户扩展信息
      * @param userId
     * @return
     */
    UserExp getUserExpByUserId(String userId);
}