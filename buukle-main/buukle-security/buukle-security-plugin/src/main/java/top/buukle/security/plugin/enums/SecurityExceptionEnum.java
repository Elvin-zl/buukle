package top.buukle.security.plugin.enums;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/8/3.
 * @Description :
 */
public enum SecurityExceptionEnum {


    SYSTEM_OUT_OF_TIME(SecurityExceptionEnumType.VIEW.type(),"SYSTEM_OUT_OF_TIME","登录超时!","/outOfTime"),
    NO_AUTH(SecurityExceptionEnumType.VIEW.type(),"NO_AUTH","用户未认证或认证已超时!","/noAuth"),
    USER_NO_PERM(SecurityExceptionEnumType.VIEW.type(),"USER_NO_PERM","没有该资源(菜单/组件)权限!","/noPerm"),
    USER_NO_ROLE(SecurityExceptionEnumType.VIEW.type(),"USER_NO_ROLE","用户在当前应用下没有角色!","/noPerm"),
    USER_NO_PERM_OTHER_LOGIN(SecurityExceptionEnumType.VIEW.type(),"USER_NO_PERM_OTHER_LOGIN","该账户已经在其他设备登录!","/noPerm"),
    APP_NO_REG(SecurityExceptionEnumType.VIEW.type(),"APP_NO_REG", "目标接口未注册,请联系应用管理员!","/noPerm"),
    APP_NO_SRC(SecurityExceptionEnumType.VIEW.type(),"APP_NO_SRC", "目标接口未配置,请联系应用管理员!","/noPerm"),
    LOAD_EXCEPTION(SecurityExceptionEnumType.JSON.type(),"LOAD_EXCEPTION" ,"加载security资源目录时,调用security-api接口异常,请稍后重试!" ,""),
    DATA_ISOLATION_NO_ROLE_SUBS(SecurityExceptionEnumType.JSON.type(),"LOAD_EXCEPTION" ,"失败!该用户在当前应用下没有角色!" ,"");

    private String type;
    private String code;
    private String msg;
    private String callBackUrl;

    SecurityExceptionEnum(String type, String code, String msg,String callBackUrl) {
        this.type = type;
        this.code = code;
        this.msg = msg;
        this.callBackUrl = callBackUrl;

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
