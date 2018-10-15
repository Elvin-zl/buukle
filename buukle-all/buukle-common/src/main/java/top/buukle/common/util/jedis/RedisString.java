package top.buukle.common.util.jedis;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/21.
 * @Description :
 */
public class RedisString {

    public static void set(String key ,String value) {
        JedisCommands.set(key ,value);
    }

    public static void setWithExpire(String key ,String value,long expire) {
        JedisCommands.setWithExpire(key ,value,expire);
    }

    public static String get(String key) {
         return JedisCommands.get(key);
    }

    public static boolean delete(String key) {
        return JedisCommands.delete(key);
    }

}
