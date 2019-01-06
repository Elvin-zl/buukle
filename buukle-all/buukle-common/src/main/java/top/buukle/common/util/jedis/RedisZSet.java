package top.buukle.common.util.jedis;

import org.springframework.data.redis.core.ZSetOperations;

import java.util.Set;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/1/7.
 * @Description :
 */
public class RedisZSet {

    public static boolean zsadd(String key,String value, Long score) {
        return JedisCommands.zsadd(key,value,score);
    }

    public static Long size(String key) {
        return JedisCommands.size(key);
    }

    public static Long count(String key,Long Smin,Long Smax) {
        return JedisCommands.count(key,Smin,Smax);
    }

    public static Set<String> rangeByScore(String key, Long Smin, Long Smax, Long offset, Long count) {
        return JedisCommands.rangeByScore(key,Smin,Smax,offset,count);
    }

    /**
     * 获取startIndex 到 endIndex 的 set 集合,集合中的元素是 value,score 的包装类
     * @param key
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static Set<ZSetOperations.TypedTuple<String>> rangeWithScores(String key, Long startIndex, Long endIndex) {
        return JedisCommands.rangeWithScores(key,startIndex,endIndex);
    }

    /**
     * 获取startIndex 到 endIndex 的 set 集合,集合中的元素是 value,score 的包装类
     * @param key
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static Set<ZSetOperations.TypedTuple<String>> reverseRangeWithScores(String key, Long startIndex, Long endIndex) {
        return JedisCommands.reverseRangeWithScores(key,startIndex,endIndex);
    }

    /**
     * 获取startIndex 到 endIndex 的 set 集合,集合中的元素是 value
     * @param key
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static Set<String> range(String key,Long startIndex,Long endIndex) {
        return JedisCommands.range(key,startIndex,endIndex);
    }

}
