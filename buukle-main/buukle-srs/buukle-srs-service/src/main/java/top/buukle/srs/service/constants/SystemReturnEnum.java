package top.buukle.srs.service.constants;


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
    OPERATE_INFO_SYSTEM_PROTECT_EXCEPTION("F","010001","操作失败,系统保护数据禁止操作!"),

    /*--api 返回码{02}{**}{**}*/
    APP_RESOURCE_EXCEPTION("F","010100","应用获取资源列表异常,应用不存在!"),

    /*--user 返回码{03}{**}{**}*/
    USER_BATCH_DELETE_IDS_NULL("F","010200","批量删除用户失败,参数错误!"),
    USER_SAVE_OR_EDIT_PARAM_WRONG("F","010201","保存或更新用户失败,用户UID信息异常!"),
    USER_SAVE_OR_EDIT_USERNAME_NULL("F","010202","保存或更新用户失败,用户名为空!"),
    USER_SAVE_OR_EDIT_PASSWORD_NULL("F","010203","保存或更新用户失败,密码为空!"),
    USER_SAVE_OR_EDIT_RPASSWORD_NULL("F","010204","保存或更新用户失败,确认密码为空!"),
    USER_SAVE_OR_EDIT_TWO_PED_NOT_SAME("F","010205","保存或更新用户失败,确认密码与密码不一致!"),
    USER_SAVE_OR_EDIT_USERNAME_EXIST("F","010206","保存或更新用户失败,用户名已存在!"),
    USER_SET_USER_ROLE_PRE_APP_CODE_WRONG("F","010207","准备分配角色失败,该应用code信息有误或不存在!"),
    USER_SET_USER_ROLE_ROLE_ID_MULTI("F","010208","分配角色失败,用户在一个应用内禁止设置多个角色!"),
    USER_SET_USER_ROLE_NO_LEVEL("F","010209","该用户当前角色不支持您操作!"),
    USER_SET_USER_ROLE_NO_ROLE("F","010210","您该应用下没有角色信息!"),
    USER_SAVE_OR_EDIT_APP_NOT_EXIST("F","010211","应用信息异常!"),
    USER_SAVE_OR_EDIT_NO_PERM("F","010212","您当前角色不支持操作此用户或其中一个!"),

    /*--role 返回码{04}{**}{**}*/
    ROLE_SAVE_OR_EDIT_APPID_NULL("F","010301","保存或更新角色失败,所属应用id为空!"),
    ROLE_SAVE_OR_EDIT_PID_NULL("F","010302","保存或更新角色失败,上级角色id为空!"),
    ROLE_SAVE_OR_EDIT_NAME_NULL("F","010303","保存或更新角色失败,角色名称为空!"),
    ROLE_SET_MENU_WRONG_BTN_LIST_NOT_EXIST("F","010304","角色设置菜单失败,应用按钮目录异常!"),
    ROLE_SET_MENU_WRONG_MENU_BTN_NOT_MATCH("F","010305","角色设置菜单失败,菜单和按钮关系不正确!"),
    ROLE_SET_MENU_WRONG_ROLE_NO_LEVEL("F","010306","您当前角色不支持操作此角色或其中一个!"),

    /*--menu 返回码{05}{**}{**}*/
    MENU_SAVE_OR_EDIT_APPID_NULL("F","010401","保存或更新菜单失败,所属应用id为空!"),
    MENU_SAVE_OR_EDIT_PID_NULL("F","010402","保存或更新菜单失败,上级菜单为空!"),
    MENU_SAVE_OR_EDIT_NAME_NULL("F","010403","保存或更新菜单失败,菜单名称为空!"),
    MENU_SAVE_OR_EDIT_NO_PERM("F","010404","您当前角色不支持操作此菜单或其中一个!"),


    /*--button 返回码{06}{**}{**}*/
    BUTTON_SAVE_OR_EDIT_APPID_NULL("F","010501","保存或更新按钮失败,所属应用id为空!"),
    BUTTON_SAVE_OR_EDIT_MENUID_NULL("F","010502","保存或更新按钮失败,所属菜单为空!"),
    BUTTON_SAVE_OR_EDIT_NAME_NULL("F","010503","保存或更新按钮失败,按钮名称为空!"),
    BUTTON_SAVE_OR_EDIT_NO_PERM("F","010504","您当前角色不支持操作此按钮或其中一个!"),

    /*--application 返回码{07}{**}{**}*/
    APPLICATION_SAVE_OR_EDIT_NO_PERM("F","010601","您当前角色不支持操作此应用或其中一个!"),
    APPLICATION_SAVE_OR_EDIT_NO_CREATOR("F","010602","操作失败,该记录创建信息有误!"),
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
