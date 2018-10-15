/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.entity;

/**
 * 注释:BuukleSign实体
 * @author tengbx
 */
public class BuukleSign implements java.io.Serializable{
	private static final long serialVersionUID = -1L;
	
	//columns START
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
	 * 合作方公钥
	 */
	private String partnerKey;
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
	private java.util.Date partnerKeyValid;
	/**
	 * 密钥失效日期
            格式:2016-01-01
	 */
	private java.util.Date partnerKeyEndvalid;
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
	private java.util.Date gmtCreated;
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
	private java.util.Date gmtModified;
	/**
	 * 备注
	 */
	private String remark;

	public BuukleSign(String applicationName, String operationId) {
		this.applicationName = applicationName;
		this.partnerId = operationId;
	}

	public BuukleSign() {
	}
	//columns END

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setApplicationName(String applicationName) {
	    this.applicationName = applicationName==null?null:applicationName.trim();
	}
	
	public String getApplicationName() {
		return this.applicationName;
	}
	public void setPartnerId(String partnerId) {
	    this.partnerId = partnerId==null?null:partnerId.trim();
	}
	
	public String getPartnerId() {
		return this.partnerId;
	}
	public void setPartnerKey(String partnerKey) {
	    this.partnerKey = partnerKey==null?null:partnerKey.trim();
	}
	
	public String getPartnerKey() {
		return this.partnerKey;
	}
	public void setPartnerType(Integer partnerType) {
		this.partnerType = partnerType;
	}
	
	public Integer getPartnerType() {
		return this.partnerType;
	}
	public void setSignType(String signType) {
	    this.signType = signType==null?null:signType.trim();
	}
	
	public String getSignType() {
		return this.signType;
	}
	public void setPartnerKeyValid(java.util.Date partnerKeyValid) {
		this.partnerKeyValid = partnerKeyValid;
	}
	
	public java.util.Date getPartnerKeyValid() {
		return this.partnerKeyValid;
	}
	public void setPartnerKeyEndvalid(java.util.Date partnerKeyEndvalid) {
		this.partnerKeyEndvalid = partnerKeyEndvalid;
	}
	
	public java.util.Date getPartnerKeyEndvalid() {
		return this.partnerKeyEndvalid;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getStatus() {
		return this.status;
	}
	public void setCreator(String creator) {
	    this.creator = creator==null?null:creator.trim();
	}
	
	public String getCreator() {
		return this.creator;
	}
	public void setCreatorNo(String creatorNo) {
	    this.creatorNo = creatorNo==null?null:creatorNo.trim();
	}
	
	public String getCreatorNo() {
		return this.creatorNo;
	}
	public void setCreatorType(String creatorType) {
	    this.creatorType = creatorType==null?null:creatorType.trim();
	}
	
	public String getCreatorType() {
		return this.creatorType;
	}
	public void setGmtCreated(java.util.Date gmtCreated) {
		this.gmtCreated = gmtCreated;
	}
	
	public java.util.Date getGmtCreated() {
		return this.gmtCreated;
	}
	public void setModifier(String modifier) {
	    this.modifier = modifier==null?null:modifier.trim();
	}
	
	public String getModifier() {
		return this.modifier;
	}
	public void setModifierNo(String modifierNo) {
	    this.modifierNo = modifierNo==null?null:modifierNo.trim();
	}
	
	public String getModifierNo() {
		return this.modifierNo;
	}
	public void setModifierType(String modifierType) {
	    this.modifierType = modifierType==null?null:modifierType.trim();
	}
	
	public String getModifierType() {
		return this.modifierType;
	}
	public void setGmtModified(java.util.Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	
	public java.util.Date getGmtModified() {
		return this.gmtModified;
	}
	public void setRemark(String remark) {
	    this.remark = remark==null?null:remark.trim();
	}
	
	public String getRemark() {
		return this.remark;
	}

}


