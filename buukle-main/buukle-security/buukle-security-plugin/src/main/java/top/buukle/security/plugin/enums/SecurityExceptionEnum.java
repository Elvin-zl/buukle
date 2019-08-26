package top.buukle.security.plugin.enums;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/8/3.
 * @Description :
 */
public enum SecurityExceptionEnum {

    SECURITY_PLUGIN_EXCEPTION("F","020001","布壳儿权限中心系统异常!"),
    SECURITY_PLUGIN_LOAD_EXCEPTION("F","020002" ,"加载security资源目录时,调用security-api接口异常,请稍后重试!" ),
    AUTH_WRONG_NO_COOKIE("F", "020003","未登录!"),
    AUTH_WRONG_COOKIE_OTHER("F", "020004","该账户已在其他设备登录!如非本人操作,请尽快修改密码或锁定账户!"),
    AUTH_WRONG_OUT_OF_TIME("F", "020005","认证超时!"),
    AUTH_WRONG_NO_PERM("F","020006","您没有该资源权限!"),
    AUTH_WRONG_NO_ROLE("F","020007","您在当前应用下没有角色!"),
    AUTH_WRONG_OTHER_LOGIN("F","020008","该账户已经在其他设备登录!"),
    AUTH_WRONG_APP_NO_REG("F","020009", "目标接口未注册,请联系应用管理员!"),
    AUTH_WRONG_APP_NO_SRC("F","020010", "目标接口未配置,请联系应用管理员!"),
    AUTH_WRONG_DATA_ISOLATION_NO_ROLE_SUBS("F","020011" ,"您在当前应用下没有角色!"),
    LOGIN_WRONG_PARAM_EXCEPTION("F","020012" ,"参数异常！"),
    LOGIN_WRONG_USER_NULL("F","020013" ,"用户名或密码错误!"),

    ;

    private String status;
    private String code;
    private String msg;

    SecurityExceptionEnum(String status, String code, String msg) {
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
