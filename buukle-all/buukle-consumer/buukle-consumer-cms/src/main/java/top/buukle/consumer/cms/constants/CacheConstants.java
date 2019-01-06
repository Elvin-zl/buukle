package top.buukle.consumer.cms.constants;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/12/23.
 * @Description : 缓存常量类
 */
public class CacheConstants {

    /** 文章分类缓存key*/
    public static final String ARTICLE_CAT_LIST_KEY = "ARTICLE_CAT_LIST_KEY:";
    /** 文章分类缓存超时时间*/
    public static final int ARTICLE_CAT_LIST_CACHE_TIME_EXPIRE = 5184000;
    /** 文章set缓存--按时间排序*/
    public static final String ARTICLE_INFO_SET_SCORE_CREATED_TIME_KEY = "ARTICLE_INFO_SET_SCORE_CREATED_TIME_KEY";
    /** 文章set缓存--按点赞排序*/
    public static final String ARTICLE_INFO_SET_SCORE_PRAISE_NUMBER_KEY = "ARTICLE_INFO_SET_SCORE_PRAISE_NUMBER_KEY";
    /** 文章set缓存--按浏览排序*/
    public static final String ARTICLE_INFO_SET_SCORE_SCAN_NUMBER_KEY = "ARTICLE_INFO_SET_SCORE_SCAN_NUMBER_KEY";
}
