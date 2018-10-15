package top.buukle.provider.security.invoker;

import com.alibaba.fastjson.JSON;
import top.buukle.common.request.RequestHead;
import top.buukle.common.util.common.NumberUtil;
import top.buukle.common.util.common.StringUtil;
import top.buukle.common.util.jedis.RedisString;
import top.buukle.common.vo.ThreadParam;
import top.buukle.provider.security.constants.UserInfoCacheConstants;
import top.buukle.provider.security.entity.*;
import top.buukle.provider.security.util.StringGeneratorUtil;
import top.buukle.common.util.common.ThreadLocalUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/30.
 * @Description : sso 用户信息缓存类
 */
public class UserInvoker {

    /**
     * 缓存全局菜单列表信息
     * @param globalModuleList
     */
    public static void saveGlobalModule(List<Module> globalModuleList) {
        RedisString.setWithExpire(UserInfoCacheConstants.GLOBAL_MODULE_LIST_KEY,JSON.toJSONString(globalModuleList),NumberUtil.LONG_ONE_DAY_SECOND);
    }

    /**
     * 缓存全局按钮列表信息
     * @param globalButtonList
     */
    public static void saveGlobalButton(List<Button> globalButtonList) {
        RedisString.setWithExpire(UserInfoCacheConstants.GLOBAL_BUTTON_LIST_KEY,JSON.toJSONString(globalButtonList),NumberUtil.LONG_ONE_DAY_SECOND);
    }

    /**
     * 缓存用户信息
     * @param user
     * @param defaultMaxAge
     * @param requestHead
     */
    public static String saveUser(User user, String defaultMaxAge, RequestHead requestHead) {
        //将调用方应用指定默认超时时间缓存到redis ,一天后失效
        RedisString.setWithExpire(UserInfoCacheConstants.APPLICATION_DEFAULT_MAX_AGE_PREFIX + requestHead.getApplicationName(),defaultMaxAge,NumberUtil.LONG_ONE_DAY_SECOND);
        //绑定用户登录策略到线程本地
        ThreadLocalUtil.set(new ThreadParam.Biulder().setLoginStrategy(user.getLoginStrategy()).build());
        return UserInvoker.saveUserInfoWithPrefixAndStrategy(UserInfoCacheConstants.USER_INFO_KEY_PREFIX,JSON.toJSONString(user),null,requestHead.getApplicationName());
    }

    /**
     * 缓存用户扩展信息
     * @param userExp
     * @param userCookie
     * @param requestHead
     */
    public static void saveUserExp(UserExp userExp, String userCookie, RequestHead requestHead) {
        UserInvoker.saveUserInfoWithPrefixAndStrategy(UserInfoCacheConstants.USER_EXP_KEY_PREFIX,JSON.toJSONString(userExp),userCookie,requestHead.getApplicationName());
    }

    /**
     * 缓存用户组别信息
     * @param groupList
     * @param userCookie
     * @param requestHead
     */
    public static void saveUserGroup(List<Groups> groupList, String userCookie, RequestHead requestHead) {
        UserInvoker.saveUserInfoWithPrefixAndStrategy(UserInfoCacheConstants.USER_GROUP_LIST_KEY_PREFIX,JSON.toJSONString(groupList),userCookie,requestHead.getApplicationName());
    }

    /**
     * 缓存用户所辖用户
     * @param userList
     * @param userCookie
     * @param requestHead
     */
    public static void saveUserSubordinate(List<User> userList, String userCookie, RequestHead requestHead) {
        UserInvoker.saveUserInfoWithPrefixAndStrategy(UserInfoCacheConstants.USER_SUBORDINATE_LIST_KEY_PREFIX,JSON.toJSONString(userList),userCookie,requestHead.getApplicationName());
    }

    /**
     * 缓存用户角色信息
     * @param roleList
     * @param userCookie
     * @param requestHead
     */
    public static void saveUserRole(List<Role> roleList, String userCookie, RequestHead requestHead) {
        UserInvoker.saveUserInfoWithPrefixAndStrategy(UserInfoCacheConstants.USER_ROLE_LIST_KEY_PREFIX,JSON.toJSONString(roleList),userCookie,requestHead.getApplicationName());
    }

    /**
     * 缓存用户菜单信息
     * @param moduleList
     * @param userCookie
     * @param requestHead
     */
    public static void saveUserModule(List<Module> moduleList, String userCookie, RequestHead requestHead) {
        UserInvoker.saveUserInfoWithPrefixAndStrategy(UserInfoCacheConstants.USER_MODULE_LIST_KEY_PREFIX,JSON.toJSONString(moduleList),userCookie,requestHead.getApplicationName());
    }

    /**
     * 缓存用户按钮信息
     * @param buttonList
     * @param userCookie
     * @param requestHead
     */
    public static void saveUserButton(List<Button> buttonList, String userCookie, RequestHead requestHead) {
        UserInvoker.saveUserInfoWithPrefixAndStrategy(UserInfoCacheConstants.USER_BUTTON_LIST_KEY_PREFIX,JSON.toJSONString(buttonList),userCookie,requestHead.getApplicationName());
    }

