package top.buukle.common.util.jedis;

import java.util.concurrent.TimeUnit;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/21.
 * @Description :
 */
public class JedisCommands {


    final private static JedisTemplate TEMPLATE = new JedisTemplate();

    public static void set(String key,String value) {
        TEMPLATE.excecute(new JedisCallable() {
            @Override
            Object call() {
                JedisCallable.stringRedisTemplate.opsForValue().set(key,value);
                return null;
            }
        });
    }

    public static void setWithExpire(String key,String value,long expire) {
        TEMPLATE.excecute(new JedisCallable() {
            @Override
            Object call() {
                JedisCallable.stringRedisTemplate.opsForValue().set(key,value,expire, TimeUnit.SECONDS);
                return null;
            }
        });
    }

    public static String get(String key) {
        return (String) TEMPLATE.excecute(new JedisCallable() {
            @Override
            String call() {
                return JedisCallable.stringRedisTemplate.opsForValue().get(key);
            }
        });
    }

    public static boolean delete(String key) {
        return (boolean) TEMPLATE.excecute(new JedisCallable<Boolean>() {
            @Override
            Boolean call() {
                return JedisCallable.stringRedisTemplate.delete(key);
            }
        });
    }
}
