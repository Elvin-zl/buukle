package top.buukle.common.call.code;

import top.buukle.common.status.StatusConstants;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/7/26.
 * @Description :
 */
public enum BaseReturnEnum {

    SUCCESS(StatusConstants.SUCCESS,"000000","成功!"),
    FAILED(StatusConstants.FAILED,"999999","失败!"),
    EXCEPTION(StatusConstants.FAILED,"999999","系统异常!"),
    NO_AUTH(StatusConstants.FAILED,"000001","未认证用户!"),
    NO_PERM(StatusConstants.FAILED,"000002","没有权限!"),
    LOGIN_FAILED(StatusConstants.FAILED,"000003","登录失败!"),
    LOGIN_FAILED_PARAM_NULL(StatusConstants.FAILED,"000004","登录失败,用户名或密码不能为空!"),
    LOGIN_FAILED_PARAM_WRONG(StatusConstants.FAILED,"000004","登录失败,用户名密码错误!"),

    ;
    private String status;
    private String code;
    private String msg;

    BaseReturnEnum(String status, String code, String msg) {
        this.status = status;
        this.code = code;
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}
