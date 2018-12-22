package top.buukle.consumer.cms.constants;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/12/21.
 * @Description : 状态信息常量类
 */
public class StatusConstants {


    /** 通用状态 : 启用*/
    public static Integer STATUS_OPEN = 1;
    /** 通用状态 : 禁用*/
    public static Integer STATUS_CLOSE = 0;

    /** 文章状态 : 用户假删除*/
    public static Integer STATUS_DELETED_CONCELABLE = -2;
    /** 文章状态 : 封禁*/
    public static Integer STATUS_BANED = 0;
    /** 文章状态 : 发布成功*/
    public static Integer STATUS_PUBLISHED = 1;
    /** 文章状态 : 真删除*/
    public static Integer STATUS_DELETED_CANNOT_CONCEL = 2;
    /** 文章状态 : 发布待审核*/
    public static Integer STATUS_WAITTING_FOR_AUDIT_PUBLISH = 3;
    /** 文章状态 : 解禁待审核*/
    public static Integer STATUS_WAITTING_FOR_AUDIT_RELEASE = 4;
    /** 文章状态 : 解禁审核不通过*/
    public static Integer STATUS_NOT_RELESED = 5;
    /** 文章状态 : 草稿*/
    public static Integer STATUS_DRAFT = 6;

}