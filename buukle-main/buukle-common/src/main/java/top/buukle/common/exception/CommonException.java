package top.buukle.common.exception;


import top.buukle.common.call.code.BaseReturnEnum;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/22.
 * @Description :
 */
public class CommonException extends RuntimeException {

    /** 状态码*/
    private String status;
    /** 响应码*/
    private String code;
    /** 信息*/
    private String msg;

    public CommonException() {

    }
    public CommonException(String status, String code, String msg) {
        super(msg);
        this.status = status;
        this.code = code;
        this.msg = msg;
    }

    public CommonException(BaseReturnEnum baseReturnEnum) {
        super(baseReturnEnum.getMsg());
        this.status = baseReturnEnum.getStatus();
        this.code = baseReturnEnum.getCode();
        this.msg = baseReturnEnum.getMsg();
    }
    public CommonException(BaseReturnEnum baseReturnEnum,String msg) {
        super(msg);
        this.status = baseReturnEnum.getStatus();
        this.code = baseReturnEnum.getCode();
        this.msg = msg;
    }


    public CommonException(BaseReturnEnum baseReturnEnum, String code, String msg) {
        super(msg);
        this.status = baseReturnEnum.getStatus();
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
