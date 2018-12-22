package top.buukle.consumer.cms.util.redis;

import redis.clients.jedis.Jedis;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/12/22.
 * @Description : redis 模板回调类
 */
public abstract class RedisCallable <T> {

    abstract T call(Jedis jedis);
}
