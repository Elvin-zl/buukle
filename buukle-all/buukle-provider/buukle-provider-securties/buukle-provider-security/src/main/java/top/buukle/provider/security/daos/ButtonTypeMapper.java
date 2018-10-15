package top.buukle.provider.security.daos;

import top.buukle.provider.security.entity.ButtonType;

public interface ButtonTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ButtonType record);

    int insertSelective(ButtonType record);

    ButtonType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ButtonType record);

    int updateByPrimaryKey(ButtonType record);
}