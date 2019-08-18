package top.buukle.security.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created By MBG-GUI-EXTENSION https:// github.com/spawpaw/mybatis-generator-gui-extension
 * Description:
 * 菜单表
 *
 * @author 
 */
public class Menu implements Serializable {
    /**
     * 主键id
     *
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    private Integer id;

    /**
     * 是否是系统守护 0 : 否 1: 是
     *
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    private Integer systemFlag;

    /**
     * 父菜单id
     *
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    private Integer pid;

    /**
     * 所属应用id
     *
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    private Integer applicationId;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    private String applicationName;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    private String name;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    private String aliasName;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    private String url;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    private String pageUrl;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    private String icon;

    /**
     * 展示位置 空/0 : 左侧 1: 顶部+左侧
     *
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    private Integer positionType;

    /**
     * 展示否 1: 展示 0:不展示
     *
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    private Integer display;

    /**
     * 排序号
     *
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    private Integer orderNo;

    /**
     * 类型  1: 菜单 0: 组件
     *
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    private Integer type;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    private String description;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    private String remark;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    private Date gmtCreated;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    private String creator;

    /**
     * 创建者的角色id
     *
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    private Integer creatorRoleId;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    private String creatorCode;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    private Date gmtModified;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    private String modifier;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    private String modifierCode;

    /**
     * 状态
     *
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    private Integer status;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    private String bak01;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    private String bak02;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    private String bak03;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    private String bak04;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    private String bak05;

    /**
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column buukle-security-new..menu.id
     *
     * @return the value of buukle-security-new..menu.id
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Menu withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..menu.id
     *
     * @param id the value for buukle-security-new..menu.id
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column buukle-security-new..menu.system_flag
     *
     * @return the value of buukle-security-new..menu.system_flag
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Integer getSystemFlag() {
        return systemFlag;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Menu withSystemFlag(Integer systemFlag) {
        this.setSystemFlag(systemFlag);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..menu.system_flag
     *
     * @param systemFlag the value for buukle-security-new..menu.system_flag
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public void setSystemFlag(Integer systemFlag) {
        this.systemFlag = systemFlag;
    }

    /**
     * This method returns the value of the database column buukle-security-new..menu.pid
     *
     * @return the value of buukle-security-new..menu.pid
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Integer getPid() {
        return pid;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Menu withPid(Integer pid) {
        this.setPid(pid);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..menu.pid
     *
     * @param pid the value for buukle-security-new..menu.pid
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * This method returns the value of the database column buukle-security-new..menu.application_id
     *
     * @return the value of buukle-security-new..menu.application_id
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Integer getApplicationId() {
        return applicationId;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Menu withApplicationId(Integer applicationId) {
        this.setApplicationId(applicationId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..menu.application_id
     *
     * @param applicationId the value for buukle-security-new..menu.application_id
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    /**
     * This method returns the value of the database column buukle-security-new..menu.application_name
     *
     * @return the value of buukle-security-new..menu.application_name
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public String getApplicationName() {
        return applicationName;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Menu withApplicationName(String applicationName) {
        this.setApplicationName(applicationName);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..menu.application_name
     *
     * @param applicationName the value for buukle-security-new..menu.application_name
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName == null ? null : applicationName.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..menu.name
     *
     * @return the value of buukle-security-new..menu.name
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Menu withName(String name) {
        this.setName(name);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..menu.name
     *
     * @param name the value for buukle-security-new..menu.name
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..menu.alias_name
     *
     * @return the value of buukle-security-new..menu.alias_name
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public String getAliasName() {
        return aliasName;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Menu withAliasName(String aliasName) {
        this.setAliasName(aliasName);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..menu.alias_name
     *
     * @param aliasName the value for buukle-security-new..menu.alias_name
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public void setAliasName(String aliasName) {
        this.aliasName = aliasName == null ? null : aliasName.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..menu.url
     *
     * @return the value of buukle-security-new..menu.url
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Menu withUrl(String url) {
        this.setUrl(url);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..menu.url
     *
     * @param url the value for buukle-security-new..menu.url
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..menu.page_url
     *
     * @return the value of buukle-security-new..menu.page_url
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public String getPageUrl() {
        return pageUrl;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Menu withPageUrl(String pageUrl) {
        this.setPageUrl(pageUrl);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..menu.page_url
     *
     * @param pageUrl the value for buukle-security-new..menu.page_url
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl == null ? null : pageUrl.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..menu.icon
     *
     * @return the value of buukle-security-new..menu.icon
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public String getIcon() {
        return icon;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Menu withIcon(String icon) {
        this.setIcon(icon);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..menu.icon
     *
     * @param icon the value for buukle-security-new..menu.icon
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..menu.position_type
     *
     * @return the value of buukle-security-new..menu.position_type
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Integer getPositionType() {
        return positionType;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Menu withPositionType(Integer positionType) {
        this.setPositionType(positionType);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..menu.position_type
     *
     * @param positionType the value for buukle-security-new..menu.position_type
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public void setPositionType(Integer positionType) {
        this.positionType = positionType;
    }

    /**
     * This method returns the value of the database column buukle-security-new..menu.display
     *
     * @return the value of buukle-security-new..menu.display
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Integer getDisplay() {
        return display;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Menu withDisplay(Integer display) {
        this.setDisplay(display);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..menu.display
     *
     * @param display the value for buukle-security-new..menu.display
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public void setDisplay(Integer display) {
        this.display = display;
    }

    /**
     * This method returns the value of the database column buukle-security-new..menu.order_no
     *
     * @return the value of buukle-security-new..menu.order_no
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Integer getOrderNo() {
        return orderNo;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Menu withOrderNo(Integer orderNo) {
        this.setOrderNo(orderNo);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..menu.order_no
     *
     * @param orderNo the value for buukle-security-new..menu.order_no
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * This method returns the value of the database column buukle-security-new..menu.type
     *
     * @return the value of buukle-security-new..menu.type
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Integer getType() {
        return type;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Menu withType(Integer type) {
        this.setType(type);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..menu.type
     *
     * @param type the value for buukle-security-new..menu.type
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method returns the value of the database column buukle-security-new..menu.description
     *
     * @return the value of buukle-security-new..menu.description
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Menu withDescription(String description) {
        this.setDescription(description);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..menu.description
     *
     * @param description the value for buukle-security-new..menu.description
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..menu.remark
     *
     * @return the value of buukle-security-new..menu.remark
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public String getRemark() {
        return remark;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Menu withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..menu.remark
     *
     * @param remark the value for buukle-security-new..menu.remark
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..menu.gmt_created
     *
     * @return the value of buukle-security-new..menu.gmt_created
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Date getGmtCreated() {
        return gmtCreated;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Menu withGmtCreated(Date gmtCreated) {
        this.setGmtCreated(gmtCreated);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..menu.gmt_created
     *
     * @param gmtCreated the value for buukle-security-new..menu.gmt_created
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**
     * This method returns the value of the database column buukle-security-new..menu.creator
     *
     * @return the value of buukle-security-new..menu.creator
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public String getCreator() {
        return creator;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Menu withCreator(String creator) {
        this.setCreator(creator);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..menu.creator
     *
     * @param creator the value for buukle-security-new..menu.creator
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..menu.creator_role_id
     *
     * @return the value of buukle-security-new..menu.creator_role_id
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Integer getCreatorRoleId() {
        return creatorRoleId;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Menu withCreatorRoleId(Integer creatorRoleId) {
        this.setCreatorRoleId(creatorRoleId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..menu.creator_role_id
     *
     * @param creatorRoleId the value for buukle-security-new..menu.creator_role_id
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public void setCreatorRoleId(Integer creatorRoleId) {
        this.creatorRoleId = creatorRoleId;
    }

    /**
     * This method returns the value of the database column buukle-security-new..menu.creator_code
     *
     * @return the value of buukle-security-new..menu.creator_code
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public String getCreatorCode() {
        return creatorCode;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Menu withCreatorCode(String creatorCode) {
        this.setCreatorCode(creatorCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..menu.creator_code
     *
     * @param creatorCode the value for buukle-security-new..menu.creator_code
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode == null ? null : creatorCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..menu.gmt_modified
     *
     * @return the value of buukle-security-new..menu.gmt_modified
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Menu withGmtModified(Date gmtModified) {
        this.setGmtModified(gmtModified);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..menu.gmt_modified
     *
     * @param gmtModified the value for buukle-security-new..menu.gmt_modified
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method returns the value of the database column buukle-security-new..menu.modifier
     *
     * @return the value of buukle-security-new..menu.modifier
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public String getModifier() {
        return modifier;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Menu withModifier(String modifier) {
        this.setModifier(modifier);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..menu.modifier
     *
     * @param modifier the value for buukle-security-new..menu.modifier
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..menu.modifier_code
     *
     * @return the value of buukle-security-new..menu.modifier_code
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public String getModifierCode() {
        return modifierCode;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Menu withModifierCode(String modifierCode) {
        this.setModifierCode(modifierCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..menu.modifier_code
     *
     * @param modifierCode the value for buukle-security-new..menu.modifier_code
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public void setModifierCode(String modifierCode) {
        this.modifierCode = modifierCode == null ? null : modifierCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..menu.status
     *
     * @return the value of buukle-security-new..menu.status
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Menu withStatus(Integer status) {
        this.setStatus(status);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..menu.status
     *
     * @param status the value for buukle-security-new..menu.status
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column buukle-security-new..menu.bak01
     *
     * @return the value of buukle-security-new..menu.bak01
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public String getBak01() {
        return bak01;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Menu withBak01(String bak01) {
        this.setBak01(bak01);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..menu.bak01
     *
     * @param bak01 the value for buukle-security-new..menu.bak01
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public void setBak01(String bak01) {
        this.bak01 = bak01 == null ? null : bak01.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..menu.bak02
     *
     * @return the value of buukle-security-new..menu.bak02
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public String getBak02() {
        return bak02;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Menu withBak02(String bak02) {
        this.setBak02(bak02);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..menu.bak02
     *
     * @param bak02 the value for buukle-security-new..menu.bak02
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public void setBak02(String bak02) {
        this.bak02 = bak02 == null ? null : bak02.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..menu.bak03
     *
     * @return the value of buukle-security-new..menu.bak03
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public String getBak03() {
        return bak03;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Menu withBak03(String bak03) {
        this.setBak03(bak03);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..menu.bak03
     *
     * @param bak03 the value for buukle-security-new..menu.bak03
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public void setBak03(String bak03) {
        this.bak03 = bak03 == null ? null : bak03.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..menu.bak04
     *
     * @return the value of buukle-security-new..menu.bak04
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public String getBak04() {
        return bak04;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Menu withBak04(String bak04) {
        this.setBak04(bak04);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..menu.bak04
     *
     * @param bak04 the value for buukle-security-new..menu.bak04
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public void setBak04(String bak04) {
        this.bak04 = bak04 == null ? null : bak04.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..menu.bak05
     *
     * @return the value of buukle-security-new..menu.bak05
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public String getBak05() {
        return bak05;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public Menu withBak05(String bak05) {
        this.setBak05(bak05);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..menu.bak05
     *
     * @param bak05 the value for buukle-security-new..menu.bak05
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    public void setBak05(String bak05) {
        this.bak05 = bak05 == null ? null : bak05.trim();
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", systemFlag=").append(systemFlag);
        sb.append(", pid=").append(pid);
        sb.append(", applicationId=").append(applicationId);
        sb.append(", applicationName=").append(applicationName);
        sb.append(", name=").append(name);
        sb.append(", aliasName=").append(aliasName);
        sb.append(", url=").append(url);
        sb.append(", pageUrl=").append(pageUrl);
        sb.append(", icon=").append(icon);
        sb.append(", positionType=").append(positionType);
        sb.append(", display=").append(display);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", type=").append(type);
        sb.append(", description=").append(description);
        sb.append(", remark=").append(remark);
        sb.append(", gmtCreated=").append(gmtCreated);
        sb.append(", creator=").append(creator);
        sb.append(", creatorRoleId=").append(creatorRoleId);
        sb.append(", creatorCode=").append(creatorCode);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", modifier=").append(modifier);
        sb.append(", modifierCode=").append(modifierCode);
        sb.append(", status=").append(status);
        sb.append(", bak01=").append(bak01);
        sb.append(", bak02=").append(bak02);
        sb.append(", bak03=").append(bak03);
        sb.append(", bak04=").append(bak04);
        sb.append(", bak05=").append(bak05);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Menu other = (Menu) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSystemFlag() == null ? other.getSystemFlag() == null : this.getSystemFlag().equals(other.getSystemFlag()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getApplicationId() == null ? other.getApplicationId() == null : this.getApplicationId().equals(other.getApplicationId()))
            && (this.getApplicationName() == null ? other.getApplicationName() == null : this.getApplicationName().equals(other.getApplicationName()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getAliasName() == null ? other.getAliasName() == null : this.getAliasName().equals(other.getAliasName()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getPageUrl() == null ? other.getPageUrl() == null : this.getPageUrl().equals(other.getPageUrl()))
            && (this.getIcon() == null ? other.getIcon() == null : this.getIcon().equals(other.getIcon()))
            && (this.getPositionType() == null ? other.getPositionType() == null : this.getPositionType().equals(other.getPositionType()))
            && (this.getDisplay() == null ? other.getDisplay() == null : this.getDisplay().equals(other.getDisplay()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreatorRoleId() == null ? other.getCreatorRoleId() == null : this.getCreatorRoleId().equals(other.getCreatorRoleId()))
            && (this.getCreatorCode() == null ? other.getCreatorCode() == null : this.getCreatorCode().equals(other.getCreatorCode()))
            && (this.getGmtModified() == null ? other.getGmtModified() == null : this.getGmtModified().equals(other.getGmtModified()))
            && (this.getModifier() == null ? other.getModifier() == null : this.getModifier().equals(other.getModifier()))
            && (this.getModifierCode() == null ? other.getModifierCode() == null : this.getModifierCode().equals(other.getModifierCode()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getBak01() == null ? other.getBak01() == null : this.getBak01().equals(other.getBak01()))
            && (this.getBak02() == null ? other.getBak02() == null : this.getBak02().equals(other.getBak02()))
            && (this.getBak03() == null ? other.getBak03() == null : this.getBak03().equals(other.getBak03()))
            && (this.getBak04() == null ? other.getBak04() == null : this.getBak04().equals(other.getBak04()))
            && (this.getBak05() == null ? other.getBak05() == null : this.getBak05().equals(other.getBak05()));
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:59:20 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSystemFlag() == null) ? 0 : getSystemFlag().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getApplicationId() == null) ? 0 : getApplicationId().hashCode());
        result = prime * result + ((getApplicationName() == null) ? 0 : getApplicationName().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getAliasName() == null) ? 0 : getAliasName().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getPageUrl() == null) ? 0 : getPageUrl().hashCode());
        result = prime * result + ((getIcon() == null) ? 0 : getIcon().hashCode());
        result = prime * result + ((getPositionType() == null) ? 0 : getPositionType().hashCode());
        result = prime * result + ((getDisplay() == null) ? 0 : getDisplay().hashCode());
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreatorRoleId() == null) ? 0 : getCreatorRoleId().hashCode());
        result = prime * result + ((getCreatorCode() == null) ? 0 : getCreatorCode().hashCode());
        result = prime * result + ((getGmtModified() == null) ? 0 : getGmtModified().hashCode());
        result = prime * result + ((getModifier() == null) ? 0 : getModifier().hashCode());
        result = prime * result + ((getModifierCode() == null) ? 0 : getModifierCode().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getBak01() == null) ? 0 : getBak01().hashCode());
        result = prime * result + ((getBak02() == null) ? 0 : getBak02().hashCode());
        result = prime * result + ((getBak03() == null) ? 0 : getBak03().hashCode());
        result = prime * result + ((getBak04() == null) ? 0 : getBak04().hashCode());
        result = prime * result + ((getBak05() == null) ? 0 : getBak05().hashCode());
        return result;
    }
}