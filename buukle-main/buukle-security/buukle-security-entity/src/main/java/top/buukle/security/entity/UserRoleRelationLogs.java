package top.buukle.security.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created By MBG-GUI-EXTENSION https:// github.com/spawpaw/mybatis-generator-gui-extension
 * Description:
 * 用户角色日志表
 *
 * @author 
 */
public class UserRoleRelationLogs implements Serializable {
    /**
     * 主键id
     *
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    private Integer id;

    /**
     * 应用id
     *
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    private Integer applicationId;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    private String userId;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    private String roleIdCollection;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    private String description;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    private String remark;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    private Date gmtCreated;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    private String creator;

    /**
     * 创建者的角色id
     *
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    private Integer creatorRoleId;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    private String creatorCode;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    private Date gmtModified;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    private String modifier;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    private String modifierCode;

    /**
     * 状态
     *
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    private Integer status;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    private String bak01;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    private String bak02;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    private String bak03;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    private String bak04;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    private String bak05;

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column buukle-security-new..user_role_relation_logs.id
     *
     * @return the value of buukle-security-new..user_role_relation_logs.id
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public UserRoleRelationLogs withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..user_role_relation_logs.id
     *
     * @param id the value for buukle-security-new..user_role_relation_logs.id
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column buukle-security-new..user_role_relation_logs.application_id
     *
     * @return the value of buukle-security-new..user_role_relation_logs.application_id
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public Integer getApplicationId() {
        return applicationId;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public UserRoleRelationLogs withApplicationId(Integer applicationId) {
        this.setApplicationId(applicationId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..user_role_relation_logs.application_id
     *
     * @param applicationId the value for buukle-security-new..user_role_relation_logs.application_id
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    /**
     * This method returns the value of the database column buukle-security-new..user_role_relation_logs.user_id
     *
     * @return the value of buukle-security-new..user_role_relation_logs.user_id
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public String getUserId() {
        return userId;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public UserRoleRelationLogs withUserId(String userId) {
        this.setUserId(userId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..user_role_relation_logs.user_id
     *
     * @param userId the value for buukle-security-new..user_role_relation_logs.user_id
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..user_role_relation_logs.role_id_collection
     *
     * @return the value of buukle-security-new..user_role_relation_logs.role_id_collection
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public String getRoleIdCollection() {
        return roleIdCollection;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public UserRoleRelationLogs withRoleIdCollection(String roleIdCollection) {
        this.setRoleIdCollection(roleIdCollection);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..user_role_relation_logs.role_id_collection
     *
     * @param roleIdCollection the value for buukle-security-new..user_role_relation_logs.role_id_collection
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public void setRoleIdCollection(String roleIdCollection) {
        this.roleIdCollection = roleIdCollection == null ? null : roleIdCollection.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..user_role_relation_logs.description
     *
     * @return the value of buukle-security-new..user_role_relation_logs.description
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public UserRoleRelationLogs withDescription(String description) {
        this.setDescription(description);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..user_role_relation_logs.description
     *
     * @param description the value for buukle-security-new..user_role_relation_logs.description
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..user_role_relation_logs.remark
     *
     * @return the value of buukle-security-new..user_role_relation_logs.remark
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public String getRemark() {
        return remark;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public UserRoleRelationLogs withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..user_role_relation_logs.remark
     *
     * @param remark the value for buukle-security-new..user_role_relation_logs.remark
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..user_role_relation_logs.gmt_created
     *
     * @return the value of buukle-security-new..user_role_relation_logs.gmt_created
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public Date getGmtCreated() {
        return gmtCreated;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public UserRoleRelationLogs withGmtCreated(Date gmtCreated) {
        this.setGmtCreated(gmtCreated);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..user_role_relation_logs.gmt_created
     *
     * @param gmtCreated the value for buukle-security-new..user_role_relation_logs.gmt_created
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**
     * This method returns the value of the database column buukle-security-new..user_role_relation_logs.creator
     *
     * @return the value of buukle-security-new..user_role_relation_logs.creator
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public String getCreator() {
        return creator;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public UserRoleRelationLogs withCreator(String creator) {
        this.setCreator(creator);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..user_role_relation_logs.creator
     *
     * @param creator the value for buukle-security-new..user_role_relation_logs.creator
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..user_role_relation_logs.creator_role_id
     *
     * @return the value of buukle-security-new..user_role_relation_logs.creator_role_id
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public Integer getCreatorRoleId() {
        return creatorRoleId;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public UserRoleRelationLogs withCreatorRoleId(Integer creatorRoleId) {
        this.setCreatorRoleId(creatorRoleId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..user_role_relation_logs.creator_role_id
     *
     * @param creatorRoleId the value for buukle-security-new..user_role_relation_logs.creator_role_id
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public void setCreatorRoleId(Integer creatorRoleId) {
        this.creatorRoleId = creatorRoleId;
    }

    /**
     * This method returns the value of the database column buukle-security-new..user_role_relation_logs.creator_code
     *
     * @return the value of buukle-security-new..user_role_relation_logs.creator_code
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public String getCreatorCode() {
        return creatorCode;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public UserRoleRelationLogs withCreatorCode(String creatorCode) {
        this.setCreatorCode(creatorCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..user_role_relation_logs.creator_code
     *
     * @param creatorCode the value for buukle-security-new..user_role_relation_logs.creator_code
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode == null ? null : creatorCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..user_role_relation_logs.gmt_modified
     *
     * @return the value of buukle-security-new..user_role_relation_logs.gmt_modified
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public UserRoleRelationLogs withGmtModified(Date gmtModified) {
        this.setGmtModified(gmtModified);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..user_role_relation_logs.gmt_modified
     *
     * @param gmtModified the value for buukle-security-new..user_role_relation_logs.gmt_modified
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method returns the value of the database column buukle-security-new..user_role_relation_logs.modifier
     *
     * @return the value of buukle-security-new..user_role_relation_logs.modifier
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public String getModifier() {
        return modifier;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public UserRoleRelationLogs withModifier(String modifier) {
        this.setModifier(modifier);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..user_role_relation_logs.modifier
     *
     * @param modifier the value for buukle-security-new..user_role_relation_logs.modifier
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..user_role_relation_logs.modifier_code
     *
     * @return the value of buukle-security-new..user_role_relation_logs.modifier_code
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public String getModifierCode() {
        return modifierCode;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public UserRoleRelationLogs withModifierCode(String modifierCode) {
        this.setModifierCode(modifierCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..user_role_relation_logs.modifier_code
     *
     * @param modifierCode the value for buukle-security-new..user_role_relation_logs.modifier_code
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public void setModifierCode(String modifierCode) {
        this.modifierCode = modifierCode == null ? null : modifierCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..user_role_relation_logs.status
     *
     * @return the value of buukle-security-new..user_role_relation_logs.status
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public UserRoleRelationLogs withStatus(Integer status) {
        this.setStatus(status);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..user_role_relation_logs.status
     *
     * @param status the value for buukle-security-new..user_role_relation_logs.status
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column buukle-security-new..user_role_relation_logs.bak01
     *
     * @return the value of buukle-security-new..user_role_relation_logs.bak01
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public String getBak01() {
        return bak01;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public UserRoleRelationLogs withBak01(String bak01) {
        this.setBak01(bak01);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..user_role_relation_logs.bak01
     *
     * @param bak01 the value for buukle-security-new..user_role_relation_logs.bak01
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public void setBak01(String bak01) {
        this.bak01 = bak01 == null ? null : bak01.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..user_role_relation_logs.bak02
     *
     * @return the value of buukle-security-new..user_role_relation_logs.bak02
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public String getBak02() {
        return bak02;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public UserRoleRelationLogs withBak02(String bak02) {
        this.setBak02(bak02);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..user_role_relation_logs.bak02
     *
     * @param bak02 the value for buukle-security-new..user_role_relation_logs.bak02
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public void setBak02(String bak02) {
        this.bak02 = bak02 == null ? null : bak02.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..user_role_relation_logs.bak03
     *
     * @return the value of buukle-security-new..user_role_relation_logs.bak03
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public String getBak03() {
        return bak03;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public UserRoleRelationLogs withBak03(String bak03) {
        this.setBak03(bak03);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..user_role_relation_logs.bak03
     *
     * @param bak03 the value for buukle-security-new..user_role_relation_logs.bak03
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public void setBak03(String bak03) {
        this.bak03 = bak03 == null ? null : bak03.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..user_role_relation_logs.bak04
     *
     * @return the value of buukle-security-new..user_role_relation_logs.bak04
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public String getBak04() {
        return bak04;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public UserRoleRelationLogs withBak04(String bak04) {
        this.setBak04(bak04);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..user_role_relation_logs.bak04
     *
     * @param bak04 the value for buukle-security-new..user_role_relation_logs.bak04
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public void setBak04(String bak04) {
        this.bak04 = bak04 == null ? null : bak04.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..user_role_relation_logs.bak05
     *
     * @return the value of buukle-security-new..user_role_relation_logs.bak05
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public String getBak05() {
        return bak05;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public UserRoleRelationLogs withBak05(String bak05) {
        this.setBak05(bak05);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..user_role_relation_logs.bak05
     *
     * @param bak05 the value for buukle-security-new..user_role_relation_logs.bak05
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    public void setBak05(String bak05) {
        this.bak05 = bak05 == null ? null : bak05.trim();
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", applicationId=").append(applicationId);
        sb.append(", userId=").append(userId);
        sb.append(", roleIdCollection=").append(roleIdCollection);
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
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
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
        UserRoleRelationLogs other = (UserRoleRelationLogs) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getApplicationId() == null ? other.getApplicationId() == null : this.getApplicationId().equals(other.getApplicationId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getRoleIdCollection() == null ? other.getRoleIdCollection() == null : this.getRoleIdCollection().equals(other.getRoleIdCollection()))
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
     * @mbg.generated Sun Aug 18 22:53:11 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getApplicationId() == null) ? 0 : getApplicationId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getRoleIdCollection() == null) ? 0 : getRoleIdCollection().hashCode());
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