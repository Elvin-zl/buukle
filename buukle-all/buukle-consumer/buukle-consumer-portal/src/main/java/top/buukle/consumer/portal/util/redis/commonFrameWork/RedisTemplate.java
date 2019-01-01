package top.buukle.consumer.portal.util.redis.commonFrameWork;

import redis.clients.jedis.Jedis;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/12/22.
 * @Description : redis 模板类
 */
public class RedisTemplate <T>{

    final private static Jedis jedis = RedisFactory.getJedis();

    public T execute(RedisCallable callable){
        return (T) callable.call(jedis);
    }
}
