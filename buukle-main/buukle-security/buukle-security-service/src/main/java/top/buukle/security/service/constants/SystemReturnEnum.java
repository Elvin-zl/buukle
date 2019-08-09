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
    APP_RESOURCE_EXCEPTION("F","020000","应用获取资源列表异常,应用不存在!"),

    /*--user 返回码{03}{**}{**}*/
    USER_BATCH_DELETE_IDS_NULL("F","030000","批量删除用户失败,参数错误!"),
    USER_SAVE_OR_EDIT_PARAM_WRONG("F","030001","保存或更新用户失败,用户UID信息异常!"),
    USER_SAVE_OR_EDIT_USERNAME_NULL("F","030002","保存或更新用户失败,用户名为空!"),
    USER_SAVE_OR_EDIT_PASSWORD_NULL("F","030003","保存或更新用户失败,密码为空!"),
    USER_SAVE_OR_EDIT_RPASSWORD_NULL("F","030004","保存或更新用户失败,确认密码为空!"),
    USER_SAVE_OR_EDIT_TWO_PED_NOT_SAME("F","030005","保存或更新用户失败,确认密码与密码不一致!"),
    USER_SAVE_OR_EDIT_USERNAME_EXIST("F","030006","保存或更新用户失败,用户名已存在!"),

    /*--role 返回码{04}{**}{**}*/
    ROLE_SAVE_OR_EDIT_APPID_NULL("F","040001","保存或更新用户失败,所属应用id为空!"),
    ROLE_SAVE_OR_EDIT_PID_NULL("F","040002","保存或更新用户失败,上级角色id为空!"),
    ROLE_SAVE_OR_EDIT_NAME_NULL("F","040003","保存或更新用户失败,角色名称为空!"),


    ;

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
