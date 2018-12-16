package top.buukle.provider.security.dao;

import top.buukle.plugin.security.entity.ButtonType;

import java.util.List;

public interface ButtonTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ButtonType record);

    int insertSelective(ButtonType record);

    ButtonType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ButtonType record);

    int updateByPrimaryKey(ButtonType record);

    /**
     * 获取全局按钮类型
     * @return
     */
    List<ButtonType> getButtonTypes();

}