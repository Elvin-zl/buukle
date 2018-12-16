package top.buukle.plugin.security.entity;

import java.util.Date;

public class Module {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 父菜单id
     */
    private Integer pid;

    /**
     * 应用名
     */
    private String applicationName;

    /**
     * 菜单名称
     */
    private String moduleName;

    /**
     * 菜单url
     */
    private String url;

    /**
     * 菜单图标
     */
    private String moduleIcon;

    /**
     * 菜单描述
     */
    private String description;

    /**
     * 创建者(用户名)
     */
    private String creator;

    /**
     * 创建者代码
     */
    private String creatorCode;

    /**
     * 创建时间
     */
    private Date gmtCreated;

    /**
     * 修改者(用户名)
     */
    private String modifier;

    /**
     * 修改者代码
     */
    private String modifierCode;

    /**
     * 更新时间
     */
    private Date gmtModified;

    /**
     * 
     */
    private Integer status;

    /**
     * 备用
     */
    private String bak01;

    /**
     * 备用
     */
    private String bak02;

    /**
     * 备用
     */
    private String bak03;

    /**
     * 备用
     */
    private String bak04;

    /**
     * 备用
     */
    private String bak05;

    /**
     * 主键id
     * @return id 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键id
     * @param id 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 父菜单id
     * @return pid 父菜单id
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 父菜单id
     * @param pid 父菜单id
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 应用名
     * @return application_name 应用名
     */
    public String getApplicationName() {
        return applicationName;
    }

    /**
     * 应用名
     * @param applicationName 应用名
     */
    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName == null ? null : applicationName.trim();
    }

    /**
     * 菜单名称
     * @return module_name 菜单名称
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * 菜单名称
     * @param moduleName 菜单名称
     */
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }

    /**
     * 菜单url
     * @return url 菜单url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 菜单url
     * @param url 菜单url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 菜单图标
     * @return module_icon 菜单图标
     */
    public String getModuleIcon() {
        return moduleIcon;
    }

    /**
     * 菜单图标
     * @param moduleIcon 菜单图标
     */
    public void setModuleIcon(String moduleIcon) {
        this.moduleIcon = moduleIcon == null ? null : moduleIcon.trim();
    }

    /**
     * 菜单描述
     * @return description 菜单描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 菜单描述
     * @param description 菜单描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 创建者(用户名)
     * @return creator 创建者(用户名)
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 创建者(用户名)
     * @param creator 创建者(用户名)
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * 创建者代码
     * @return creator_code 创建者代码
     */
    public String getCreatorCode() {
        return creatorCode;
    }

    /**
     * 创建者代码
     * @param creatorCode 创建者代码
     */
    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode == null ? null : creatorCode.trim();
    }

    /**
     * 创建时间
     * @return gmt_created 创建时间
     */
    public Date getGmtCreated() {
        return gmtCreated;
    }

    /**
     * 创建时间
     * @param gmtCreated 创建时间
     */
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**
     * 修改者(用户名)
     * @return modifier 修改者(用户名)
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 修改者(用户名)
     * @param modifier 修改者(用户名)
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * 修改者代码
     * @return modifier_code 修改者代码
     */
    public String getModifierCode() {
        return modifierCode;
    }

    /**
     * 修改者代码
     * @param modifierCode 修改者代码
     */
    public void setModifierCode(String modifierCode) {
        this.modifierCode = modifierCode == null ? null : modifierCode.trim();
    }

    /**
     * 更新时间
     * @return gmt_modified 更新时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 更新时间
     * @param gmtModified 更新时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 
     * @return status 
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 
     * @param status 
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 备用
     * @return bak01 备用
     */
    public String getBak01() {
        return bak01;
    }

    /**
     * 备用
     * @param bak01 备用
     */
    public void setBak01(String bak01) {
        this.bak01 = bak01 == null ? null : bak01.trim();
    }

    /**
     * 备用
     * @return bak02 备用
     */
    public String getBak02() {
        return bak02;
    }

    /**
     * 备用
     * @param bak02 备用
     */
    public void setBak02(String bak02) {
        this.bak02 = bak02 == null ? null : bak02.trim();
    }

    /**
     * 备用
     * @return bak03 备用
     */
    public String getBak03() {
        return bak03;
    }

    /**
     * 备用
     * @param bak03 备用
     */
    public void setBak03(String bak03) {
        this.bak03 = bak03 == null ? null : bak03.trim();
    }

    /**
     * 备用
     * @return bak04 备用
     */
    public String getBak04() {
        return bak04;
    }

    /**
     * 备用
     * @param bak04 备用
     */
    public void setBak04(String bak04) {
        this.bak04 = bak04 == null ? null : bak04.trim();
    }

    /**
     * 备用
     * @return bak05 备用
     */
    public String getBak05() {
        return bak05;
    }

    /**
     * 备用
     * @param bak05 备用
     */
    public void setBak05(String bak05) {
        this.bak05 = bak05 == null ? null : bak05.trim();
    }
}