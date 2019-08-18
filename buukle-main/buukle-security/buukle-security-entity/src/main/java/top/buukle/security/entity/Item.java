package top.buukle.security.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created By MBG-GUI-EXTENSION https:// github.com/spawpaw/mybatis-generator-gui-extension
 * Description:
 * 商品表
 *
 * @author 
 */
public class Item implements Serializable {
    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    private Integer id;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    private String uuid;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    private String skuid;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    private String skuname;

    /**
     * 业务类型
     *
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    private Integer biztype;

    /**
     * 产品类型
     *
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    private Integer productid;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    private String merchantid;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    private String merchantname;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    private String thirdcode;

    /**
     * 售卖状态
     *
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    private Integer itemstatus;

    /**
     * 审核状态
     *
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    private Integer auditstatus;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    private String pin;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    private Date fundcloseenddate;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    private Date fundclosebegindate;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    private Date fundraisingbegindate;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    private Date fundraisingenddate;

    /**
     * 版本
     *
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    private Integer version;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    private String remark;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    private Date gmtCreated;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    private String creator;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    private String creatorCode;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    private Date gmtModified;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    private String modifier;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    private String modifierCode;

    /**
     * 状态
     *
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    private Integer status;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    private String bak06;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    private String bak07;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    private String bak08;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    private String bak09;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    private String bak10;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    private String bak01;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    private String bak02;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    private String bak03;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    private String bak04;

    /**
     *
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    private String bak05;

    /**
     * 详情
     *
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    private String detail;

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column buukle-security-new..item.id
     *
     * @return the value of buukle-security-new..item.id
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Item withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..item.id
     *
     * @param id the value for buukle-security-new..item.id
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column buukle-security-new..item.uuid
     *
     * @return the value of buukle-security-new..item.uuid
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public String getUuid() {
        return uuid;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Item withUuid(String uuid) {
        this.setUuid(uuid);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..item.uuid
     *
     * @param uuid the value for buukle-security-new..item.uuid
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..item.skuId
     *
     * @return the value of buukle-security-new..item.skuId
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public String getSkuid() {
        return skuid;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Item withSkuid(String skuid) {
        this.setSkuid(skuid);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..item.skuId
     *
     * @param skuid the value for buukle-security-new..item.skuId
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void setSkuid(String skuid) {
        this.skuid = skuid == null ? null : skuid.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..item.skuName
     *
     * @return the value of buukle-security-new..item.skuName
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public String getSkuname() {
        return skuname;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Item withSkuname(String skuname) {
        this.setSkuname(skuname);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..item.skuName
     *
     * @param skuname the value for buukle-security-new..item.skuName
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void setSkuname(String skuname) {
        this.skuname = skuname == null ? null : skuname.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..item.bizType
     *
     * @return the value of buukle-security-new..item.bizType
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Integer getBiztype() {
        return biztype;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Item withBiztype(Integer biztype) {
        this.setBiztype(biztype);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..item.bizType
     *
     * @param biztype the value for buukle-security-new..item.bizType
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void setBiztype(Integer biztype) {
        this.biztype = biztype;
    }

    /**
     * This method returns the value of the database column buukle-security-new..item.productId
     *
     * @return the value of buukle-security-new..item.productId
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Integer getProductid() {
        return productid;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Item withProductid(Integer productid) {
        this.setProductid(productid);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..item.productId
     *
     * @param productid the value for buukle-security-new..item.productId
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    /**
     * This method returns the value of the database column buukle-security-new..item.merchantId
     *
     * @return the value of buukle-security-new..item.merchantId
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public String getMerchantid() {
        return merchantid;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Item withMerchantid(String merchantid) {
        this.setMerchantid(merchantid);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..item.merchantId
     *
     * @param merchantid the value for buukle-security-new..item.merchantId
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void setMerchantid(String merchantid) {
        this.merchantid = merchantid == null ? null : merchantid.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..item.merchantName
     *
     * @return the value of buukle-security-new..item.merchantName
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public String getMerchantname() {
        return merchantname;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Item withMerchantname(String merchantname) {
        this.setMerchantname(merchantname);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..item.merchantName
     *
     * @param merchantname the value for buukle-security-new..item.merchantName
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void setMerchantname(String merchantname) {
        this.merchantname = merchantname == null ? null : merchantname.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..item.thirdCode
     *
     * @return the value of buukle-security-new..item.thirdCode
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public String getThirdcode() {
        return thirdcode;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Item withThirdcode(String thirdcode) {
        this.setThirdcode(thirdcode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..item.thirdCode
     *
     * @param thirdcode the value for buukle-security-new..item.thirdCode
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void setThirdcode(String thirdcode) {
        this.thirdcode = thirdcode == null ? null : thirdcode.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..item.itemStatus
     *
     * @return the value of buukle-security-new..item.itemStatus
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Integer getItemstatus() {
        return itemstatus;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Item withItemstatus(Integer itemstatus) {
        this.setItemstatus(itemstatus);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..item.itemStatus
     *
     * @param itemstatus the value for buukle-security-new..item.itemStatus
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void setItemstatus(Integer itemstatus) {
        this.itemstatus = itemstatus;
    }

    /**
     * This method returns the value of the database column buukle-security-new..item.auditStatus
     *
     * @return the value of buukle-security-new..item.auditStatus
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Integer getAuditstatus() {
        return auditstatus;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Item withAuditstatus(Integer auditstatus) {
        this.setAuditstatus(auditstatus);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..item.auditStatus
     *
     * @param auditstatus the value for buukle-security-new..item.auditStatus
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void setAuditstatus(Integer auditstatus) {
        this.auditstatus = auditstatus;
    }

    /**
     * This method returns the value of the database column buukle-security-new..item.pin
     *
     * @return the value of buukle-security-new..item.pin
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public String getPin() {
        return pin;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Item withPin(String pin) {
        this.setPin(pin);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..item.pin
     *
     * @param pin the value for buukle-security-new..item.pin
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void setPin(String pin) {
        this.pin = pin == null ? null : pin.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..item.fundCloseEndDate
     *
     * @return the value of buukle-security-new..item.fundCloseEndDate
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Date getFundcloseenddate() {
        return fundcloseenddate;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Item withFundcloseenddate(Date fundcloseenddate) {
        this.setFundcloseenddate(fundcloseenddate);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..item.fundCloseEndDate
     *
     * @param fundcloseenddate the value for buukle-security-new..item.fundCloseEndDate
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void setFundcloseenddate(Date fundcloseenddate) {
        this.fundcloseenddate = fundcloseenddate;
    }

    /**
     * This method returns the value of the database column buukle-security-new..item.fundCloseBeginDate
     *
     * @return the value of buukle-security-new..item.fundCloseBeginDate
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Date getFundclosebegindate() {
        return fundclosebegindate;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Item withFundclosebegindate(Date fundclosebegindate) {
        this.setFundclosebegindate(fundclosebegindate);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..item.fundCloseBeginDate
     *
     * @param fundclosebegindate the value for buukle-security-new..item.fundCloseBeginDate
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void setFundclosebegindate(Date fundclosebegindate) {
        this.fundclosebegindate = fundclosebegindate;
    }

    /**
     * This method returns the value of the database column buukle-security-new..item.fundraisingBeginDate
     *
     * @return the value of buukle-security-new..item.fundraisingBeginDate
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Date getFundraisingbegindate() {
        return fundraisingbegindate;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Item withFundraisingbegindate(Date fundraisingbegindate) {
        this.setFundraisingbegindate(fundraisingbegindate);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..item.fundraisingBeginDate
     *
     * @param fundraisingbegindate the value for buukle-security-new..item.fundraisingBeginDate
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void setFundraisingbegindate(Date fundraisingbegindate) {
        this.fundraisingbegindate = fundraisingbegindate;
    }

    /**
     * This method returns the value of the database column buukle-security-new..item.fundraisingEndDate
     *
     * @return the value of buukle-security-new..item.fundraisingEndDate
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Date getFundraisingenddate() {
        return fundraisingenddate;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Item withFundraisingenddate(Date fundraisingenddate) {
        this.setFundraisingenddate(fundraisingenddate);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..item.fundraisingEndDate
     *
     * @param fundraisingenddate the value for buukle-security-new..item.fundraisingEndDate
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void setFundraisingenddate(Date fundraisingenddate) {
        this.fundraisingenddate = fundraisingenddate;
    }

    /**
     * This method returns the value of the database column buukle-security-new..item.version
     *
     * @return the value of buukle-security-new..item.version
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Integer getVersion() {
        return version;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Item withVersion(Integer version) {
        this.setVersion(version);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..item.version
     *
     * @param version the value for buukle-security-new..item.version
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * This method returns the value of the database column buukle-security-new..item.remark
     *
     * @return the value of buukle-security-new..item.remark
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public String getRemark() {
        return remark;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Item withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..item.remark
     *
     * @param remark the value for buukle-security-new..item.remark
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..item.gmt_created
     *
     * @return the value of buukle-security-new..item.gmt_created
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Date getGmtCreated() {
        return gmtCreated;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Item withGmtCreated(Date gmtCreated) {
        this.setGmtCreated(gmtCreated);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..item.gmt_created
     *
     * @param gmtCreated the value for buukle-security-new..item.gmt_created
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**
     * This method returns the value of the database column buukle-security-new..item.creator
     *
     * @return the value of buukle-security-new..item.creator
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public String getCreator() {
        return creator;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Item withCreator(String creator) {
        this.setCreator(creator);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..item.creator
     *
     * @param creator the value for buukle-security-new..item.creator
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..item.creator_code
     *
     * @return the value of buukle-security-new..item.creator_code
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public String getCreatorCode() {
        return creatorCode;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Item withCreatorCode(String creatorCode) {
        this.setCreatorCode(creatorCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..item.creator_code
     *
     * @param creatorCode the value for buukle-security-new..item.creator_code
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode == null ? null : creatorCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..item.gmt_modified
     *
     * @return the value of buukle-security-new..item.gmt_modified
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Item withGmtModified(Date gmtModified) {
        this.setGmtModified(gmtModified);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..item.gmt_modified
     *
     * @param gmtModified the value for buukle-security-new..item.gmt_modified
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method returns the value of the database column buukle-security-new..item.modifier
     *
     * @return the value of buukle-security-new..item.modifier
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public String getModifier() {
        return modifier;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Item withModifier(String modifier) {
        this.setModifier(modifier);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..item.modifier
     *
     * @param modifier the value for buukle-security-new..item.modifier
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..item.modifier_code
     *
     * @return the value of buukle-security-new..item.modifier_code
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public String getModifierCode() {
        return modifierCode;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Item withModifierCode(String modifierCode) {
        this.setModifierCode(modifierCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..item.modifier_code
     *
     * @param modifierCode the value for buukle-security-new..item.modifier_code
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void setModifierCode(String modifierCode) {
        this.modifierCode = modifierCode == null ? null : modifierCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..item.status
     *
     * @return the value of buukle-security-new..item.status
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Item withStatus(Integer status) {
        this.setStatus(status);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..item.status
     *
     * @param status the value for buukle-security-new..item.status
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column buukle-security-new..item.bak06
     *
     * @return the value of buukle-security-new..item.bak06
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public String getBak06() {
        return bak06;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Item withBak06(String bak06) {
        this.setBak06(bak06);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..item.bak06
     *
     * @param bak06 the value for buukle-security-new..item.bak06
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void setBak06(String bak06) {
        this.bak06 = bak06 == null ? null : bak06.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..item.bak07
     *
     * @return the value of buukle-security-new..item.bak07
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public String getBak07() {
        return bak07;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Item withBak07(String bak07) {
        this.setBak07(bak07);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..item.bak07
     *
     * @param bak07 the value for buukle-security-new..item.bak07
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void setBak07(String bak07) {
        this.bak07 = bak07 == null ? null : bak07.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..item.bak08
     *
     * @return the value of buukle-security-new..item.bak08
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public String getBak08() {
        return bak08;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Item withBak08(String bak08) {
        this.setBak08(bak08);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..item.bak08
     *
     * @param bak08 the value for buukle-security-new..item.bak08
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void setBak08(String bak08) {
        this.bak08 = bak08 == null ? null : bak08.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..item.bak09
     *
     * @return the value of buukle-security-new..item.bak09
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public String getBak09() {
        return bak09;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Item withBak09(String bak09) {
        this.setBak09(bak09);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..item.bak09
     *
     * @param bak09 the value for buukle-security-new..item.bak09
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void setBak09(String bak09) {
        this.bak09 = bak09 == null ? null : bak09.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..item.bak10
     *
     * @return the value of buukle-security-new..item.bak10
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public String getBak10() {
        return bak10;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Item withBak10(String bak10) {
        this.setBak10(bak10);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..item.bak10
     *
     * @param bak10 the value for buukle-security-new..item.bak10
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void setBak10(String bak10) {
        this.bak10 = bak10 == null ? null : bak10.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..item.bak01
     *
     * @return the value of buukle-security-new..item.bak01
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public String getBak01() {
        return bak01;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Item withBak01(String bak01) {
        this.setBak01(bak01);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..item.bak01
     *
     * @param bak01 the value for buukle-security-new..item.bak01
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void setBak01(String bak01) {
        this.bak01 = bak01 == null ? null : bak01.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..item.bak02
     *
     * @return the value of buukle-security-new..item.bak02
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public String getBak02() {
        return bak02;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Item withBak02(String bak02) {
        this.setBak02(bak02);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..item.bak02
     *
     * @param bak02 the value for buukle-security-new..item.bak02
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void setBak02(String bak02) {
        this.bak02 = bak02 == null ? null : bak02.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..item.bak03
     *
     * @return the value of buukle-security-new..item.bak03
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public String getBak03() {
        return bak03;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Item withBak03(String bak03) {
        this.setBak03(bak03);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..item.bak03
     *
     * @param bak03 the value for buukle-security-new..item.bak03
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void setBak03(String bak03) {
        this.bak03 = bak03 == null ? null : bak03.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..item.bak04
     *
     * @return the value of buukle-security-new..item.bak04
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public String getBak04() {
        return bak04;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Item withBak04(String bak04) {
        this.setBak04(bak04);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..item.bak04
     *
     * @param bak04 the value for buukle-security-new..item.bak04
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void setBak04(String bak04) {
        this.bak04 = bak04 == null ? null : bak04.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..item.bak05
     *
     * @return the value of buukle-security-new..item.bak05
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public String getBak05() {
        return bak05;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Item withBak05(String bak05) {
        this.setBak05(bak05);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..item.bak05
     *
     * @param bak05 the value for buukle-security-new..item.bak05
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void setBak05(String bak05) {
        this.bak05 = bak05 == null ? null : bak05.trim();
    }

    /**
     * This method returns the value of the database column buukle-security-new..item.detail
     *
     * @return the value of buukle-security-new..item.detail
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public String getDetail() {
        return detail;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Item withDetail(String detail) {
        this.setDetail(detail);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security-new..item.detail
     *
     * @param detail the value for buukle-security-new..item.detail
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", uuid=").append(uuid);
        sb.append(", skuid=").append(skuid);
        sb.append(", skuname=").append(skuname);
        sb.append(", biztype=").append(biztype);
        sb.append(", productid=").append(productid);
        sb.append(", merchantid=").append(merchantid);
        sb.append(", merchantname=").append(merchantname);
        sb.append(", thirdcode=").append(thirdcode);
        sb.append(", itemstatus=").append(itemstatus);
        sb.append(", auditstatus=").append(auditstatus);
        sb.append(", pin=").append(pin);
        sb.append(", fundcloseenddate=").append(fundcloseenddate);
        sb.append(", fundclosebegindate=").append(fundclosebegindate);
        sb.append(", fundraisingbegindate=").append(fundraisingbegindate);
        sb.append(", fundraisingenddate=").append(fundraisingenddate);
        sb.append(", version=").append(version);
        sb.append(", remark=").append(remark);
        sb.append(", gmtCreated=").append(gmtCreated);
        sb.append(", creator=").append(creator);
        sb.append(", creatorCode=").append(creatorCode);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", modifier=").append(modifier);
        sb.append(", modifierCode=").append(modifierCode);
        sb.append(", status=").append(status);
        sb.append(", bak06=").append(bak06);
        sb.append(", bak07=").append(bak07);
        sb.append(", bak08=").append(bak08);
        sb.append(", bak09=").append(bak09);
        sb.append(", bak10=").append(bak10);
        sb.append(", bak01=").append(bak01);
        sb.append(", bak02=").append(bak02);
        sb.append(", bak03=").append(bak03);
        sb.append(", bak04=").append(bak04);
        sb.append(", bak05=").append(bak05);
        sb.append(", detail=").append(detail);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
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
        Item other = (Item) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getSkuid() == null ? other.getSkuid() == null : this.getSkuid().equals(other.getSkuid()))
            && (this.getSkuname() == null ? other.getSkuname() == null : this.getSkuname().equals(other.getSkuname()))
            && (this.getBiztype() == null ? other.getBiztype() == null : this.getBiztype().equals(other.getBiztype()))
            && (this.getProductid() == null ? other.getProductid() == null : this.getProductid().equals(other.getProductid()))
            && (this.getMerchantid() == null ? other.getMerchantid() == null : this.getMerchantid().equals(other.getMerchantid()))
            && (this.getMerchantname() == null ? other.getMerchantname() == null : this.getMerchantname().equals(other.getMerchantname()))
            && (this.getThirdcode() == null ? other.getThirdcode() == null : this.getThirdcode().equals(other.getThirdcode()))
            && (this.getItemstatus() == null ? other.getItemstatus() == null : this.getItemstatus().equals(other.getItemstatus()))
            && (this.getAuditstatus() == null ? other.getAuditstatus() == null : this.getAuditstatus().equals(other.getAuditstatus()))
            && (this.getPin() == null ? other.getPin() == null : this.getPin().equals(other.getPin()))
            && (this.getFundcloseenddate() == null ? other.getFundcloseenddate() == null : this.getFundcloseenddate().equals(other.getFundcloseenddate()))
            && (this.getFundclosebegindate() == null ? other.getFundclosebegindate() == null : this.getFundclosebegindate().equals(other.getFundclosebegindate()))
            && (this.getFundraisingbegindate() == null ? other.getFundraisingbegindate() == null : this.getFundraisingbegindate().equals(other.getFundraisingbegindate()))
            && (this.getFundraisingenddate() == null ? other.getFundraisingenddate() == null : this.getFundraisingenddate().equals(other.getFundraisingenddate()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreatorCode() == null ? other.getCreatorCode() == null : this.getCreatorCode().equals(other.getCreatorCode()))
            && (this.getGmtModified() == null ? other.getGmtModified() == null : this.getGmtModified().equals(other.getGmtModified()))
            && (this.getModifier() == null ? other.getModifier() == null : this.getModifier().equals(other.getModifier()))
            && (this.getModifierCode() == null ? other.getModifierCode() == null : this.getModifierCode().equals(other.getModifierCode()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getBak06() == null ? other.getBak06() == null : this.getBak06().equals(other.getBak06()))
            && (this.getBak07() == null ? other.getBak07() == null : this.getBak07().equals(other.getBak07()))
            && (this.getBak08() == null ? other.getBak08() == null : this.getBak08().equals(other.getBak08()))
            && (this.getBak09() == null ? other.getBak09() == null : this.getBak09().equals(other.getBak09()))
            && (this.getBak10() == null ? other.getBak10() == null : this.getBak10().equals(other.getBak10()))
            && (this.getBak01() == null ? other.getBak01() == null : this.getBak01().equals(other.getBak01()))
            && (this.getBak02() == null ? other.getBak02() == null : this.getBak02().equals(other.getBak02()))
            && (this.getBak03() == null ? other.getBak03() == null : this.getBak03().equals(other.getBak03()))
            && (this.getBak04() == null ? other.getBak04() == null : this.getBak04().equals(other.getBak04()))
            && (this.getBak05() == null ? other.getBak05() == null : this.getBak05().equals(other.getBak05()))
            && (this.getDetail() == null ? other.getDetail() == null : this.getDetail().equals(other.getDetail()));
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getSkuid() == null) ? 0 : getSkuid().hashCode());
        result = prime * result + ((getSkuname() == null) ? 0 : getSkuname().hashCode());
        result = prime * result + ((getBiztype() == null) ? 0 : getBiztype().hashCode());
        result = prime * result + ((getProductid() == null) ? 0 : getProductid().hashCode());
        result = prime * result + ((getMerchantid() == null) ? 0 : getMerchantid().hashCode());
        result = prime * result + ((getMerchantname() == null) ? 0 : getMerchantname().hashCode());
        result = prime * result + ((getThirdcode() == null) ? 0 : getThirdcode().hashCode());
        result = prime * result + ((getItemstatus() == null) ? 0 : getItemstatus().hashCode());
        result = prime * result + ((getAuditstatus() == null) ? 0 : getAuditstatus().hashCode());
        result = prime * result + ((getPin() == null) ? 0 : getPin().hashCode());
        result = prime * result + ((getFundcloseenddate() == null) ? 0 : getFundcloseenddate().hashCode());
        result = prime * result + ((getFundclosebegindate() == null) ? 0 : getFundclosebegindate().hashCode());
        result = prime * result + ((getFundraisingbegindate() == null) ? 0 : getFundraisingbegindate().hashCode());
        result = prime * result + ((getFundraisingenddate() == null) ? 0 : getFundraisingenddate().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreatorCode() == null) ? 0 : getCreatorCode().hashCode());
        result = prime * result + ((getGmtModified() == null) ? 0 : getGmtModified().hashCode());
        result = prime * result + ((getModifier() == null) ? 0 : getModifier().hashCode());
        result = prime * result + ((getModifierCode() == null) ? 0 : getModifierCode().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getBak06() == null) ? 0 : getBak06().hashCode());
        result = prime * result + ((getBak07() == null) ? 0 : getBak07().hashCode());
        result = prime * result + ((getBak08() == null) ? 0 : getBak08().hashCode());
        result = prime * result + ((getBak09() == null) ? 0 : getBak09().hashCode());
        result = prime * result + ((getBak10() == null) ? 0 : getBak10().hashCode());
        result = prime * result + ((getBak01() == null) ? 0 : getBak01().hashCode());
        result = prime * result + ((getBak02() == null) ? 0 : getBak02().hashCode());
        result = prime * result + ((getBak03() == null) ? 0 : getBak03().hashCode());
        result = prime * result + ((getBak04() == null) ? 0 : getBak04().hashCode());
        result = prime * result + ((getBak05() == null) ? 0 : getBak05().hashCode());
        result = prime * result + ((getDetail() == null) ? 0 : getDetail().hashCode());
        return result;
    }
}