package top.buukle.provider.security.dao;

import org.apache.ibatis.annotations.Param;
import top.buukle.provider.security.entity.Button;
import top.buukle.provider.security.entity.Module;

import java.util.List;

public interface ButtonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Button record);

    int insertSelective(Button record);

    Button selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Button record);

    int updateByPrimaryKey(Button record);

    /**
     * 根据用户菜单列表获取用户按钮列表
     * @param userModuleList
     * @return
     */
    List<Button> getUserButtonListByUserModuleList(@Param("userModuleList") List<Module> userModuleList);

    /**
     * 获取全局按钮列表
     * @return
     */
    List<Button> getGlobalButtonList();
}