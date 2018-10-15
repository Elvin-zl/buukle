package top.buukle.provider.security.daos;

import top.buukle.provider.security.entity.UserExp;

public interface UserExpMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserExp record);

    int insertSelective(UserExp record);

    UserExp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserExp record);

    int updateByPrimaryKey(UserExp record);
}