/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.entity;

/**
 * 注释:BuukleSignLogs实体
 * @author tengbx
 */
public class BuukleSignLogs implements java.io.Serializable{
	private static final long serialVersionUID = -1L;
	
	//columns START
	/**
	 * 主键
	 */
	private Integer id;
	/**
	 * 验签id
	 */
	private Integer buukleSignId;
	/**
	 * 操作人名称
	 */
	private String operationName;
	/**
	 * 操作人代码
	 */
	private String operationCode;
	/**
	 * 操作类型
            0新增操作
            1修改操作
	 */
	private String operationType;
	/**
	 * 操作时间
	 */
	private java.util.Date operationTime;
	/**
	 * 日志类型
	 */
	private String logType;
	/**
	 * 日志描述
	 */
	private String logMsg;
	//columns END

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setBuukleSignId(Integer buukleSignId) {
		this.buukleSignId = buukleSignId;
	}
	
	public Integer getBuukleSignId() {
		return this.buukleSignId;
	}
	public void setOperationName(String operationName) {
	    this.operationName = operationName==null?null:operationName.trim();
	}
	
	public String getOperationName() {
		return this.operationName;
	}
	public void setOperationCode(String operationCode) {
	    this.operationCode = operationCode==null?null:operationCode.trim();
	}
	
	public String getOperationCode() {
		return this.operationCode;
	}
	public void setOperationType(String operationType) {
	    this.operationType = operationType==null?null:operationType.trim();
	}
	
	public String getOperationType() {
		return this.operationType;
	}
	public void setOperationTime(java.util.Date operationTime) {
		this.operationTime = operationTime;
	}
	
	public java.util.Date getOperationTime() {
		return this.operationTime;
	}
	public void setLogType(String logType) {
	    this.logType = logType==null?null:logType.trim();
	}
	
	public String getLogType() {
		return this.logType;
	}
	public void setLogMsg(String logMsg) {
	    this.logMsg = logMsg==null?null:logMsg.trim();
	}
	
	public String getLogMsg() {
		return this.logMsg;
	}

}


