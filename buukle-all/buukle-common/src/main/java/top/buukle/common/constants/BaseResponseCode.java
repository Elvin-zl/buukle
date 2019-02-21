package top.buukle.common.constants;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/22.
 * @Description :
 *
 * <p> this enum is used as the response code manager class, we define a data structure like this </p> :
 *     { status;  code; msg; }
 * <p>  use this structure , we can response the system witch call our web server.in this data structure ,
 *      'status' mean the response status of once request, 'code' mean the error code of the  response,the msg
 *      is the same.
 * <p/>
 * <p>the field 'code' must follow this rule :
 *     1. the length of the string code must be six ,and it must be all number.
 *     2. the first two numbers means every project's code,like :
 *        {01 = security; 02 = cms; 03 = article; 04 = www; 05 = album; 06 = security-plugin; 99 = system}
 *        the third and fourth number means every module's error code code, from 00 - 99;
 *        the third and fourth number means every project's module code, from 00 - 99;
 * </p>
 */
public enum BaseResponseCode {


    /*----------------------------------------------SYSTEM--99{**}{**}--------------------------------------------------------------------*/
    // 全局积极,消极响应 --9999{**}
    SUCCESS(BaseResponseCode.SUCCESSFUL,"999999","成功!"),
    FAILED(BaseResponseCode.FAILURES,"999998","失败!"),
    NOT_FOUND(BaseResponseCode.FAILURES,"999997","页面走丢了!"),
    // 通讯响应 --9998{**}
    HTTP_CELENE_FAILED(BaseResponseCode.FAILURES, "999899", "通讯失败!"),

    /*----------------------------------------------SECURITY--01{**}{**}--------------------------------------------------------------------*/
    // 登录,验签 --0100{**}
    LOGIN_FAILED(BaseResponseCode.FAILURES, "010000","登录失败,参数错误!" ),
    LOGIN_FAILED_USERNAME_PWD_NULL(BaseResponseCode.FAILURES, "010001","登录失败,用户名或密码为空!"),
    USER_LOGIN_USERNAME_PASSWORD_WRONG(BaseResponseCode.FAILURES, "010002","登录失败,密码错误!"),
    LOGIN_FAILED_USER_LOGIN_STRATEGY_AND_DEFAULT_MAX_AGE_NULL(BaseResponseCode.FAILURES, "010003", "登录失败,用户登陆策略和缺省设置为空!"),
    LOGIN_FAILED_USER_BANED(BaseResponseCode.FAILURES, "010004", "登录失败,用户已经被禁用!"),
    LOGOUT_FAILED_COOKIE_VALUE_NULL(BaseResponseCode.FAILURES, "010005", "登出失败,用户客户端标识信息为空!"),

    // 用户认证授权错误返回码  --0101{**}
    USER_PERMISSION_PARAM_WRONG(BaseResponseCode.FAILURES,"010101","用户认证失败!认证参数错误!" ),
    USER_PERMISSION_GLOBAL_MODULE_LIST_NULL(BaseResponseCode.FAILURES, "010102", "用户授权失败!全局菜单列表为空!"),
    USER_PERMISSION_GLOBAL_BUTTON_LIST_NULL(BaseResponseCode.FAILURES, "010103", "用户授权失败!全局按钮列表为空!"),
    USER_PERMISSION_USER_MODULE_LIST_NULL(BaseResponseCode.FAILURES, "010104", "用户授权失败!用户菜单列表为空!"),
    USER_PERMISSION_USER_NO_PERMISSION(BaseResponseCode.FAILURES, "010105", "请求失败!当前用户无此权限!" ),
    USER_PERMISSION_USER_ROLE_LIST_NULL(BaseResponseCode.FAILURES, "010106","用户授权失败!用户角色为空!"),
    USER_COOKIE_NULL(BaseResponseCode.FAILURES, "010107","操作失败,获取用户信息为空!" ),
    USER_OUT_OF_TIME(BaseResponseCode.FAILURES, "010108","登录超时!" ),

    // 菜单错误返回码 --0102{**}
    MODULE_ADD_NAME_NULL(BaseResponseCode.FAILURES, "010200","更新菜单参数检验格式不通过,名称为空!" ),
    MODULE_ADD_PID_NULL(BaseResponseCode.FAILURES, "010201","更新菜单参数检验格式不通过,父级菜单id为空!" ),
    MODULE_ADD_STATUS_NULL(BaseResponseCode.FAILURES, "010202","更新菜单参数检验格式不通过,状态为空!" ),
    ROLE_ADD_NAME_NULL(BaseResponseCode.FAILURES, "010203","添加角色参数检验格式不通过,角色名称为空!" ),

    // 角色错误返回码 --0102{**}
    ROLE_ADD_STATUS_NULL(BaseResponseCode.FAILURES, "010310","添加角色参数检验格式不通过,角色状态为空!" ),
    ROLE_EDIT_NAME_NULL(BaseResponseCode.FAILURES, "010311","更新角色参数检验格式不通过,角色名称为空!" ),
    ROLE_EDIT_STATUS_NULL(BaseResponseCode.FAILURES, "010312","更新角色参数检验格式不通过,角色状态为空!" ),
    ROLE_ADD_ROLE_LEVEL_NULL(BaseResponseCode.FAILURES, "010313","添加角色参数检验格式不通过,角色级别为空!" ),


