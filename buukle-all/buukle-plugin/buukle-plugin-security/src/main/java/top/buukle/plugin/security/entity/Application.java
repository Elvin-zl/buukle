package top.buukle.plugin.security.entity;

import java.util.Date;

public class Application {
    /**
     * 
     */
    private Integer id;

    /**
     * 应用名
     */
    private String name;

    /**
     * 创建时间
     */
    private Date gmtCreated;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 创建者编码
     */
    private String creatorCode;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * 修改者
     */
    private String modifier;

    /**
     * 修改者编码
     */
    private String modifierCode;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 应用名
     * @return name 应用名
     */
    public String getName() {
        return name;
    }

    /**
     * 应用名
     * @param name 应用名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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
     * 创建者
     * @return creator 创建者
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 创建者
     * @param creator 创建者
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * 创建者编码
     * @return creator_code 创建者编码
     */
    public String getCreatorCode() {
        return creatorCode;
    }

    /**
     * 创建者编码
     * @param creatorCode 创建者编码
     */
    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode == null ? null : creatorCode.trim();
    }

    /**
     * 修改时间
     * @return gmt_modified 修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 修改时间
     * @param gmtModified 修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 修改者
     * @return modifier 修改者
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 修改者
     * @param modifier 修改者
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * 修改者编码
     * @return modifier_code 修改者编码
     */
    public String getModifierCode() {
        return modifierCode;
    }

    /**
     * 修改者编码
     * @param modifierCode 修改者编码
     */
    public void setModifierCode(String modifierCode) {
        this.modifierCode = modifierCode == null ? null : modifierCode.trim();
    }

    /**
     * 状态
     * @return status 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态
     * @param status 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}