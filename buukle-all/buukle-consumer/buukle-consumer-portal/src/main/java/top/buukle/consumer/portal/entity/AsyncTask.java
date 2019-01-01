package top.buukle.consumer.portal.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created By elvin
 * Description:
 * 延时任务表
 * @author 
 */
public class AsyncTask implements Serializable {
    /**
     * id
     *
     */
    private Integer id;

    /**
     * 类名字（反射使用）
     *
     */
    private String className;

    /**
     * 方法名字（反射使用）
     *
     */
    private String methodName;

    /**
     * 定时任务执行参数
     *
     */
    private String parameter;

    /**
     * 描述
     *
     */
    private String description;

    /**
     * 提醒邮箱
     *
     */
    private String alarmMail;

    /**
     * 启动提醒
                        1 是
                        0 否
     *
     */
    private Integer startAlarm;

    /**
     * 停止提醒
                        1 是
                        0 否
     *
     */
    private Integer stopAlarm;

    /**
     * 异常提醒
                        1 是
                        0 否
     *
     */
    private Integer errorAlarm;

    /**
     * 执行计划规则
     *
     */
    private String cronExpression;

    /**
     * 启动开始时间
     *
     */
    private Date startDate;

    /**
     * 类型
                        0 重复执行
                        1 执行一次
     *
     */
    private Integer type;

    /**
     * 运行环境类型 0 灰度 1 线上
     *
     */
    private Integer runtype;

    /**
     * 创建者(用户名)
     *
     */
    private String creator;

    /**
     * 创建者代码
     *
     */
    private String creatorCode;

    /**
     * 创建时间
     *
     */
    private Date gmtCreated;

    /**
     * 修改者(用户名)
     *
     */
    private String modifier;

    /**
     * 修改者代码
     *
     */
    private String modifierCode;

    /**
     * 更新时间
     *
     */
    private Date gmtModified;

    /**
     *
     */
    private Integer status;

    /**
     * 备用
     *
     */
    private String bak01;

    /**
     * 备用
     *
     */
    private String bak02;

    /**
     * 备用
     *
     */
    private String bak03;

    /**
     * 备用
     *
     */
    private String bak04;

    /**
     * 备用
     *
     */
    private String bak05;

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column buukle-cms..async_task.id
     *
     * @return the value of buukle-cms..async_task.id
     */
    public Integer getId() {
        return id;
    }

    /**
     */
    public AsyncTask withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..async_task.id
     *
     * @param id the value for buukle-cms..async_task.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column buukle-cms..async_task.class_name
     *
     * @return the value of buukle-cms..async_task.class_name
     */
    public String getClassName() {
        return className;
    }

