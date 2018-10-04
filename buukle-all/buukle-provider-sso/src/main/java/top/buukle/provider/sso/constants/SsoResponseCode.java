package top.buukle.provider.sso.constants;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/22.
 * @Description :
 */
public enum SsoResponseCode {


    /** 系统响应码*/
    TRUE(SsoResponseCode.SUCCESS,"111111","成功!"),
    FALSE(SsoResponseCode.FAILED,"000000","失败!"),

    HTTP_CELENE_FAILED(SsoResponseCode.FAILED, "000001", "通讯失败!");

    private static final String SUCCESS = "S";
    private static final String FAILED = "F";

    SsoResponseCode(String status, String code, String msg) {
        this.status = status;
        this.code = code;
        this.msg = msg;
    }

    /** 返回状态码*/
    private String status;
    /** 返回成功/失败编码*/
    private String code;
    /** 返回信息*/
    private String msg;

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
