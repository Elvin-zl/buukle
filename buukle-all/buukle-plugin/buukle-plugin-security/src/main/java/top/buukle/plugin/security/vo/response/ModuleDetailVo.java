package top.buukle.plugin.security.vo.response;

import top.buukle.plugin.security.entity.Module;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/30.
 * @Description : 菜单详情返回包装类
 */
public class ModuleDetailVo extends Module{

    /** 父级菜单名称*/
    private String pName;

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }
}
