package top.buukle.common.dataIsolation;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/12/5.
 * @Description : 用户信息常量类
 */
public class IsolationConstants {

    /** 用户级别 : boss 级别*/
    public static final Integer USER_LEVEL_BOSS = 0;
    /** 用户级别 :  平台级别*/
    public static final Integer USER_LEVEL_PLATFORM = 1;
    /** 用户级别 :  代理商级别*/
    public static final Integer USER_LEVEL_AGENT = 2;
    /** 用户级别 :  区域管理级别*/
    public static final Integer USER_LEVEL_GROUP = 3;
    /** 用户级别 :  业务员级别*/
    public static final Integer USER_LEVEL_SALESMAN = 4;
    /** 用户级别 :  创建者级别*/
    public static final Integer USER_LEVEL_CREATOR = 5;

    /** 用户级别字段名 :  平台级别*/
    public static final String USER_LEVEL_PLATFORM_FILED =  "platform_id";
    /** 用户级别字段名 :  代理商级别*/
    public static final String USER_LEVEL_AGENT_FILED =  "agent_id";
    /** 用户级别字段名 :  区域管理级别*/
    public static final String USER_LEVEL_GROUP_FILED =  "group_id";
    /** 用户级别字段名 :  业务员级别*/
    public static final String USER_LEVEL_SALESMAN_FILED =  "salesman_id";
    /** 用户级别字段名 :  创建者级别*/
    public static final String USER_LEVEL_CREATOR_FILED =  "creator_code";

    /** 用户级别中文名称 :  平台级别*/
    public static final String USER_LEVEL_PLATFORM_NAME_CN =  "平台";
    /** 用户级别中文名称 :  代理商级别*/
    public static final String USER_LEVEL_AGENT_NAME_CN =  "代理";
    /** 用户级别中文名称 :  区域管理级别*/
    public static final String USER_LEVEL_GROUP_NAME_CN =  "区域";
    /** 用户级别中文名称 :  业务员级别*/
    public static final String USER_LEVEL_SALESMAN_NAME_CN =  "业务员";
    /** 用户级别中文名称 :  创建者级别*/
    public static final String USER_LEVEL_CREATOR_NAME_CN =  "普通用户";
}
