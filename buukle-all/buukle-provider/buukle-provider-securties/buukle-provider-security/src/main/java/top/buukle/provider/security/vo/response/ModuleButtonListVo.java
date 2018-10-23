package top.buukle.provider.security.vo.response;

import top.buukle.provider.security.entity.Button;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/19.
 * @Description :
 */
public class ModuleButtonListVo extends Button{
    private Integer pId;
    private boolean checked;
    private String name;


    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
