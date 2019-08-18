package top.buukle.security.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created By MBG-GUI-EXTENSION https:// github.com/spawpaw/mybatis-generator-gui-extension
 * Description:
 * 角色表
 *
 * @author 
 */
public class Role implements Serializable {
    /**
     * 主键id
     *
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    private Integer id;

    /**
     * 上级角色id
     *
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    private Integer pid;

    /**
     * 是否是系统守护 0 : 否 1: 是
     *
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    private Integer systemFlag;

    /**
     * 所属应用id
     *
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    private Integer applicationId;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    private String applicationName;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    private String roleName;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    private String description;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    private String remark;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    private Date gmtCreated;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    private String creator;

    /**
     * 创建者的角色id
     *
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    private Integer creatorRoleId;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    private String creatorCode;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    private Date gmtModified;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    private String modifier;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    private String modifierCode;

    /**
     * 状态
     *
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    private Integer status;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    private String bak01;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    private String bak02;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    private String bak03;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    private String bak04;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    private String bak05;

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column buukle-security-new..role.id
     *
     * @return the value of buukle-security-new..role.id
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public Role withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..role.id
     *
     * @param id the value for buukle-security-new..role.id
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column buukle-security-new..role.pid
     *
     * @return the value of buukle-security-new..role.pid
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public Integer getPid() {
        return pid;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public Role withPid(Integer pid) {
        this.setPid(pid);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..role.pid
     *
     * @param pid the value for buukle-security-new..role.pid
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * This method returns the value of the database column buukle-security-new..role.system_flag
     *
     * @return the value of buukle-security-new..role.system_flag
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public Integer getSystemFlag() {
        return systemFlag;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public Role withSystemFlag(Integer systemFlag) {
        this.setSystemFlag(systemFlag);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..role.system_flag
     *
     * @param systemFlag the value for buukle-security-new..role.system_flag
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public void setSystemFlag(Integer systemFlag) {
        this.systemFlag = systemFlag;
    }

    /**
     * This method returns the value of the database column buukle-security-new..role.application_id
     *
     * @return the value of buukle-security-new..role.application_id
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public Integer getApplicationId() {
        return applicationId;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public Role withApplicationId(Integer applicationId) {
        this.setApplicationId(applicationId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..role.application_id
     *
     * @param applicationId the value for buukle-security-new..role.application_id
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    /**
     * This method returns the value of the database column buukle-security-new..role.application_name
     *
     * @return the value of buukle-security-new..role.application_name
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public String getApplicationName() {
        return applicationName;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public Role withApplicationName(String applicationName) {
        this.setApplicationName(applicationName);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..role.application_name
     *
     * @param applicationName the value for buukle-security-new..role.application_name
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName == null ? null : applicationName.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..role.role_name
     *
     * @return the value of buukle-security-new..role.role_name
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public Role withRoleName(String roleName) {
        this.setRoleName(roleName);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..role.role_name
     *
     * @param roleName the value for buukle-security-new..role.role_name
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..role.description
     *
     * @return the value of buukle-security-new..role.description
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public Role withDescription(String description) {
        this.setDescription(description);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..role.description
     *
     * @param description the value for buukle-security-new..role.description
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..role.remark
     *
     * @return the value of buukle-security-new..role.remark
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public String getRemark() {
        return remark;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public Role withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..role.remark
     *
     * @param remark the value for buukle-security-new..role.remark
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..role.gmt_created
     *
     * @return the value of buukle-security-new..role.gmt_created
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public Date getGmtCreated() {
        return gmtCreated;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public Role withGmtCreated(Date gmtCreated) {
        this.setGmtCreated(gmtCreated);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..role.gmt_created
     *
     * @param gmtCreated the value for buukle-security-new..role.gmt_created
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**
     * This method returns the value of the database column buukle-security-new..role.creator
     *
     * @return the value of buukle-security-new..role.creator
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public String getCreator() {
        return creator;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public Role withCreator(String creator) {
        this.setCreator(creator);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..role.creator
     *
     * @param creator the value for buukle-security-new..role.creator
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..role.creator_role_id
     *
     * @return the value of buukle-security-new..role.creator_role_id
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public Integer getCreatorRoleId() {
        return creatorRoleId;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public Role withCreatorRoleId(Integer creatorRoleId) {
        this.setCreatorRoleId(creatorRoleId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..role.creator_role_id
     *
     * @param creatorRoleId the value for buukle-security-new..role.creator_role_id
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public void setCreatorRoleId(Integer creatorRoleId) {
        this.creatorRoleId = creatorRoleId;
    }

    /**
     * This method returns the value of the database column buukle-security-new..role.creator_code
     *
     * @return the value of buukle-security-new..role.creator_code
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public String getCreatorCode() {
        return creatorCode;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public Role withCreatorCode(String creatorCode) {
        this.setCreatorCode(creatorCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..role.creator_code
     *
     * @param creatorCode the value for buukle-security-new..role.creator_code
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode == null ? null : creatorCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..role.gmt_modified
     *
     * @return the value of buukle-security-new..role.gmt_modified
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public Role withGmtModified(Date gmtModified) {
        this.setGmtModified(gmtModified);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..role.gmt_modified
     *
     * @param gmtModified the value for buukle-security-new..role.gmt_modified
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method returns the value of the database column buukle-security-new..role.modifier
     *
     * @return the value of buukle-security-new..role.modifier
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public String getModifier() {
        return modifier;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public Role withModifier(String modifier) {
        this.setModifier(modifier);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..role.modifier
     *
     * @param modifier the value for buukle-security-new..role.modifier
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..role.modifier_code
     *
     * @return the value of buukle-security-new..role.modifier_code
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public String getModifierCode() {
        return modifierCode;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public Role withModifierCode(String modifierCode) {
        this.setModifierCode(modifierCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..role.modifier_code
     *
     * @param modifierCode the value for buukle-security-new..role.modifier_code
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public void setModifierCode(String modifierCode) {
        this.modifierCode = modifierCode == null ? null : modifierCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..role.status
     *
     * @return the value of buukle-security-new..role.status
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public Role withStatus(Integer status) {
        this.setStatus(status);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..role.status
     *
     * @param status the value for buukle-security-new..role.status
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column buukle-security-new..role.bak01
     *
     * @return the value of buukle-security-new..role.bak01
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public String getBak01() {
        return bak01;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public Role withBak01(String bak01) {
        this.setBak01(bak01);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..role.bak01
     *
     * @param bak01 the value for buukle-security-new..role.bak01
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public void setBak01(String bak01) {
        this.bak01 = bak01 == null ? null : bak01.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..role.bak02
     *
     * @return the value of buukle-security-new..role.bak02
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public String getBak02() {
        return bak02;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public Role withBak02(String bak02) {
        this.setBak02(bak02);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..role.bak02
     *
     * @param bak02 the value for buukle-security-new..role.bak02
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public void setBak02(String bak02) {
        this.bak02 = bak02 == null ? null : bak02.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..role.bak03
     *
     * @return the value of buukle-security-new..role.bak03
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public String getBak03() {
        return bak03;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public Role withBak03(String bak03) {
        this.setBak03(bak03);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..role.bak03
     *
     * @param bak03 the value for buukle-security-new..role.bak03
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public void setBak03(String bak03) {
        this.bak03 = bak03 == null ? null : bak03.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..role.bak04
     *
     * @return the value of buukle-security-new..role.bak04
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public String getBak04() {
        return bak04;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public Role withBak04(String bak04) {
        this.setBak04(bak04);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..role.bak04
     *
     * @param bak04 the value for buukle-security-new..role.bak04
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public void setBak04(String bak04) {
        this.bak04 = bak04 == null ? null : bak04.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..role.bak05
     *
     * @return the value of buukle-security-new..role.bak05
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public String getBak05() {
        return bak05;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public Role withBak05(String bak05) {
        this.setBak05(bak05);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..role.bak05
     *
     * @param bak05 the value for buukle-security-new..role.bak05
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public void setBak05(String bak05) {
        this.bak05 = bak05 == null ? null : bak05.trim();
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pid=").append(pid);
        sb.append(", systemFlag=").append(systemFlag);
        sb.append(", applicationId=").append(applicationId);
        sb.append(", applicationName=").append(applicationName);
        sb.append(", roleName=").append(roleName);
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
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
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
        Role other = (Role) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getSystemFlag() == null ? other.getSystemFlag() == null : this.getSystemFlag().equals(other.getSystemFlag()))
            && (this.getApplicationId() == null ? other.getApplicationId() == null : this.getApplicationId().equals(other.getApplicationId()))
            && (this.getApplicationName() == null ? other.getApplicationName() == null : this.getApplicationName().equals(other.getApplicationName()))
            && (this.getRoleName() == null ? other.getRoleName() == null : this.getRoleName().equals(other.getRoleName()))
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
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getSystemFlag() == null) ? 0 : getSystemFlag().hashCode());
        result = prime * result + ((getApplicationId() == null) ? 0 : getApplicationId().hashCode());
        result = prime * result + ((getApplicationName() == null) ? 0 : getApplicationName().hashCode());
        result = prime * result + ((getRoleName() == null) ? 0 : getRoleName().hashCode());
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