package top.buukle.consumer.www.util.ThreadPool;


import redis.clients.jedis.Jedis;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/1/1.
 * @Description :
 */
public class JedisThreadLocal{

    private  static ThreadLocal<Jedis> THREAD_LOCAL_PARAMETERS = new ThreadLocal();

    public static void set(Jedis jedis) {
        THREAD_LOCAL_PARAMETERS.set(jedis);
    }

    public static Jedis get() {
        return THREAD_LOCAL_PARAMETERS.get();
    }

    public static void clear() {
        THREAD_LOCAL_PARAMETERS.remove();
    }
}
