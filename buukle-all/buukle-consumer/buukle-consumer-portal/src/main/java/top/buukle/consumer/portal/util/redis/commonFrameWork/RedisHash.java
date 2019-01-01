package top.buukle.consumer.portal.util.redis.commonFrameWork;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/12/22.
 * @Description : redis 哈希类
 */
public class RedisHash {


    public static Long hset (String k,String f,String v) {
        return RedisCommond.hset(k,f,v);
    }

    public static String hget (String k,String f) {
        return RedisCommond.hget(k,f);
    }

    public static Long hdel (String k,String f) {
        return RedisCommond.hdel(k,f);
    }
}
