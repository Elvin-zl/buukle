package top.buukle.consumer.www.constants;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/12/31.
 * @Description :
 */
public class ArticleInfoConstants {

    /*查询排序方式 - 默认*/
    public static final Integer ORDER_BY_DEFAULT = 0;
    /*查询排序方式 - 最新*/
    public static final Integer ORDER_BY_GMT_MODIFIED = 1;
    /*查询排序方式 - 赞数最多*/
    public static final Integer ORDER_BY_PRAISE = 2;
    /*查询排序方式 - 评论最多*/
    public static final Integer ORDER_BY_SCAN = 3;

    /*更新文章赞数锁名称前缀*/
    public static final String LOCK_NAME_UPDATE_PRAISE_NUMBER_PREFIX = "LOCK_NAME_UPDATE_PRAISE_NUMBER_PREFIX :";
    /*文章重复访问无效计数时间段前缀*/
    public static final String VISIT_EXPIRE_PREFIX = "VISIT_EXPIRE_PREFIX :";
    /*文章重复访问无效计数时间段*/
    public static final Long VISIT_EXPIRE_TIME_ZONE_SECONDED = 60l;
    /*更新文章浏览量前缀*/
    public static final String VISIT_PREFIX = "VISIT_PREFIX :";
    /*文章访问次数缓存大小*/
    public static final Long VISIT_CACHE_LIMIT = 10L;
}