    /**
     * 获取用户基本信息缓存信息
     * @param userCookie
     * @return
     */
    public static User getUser(String userCookie) {
        String UserInfoStr = RedisString.get(UserInfoCacheConstants.USER_INFO_KEY_PREFIX + userCookie);
        return StringUtil.isEmpty(UserInfoStr) ? null : JSON.parseObject(UserInfoStr,User.class);
    }

    /**
     * 获取全局菜单列表缓存信息
     * @return
     */
    public static List<Module> getGlobalModule() {
        String globalModuleListStr = RedisString.get(UserInfoCacheConstants.GLOBAL_MODULE_LIST_KEY);
        return null == globalModuleListStr ? null : JSON.parseArray(globalModuleListStr,Module.class);
    }

    /**
     * 获取全局按钮列表缓存信息
     * @return
     */
    public static List<Button> getGlobalButton() {
        String globalButtonListStr = RedisString.get(UserInfoCacheConstants.GLOBAL_BUTTON_LIST_KEY);
        return null == globalButtonListStr ? null : JSON.parseArray(globalButtonListStr,Button.class);
    }

    /**
     * 获取用户角色列表缓存信息
     * @param userCookie
     * @return
     */
    public static List<Role> getUserRole(String userCookie) {
        String userModuleListStr = RedisString.get(UserInfoCacheConstants.USER_ROLE_LIST_KEY_PREFIX + userCookie);
        return null == userModuleListStr ? null : JSON.parseArray(userModuleListStr,Role.class);
    }

    /**
     * 获取用户菜单缓存信息
     * @param userCookie
     * @return
     */
    public static List<Module> getUserModule(String userCookie) {
        String userModuleListStr = RedisString.get(UserInfoCacheConstants.USER_MODULE_LIST_KEY_PREFIX + userCookie);
        return null == userModuleListStr ? null : JSON.parseArray(userModuleListStr,Module.class);
    }

    /**
     * 获取用户按钮缓存信息
     * @param userCookie
     * @return
     */
    public static List<Button> getUserButton(String userCookie) {
        String userModuleListStr = RedisString.get(UserInfoCacheConstants.USER_BUTTON_LIST_KEY_PREFIX + userCookie);
        return null == userModuleListStr ? new ArrayList<>() : JSON.parseArray(userModuleListStr,Button.class);
    }

    /**
     * 清除用户的权限信息
     * @param userCookie
     */
    public static void clearUserSecurityInfo(String userCookie) {
        //清除角色缓存
        RedisString.delete(UserInfoCacheConstants.USER_ROLE_LIST_KEY_PREFIX + userCookie);
        //清除菜单缓存
        RedisString.delete(UserInfoCacheConstants.USER_MODULE_LIST_KEY_PREFIX + userCookie);
        //清除按钮缓存
        RedisString.delete(UserInfoCacheConstants.USER_BUTTON_LIST_KEY_PREFIX + userCookie);
    }

    /**
     * 缓存信息
     * @param prefix
     * @param value
     * @param userCookie
     * @param applicationName
     */
    private static String saveUserInfoWithPrefixAndStrategy(String prefix, String value, String userCookie, String applicationName) {
        // userCookie 处理
        userCookie = StringUtil.isEmpty(userCookie) ? StringGeneratorUtil.generateUserCookie() : userCookie;
        // defaultMaxAge处理
        String defaultMaxAge = StringUtil.isEmpty(RedisString.get(UserInfoCacheConstants.APPLICATION_DEFAULT_MAX_AGE_PREFIX + applicationName)) ? NumberUtil.LONG_FIVE_MINUTES_SECOND.toString() : RedisString.get(UserInfoCacheConstants.APPLICATION_DEFAULT_MAX_AGE_PREFIX + applicationName);

        if(null!= ThreadLocalUtil.get() && null != ThreadLocalUtil.get().getLoginStrategy() &&  ThreadLocalUtil.get().getLoginStrategy().equals(UserInfoCacheConstants.USER_LOGIN_CACHE_STRATEGY_ONE_WEEK)){
            RedisString.setWithExpire(prefix + userCookie,value, NumberUtil.LONG_ONE_WEEK_SECOND);
            return userCookie;
        }
        if(null!= ThreadLocalUtil.get() && null !=  ThreadLocalUtil.get().getLoginStrategy() &&  ThreadLocalUtil.get().getLoginStrategy().equals(UserInfoCacheConstants.USER_LOGIN_CACHE_STRATEGY_FIVE_MINUTES)){
            RedisString.setWithExpire(prefix + userCookie, value, NumberUtil.LONG_FIVE_MINUTES_SECOND);
            return userCookie;
        }
        RedisString.setWithExpire(prefix + userCookie, value, Long.parseLong(defaultMaxAge));
        return userCookie;
    }

}
