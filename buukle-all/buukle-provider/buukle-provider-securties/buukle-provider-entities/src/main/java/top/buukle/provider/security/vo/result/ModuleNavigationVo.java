package top.buukle.provider.security.vo.result;

import top.buukle.provider.security.entity.Module;

import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/10.
 * @Description :
 */
public class ModuleNavigationVo {

    private String title;
    private String icon;
    private Integer layId;
    private String layUrl;
    private Integer id;
    private Integer pid;
    private List<ModuleNavigationVo> children;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getLayId() {
        return layId;
    }

    public void setLayId(Integer layId) {
        this.layId = layId;
    }

    public String getLayUrl() {
        return layUrl;
    }

    public void setLayUrl(String layUrl) {
        this.layUrl = layUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public List<ModuleNavigationVo> getChildren() {
        return children;
    }

    public void setChildren(List<ModuleNavigationVo> children) {
        this.children = children;
    }

    /**
     * copy菜单实例对象中的属性到包装对象实例
     * @param module
     * @param moduleNavigationVo
     */
    public static void copyProperties(Module module, ModuleNavigationVo moduleNavigationVo) {
        moduleNavigationVo.setIcon(module.getModuleIcon());
        moduleNavigationVo.setId(module.getId());
        moduleNavigationVo.setLayId(module.getId());
        moduleNavigationVo.setLayUrl(module.getUrl());
        moduleNavigationVo.setPid(module.getPid());
        moduleNavigationVo.setTitle(module.getModuleName());
    }
}
