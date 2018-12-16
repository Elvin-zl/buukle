package top.buukle.plugin.security.vo.response;

import top.buukle.plugin.security.entity.User;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/11/6.
 * @Description : 用户组别信息包装类
 */
public class UserMemberVo extends User {

    /** 是否属于当前组别常量 1: 是*/
    public static final Integer IS_BELONG_TRUE = 1;
    /** 是否属于当前组别常量 1: 否*/
    public static final Integer IS_BELONG_FALSE = 0;
    /** 是否为当前组别管理员 1 : 是*/
    public static final Integer IS_ADMIN_TRUE = 1;
    /** 是否为当前组别管理员 0 : 否*/
    public static final Integer IS_ADMIN_FALSE = 0;

    /** 是否属于当前组别*/
    private Integer isBelong;
    /** 是否为当前组别管理员*/
    private Integer isAdmin;
    /** 用户当前所属的组别id*/
    private Integer currentGroupsId;
    /** 用户当前所属的组别名称*/
    private String currentGroupsName;

    public Integer getIsBelong() {
        return isBelong;
    }

    public void setIsBelong(Integer isBelong) {
        this.isBelong = isBelong;
    }

    public Integer getCurrentGroupsId() {
        return currentGroupsId;
    }

    public void setCurrentGroupsId(Integer currentGroupsId) {
        this.currentGroupsId = currentGroupsId;
    }

    public String getCurrentGroupsName() {
        return currentGroupsName;
    }

    public void setCurrentGroupsName(String currentGroupsName) {
        this.currentGroupsName = currentGroupsName;
    }

    public static Integer getIsBelongTrue() {
        return IS_BELONG_TRUE;
    }

    public static Integer getIsBelongFalse() {
        return IS_BELONG_FALSE;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }
}
