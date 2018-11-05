package top.buukle.common.constants;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/22.
 * @Description :
 *
 * 系统响应码编码规则 : "000000" --> 6位
 *
 *      1-2位 : 指响应系统编码
 *          00 = mc;
 *          01 = sso;
 *          02 = cms;
 *          03 = article;
 *          04 = portal;
 *          05 = album;
 *          06 = buukle-security;
 *          99 = 系统;
 *      3-4位 : 指响应功能编码
 *          每个系统依次从00开始,到99结束;
 *      5-6位 : 指响应功能错误明细编码
 *           每个功能依次从00开始,到99结束;
 */
public enum BaseResponseCode {


    /** 系统响应码*/
    SUCCESS(BaseResponseCode.SUCCESSFUL,"999999","成功!"),
    FAILED(BaseResponseCode.FAILURES,"999998","失败!"),

    HTTP_CELENE_FAILED(BaseResponseCode.FAILURES, "999997", "通讯失败!"),
    BASE_REQUEST_NULL(BaseResponseCode.FAILURES, "999996", "参数错误!"),
    BASE_REQUEST_APPLICATION_NAME_NULL(BaseResponseCode.FAILURES, "999995", "参数错误!调用方应用名为空!"),
    BASE_REQUEST_FORMAT_INFO_LIST_WRONG(BaseResponseCode.FAILURES, "999994", "请求转换异常!"),
    BASE_REQUEST_PARSE_INFO_LIST_WRONG(BaseResponseCode.FAILURES, "999993", "参数解析异常!"),
    BASE_REQUEST_SIGN_WRONG(BaseResponseCode.FAILURES, "999992", "签名错误!"),
    BASE_REQUEST_SIGN_EXCEPTION(BaseResponseCode.FAILURES, "999991", "验签异常!"),
    BASE_REQUEST_SIGN_PUBLIC_KEY_NULL(BaseResponseCode.FAILURES, "999990", "验签异常,该机构公钥不存在!"),

    /*----------------------------------------------Security--01{*}{*}{*}{*}--------------------------------------------------------------------*/
    /** 登录,认证,授权 --0100{*}{*}*/
    LOGIN_FAILED(BaseResponseCode.FAILURES, "010000","登录失败!参数错误!" ),
    LOGIN_FAILED_USERNAME_PWD_NULL(BaseResponseCode.FAILURES, "010001","登录失败!用户名或密码为空!"),
    USER_PERMISSION_PARAM_WRONG(BaseResponseCode.FAILURES,"010002","用户认证失败!认证参数错误!" ),
    USER_PERMISSION_GLOBAL_MODULE_LIST_NULL(BaseResponseCode.FAILURES, "010003", "用户授权失败!全局菜单列表为空!"),
    USER_PERMISSION_GLOBAL_BUTTON_LIST_NULL(BaseResponseCode.FAILURES, "010004", "用户授权失败!全局按钮列表为空!"),
    USER_PERMISSION_USER_MODULE_LIST_NULL(BaseResponseCode.FAILURES, "010005", "用户授权失败!用户菜单列表为空!"),
    USER_PERMISSION_USER_NO_PERMISSION(BaseResponseCode.FAILURES, "010006", "请求失败!当前用户无此权限!" ),
    USER_PERMISSION_USER_ROLE_LIST_NULL(BaseResponseCode.FAILURES, "010007","用户授权失败!用户角色为空!"),
    USER_COOKIE_NULL(BaseResponseCode.FAILURES, "010008","操作失败,获取用户信息为空!" ),
    USER_OUT_OF_TIME(BaseResponseCode.FAILURES, "010009","登录超时!" ),
    BUTTON_ADD_NAME_NULL(BaseResponseCode.FAILURES, "010010","添加按钮参数检验格式不通过,按钮名称为空!" ),
    BUTTON_ADD_LAYOUTLEVEL_NULL(BaseResponseCode.FAILURES, "010011","添加按钮参数检验格式不通过,按钮分布级别为空!" ),
    BUTTON_ADD_OPERATION_TYPE_NULL(BaseResponseCode.FAILURES, "010012","添加按钮参数检验格式不通过,按钮响应类型为空!" ),
    BUTTON_ADD_REMARK_NULL(BaseResponseCode.FAILURES, "010013","添加按钮参数检验格式不通过,按钮备注为空!" ),
    BUTTON_EDIT_EXCEPTION(BaseResponseCode.FAILURES, "010014","更新按钮失败!"),
    MODULE_ADD_NAME_NULL(BaseResponseCode.FAILURES, "010015","更新菜单参数检验格式不通过,名称为空!" ),
    MODULE_ADD_PID_NULL(BaseResponseCode.FAILURES, "010016","更新菜单参数检验格式不通过,父级菜单id为空!" ),
    MODULE_ADD_STATUS_NULL(BaseResponseCode.FAILURES, "010017","更新菜单参数检验格式不通过,状态为空!" ),
    ROLE_ADD_NAME_NULL(BaseResponseCode.FAILURES, "010018","添加角色参数检验格式不通过,角色名称为空!" ),
    ROLE_ADD_STATUS_NULL(BaseResponseCode.FAILURES, "010018","添加角色参数检验格式不通过,角色状态为空!" ),
    ROLE_EDIT_NAME_NULL(BaseResponseCode.FAILURES, "010019","更新角色参数检验格式不通过,角色名称为空!" ),
    ROLE_EDIT_STATUS_NULL(BaseResponseCode.FAILURES, "010019","更新角色参数检验格式不通过,角色状态为空!" ),
    USER_ADD_USERNAME_NULL(BaseResponseCode.FAILURES, "010020","添加用户参数检验格式不通过,用户名为空!"),
    USER_ADD_PASSWORD_NULL(BaseResponseCode.FAILURES, "010021","添加用户参数检验格式不通过,密码为空!"),
    USER_ADD_GENDER_NULL(BaseResponseCode.FAILURES, "010022","添加用户参数检验格式不通过,性别为空!"),
    USER_ADD_STATUS_NULL(BaseResponseCode.FAILURES, "010023","添加用户参数检验格式不通过,状态为空!"),
    USER_ADD_USERNAME_EXIST(BaseResponseCode.FAILURES, "010024","添加用户失败,用户名已经存在!"),
    EDIT_FORBIDDEN(BaseResponseCode.FAILURES, "010025","该记录由系统创建,不允许该操作!"),
    GROUPS_ADD_NAME_NULL(BaseResponseCode.FAILURES, "010026","添加组别参数检验格式不通过,名称为空!"),
    GROUPS_ADD_STATUS_NULL(BaseResponseCode.FAILURES, "010026","添加组别参数检验格式不通过,状态为空!"),
    GROUPS_EDIT_NAME_NULL(BaseResponseCode.FAILURES, "010027","修改组别参数检验格式不通过,名称为空!"),
    GROUPS_EDIT_STATUS_NULL(BaseResponseCode.FAILURES, "010028","修改组别参数检验格式不通过,状态为空!"),


