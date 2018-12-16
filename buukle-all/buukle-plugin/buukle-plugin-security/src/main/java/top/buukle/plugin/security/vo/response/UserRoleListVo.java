package top.buukle.plugin.security.vo.response;

import top.buukle.plugin.security.entity.Role;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/18.
 * @Description : 分配角色弹层包装类
 */
public class UserRoleListVo extends Role{

    /** 是否是选中的*/
    private Integer isSelected;

    public Integer getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(Integer isSelected) {
        this.isSelected = isSelected;
    }
}
