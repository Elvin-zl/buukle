package top.buukle.consumer.portal.util.redis.commonFrameWork;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/12/22.
 * @Description : redis 命令
 */
public class RedisCommond {

    /**初始化redis模板类*/
    final private static RedisTemplate template = new RedisTemplate();
/*string*/
    public static String set(String k,String v){
        return (String) template.execute(new RedisCallable<String>() {
            @Override
            String call(Jedis jedis) {
                return jedis.set(k, v);
            }
        });
    }

    public static String setex(String k,int second,String v){
        return (String) template.execute(new RedisCallable<String>() {
            @Override
            String call(Jedis jedis) {
                return jedis.setex(k,second,v);
            }
        });
    }

    public static String get(String k){
        return (String) template.execute(new RedisCallable<String>() {
            @Override
            String call(Jedis jedis) {
                return jedis.get(k);
            }
        });
    }

    public static Long setnx(String k,String v){
        return (Long) template.execute(new RedisCallable<Long>() {
            @Override
            Long call(Jedis jedis) {
                return jedis.setnx(k,v);
            }
        });
    }

    public static String getSet(String k,String v){
        return (String) template.execute(new RedisCallable<String>() {
            @Override
            String call(Jedis jedis) {
                return jedis.getSet(k,v);
            }
        });
    }

    public static Long delete(String k) {
        return (Long) template.execute(new RedisCallable<Long>() {
            @Override
            Long call(Jedis jedis) {
                return jedis.del(k);
            }
        });
    }
/*set*/
    public static Long sadd(String k ,String v) {
        return (Long) template.execute(new RedisCallable<Long>() {
            @Override
            Long call(Jedis jedis) {
                return jedis.sadd(k,v);
            }
        });
    }
    public static Long sadds(String k ,String ... strings) {
        return (Long) template.execute(new RedisCallable<Long>() {
            @Override
            Long call(Jedis jedis) {
                return jedis.sadd(k,strings);
            }
        });
    }
    public static Long srem (String k ,String v) {
        return (Long) template.execute(new RedisCallable<Long>() {
            @Override
            Long call(Jedis jedis) {
                return jedis.srem (k,v);
            }
        });
    }
    public static Long srems (String k ,String ... strings) {
        return (Long) template.execute(new RedisCallable<Long>() {
            @Override
            Long call(Jedis jedis) {
                return jedis.srem (k,strings);
            }
        });
    }
    public static Long scard (String k) {
        return (Long) template.execute(new RedisCallable<Long>() {
            @Override
            Long call(Jedis jedis) {
                return jedis.scard (k);
            }
        });
    }
    public static Set<String> smembers  (String k) {
        return (Set<String>) template.execute(new RedisCallable<Set<String>>() {
            @Override
            Set<String> call(Jedis jedis) {
                return jedis.smembers (k);
            }
        });
    }
/*hash*/
    public static Long hset (String k,String f,String v) {
        return (Long) template.execute(new RedisCallable<Long>() {
            @Override
            Long call(Jedis jedis) {
                return jedis.hset  (k,f,v);
            }
        });
    }

    public static String hget (String k,String f) {
        return (String) template.execute(new RedisCallable<String>() {
            @Override
            String call(Jedis jedis) {
                return jedis.hget  (k,f);
            }
        });
    }
    public static Long hdel (String k,String f) {
        return (Long) template.execute(new RedisCallable<Long>() {
            @Override
            Long call(Jedis jedis) {
                return jedis.hdel  (k,f);
            }
        });
    }

}
