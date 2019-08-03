/*
 * Powered By [rapid-framework]
 * Web Site: http:// www.rapid-framework.org.cn
 * Google Code: http:// code.google.com/p/rapid-framework/
 * Since 2008 - 2017
 */

package top.buukle.generator.hibernate.targetEntity;

/**
 * 注释:DelayTask实体
 * @author tengbx
 */
public class Task implements java.io.Serializable{
	// columns START
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 类名字（反射使用）
	 */
	private String className;
	/**
	 * 方法名字（反射使用）
	 */
	private String methodName;
	/**
	 * 定时任务执行参数
	 */
	private String parameter;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 提醒邮箱
	 */
	private String alarmMail;
	/**
	 * 启动提醒
            1 是
            0 否
	 */
	private Integer startAlarm;
	/**
	 * 停止提醒
            1 是
            0 否
	 */
	private Integer stopAlarm;
	/**
	 * 异常提醒
            1 是
            0 否
	 */
	private Integer errorAlarm;
	/**
	 * 执行计划规则
	 */
	private String cronExpression;
	/**
	 * 启动开始时间
	 */
	private java.util.Date startDate;
	/**
	 * 类型
            0 重复执行
            1 执行一次
	 */
	private Integer type;
	/**
	 * 状态
            0待执行
            1执行中
            2执行完成
	 */
	private Integer status;
	/**
	 * 创建人
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
            2 BOSS创建
            3 MS创建
            4 CMS创建
	 */
	private String creatorType;
	/**
	 * 创建时间
	 */
	private java.util.Date gmtCreated;
	/**
	 * 修改人
	 */
	private String modifier;
	/**
	 * 修改人代码
	 */
	private String modifierNo;
	/**
	 * 修改人类型
            0 pid修改
            1 代理修改
            2 BOSS修改
            3 MS修改
            4 CMS修改
	 */
	private String modifierType;
	/**
	 * 修改时间
	 */
	private java.util.Date gmtModified;
	// columns END

	public Task() {}

	public Task(String parameter, Integer status) {
		this.parameter = parameter;
		this.status = status;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className==null?null:className.trim();
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName==null?null:methodName.trim();
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter==null?null:parameter.trim();
	}

	public void setDescription(String description) {
	    this.description = description==null?null:description.trim();
	}
	
	public String getDescription() {
		return this.description;
	}
	public void setAlarmMail(String alarmMail) {
	    this.alarmMail = alarmMail==null?null:alarmMail.trim();
	}
	
	public String getAlarmMail() {
		return this.alarmMail;
	}
	public void setStartAlarm(Integer startAlarm) {
		this.startAlarm = startAlarm;
	}
	
	public Integer getStartAlarm() {
		return this.startAlarm;
	}
	public void setStopAlarm(Integer stopAlarm) {
		this.stopAlarm = stopAlarm;
	}
	
	public Integer getStopAlarm() {
		return this.stopAlarm;
	}
	public void setErrorAlarm(Integer errorAlarm) {
		this.errorAlarm = errorAlarm;
	}
	
	public Integer getErrorAlarm() {
		return this.errorAlarm;
	}
	public void setCronExpression(String cronExpression) {
	    this.cronExpression = cronExpression==null?null:cronExpression.trim();
	}
	
	public String getCronExpression() {
		return this.cronExpression;
	}
	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}
	
	public java.util.Date getStartDate() {
		return this.startDate;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	public Integer getType() {
		return this.type;
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

}

