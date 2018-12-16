package top.buukle.plugin.security.entity;

import java.util.Date;

public class BuukleSignLogs {
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
    private Date operationTime;

    /**
     * 日志类型
     */
    private String logType;

    /**
     * 日志描述
     */
    private String logMsg;

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
     * 验签id
     * @return buukle_sign_id 验签id
     */
    public Integer getBuukleSignId() {
        return buukleSignId;
    }

    /**
     * 验签id
     * @param buukleSignId 验签id
     */
    public void setBuukleSignId(Integer buukleSignId) {
        this.buukleSignId = buukleSignId;
    }

    /**
     * 操作人名称
     * @return operation_name 操作人名称
     */
    public String getOperationName() {
        return operationName;
    }

    /**
     * 操作人名称
     * @param operationName 操作人名称
     */
    public void setOperationName(String operationName) {
        this.operationName = operationName == null ? null : operationName.trim();
    }

    /**
     * 操作人代码
     * @return operation_code 操作人代码
     */
    public String getOperationCode() {
        return operationCode;
    }

    /**
     * 操作人代码
     * @param operationCode 操作人代码
     */
    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode == null ? null : operationCode.trim();
    }

    /**
     * 操作类型
            0新增操作
            1修改操作
     * @return operation_type 操作类型
            0新增操作
            1修改操作
     */
    public String getOperationType() {
        return operationType;
    }

    /**
     * 操作类型
            0新增操作
            1修改操作
     * @param operationType 操作类型
            0新增操作
            1修改操作
     */
    public void setOperationType(String operationType) {
        this.operationType = operationType == null ? null : operationType.trim();
    }

    /**
     * 操作时间
     * @return operation_time 操作时间
     */
    public Date getOperationTime() {
        return operationTime;
    }

    /**
     * 操作时间
     * @param operationTime 操作时间
     */
    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    /**
     * 日志类型
     * @return log_type 日志类型
     */
    public String getLogType() {
        return logType;
    }

    /**
     * 日志类型
     * @param logType 日志类型
     */
    public void setLogType(String logType) {
        this.logType = logType == null ? null : logType.trim();
    }

    /**
     * 日志描述
     * @return log_msg 日志描述
     */
    public String getLogMsg() {
        return logMsg;
    }

    /**
     * 日志描述
     * @param logMsg 日志描述
     */
    public void setLogMsg(String logMsg) {
        this.logMsg = logMsg == null ? null : logMsg.trim();
    }
}