    /**
     */
    public AsyncTask withClassName(String className) {
        this.setClassName(className);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..async_task.class_name
     *
     * @param className the value for buukle-cms..async_task.class_name
     */
    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..async_task.method_name
     *
     * @return the value of buukle-cms..async_task.method_name
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     */
    public AsyncTask withMethodName(String methodName) {
        this.setMethodName(methodName);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..async_task.method_name
     *
     * @param methodName the value for buukle-cms..async_task.method_name
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName == null ? null : methodName.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..async_task.parameter
     *
     * @return the value of buukle-cms..async_task.parameter
     */
    public String getParameter() {
        return parameter;
    }

    /**
     */
    public AsyncTask withParameter(String parameter) {
        this.setParameter(parameter);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..async_task.parameter
     *
     * @param parameter the value for buukle-cms..async_task.parameter
     */
    public void setParameter(String parameter) {
        this.parameter = parameter == null ? null : parameter.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..async_task.description
     *
     * @return the value of buukle-cms..async_task.description
     */
    public String getDescription() {
        return description;
    }

    /**
     */
    public AsyncTask withDescription(String description) {
        this.setDescription(description);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..async_task.description
     *
     * @param description the value for buukle-cms..async_task.description
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..async_task.alarm_mail
     *
     * @return the value of buukle-cms..async_task.alarm_mail
     */
    public String getAlarmMail() {
        return alarmMail;
    }

    /**
     */
    public AsyncTask withAlarmMail(String alarmMail) {
        this.setAlarmMail(alarmMail);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..async_task.alarm_mail
     *
     * @param alarmMail the value for buukle-cms..async_task.alarm_mail
     */
    public void setAlarmMail(String alarmMail) {
        this.alarmMail = alarmMail == null ? null : alarmMail.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..async_task.start_alarm
     *
     * @return the value of buukle-cms..async_task.start_alarm
     */
    public Integer getStartAlarm() {
        return startAlarm;
    }

    /**
     */
    public AsyncTask withStartAlarm(Integer startAlarm) {
        this.setStartAlarm(startAlarm);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..async_task.start_alarm
     *
     * @param startAlarm the value for buukle-cms..async_task.start_alarm
     */
    public void setStartAlarm(Integer startAlarm) {
        this.startAlarm = startAlarm;
    }

    /**
     * This method returns the value of the database column buukle-cms..async_task.stop_alarm
     *
     * @return the value of buukle-cms..async_task.stop_alarm
     */
    public Integer getStopAlarm() {
        return stopAlarm;
    }

    /**
     */
    public AsyncTask withStopAlarm(Integer stopAlarm) {
        this.setStopAlarm(stopAlarm);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..async_task.stop_alarm
     *
     * @param stopAlarm the value for buukle-cms..async_task.stop_alarm
     */
    public void setStopAlarm(Integer stopAlarm) {
        this.stopAlarm = stopAlarm;
    }

    /**
     * This method returns the value of the database column buukle-cms..async_task.error_alarm
     *
     * @return the value of buukle-cms..async_task.error_alarm
     */
    public Integer getErrorAlarm() {
        return errorAlarm;
    }

    /**
     */
    public AsyncTask withErrorAlarm(Integer errorAlarm) {
        this.setErrorAlarm(errorAlarm);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..async_task.error_alarm
     *
     * @param errorAlarm the value for buukle-cms..async_task.error_alarm
     */
    public void setErrorAlarm(Integer errorAlarm) {
        this.errorAlarm = errorAlarm;
    }

    /**
     * This method returns the value of the database column buukle-cms..async_task.cron_expression
     *
     * @return the value of buukle-cms..async_task.cron_expression
     */
    public String getCronExpression() {
        return cronExpression;
    }

    /**
     */
    public AsyncTask withCronExpression(String cronExpression) {
        this.setCronExpression(cronExpression);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..async_task.cron_expression
     *
     * @param cronExpression the value for buukle-cms..async_task.cron_expression
     */
    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression == null ? null : cronExpression.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..async_task.start_date
     *
     * @return the value of buukle-cms..async_task.start_date
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     */
    public AsyncTask withStartDate(Date startDate) {
        this.setStartDate(startDate);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..async_task.start_date
     *
     * @param startDate the value for buukle-cms..async_task.start_date
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * This method returns the value of the database column buukle-cms..async_task.type
     *
     * @return the value of buukle-cms..async_task.type
     */
    public Integer getType() {
        return type;
    }

    /**
     */
    public AsyncTask withType(Integer type) {
        this.setType(type);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..async_task.type
     *
     * @param type the value for buukle-cms..async_task.type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method returns the value of the database column buukle-cms..async_task.runType
     *
     * @return the value of buukle-cms..async_task.runType
     */
    public Integer getRuntype() {
        return runtype;
    }

    /**
     */
    public AsyncTask withRuntype(Integer runtype) {
        this.setRuntype(runtype);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..async_task.runType
     *
     * @param runtype the value for buukle-cms..async_task.runType
     */
    public void setRuntype(Integer runtype) {
        this.runtype = runtype;
    }

    /**
     * This method returns the value of the database column buukle-cms..async_task.creator
     *
     * @return the value of buukle-cms..async_task.creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     */
    public AsyncTask withCreator(String creator) {
        this.setCreator(creator);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..async_task.creator
     *
     * @param creator the value for buukle-cms..async_task.creator
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..async_task.creator_code
     *
     * @return the value of buukle-cms..async_task.creator_code
     */
    public String getCreatorCode() {
        return creatorCode;
    }

    /**
     */
    public AsyncTask withCreatorCode(String creatorCode) {
        this.setCreatorCode(creatorCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..async_task.creator_code
     *
     * @param creatorCode the value for buukle-cms..async_task.creator_code
     */
    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode == null ? null : creatorCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..async_task.gmt_created
     *
     * @return the value of buukle-cms..async_task.gmt_created
     */
    public Date getGmtCreated() {
        return gmtCreated;
    }

    /**
     */
    public AsyncTask withGmtCreated(Date gmtCreated) {
        this.setGmtCreated(gmtCreated);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..async_task.gmt_created
     *
     * @param gmtCreated the value for buukle-cms..async_task.gmt_created
     */
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**
     * This method returns the value of the database column buukle-cms..async_task.modifier
     *
     * @return the value of buukle-cms..async_task.modifier
     */
    public String getModifier() {
        return modifier;
    }

    /**
     */
    public AsyncTask withModifier(String modifier) {
        this.setModifier(modifier);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..async_task.modifier
     *
     * @param modifier the value for buukle-cms..async_task.modifier
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..async_task.modifier_code
     *
     * @return the value of buukle-cms..async_task.modifier_code
     */
    public String getModifierCode() {
        return modifierCode;
    }

    /**
     */
    public AsyncTask withModifierCode(String modifierCode) {
        this.setModifierCode(modifierCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..async_task.modifier_code
     *
     * @param modifierCode the value for buukle-cms..async_task.modifier_code
     */
    public void setModifierCode(String modifierCode) {
        this.modifierCode = modifierCode == null ? null : modifierCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..async_task.gmt_modified
     *
     * @return the value of buukle-cms..async_task.gmt_modified
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     */
    public AsyncTask withGmtModified(Date gmtModified) {
        this.setGmtModified(gmtModified);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..async_task.gmt_modified
     *
     * @param gmtModified the value for buukle-cms..async_task.gmt_modified
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method returns the value of the database column buukle-cms..async_task.status
     *
     * @return the value of buukle-cms..async_task.status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     */
    public AsyncTask withStatus(Integer status) {
        this.setStatus(status);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..async_task.status
     *
     * @param status the value for buukle-cms..async_task.status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column buukle-cms..async_task.bak01
     *
     * @return the value of buukle-cms..async_task.bak01
     */
    public String getBak01() {
        return bak01;
    }

    /**
     */
    public AsyncTask withBak01(String bak01) {
        this.setBak01(bak01);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..async_task.bak01
     *
     * @param bak01 the value for buukle-cms..async_task.bak01
     */
    public void setBak01(String bak01) {
        this.bak01 = bak01 == null ? null : bak01.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..async_task.bak02
     *
     * @return the value of buukle-cms..async_task.bak02
     */
    public String getBak02() {
        return bak02;
    }

    /**
     */
    public AsyncTask withBak02(String bak02) {
        this.setBak02(bak02);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..async_task.bak02
     *
     * @param bak02 the value for buukle-cms..async_task.bak02
     */
    public void setBak02(String bak02) {
        this.bak02 = bak02 == null ? null : bak02.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..async_task.bak03
     *
     * @return the value of buukle-cms..async_task.bak03
     */
    public String getBak03() {
        return bak03;
    }

    /**
     */
    public AsyncTask withBak03(String bak03) {
        this.setBak03(bak03);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..async_task.bak03
     *
     * @param bak03 the value for buukle-cms..async_task.bak03
     */
    public void setBak03(String bak03) {
        this.bak03 = bak03 == null ? null : bak03.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..async_task.bak04
     *
     * @return the value of buukle-cms..async_task.bak04
     */
    public String getBak04() {
        return bak04;
    }

    /**
     */
    public AsyncTask withBak04(String bak04) {
        this.setBak04(bak04);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..async_task.bak04
     *
     * @param bak04 the value for buukle-cms..async_task.bak04
     */
    public void setBak04(String bak04) {
        this.bak04 = bak04 == null ? null : bak04.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..async_task.bak05
     *
     * @return the value of buukle-cms..async_task.bak05
     */
    public String getBak05() {
        return bak05;
    }

    /**
     */
    public AsyncTask withBak05(String bak05) {
        this.setBak05(bak05);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..async_task.bak05
     *
     * @param bak05 the value for buukle-cms..async_task.bak05
     */
    public void setBak05(String bak05) {
        this.bak05 = bak05 == null ? null : bak05.trim();
    }

    /**
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", className=").append(className);
        sb.append(", methodName=").append(methodName);
        sb.append(", parameter=").append(parameter);
        sb.append(", description=").append(description);
        sb.append(", alarmMail=").append(alarmMail);
        sb.append(", startAlarm=").append(startAlarm);
        sb.append(", stopAlarm=").append(stopAlarm);
        sb.append(", errorAlarm=").append(errorAlarm);
        sb.append(", cronExpression=").append(cronExpression);
        sb.append(", startDate=").append(startDate);
        sb.append(", type=").append(type);
        sb.append(", runtype=").append(runtype);
        sb.append(", creator=").append(creator);
        sb.append(", creatorCode=").append(creatorCode);
        sb.append(", gmtCreated=").append(gmtCreated);
        sb.append(", modifier=").append(modifier);
        sb.append(", modifierCode=").append(modifierCode);
        sb.append(", gmtModified=").append(gmtModified);
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
        AsyncTask other = (AsyncTask) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getClassName() == null ? other.getClassName() == null : this.getClassName().equals(other.getClassName()))
            && (this.getMethodName() == null ? other.getMethodName() == null : this.getMethodName().equals(other.getMethodName()))
            && (this.getParameter() == null ? other.getParameter() == null : this.getParameter().equals(other.getParameter()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getAlarmMail() == null ? other.getAlarmMail() == null : this.getAlarmMail().equals(other.getAlarmMail()))
            && (this.getStartAlarm() == null ? other.getStartAlarm() == null : this.getStartAlarm().equals(other.getStartAlarm()))
            && (this.getStopAlarm() == null ? other.getStopAlarm() == null : this.getStopAlarm().equals(other.getStopAlarm()))
            && (this.getErrorAlarm() == null ? other.getErrorAlarm() == null : this.getErrorAlarm().equals(other.getErrorAlarm()))
            && (this.getCronExpression() == null ? other.getCronExpression() == null : this.getCronExpression().equals(other.getCronExpression()))
            && (this.getStartDate() == null ? other.getStartDate() == null : this.getStartDate().equals(other.getStartDate()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getRuntype() == null ? other.getRuntype() == null : this.getRuntype().equals(other.getRuntype()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreatorCode() == null ? other.getCreatorCode() == null : this.getCreatorCode().equals(other.getCreatorCode()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getModifier() == null ? other.getModifier() == null : this.getModifier().equals(other.getModifier()))
            && (this.getModifierCode() == null ? other.getModifierCode() == null : this.getModifierCode().equals(other.getModifierCode()))
            && (this.getGmtModified() == null ? other.getGmtModified() == null : this.getGmtModified().equals(other.getGmtModified()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getBak01() == null ? other.getBak01() == null : this.getBak01().equals(other.getBak01()))
            && (this.getBak02() == null ? other.getBak02() == null : this.getBak02().equals(other.getBak02()))
            && (this.getBak03() == null ? other.getBak03() == null : this.getBak03().equals(other.getBak03()))
            && (this.getBak04() == null ? other.getBak04() == null : this.getBak04().equals(other.getBak04()))
            && (this.getBak05() == null ? other.getBak05() == null : this.getBak05().equals(other.getBak05()));
    }

    /**
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getClassName() == null) ? 0 : getClassName().hashCode());
        result = prime * result + ((getMethodName() == null) ? 0 : getMethodName().hashCode());
        result = prime * result + ((getParameter() == null) ? 0 : getParameter().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getAlarmMail() == null) ? 0 : getAlarmMail().hashCode());
        result = prime * result + ((getStartAlarm() == null) ? 0 : getStartAlarm().hashCode());
        result = prime * result + ((getStopAlarm() == null) ? 0 : getStopAlarm().hashCode());
        result = prime * result + ((getErrorAlarm() == null) ? 0 : getErrorAlarm().hashCode());
        result = prime * result + ((getCronExpression() == null) ? 0 : getCronExpression().hashCode());
        result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getRuntype() == null) ? 0 : getRuntype().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreatorCode() == null) ? 0 : getCreatorCode().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getModifier() == null) ? 0 : getModifier().hashCode());
        result = prime * result + ((getModifierCode() == null) ? 0 : getModifierCode().hashCode());
        result = prime * result + ((getGmtModified() == null) ? 0 : getGmtModified().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getBak01() == null) ? 0 : getBak01().hashCode());
        result = prime * result + ((getBak02() == null) ? 0 : getBak02().hashCode());
        result = prime * result + ((getBak03() == null) ? 0 : getBak03().hashCode());
        result = prime * result + ((getBak04() == null) ? 0 : getBak04().hashCode());
        result = prime * result + ((getBak05() == null) ? 0 : getBak05().hashCode());
        return result;
    }
}