package top.buukle.consumer.cms.util.redis;

import redis.clients.jedis.Jedis;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/12/22.
 * @Description : redis 命令
 */
public class RedisCommond {

    /**初始化redis模板类*/
    final private static  RedisTemplate template = new RedisTemplate();

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
}
