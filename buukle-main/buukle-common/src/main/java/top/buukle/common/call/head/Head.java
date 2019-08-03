/**
 * Copyright (C), 2015-2019  http://www.jd.com
 * FileName: Head
 * Author:   zhanglei1102
 * Date:     2019/7/26 15:09
 * Description: 来源头部规范
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.common.call.head;

import java.util.Date;

/**
 * @description 〈来源头部规范〉
 * @author zhanglei1102
 * @create 2019/7/26
 * @since 1.0.0
 */
public class Head {

    /** 来源系统名称*/
    private String applicationName;
    /** 来源操作时间*/
    private Date operationTime;
    /** 来源操作人*/
    private String operator;
    /** 来源操作人Id*/
    private String operatorId;

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }
}