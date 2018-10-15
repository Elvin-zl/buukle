package top.buukle.provider.security.entity;

import java.util.Date;

public class Groups {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 组名
     */
    private String name;

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
     * 状态 1：启用 0：停用 -1 : 删除
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
     * 组名
     * @return name 组名
     */
    public String getName() {
        return name;
    }

    /**
     * 组名
     * @param name 组名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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
     * 状态 1：启用 0：停用 -1 : 删除
     * @return status 状态 1：启用 0：停用 -1 : 删除
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态 1：启用 0：停用 -1 : 删除
     * @param status 状态 1：启用 0：停用 -1 : 删除
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