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
