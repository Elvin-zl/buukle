package top.buukle.common.util.jedis;

import org.springframework.data.redis.core.ZSetOperations;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/21.
 * @Description : jedis commands
 */
public class JedisCommands {


    final private static JedisTemplate TEMPLATE = new JedisTemplate();

/*string*/
    public static void set(String key,String value) {
        TEMPLATE.execute(new JedisCallable() {
            @Override
            Object call() {
                JedisFactory.getTemplate().opsForValue().set(key,value);
                return null;
            }
        });
    }

    public static void setWithExpire(String key,String value,long expire) {
        TEMPLATE.execute(new JedisCallable() {
            @Override
            Object call() {
                JedisFactory.getTemplate().opsForValue().set(key,value,expire, TimeUnit.SECONDS);
                return null;
            }
        });
    }

    public static String get(String key) {
        return (String) TEMPLATE.execute(new JedisCallable() {
            @Override
            String call() {
                return JedisFactory.getTemplate().opsForValue().get(key);
            }
        });
    }

    public static boolean delete(String key) {
        return (boolean) TEMPLATE.execute(new JedisCallable<Boolean>() {
            @Override
            Boolean call() {
                return JedisFactory.getTemplate().delete(key);
            }
        });
    }

/*hash*/

/*set*/

/*zet*/
    public static boolean zsadd(String key,String value, Long score) {
        return (boolean) TEMPLATE.execute(new JedisCallable<Boolean>() {
            @Override
            Boolean call() {
                return JedisFactory.getTemplate().opsForZSet().add(key,value,score);
            }
        });
    }

    public static Long size(String key) {
        return (Long) TEMPLATE.execute(new JedisCallable<Long>() {
            @Override
            Long call() {
                return JedisFactory.getTemplate().opsForZSet().size(key);
            }
        });
    }

    public static Long count(String key,Long Smin,Long Smax) {
        return (Long) TEMPLATE.execute(new JedisCallable<Long>() {
            @Override
            Long call() {
                return JedisFactory.getTemplate().opsForZSet().count(key,Smin,Smax);
            }
        });
    }

    public static Set<String> rangeByScore(String key,Long Smin,Long Smax, Long offset, Long count) {
        return (Set<String>) TEMPLATE.execute(new JedisCallable<Set<String>>() {
            @Override
            Set<String> call() {
                return JedisFactory.getTemplate().opsForZSet().rangeByScore(key,Smin,Smax,offset,count);
            }
        });
    }

    /**
     * 获取startIndex 到 endIndex 的 set 集合,集合中的元素是 value,score 的包装类
     * @param key
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static Set<ZSetOperations.TypedTuple<String>> rangeWithScores(String key,Long startIndex,Long endIndex) {
        return (Set<ZSetOperations.TypedTuple<String>>) TEMPLATE.execute(new JedisCallable<Set<ZSetOperations.TypedTuple<String>>>() {
            @Override
            Set<ZSetOperations.TypedTuple<String>> call() {
                return JedisFactory.getTemplate().opsForZSet().rangeWithScores(key,startIndex,endIndex);
            }
        });
    }

    /**
     * 获取startIndex 到 endIndex 的 set 集合,集合中的元素是 value
     * @param key
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static Set<String> range(String key,Long startIndex,Long endIndex) {
        return (Set<String>) TEMPLATE.execute(new JedisCallable<Set<String>>() {
            @Override
            Set<String> call() {
                return JedisFactory.getTemplate().opsForZSet().range(key,startIndex,endIndex);
            }
        });
    }

    public static Set<ZSetOperations.TypedTuple<String>> reverseRangeWithScores(String key, Long startIndex, Long endIndex) {
        return (Set<ZSetOperations.TypedTuple<String>>) TEMPLATE.execute(new JedisCallable<Set<ZSetOperations.TypedTuple<String>>>() {
            @Override
            Set<ZSetOperations.TypedTuple<String>> call() {
                return JedisFactory.getTemplate().opsForZSet().reverseRangeWithScores(key,startIndex,endIndex);
            }
        });
    }

}
