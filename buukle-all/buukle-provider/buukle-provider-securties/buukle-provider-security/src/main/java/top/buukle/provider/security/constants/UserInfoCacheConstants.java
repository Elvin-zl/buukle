package top.buukle.provider.security.constants;


/**
 * @Author elvin
 * @Date Created by elvin on 2018/8/30.
 * @Description _
 */
public class UserInfoCacheConstants {


    /** 全局菜单缓存信息 KEY*/
    public static final String GLOBAL_MODULE_LIST_KEY = "GLOBAL_MODULE_LIST_KEY:";
    /** 全局按钮缓存信息 KEY*/
    public static final String GLOBAL_BUTTON_LIST_KEY = "GLOBAL_BUTTON_LIST_KEY:";
    /** 全局角色缓存信息 KEY*/
    public static final String GLOBAL_ROLE_LIST_KEY = "GLOBAL_ROLE_LIST_KEY:";
    /** 全局组别缓存信息 KEY*/
    public static final String GLOBAL_GROUPS_LIST_KEY = "GLOBAL_GROUPS_LIST_KEY:";
    /** 调用系统默认自动登录超时策略cache前缀*/
    public static final String APPLICATION_DEFAULT_MAX_AGE_PREFIX = "APPLICATION_DEFAULT_MAX_AGE_PREFIX:";
    /** 用户基本信息cache前缀*/
    public static final String USER_INFO_KEY_PREFIX = "USER_INFO_KEY_PREFIX:";

    /** 用户扩展信息cache前缀*/
    public static final String USER_EXP_KEY_PREFIX = "USER_EXP_KEY_PREFIX:";
    /** 用户组别信息cache前缀*/
    public static final String USER_GROUP_LIST_KEY_PREFIX = "USER_GROUP_LIST_KEY_PREFIX:";
    /** 用户下级信息cache前缀*/
    public static final String USER_SUBORDINATE_LIST_KEY_PREFIX = "USER_SUBORDINATE_LIST_KEY_PREFIX:";
    /** 用户角色信息cache前缀*/
    public static final String USER_ROLE_LIST_KEY_PREFIX = "USER_ROLE_LIST_KEY_PREFIX:";
    /** 用户菜单信息cache前缀*/
    public static final String USER_MODULE_LIST_KEY_PREFIX = "USER_MODULE_LIST_KEY_PREFIX:";
    /** 用户按钮信息cache前缀*/
    public static final String USER_BUTTON_LIST_KEY_PREFIX = "USER_BUTTON_LIST_KEY_PREFIX:";

    /** 指定菜单按钮信息cache前缀*/
    public static final String MODULE_BUTTON_LIST_KEY_PREFIX = "MODULE_BUTTON_LIST_KEY_PREFIX:";
    /** 用户自动登录超时策略 _ 一周*/
    public static final Integer USER_LOGIN_CACHE_STRATEGY_ONE_WEEK = 1;
    /** 用户自动登录超时策略 _ 5分钟*/
    public static final Integer USER_LOGIN_CACHE_STRATEGY_FIVE_MINUTES = 0;
}
