package top.buukle.consumer.portal.util.redis.commonFrameWork;

import java.util.Set;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/12/22.
 * @Description : redis String类
 */
public class RedisSet {

    public static Long sadd(String k ,String v) {
        return RedisCommond.sadd(k,v);
    }
    public static Long sadds(String k ,String ... strings) {
        return RedisCommond.sadds(k,strings);
    }
    public static Long srem (String k ,String v) {
        return RedisCommond.srem(k,v);
    }
    public static Long srems (String k ,String ... strings) {
        return RedisCommond.srems(k,strings);
    }
    public static Long scard (String k) {
        return RedisCommond.scard(k);
    }
    public static Set<String> smembers  (String k) {
        return RedisCommond.smembers(k);
    }
}
