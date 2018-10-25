package top.buukle.provider.security.vo.response;

import top.buukle.provider.security.entity.Module;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/19.
 * @Description : 分配菜单弹层包装类
 */
public class RoleModuleListVo extends Module{

    private String name;
    private String click;
    private Boolean checked;
    private Integer pId;

    public String getClick() {
        return click;
    }

    public void setClick(String click) {
        this.click = click;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }
}
