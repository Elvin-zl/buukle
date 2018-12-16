package top.buukle.provider.security.dao;

import org.apache.ibatis.annotations.Param;
import top.buukle.plugin.security.entity.ModuleButton;

import java.util.List;

public interface ModuleButtonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ModuleButton record);

    int insertSelective(ModuleButton record);

    ModuleButton selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ModuleButton record);

    int updateByPrimaryKey(ModuleButton record);

    void deleteModuleButton(@Param("moduleId") Integer moduleId);

    List<ModuleButton> getByButtonId(@Param("buttonId") Integer buttonId);
}