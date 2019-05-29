package top.buukle.consumer.www.constants;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/12/21.
 * @Description : 状态信息常量类
 */
public class StatusConstants {

    /** 通用状态 : 启用*/
    public static final Integer STATUS_OPEN = 1;
    /** 通用状态 : 禁用*/
    public static final Integer STATUS_CLOSE = 0;

    /** 通用状态 : 用户假删除*/
    public static final Integer STATUS_DELETED_CONCEALABLE = -2;
    /** 通用状态 : 封禁*/
    public static final Integer STATUS_BANED = 0;
    /** 通用状态 : 发布成功*/
    public static final Integer STATUS_PUBLISHED = 1;
    /** 通用状态 : 真删除*/
    public static final Integer STATUS_DELETED_CANNOT_CONCEL = 2;
    /** 通用状态 : 发布待审核*/
    public static final Integer STATUS_WAITING_FOR_AUDIT_PUBLISH = 3;
    /** 通用状态 : 解禁待审核*/
    public static final Integer STATUS_WAITING_FOR_AUDIT_RELEASE = 4;
    /** 通用状态 : 解禁审核不通过*/
    public static final Integer STATUS_NOT_RELEASED = 5;
    /** 通用状态 : 草稿*/
    public static final Integer STATUS_DRAFT = 6;
    /** 通用状态 : 审核中/处理中*/
    public static final Integer STATUS_AUDITING = 7;

    /** 可见通用状态值列表*/
    public static final List<Integer> ARTICLE_VERSION_STATUS_LIST_CMS = new ArrayList<>();
    public static final List<Integer> ARTICLE_VERSION_STATUS_LIST_WWW =  new ArrayList<>();

    static{
        // 初始化cms可见状态列表值
        ARTICLE_VERSION_STATUS_LIST_CMS.add(StatusConstants.STATUS_PUBLISHED);
        ARTICLE_VERSION_STATUS_LIST_CMS.add(StatusConstants.STATUS_BANED);
        ARTICLE_VERSION_STATUS_LIST_CMS.add(StatusConstants.STATUS_WAITING_FOR_AUDIT_RELEASE);
        ARTICLE_VERSION_STATUS_LIST_CMS.add(StatusConstants.STATUS_WAITING_FOR_AUDIT_PUBLISH);
        ARTICLE_VERSION_STATUS_LIST_CMS.add(StatusConstants.STATUS_NOT_RELEASED);
        // 初始化www可见状态列表值
        ARTICLE_VERSION_STATUS_LIST_WWW.add(StatusConstants.STATUS_PUBLISHED);
        ARTICLE_VERSION_STATUS_LIST_WWW.add(StatusConstants.STATUS_WAITING_FOR_AUDIT_PUBLISH);
        ARTICLE_VERSION_STATUS_LIST_WWW.add(StatusConstants.STATUS_AUDITING);
    }

}
