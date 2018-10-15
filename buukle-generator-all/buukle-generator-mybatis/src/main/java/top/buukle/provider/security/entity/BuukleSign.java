package top.buukle.provider.security.entity;

import java.util.Date;

public class BuukleSign {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 外键-应用名
     */
    private String applicationName;

    /**
     * 合作方id
     */
    private String partnerId;

    /**
     * 合作方类型
            0:外部
            1:内部
     */
    private Integer partnerType;

    /**
     * 验签方式
     */
    private String signType;

    /**
     * 密钥生效日期
            格式:2016-01-01
     */
    private Date partnerKeyValid;

    /**
     * 密钥失效日期
            格式:2016-01-01
     */
    private Date partnerKeyEndvalid;

    /**
     * 状态
            0 启用
            1 未启用
     */
    private Integer status;

    /**
     * 创建人名称
     */
    private String creator;

    /**
     * 创建人代码
     */
    private String creatorNo;

    /**
     * 创建人类型
            0 pid创建
            1 代理创建
     */
    private String creatorType;

    /**
     * 创建时间
     */
    private Date gmtCreated;

    /**
     * 修改人名称
     */
    private String modifier;

    /**
     * 修改人代码
     */
    private String modifierNo;

    /**
     * 修改人类型
            0 pid创建
            1 代理创建
     */
    private String modifierType;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * 备注
     */
    private String remark;

    /**
     * 合作方公钥
     */
    private String partnerKey;

    /**
     * 主键
     * @return id 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 外键-应用名
     * @return application_name 外键-应用名
     */
    public String getApplicationName() {
        return applicationName;
    }

    /**
     * 外键-应用名
     * @param applicationName 外键-应用名
     */
    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName == null ? null : applicationName.trim();
    }

    /**
     * 合作方id
     * @return partner_id 合作方id
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 合作方id
     * @param partnerId 合作方id
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * 合作方类型
            0:外部
            1:内部
     * @return partner_type 合作方类型
            0:外部
            1:内部
     */
    public Integer getPartnerType() {
        return partnerType;
    }

    /**
     * 合作方类型
            0:外部
            1:内部
     * @param partnerType 合作方类型
            0:外部
            1:内部
     */
    public void setPartnerType(Integer partnerType) {
        this.partnerType = partnerType;
    }

    /**
     * 验签方式
     * @return sign_type 验签方式
     */
    public String getSignType() {
        return signType;
    }

    /**
     * 验签方式
     * @param signType 验签方式
     */
    public void setSignType(String signType) {
        this.signType = signType == null ? null : signType.trim();
    }

    /**
     * 密钥生效日期
            格式:2016-01-01
     * @return partner_key_valid 密钥生效日期
            格式:2016-01-01
     */
    public Date getPartnerKeyValid() {
        return partnerKeyValid;
    }

    /**
     * 密钥生效日期
            格式:2016-01-01
     * @param partnerKeyValid 密钥生效日期
            格式:2016-01-01
     */
    public void setPartnerKeyValid(Date partnerKeyValid) {
        this.partnerKeyValid = partnerKeyValid;
    }

    /**
     * 密钥失效日期
            格式:2016-01-01
     * @return partner_key_endvalid 密钥失效日期
            格式:2016-01-01
     */
    public Date getPartnerKeyEndvalid() {
        return partnerKeyEndvalid;
    }

    /**
     * 密钥失效日期
            格式:2016-01-01
     * @param partnerKeyEndvalid 密钥失效日期
            格式:2016-01-01
     */
    public void setPartnerKeyEndvalid(Date partnerKeyEndvalid) {
        this.partnerKeyEndvalid = partnerKeyEndvalid;
    }

    /**
     * 状态
            0 启用
            1 未启用
     * @return status 状态
            0 启用
            1 未启用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态
            0 启用
            1 未启用
     * @param status 状态
            0 启用
            1 未启用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 创建人名称
     * @return creator 创建人名称
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 创建人名称
     * @param creator 创建人名称
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * 创建人代码
     * @return creator_no 创建人代码
     */
    public String getCreatorNo() {
        return creatorNo;
    }

    /**
     * 创建人代码
     * @param creatorNo 创建人代码
     */
    public void setCreatorNo(String creatorNo) {
        this.creatorNo = creatorNo == null ? null : creatorNo.trim();
    }

    /**
     * 创建人类型
            0 pid创建
            1 代理创建
     * @return creator_type 创建人类型
            0 pid创建
            1 代理创建
     */
    public String getCreatorType() {
        return creatorType;
    }

    /**
     * 创建人类型
            0 pid创建
            1 代理创建
     * @param creatorType 创建人类型
            0 pid创建
            1 代理创建
     */
    public void setCreatorType(String creatorType) {
        this.creatorType = creatorType == null ? null : creatorType.trim();
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
     * 修改人名称
     * @return modifier 修改人名称
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 修改人名称
     * @param modifier 修改人名称
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * 修改人代码
     * @return modifier_no 修改人代码
     */
    public String getModifierNo() {
        return modifierNo;
    }

    /**
     * 修改人代码
     * @param modifierNo 修改人代码
     */
    public void setModifierNo(String modifierNo) {
        this.modifierNo = modifierNo == null ? null : modifierNo.trim();
    }

    /**
     * 修改人类型
            0 pid创建
            1 代理创建
     * @return modifier_type 修改人类型
            0 pid创建
            1 代理创建
     */
    public String getModifierType() {
        return modifierType;
    }

    /**
     * 修改人类型
            0 pid创建
            1 代理创建
     * @param modifierType 修改人类型
            0 pid创建
            1 代理创建
     */
    public void setModifierType(String modifierType) {
        this.modifierType = modifierType == null ? null : modifierType.trim();
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
     * 备注
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 合作方公钥
     * @return partner_key 合作方公钥
     */
    public String getPartnerKey() {
        return partnerKey;
    }

    /**
     * 合作方公钥
     * @param partnerKey 合作方公钥
     */
    public void setPartnerKey(String partnerKey) {
        this.partnerKey = partnerKey == null ? null : partnerKey.trim();
    }
}