package top.buukle.common.exception;


import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.response.BaseResponse;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/22.
 * @Description :
 */
public class BaseException extends RuntimeException {

    /** 状态码*/
    private String status;
    /** 响应码*/
    private String code;
    /** 信息*/
    private String msg;

    public BaseException(BaseResponseCode baseResponseCode) {
        super(baseResponseCode.getMsg());
        this.status = baseResponseCode.getStatus();
        this.code = baseResponseCode.getCode();
        this.msg = baseResponseCode.getMsg();
    }

    public BaseException(BaseResponseCode ssoResponseCode, String thirdMessage) {
        super(thirdMessage);
        this.status = ssoResponseCode.getStatus();
        this.code = ssoResponseCode.getCode();
        this.msg = ssoResponseCode.getMsg() + thirdMessage;
    }

    public BaseException(BaseResponse baseResponse) {
        super(baseResponse.getMsg());
        this.status = baseResponse.getStatus();
        this.code = baseResponse.getCode();
        this.msg = baseResponse.getMsg();
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