    /*----------------------------------------------MC--00{*}{*}{*}{*}--------------------------------------------------------------------*/
    /** 登录,认证,授权 --0000{*}{*}*/
    USER_LOGIN_PARAM_WRONG(BaseResponseCode.FAILURES, "000000","登录失败!参数错误!" ),
    USER_LOGIN_USERNAME_PASSWORD_NULL(BaseResponseCode.FAILURES, "000001","登录失败!用户名或密码为空!"),
    USER_LOGIN_USERNAME_PASSWORD_WRONG(BaseResponseCode.FAILURES, "000002","登录失败!密码错误!"),
    USER_PERMISSION_USER_ROLE_LIST_NULL_MC(BaseResponseCode.FAILURES, "000003", "用户授权失败!用户菜单列表为空!"),
    LOGIN_FAILED_USER_LOGIN_STRATEGY_AND_DEFAULT_MAX_AGE_NULL(BaseResponseCode.FAILURES, "000004", "登录失败!用户登陆策略和缺省设置为空!"),

    /*----------------------------------------------SS0-PLUGIN--06{*}{*}{*}{*}-------------------------------------------------------------*/
    USER_LOGIN_VERIFY_CODE_NULL(BaseResponseCode.FAILURES, "060000", "登录失败!验证码为空!"),
    USER_LOGIN_VERIFY_CODE_WRONG(BaseResponseCode.FAILURES, "060001", "登录失败!验证码错误!"),
    USER_PERMISSION_OPEN_AUTH_NULL(BaseResponseCode.FAILURES, "060002", "授权失败! 请指定授权策略!"),
    USER_LOGIN_USERNAME_PASSWORD_NULL_SSO_PLUGIN(BaseResponseCode.FAILURES, "060003","登录失败!用户名或密码为空!"),
    USER_AUTHENTICATION_FAILED_COOKIE_NULL(BaseResponseCode.FAILURES, "060004","认证失败!客户端标识信息为空!"),
    USER_AUTHENTICATION_FAILED_REQUEST_WRONG(BaseResponseCode.FAILURES, "060005","认证失败!buukle-security配置security.host请求失败!"),

    ;

    private static final String SUCCESSFUL = "S";
    private static final String FAILURES = "F";

    BaseResponseCode(String status, String code, String msg) {
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
