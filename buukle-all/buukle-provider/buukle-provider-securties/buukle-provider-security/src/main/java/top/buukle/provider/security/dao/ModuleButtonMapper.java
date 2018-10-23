package top.buukle.provider.security.dao;

import org.apache.ibatis.annotations.Param;
import top.buukle.provider.security.entity.ModuleButton;

public interface ModuleButtonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ModuleButton record);

    int insertSelective(ModuleButton record);

    ModuleButton selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ModuleButton record);

    int updateByPrimaryKey(ModuleButton record);

    void deleteModuleButton(@Param("moduleId") Integer moduleId);

    ModuleButton getByButtonId(@Param("buttonId") Integer buttonId);
}