    // 用户操作返回码 --0104{**}
    USER_ADD_USERNAME_NULL(BaseResponseCode.FAILURES, "010400","添加用户参数检验格式不通过,用户名为空!"),
    USER_ADD_PASSWORD_NULL(BaseResponseCode.FAILURES, "010401","添加用户参数检验格式不通过,密码为空!"),
    USER_ADD_GENDER_NULL(BaseResponseCode.FAILURES, "010402","添加用户参数检验格式不通过,性别为空!"),
    USER_ADD_STATUS_NULL(BaseResponseCode.FAILURES, "010403","添加用户参数检验格式不通过,状态为空!"),
    USER_ADD_USERNAME_EXIST(BaseResponseCode.FAILURES, "010404","添加用户失败,用户名已经存在!"),
    USER_SET_ROLE_LIST_NULL(BaseResponseCode.FAILURES, "010405","修改用户角色失败,用户角色列表为空!"),
    USER_SET_ROLE_UPDATE_USER_LEVEL_INFO_WRONG(BaseResponseCode.FAILURES, "010406","修改用户角色失败,更新用户等级归属信息失败!"),
    USER_SET_ROLE_USER_NULL(BaseResponseCode.FAILURES, "010407","修改用户角色失败,用户id对应用户信息为空!"),
    USER_SET_ROLE_USER_LEVEL_BELONGING_RELATION_WRONG(BaseResponseCode.FAILURES, "010408","修改用户角色失败,用户等级和归属关系不匹配!"),
    USER_SET_ROLE_OPERATOR_PERMISSION_NOT_ENOUGH(BaseResponseCode.FAILURES, "010409","修改用户角色失败,当前用户等级不够!"),
    USER_GET_ARTICLE_AUTHOR_USER_ID_NULL(BaseResponseCode.FAILURES, "010410","查询作者信息失败,作者id为空!"),
    USER_UPDATE_BASE_RESOURCE_FAILED(BaseResponseCode.FAILURES, "010411","用户更新基本信息出现异常!"),

    // 系统禁止操作返回码 --0105{**}
    EDIT_FORBIDDEN(BaseResponseCode.FAILURES, "010500","该记录由系统创建,不允许该操作!"),

    // 区域操作返回码 --0106{**}
    GROUPS_ADD_NAME_NULL(BaseResponseCode.FAILURES, "010600","添加组别参数检验格式不通过,名称为空!"),
    GROUPS_ADD_STATUS_NULL(BaseResponseCode.FAILURES, "010601","添加组别参数检验格式不通过,状态为空!"),
    GROUPS_EDIT_NAME_NULL(BaseResponseCode.FAILURES, "010602","修改组别参数检验格式不通过,名称为空!"),
    GROUPS_EDIT_STATUS_NULL(BaseResponseCode.FAILURES, "010603","修改组别参数检验格式不通过,状态为空!"),

    // 数据隔离错误返回码 --0107{**}
    ISOLATION_TABLE_NAME_NULL(BaseResponseCode.FAILURES, "010700","数据隔离查询表名为空!"),
    ISOLATION_QUERY_DIMENSION_NULL(BaseResponseCode.FAILURES, "010701","数据隔离查询维度为空!"),
    ISOLATION_QUERY_CODE_NULL(BaseResponseCode.FAILURES, "010702","数据隔离查询字段名为空!"),

    // 通用查询组件错误返回码 --0108{**}
    COMMON_SELECT_TYPE_NULL(BaseResponseCode.FAILURES, "010800","查询失败!查询标识为空!"),
    COMMON_SELECT_TYPE_SUPER_CODE_NULL(BaseResponseCode.FAILURES, "010801","查询失败!请传入直接上级代码进行查询!"),

    // 按钮操作错误返回码 --0109{**}
    BUTTON_ADD_NAME_NULL(BaseResponseCode.FAILURES, "010900","添加按钮参数检验格式不通过,按钮名称为空!" ),
    BUTTON_ADD_LAYOUTLEVEL_NULL(BaseResponseCode.FAILURES, "010901","添加按钮参数检验格式不通过,按钮分布级别为空!" ),
    BUTTON_ADD_OPERATION_TYPE_NULL(BaseResponseCode.FAILURES, "010902","添加按钮参数检验格式不通过,按钮响应类型为空!" ),
    BUTTON_ADD_REMARK_NULL(BaseResponseCode.FAILURES, "010903","添加按钮参数检验格式不通过,按钮备注为空!" ),
    BUTTON_EDIT_EXCEPTION(BaseResponseCode.FAILURES, "010904","更新按钮失败!"),

