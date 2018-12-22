package top.buukle.consumer.cms.util.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import top.buukle.common.util.common.SpringContextUtil;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/12/22.
 * @Description : redis工厂类
 */
public class RedisFactory {

    /** 从 spring context 容器中获取jedis链接池对象*/
    final static private Jedis jedis = SpringContextUtil.getBean(JedisPool.class).getResource();

    private RedisFactory(){

    }

    public static Jedis getJedis() {
        return jedis;
    }
}
