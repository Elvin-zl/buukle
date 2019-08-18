package top.buukle.security.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created By MBG-GUI-EXTENSION https:// github.com/spawpaw/mybatis-generator-gui-extension
 * Description:
 * buukle验签配置
 *
 * @author 
 */
public class BuukleSign implements Serializable {
    /**
     * 主键
     *
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    private Integer id;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    private String partnerName;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    private String partnerId;

    /**
     * 合作方类型
     *             0:外部
     *             1:内部用户
     *             2:内部应用
     *
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    private Integer partnerType;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    private Date partnerKeyValid;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    private Date partnerKeyEndvalid;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    private String description;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    private String remark;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    private Date gmtCreated;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    private String creator;

    /**
     * 创建者的角色id
     *
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    private Integer creatorRoleId;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    private String creatorCode;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    private Date gmtModified;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    private String modifier;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    private String modifierCode;

    /**
     * 状态
     *
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    private Integer status;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    private String bak01;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    private String bak02;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    private String bak03;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    private String bak04;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    private String bak05;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    private String partnerKey;

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column buukle-security-new..buukle_sign.id
     *
     * @return the value of buukle-security-new..buukle_sign.id
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public BuukleSign withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..buukle_sign.id
     *
     * @param id the value for buukle-security-new..buukle_sign.id
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column buukle-security-new..buukle_sign.partner_name
     *
     * @return the value of buukle-security-new..buukle_sign.partner_name
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public String getPartnerName() {
        return partnerName;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public BuukleSign withPartnerName(String partnerName) {
        this.setPartnerName(partnerName);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..buukle_sign.partner_name
     *
     * @param partnerName the value for buukle-security-new..buukle_sign.partner_name
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName == null ? null : partnerName.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..buukle_sign.partner_id
     *
     * @return the value of buukle-security-new..buukle_sign.partner_id
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public BuukleSign withPartnerId(String partnerId) {
        this.setPartnerId(partnerId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..buukle_sign.partner_id
     *
     * @param partnerId the value for buukle-security-new..buukle_sign.partner_id
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..buukle_sign.partner_type
     *
     * @return the value of buukle-security-new..buukle_sign.partner_type
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public Integer getPartnerType() {
        return partnerType;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public BuukleSign withPartnerType(Integer partnerType) {
        this.setPartnerType(partnerType);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..buukle_sign.partner_type
     *
     * @param partnerType the value for buukle-security-new..buukle_sign.partner_type
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public void setPartnerType(Integer partnerType) {
        this.partnerType = partnerType;
    }

    /**
     * This method returns the value of the database column buukle-security-new..buukle_sign.partner_key_valid
     *
     * @return the value of buukle-security-new..buukle_sign.partner_key_valid
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public Date getPartnerKeyValid() {
        return partnerKeyValid;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public BuukleSign withPartnerKeyValid(Date partnerKeyValid) {
        this.setPartnerKeyValid(partnerKeyValid);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..buukle_sign.partner_key_valid
     *
     * @param partnerKeyValid the value for buukle-security-new..buukle_sign.partner_key_valid
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public void setPartnerKeyValid(Date partnerKeyValid) {
        this.partnerKeyValid = partnerKeyValid;
    }

    /**
     * This method returns the value of the database column buukle-security-new..buukle_sign.partner_key_endvalid
     *
     * @return the value of buukle-security-new..buukle_sign.partner_key_endvalid
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public Date getPartnerKeyEndvalid() {
        return partnerKeyEndvalid;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public BuukleSign withPartnerKeyEndvalid(Date partnerKeyEndvalid) {
        this.setPartnerKeyEndvalid(partnerKeyEndvalid);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..buukle_sign.partner_key_endvalid
     *
     * @param partnerKeyEndvalid the value for buukle-security-new..buukle_sign.partner_key_endvalid
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public void setPartnerKeyEndvalid(Date partnerKeyEndvalid) {
        this.partnerKeyEndvalid = partnerKeyEndvalid;
    }

    /**
     * This method returns the value of the database column buukle-security-new..buukle_sign.description
     *
     * @return the value of buukle-security-new..buukle_sign.description
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public BuukleSign withDescription(String description) {
        this.setDescription(description);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..buukle_sign.description
     *
     * @param description the value for buukle-security-new..buukle_sign.description
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..buukle_sign.remark
     *
     * @return the value of buukle-security-new..buukle_sign.remark
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public String getRemark() {
        return remark;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public BuukleSign withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..buukle_sign.remark
     *
     * @param remark the value for buukle-security-new..buukle_sign.remark
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..buukle_sign.gmt_created
     *
     * @return the value of buukle-security-new..buukle_sign.gmt_created
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public Date getGmtCreated() {
        return gmtCreated;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public BuukleSign withGmtCreated(Date gmtCreated) {
        this.setGmtCreated(gmtCreated);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..buukle_sign.gmt_created
     *
     * @param gmtCreated the value for buukle-security-new..buukle_sign.gmt_created
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**
     * This method returns the value of the database column buukle-security-new..buukle_sign.creator
     *
     * @return the value of buukle-security-new..buukle_sign.creator
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public String getCreator() {
        return creator;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public BuukleSign withCreator(String creator) {
        this.setCreator(creator);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..buukle_sign.creator
     *
     * @param creator the value for buukle-security-new..buukle_sign.creator
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..buukle_sign.creator_role_id
     *
     * @return the value of buukle-security-new..buukle_sign.creator_role_id
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public Integer getCreatorRoleId() {
        return creatorRoleId;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public BuukleSign withCreatorRoleId(Integer creatorRoleId) {
        this.setCreatorRoleId(creatorRoleId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..buukle_sign.creator_role_id
     *
     * @param creatorRoleId the value for buukle-security-new..buukle_sign.creator_role_id
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public void setCreatorRoleId(Integer creatorRoleId) {
        this.creatorRoleId = creatorRoleId;
    }

    /**
     * This method returns the value of the database column buukle-security-new..buukle_sign.creator_code
     *
     * @return the value of buukle-security-new..buukle_sign.creator_code
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public String getCreatorCode() {
        return creatorCode;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public BuukleSign withCreatorCode(String creatorCode) {
        this.setCreatorCode(creatorCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..buukle_sign.creator_code
     *
     * @param creatorCode the value for buukle-security-new..buukle_sign.creator_code
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode == null ? null : creatorCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..buukle_sign.gmt_modified
     *
     * @return the value of buukle-security-new..buukle_sign.gmt_modified
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public BuukleSign withGmtModified(Date gmtModified) {
        this.setGmtModified(gmtModified);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..buukle_sign.gmt_modified
     *
     * @param gmtModified the value for buukle-security-new..buukle_sign.gmt_modified
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method returns the value of the database column buukle-security-new..buukle_sign.modifier
     *
     * @return the value of buukle-security-new..buukle_sign.modifier
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public String getModifier() {
        return modifier;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public BuukleSign withModifier(String modifier) {
        this.setModifier(modifier);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..buukle_sign.modifier
     *
     * @param modifier the value for buukle-security-new..buukle_sign.modifier
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..buukle_sign.modifier_code
     *
     * @return the value of buukle-security-new..buukle_sign.modifier_code
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public String getModifierCode() {
        return modifierCode;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public BuukleSign withModifierCode(String modifierCode) {
        this.setModifierCode(modifierCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..buukle_sign.modifier_code
     *
     * @param modifierCode the value for buukle-security-new..buukle_sign.modifier_code
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public void setModifierCode(String modifierCode) {
        this.modifierCode = modifierCode == null ? null : modifierCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..buukle_sign.status
     *
     * @return the value of buukle-security-new..buukle_sign.status
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public BuukleSign withStatus(Integer status) {
        this.setStatus(status);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..buukle_sign.status
     *
     * @param status the value for buukle-security-new..buukle_sign.status
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column buukle-security-new..buukle_sign.bak01
     *
     * @return the value of buukle-security-new..buukle_sign.bak01
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public String getBak01() {
        return bak01;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public BuukleSign withBak01(String bak01) {
        this.setBak01(bak01);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..buukle_sign.bak01
     *
     * @param bak01 the value for buukle-security-new..buukle_sign.bak01
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public void setBak01(String bak01) {
        this.bak01 = bak01 == null ? null : bak01.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..buukle_sign.bak02
     *
     * @return the value of buukle-security-new..buukle_sign.bak02
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public String getBak02() {
        return bak02;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public BuukleSign withBak02(String bak02) {
        this.setBak02(bak02);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..buukle_sign.bak02
     *
     * @param bak02 the value for buukle-security-new..buukle_sign.bak02
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public void setBak02(String bak02) {
        this.bak02 = bak02 == null ? null : bak02.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..buukle_sign.bak03
     *
     * @return the value of buukle-security-new..buukle_sign.bak03
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public String getBak03() {
        return bak03;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public BuukleSign withBak03(String bak03) {
        this.setBak03(bak03);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..buukle_sign.bak03
     *
     * @param bak03 the value for buukle-security-new..buukle_sign.bak03
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public void setBak03(String bak03) {
        this.bak03 = bak03 == null ? null : bak03.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..buukle_sign.bak04
     *
     * @return the value of buukle-security-new..buukle_sign.bak04
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public String getBak04() {
        return bak04;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public BuukleSign withBak04(String bak04) {
        this.setBak04(bak04);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..buukle_sign.bak04
     *
     * @param bak04 the value for buukle-security-new..buukle_sign.bak04
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public void setBak04(String bak04) {
        this.bak04 = bak04 == null ? null : bak04.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..buukle_sign.bak05
     *
     * @return the value of buukle-security-new..buukle_sign.bak05
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public String getBak05() {
        return bak05;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public BuukleSign withBak05(String bak05) {
        this.setBak05(bak05);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..buukle_sign.bak05
     *
     * @param bak05 the value for buukle-security-new..buukle_sign.bak05
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public void setBak05(String bak05) {
        this.bak05 = bak05 == null ? null : bak05.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..buukle_sign.partner_key
     *
     * @return the value of buukle-security-new..buukle_sign.partner_key
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public String getPartnerKey() {
        return partnerKey;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public BuukleSign withPartnerKey(String partnerKey) {
        this.setPartnerKey(partnerKey);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..buukle_sign.partner_key
     *
     * @param partnerKey the value for buukle-security-new..buukle_sign.partner_key
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    public void setPartnerKey(String partnerKey) {
        this.partnerKey = partnerKey == null ? null : partnerKey.trim();
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", partnerName=").append(partnerName);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", partnerType=").append(partnerType);
        sb.append(", partnerKeyValid=").append(partnerKeyValid);
        sb.append(", partnerKeyEndvalid=").append(partnerKeyEndvalid);
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
        sb.append(", partnerKey=").append(partnerKey);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
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
        BuukleSign other = (BuukleSign) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPartnerName() == null ? other.getPartnerName() == null : this.getPartnerName().equals(other.getPartnerName()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPartnerType() == null ? other.getPartnerType() == null : this.getPartnerType().equals(other.getPartnerType()))
            && (this.getPartnerKeyValid() == null ? other.getPartnerKeyValid() == null : this.getPartnerKeyValid().equals(other.getPartnerKeyValid()))
            && (this.getPartnerKeyEndvalid() == null ? other.getPartnerKeyEndvalid() == null : this.getPartnerKeyEndvalid().equals(other.getPartnerKeyEndvalid()))
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
            && (this.getBak05() == null ? other.getBak05() == null : this.getBak05().equals(other.getBak05()))
            && (this.getPartnerKey() == null ? other.getPartnerKey() == null : this.getPartnerKey().equals(other.getPartnerKey()));
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:09 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPartnerName() == null) ? 0 : getPartnerName().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPartnerType() == null) ? 0 : getPartnerType().hashCode());
        result = prime * result + ((getPartnerKeyValid() == null) ? 0 : getPartnerKeyValid().hashCode());
        result = prime * result + ((getPartnerKeyEndvalid() == null) ? 0 : getPartnerKeyEndvalid().hashCode());
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
        result = prime * result + ((getPartnerKey() == null) ? 0 : getPartnerKey().hashCode());
        return result;
    }
}