    // 参数响应 --0110{**}
    BASE_REQUEST_NULL(BaseResponseCode.FAILURES, "011000", "参数错误!"),
    BASE_REQUEST_APPLICATION_NAME_NULL(BaseResponseCode.FAILURES, "011001", "参数错误!调用方应用名为空!"),
    BASE_REQUEST_FORMAT_INFO_LIST_WRONG(BaseResponseCode.FAILURES, "011002", "请求转换异常!"),
    BASE_REQUEST_PARSE_INFO_LIST_WRONG(BaseResponseCode.FAILURES, "011003", "参数解析异常!"),
    BASE_REQUEST_SIGN_WRONG(BaseResponseCode.FAILURES, "011004", "签名错误!"),
    BASE_REQUEST_SIGN_EXCEPTION(BaseResponseCode.FAILURES, "011005", "验签异常!"),
    BASE_REQUEST_SIGN_PUBLIC_KEY_NULL(BaseResponseCode.FAILURES, "011006", "验签异常,该机构公钥不存在!"),

    /*------------------------------------------------------CMS--02{**}{**}-----------------------------------------------------------------*/
    // 状态操作返回码 --0200{**}
    STATUS_UPDATE_FAIL(BaseResponseCode.FAILURES, "020000", "状态变更失败!"),

    // 文章发布返回码 --0201{**}
    ARTICLE_PUBLISH_FAILED_TITLE_NULL(BaseResponseCode.FAILURES, "020100", "文章发布失败,题目为空!"),
    ARTICLE_PUBLISH_FAILED_DESC_NULL(BaseResponseCode.FAILURES, "020100", "文章发布失败,摘要为空!"),
    ARTICLE_PUBLISH_FAILED_CONTENT_NULL(BaseResponseCode.FAILURES, "020100", "文章发布失败,内容为空!"),
    ARTICLE_PUBLISH_FAILED_PID_NULL(BaseResponseCode.FAILURES, "020100", "文章发布失败,文章分类id为空!"),

    /*---------------------------------------------------WWW--04{**}{**}-----------------------------------------------------------------*/
    // 文章操作返回码 --0401{**}
    ARTICLE_PRAISE_FAILED(BaseResponseCode.FAILURES, "040100", "文章赞数更新异常!"),
    ARTICLE_QUERY_FAILED(BaseResponseCode.FAILURES, "040101", "文章加载异常,文章id解析错误!"),
    ARTICLE_QUERY_ID_NOT_EXIST(BaseResponseCode.FAILURES, "040102", "文章id不存在!"),
    // 图片上传操作返回码 --0402{**}
    UPLOAD_IMAGE_NULL(BaseResponseCode.FAILURES, "040200", "图片上传失败,图片内容为空!"),
    UPLOAD_IMAGE_FORMAT_ERROR(BaseResponseCode.FAILURES, "040201", "图片上传失败,图片格式不正确!"),
    UPLOAD_IMAGE_OFFLINE(BaseResponseCode.FAILURES, "040202", "图片上传失败,离线状态不能上传!"),
    UPLOAD_IMAGE_WRONG(BaseResponseCode.FAILURES, "040203", "图片上传失败,原因:{}"),
    UPLOAD_IMAGE_WRONG_APPLICATION_NULL(BaseResponseCode.FAILURES, "040204", "图片上传失败,应用名为空!"),
    UPLOAD_IMAGE_WRONG_USER_INFO_NULL(BaseResponseCode.FAILURES, "040205", "图片上传失败,未登录或登录超时,不能上传图片!"),
    UPLOAD_IMAGE_WRONG_SIGN_EXCEPTION(BaseResponseCode.FAILURES, "040206", "图片上传失败,验签异常!"),

    // 文章操作返回码 --0402{**}
    ARTICLE_ADD_EXCEPTION(BaseResponseCode.FAILURES, "040300", "请先登录在写文章!"),

    /*----------------------------------------------SECURITY-PLUGIN--06{**}{**}-------------------------------------------------------------*/
    // 登录错误返回码 --0600{**}
    USER_LOGIN_VERIFY_CODE_NULL(BaseResponseCode.FAILURES, "060000", "登录失败!验证码为空!"),
    USER_LOGIN_VERIFY_CODE_WRONG(BaseResponseCode.FAILURES, "060001", "登录失败!验证码错误!"),
    USER_PERMISSION_OPEN_AUTH_NULL(BaseResponseCode.FAILURES, "060002", "授权失败! 请指定授权策略!"),
    USER_LOGIN_USERNAME_PASSWORD_NULL_SSO_PLUGIN(BaseResponseCode.FAILURES, "060003","登录失败!用户名或密码为空!"),
    USER_AUTHENTICATION_FAILED_COOKIE_NULL(BaseResponseCode.FAILURES, "060004","认证失败!客户端标识信息为空!"),
    USER_AUTHENTICATION_FAILED_REQUEST_WRONG(BaseResponseCode.FAILURES, "060005","认证失败!buukle-security配置security.host请求失败!"),
    USER_UPDATE_WRONG_NO_LOGIN(BaseResponseCode.FAILURES, "060006","更新失败!用户登录状态不正确,请重新登陆后再次尝试!"),

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
