package top.buukle.security.service.constants;


import top.buukle.common.call.code.BaseReturnEnum;

/**
 * @Author: elvin
 * @Date: 2019/7/28/028 4:10
 * @see : 返回码格式 {xx}{xx}{xx} ==> {应用序号}{模块序号}{异常序号}
 */
public enum SystemReturnEnum {

    SUCCESS(BaseReturnEnum.SUCCESS),
    FAILED(BaseReturnEnum.FAILED),

    /*--security系统级别*/
    /** 删除异常 */
    DELETE_INFO_EXCEPTION("F","010000","删除失败!更新状态异常!"),

    /*--api 返回码{02}{**}{**}*/
    /**应用不存在*/
    APP_RESOURCE_EXCEPTION("F","020000","应用获取资源列表异常,应用不存在!"),

    /*--user 返回码{03}{**}{**}*/
    USER_BATCH_IDS_NULL("F","030000","批量删除用户失败,参数错误!");


    private String status;
    private String code;
    private String msg;

    SystemReturnEnum(BaseReturnEnum baseReturnEnum) {
        this.status = baseReturnEnum.getStatus();
        this.code = baseReturnEnum.getCode();
        this.msg = baseReturnEnum.getMsg();
    }
    SystemReturnEnum(String status, String code, String msg) {
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
