package top.buukle.common.util.jedis;


/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/21.
 * @Description : jedis 回调类
 */
abstract class JedisCallable <T> {
    abstract T call();
}
