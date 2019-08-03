/**
 * Copyright (C), 2015-2019  http://www.buukle.top
 * FileName: SecurityPluginException
 * Author:   elvin
 * Date:     2019/8/3 0:40
 * Description: security插件异常
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.security.plugin.exception;

import top.buukle.common.exception.CommonException;
import top.buukle.security.plugin.enums.SecurityExceptionEnum;

/**
 * @description 〈security插件异常〉
 * @author elvin
 * @create 2019/8/3
 * @since 1.0.0
 */
public class SecurityPluginException extends CommonException {


    /** 类型*/
    private String type;
    /** 响应码*/
    private String code;
    /** 信息*/
    private String msg;
    /** url*/
    private String callBackUrl;

    public SecurityPluginException(SecurityExceptionEnum securityExceptionEnum) {
        super(securityExceptionEnum.getType(),securityExceptionEnum.getCode(),securityExceptionEnum.getMsg());
        this.type=securityExceptionEnum.getType();
        this.code=securityExceptionEnum.getCode();
        this.msg=securityExceptionEnum.getMsg();
        this.callBackUrl=securityExceptionEnum.getCallBackUrl();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCallBackUrl() {
        return callBackUrl;
    }

    public void setCallBackUrl(String callBackUrl) {
        this.callBackUrl = callBackUrl;
    }
}