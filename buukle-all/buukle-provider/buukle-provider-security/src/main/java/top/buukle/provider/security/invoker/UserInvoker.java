package top.buukle.provider.security.invoker;

import com.alibaba.fastjson.JSON;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;
import top.buukle.common.request.RequestHead;
import top.buukle.common.util.common.NumberUtil;
import top.buukle.common.util.common.StringUtil;

import top.buukle.common.util.jedis.RedisString;
import top.buukle.common.vo.ThreadParam;
import top.buukle.provider.security.constants.UserInfoCacheConstants;
import top.buukle.plugin.security.entity.*;
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
     * 缓存全局按钮列表信息
     * @param globalButtonList
     */
    public static void saveGlobalButton(List<Button> globalButtonList) {
        RedisString.setWithExpire(UserInfoCacheConstants.GLOBAL_BUTTON_LIST_KEY,JSON.toJSONString(globalButtonList),NumberUtil.LONG_ONE_DAY_SECOND);
    }
    /**
     * 缓存全局菜单列表信息
     * @param globalModuleList
     */
    public static void saveGlobalModule(List<Module> globalModuleList) {
        RedisString.setWithExpire(UserInfoCacheConstants.GLOBAL_MODULE_LIST_KEY,JSON.toJSONString(globalModuleList),NumberUtil.LONG_ONE_DAY_SECOND);
    }

    /**
     * 缓存全局角色列表信息
     * @param roleList
     */
    public static void saveGlobalRole(List<Role> roleList) {
        RedisString.setWithExpire(UserInfoCacheConstants.GLOBAL_ROLE_LIST_KEY,JSON.toJSONString(roleList),NumberUtil.LONG_ONE_DAY_SECOND);
    }

    /**
     * 缓存全局组别列表信息
     * @param groupsList
     */
    public static void saveGlobalGroups(List<Groups> groupsList) {
        RedisString.setWithExpire(UserInfoCacheConstants.GLOBAL_GROUPS_LIST_KEY,JSON.toJSONString(groupsList),NumberUtil.LONG_ONE_DAY_SECOND);
    }

    /**
     * 根据类型全局缓存信息
     * @param clazz
     */
    public static void clearGlobalCacheInfoByType(Class clazz) {
        if(null == clazz){
            // 清除全局按钮缓存
            RedisString.delete(UserInfoCacheConstants.GLOBAL_BUTTON_LIST_KEY);
            // 清除全局菜单缓存
            RedisString.delete(UserInfoCacheConstants.GLOBAL_MODULE_LIST_KEY);
            // 清除全局角色缓存
            RedisString.delete(UserInfoCacheConstants.GLOBAL_ROLE_LIST_KEY);
            // 清除全局组别缓存
            RedisString.delete(UserInfoCacheConstants.GLOBAL_GROUPS_LIST_KEY);
            return;
        }
        if(clazz.equals(Button.class)){
            // 清除全局按钮缓存
            RedisString.delete(UserInfoCacheConstants.GLOBAL_BUTTON_LIST_KEY);
            return;
        }
        if(clazz.equals(Module.class)){
            // 清除全局菜单缓存
            RedisString.delete(UserInfoCacheConstants.GLOBAL_MODULE_LIST_KEY);
            return;
        }
        if(clazz.equals(Role.class)){
            // 清除全局角色缓存
            RedisString.delete(UserInfoCacheConstants.GLOBAL_ROLE_LIST_KEY);
            return;
        }
        if(clazz.equals(Groups.class)){
            // 清除全局组别缓存
            RedisString.delete(UserInfoCacheConstants.GLOBAL_GROUPS_LIST_KEY);
            return;
        }
    }

    /**
     * 缓存用户信息
     * @param user
     * @param defaultMaxAge
     * @param requestHead
     * @param userCookie   userCookie ==null ? "登录调用" : "认证调用";
     */
    public static String saveUser(User user, String defaultMaxAge, RequestHead requestHead, String userCookie) {
        // 将调用方应用指定默认超时时间缓存到redis ,一天后失效
        RedisString.setWithExpire(UserInfoCacheConstants.APPLICATION_DEFAULT_MAX_AGE_PREFIX + requestHead.getApplicationName(),defaultMaxAge,NumberUtil.LONG_ONE_DAY_SECOND);
        // 绑定用户登录策略到线程本地
        ThreadLocalUtil.set(new ThreadParam.Biulder().setLoginStrategy(user.getLoginStrategy()).build());
        return UserInvoker.saveUserInfoWithPrefixAndStrategy(UserInfoCacheConstants.USER_INFO_KEY_PREFIX,JSON.toJSONString(user),userCookie,requestHead.getApplicationName());
    }
    /**
     * 更新用户信息
     * @param user
     * @param requestHead
     */
    public static String updateUser(User user, RequestHead requestHead, String userCookie) {
        // 绑定用户登录策略到线程本地
        ThreadLocalUtil.set(new ThreadParam.Biulder().setLoginStrategy(user.getLoginStrategy()).build());
        return UserInvoker.saveUserInfoWithPrefixAndStrategy(UserInfoCacheConstants.USER_INFO_KEY_PREFIX,JSON.toJSONString(user),userCookie,requestHead.getApplicationName());
    }

    /**
     * 缓存用户扩展信息
     * @param userExp
     * @param userId
     * @param requestHead
     */
    public static void saveUserExp(UserExp userExp, String userId, RequestHead requestHead) {
        UserInvoker.saveUserInfoWithPrefixAndStrategy(UserInfoCacheConstants.USER_EXP_KEY_PREFIX,JSON.toJSONString(userExp),userId,requestHead.getApplicationName());
    }

    /**
     * 缓存用户所辖用户
     * @param subordinateList
     * @param userId
     * @param requestHead
     */
    public static void saveUserSubordinate(List<String> subordinateList, String userId, RequestHead requestHead) {
        UserInvoker.saveUserInfoWithPrefixAndStrategy(UserInfoCacheConstants.USER_SUBORDINATE_LIST_KEY_PREFIX,JSON.toJSONString(subordinateList),userId,requestHead.getApplicationName());
    }

    /**
     * 缓存用户角色信息
     * @param roleList
     * @param userId
     * @param requestHead
     */
    public static void saveUserRole(List<Role> roleList, String userId, RequestHead requestHead) {
        UserInvoker.saveUserInfoWithPrefixAndStrategy(UserInfoCacheConstants.USER_ROLE_LIST_KEY_PREFIX,JSON.toJSONString(roleList),userId,requestHead.getApplicationName());
    }

    /**
     * 缓存用户菜单信息
     * @param moduleList
     * @param userId
     * @param requestHead
     */
    public static void saveUserModule(List<Module> moduleList, String userId, RequestHead requestHead) {
        UserInvoker.saveUserInfoWithPrefixAndStrategy(UserInfoCacheConstants.USER_MODULE_LIST_KEY_PREFIX,JSON.toJSONString(moduleList),userId,requestHead.getApplicationName());
    }

    /**
     * 缓存用户按钮信息
     * @param buttonList
     * @param userId
     * @param requestHead
     */
    public static void saveUserButton(List<Button> buttonList, String userId, RequestHead requestHead) {
        UserInvoker.saveUserInfoWithPrefixAndStrategy(UserInfoCacheConstants.USER_BUTTON_LIST_KEY_PREFIX,JSON.toJSONString(buttonList),userId,requestHead.getApplicationName());
    }

    /**
     * 获取用户基本信息缓存信息
     * @param userCookie
     * @return
     */
    public static User getUser(String userCookie) {
        String UserInfoStr = RedisString.get(UserInfoCacheConstants.USER_INFO_KEY_PREFIX + userCookie);
        if(StringUtil.isEmpty(UserInfoStr)){
            throw new BaseException(BaseResponseCode.USER_OUT_OF_TIME);
        }
        return JSON.parseObject(UserInfoStr,User.class);
    }

    /**
     * 获取全局角色列表缓存信息
     * @return
     */
    public static List<Role> getGlobalRole() {
        String globalRoleList = RedisString.get(UserInfoCacheConstants.GLOBAL_ROLE_LIST_KEY);
        return null == globalRoleList ? null : JSON.parseArray(globalRoleList,Role.class);
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
     * 获取全局组别列表信息
     * @return
     */
    public static List<Groups> getGlobalGroups() {
        String globalGroupsListStr = RedisString.get(UserInfoCacheConstants.GLOBAL_GROUPS_LIST_KEY);
        return null == globalGroupsListStr ? null : JSON.parseArray(globalGroupsListStr,Groups.class);
    }

    /**
     * 获取用户所辖用户
     * @param userId
     */
    public static List<String> getUserSubordinate(String userId) {
        String userSubordinate = RedisString.get(UserInfoCacheConstants.USER_SUBORDINATE_LIST_KEY_PREFIX + userId);
        return null == userSubordinate ? null : JSON.parseArray(userSubordinate,String.class);
    }
    /**
     * 获取用户角色列表缓存信息
     * @param userId
     * @return
     */
    public static List<Role> getUserRole(String userId) {
        String userModuleListStr = RedisString.get(UserInfoCacheConstants.USER_ROLE_LIST_KEY_PREFIX + userId);
        return null == userModuleListStr ? null : JSON.parseArray(userModuleListStr,Role.class);
    }

    /**
     * 获取用户菜单缓存信息
     * @param userId
     * @return
     */
    public static List<Module> getUserModule(String userId) {
        String userModuleListStr = RedisString.get(UserInfoCacheConstants.USER_MODULE_LIST_KEY_PREFIX + userId);
        return null == userModuleListStr ? null : JSON.parseArray(userModuleListStr,Module.class);
    }

    /**
     * 获取用户按钮缓存信息
     * @param userId
     * @return
     */
    public static List<Button> getUserButton(String userId) {
        String userModuleListStr = RedisString.get(UserInfoCacheConstants.USER_BUTTON_LIST_KEY_PREFIX + userId);
        return null == userModuleListStr ? new ArrayList<>() : JSON.parseArray(userModuleListStr,Button.class);
    }

    /**
     * 根据类型清除用户的权限信息
     * @param userId
     * @param clazz
     */
    public static void clearUserCacheInfoByType(Class clazz, String userId) {
        if(null == clazz){
            // 清除角色缓存
            RedisString.delete(UserInfoCacheConstants.USER_ROLE_LIST_KEY_PREFIX + userId);
            // 清除菜单缓存
            RedisString.delete(UserInfoCacheConstants.USER_MODULE_LIST_KEY_PREFIX + userId);
            // 清除按钮缓存
            RedisString.delete(UserInfoCacheConstants.USER_BUTTON_LIST_KEY_PREFIX + userId);
            // 清除扩展缓存
            RedisString.delete(UserInfoCacheConstants.USER_EXP_KEY_PREFIX + userId);
            // 清除组别缓存
            RedisString.delete(UserInfoCacheConstants.USER_GROUP_LIST_KEY_PREFIX + userId);
            // 清除下属缓存
            RedisString.delete(UserInfoCacheConstants.USER_SUBORDINATE_LIST_KEY_PREFIX + userId);
            return;
        }
        if(clazz.equals(Role.class)){
            // 清除角色缓存
            RedisString.delete(UserInfoCacheConstants.USER_ROLE_LIST_KEY_PREFIX + userId);
            return;
        }
        if(clazz.equals(Module.class)){
            // 清除菜单缓存
            RedisString.delete(UserInfoCacheConstants.USER_MODULE_LIST_KEY_PREFIX + userId);
            return;
        }
        if(clazz.equals(Button.class)){
            // 清除按钮缓存
            RedisString.delete(UserInfoCacheConstants.USER_BUTTON_LIST_KEY_PREFIX + userId);
            return;
        }
        if(clazz.equals(Button.class)){
            // 清除扩展缓存
            RedisString.delete(UserInfoCacheConstants.USER_EXP_KEY_PREFIX + userId);
            return;
        }
        if(clazz.equals(Button.class)){
            // 清除组别缓存
            RedisString.delete(UserInfoCacheConstants.USER_GROUP_LIST_KEY_PREFIX + userId);
            return;
        }
        if(clazz.equals(Button.class)){
            // 清除下属缓存
            RedisString.delete(UserInfoCacheConstants.USER_SUBORDINATE_LIST_KEY_PREFIX + userId);
        }
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

    /**
     * 获取指定菜单id下的按钮列表信息
     * @param moduleId
     * @return
     */
    public static List<Button> getModuleButton(Integer moduleId) {
        String moduleButtonStr = RedisString.get(UserInfoCacheConstants.MODULE_BUTTON_LIST_KEY_PREFIX + moduleId);
        return null == moduleButtonStr ? null : JSON.parseArray(moduleButtonStr,Button.class);
    }

    /**
     * 缓存指定菜单id下的按钮列表信息
     * @param moduleButtons
     * @param moduleId
     */
    public static void saveModuleButton(List<Button> moduleButtons, Integer moduleId) {
        RedisString.setWithExpire(UserInfoCacheConstants.MODULE_BUTTON_LIST_KEY_PREFIX + moduleId ,JSON.toJSONString(moduleButtons),NumberUtil.LONG_ONE_DAY_SECOND);
    }

    /**
     * 清除指定菜单id下的按钮列表信息
     * @param moduleId
     */
    public static void deleteModuleButton(Integer moduleId) {
        RedisString.delete(UserInfoCacheConstants.MODULE_BUTTON_LIST_KEY_PREFIX + moduleId);
    }

    /**
     * 登出
     * @param cookieValue
     */
    public static void logout(String cookieValue) {
        RedisString.delete(cookieValue);
    }
}
