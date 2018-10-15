package top.buukle.provider.security.daos;

import top.buukle.provider.security.entity.ModuleButton;

public interface ModuleButtonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ModuleButton record);

    int insertSelective(ModuleButton record);

    ModuleButton selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ModuleButton record);

    int updateByPrimaryKey(ModuleButton record);
}