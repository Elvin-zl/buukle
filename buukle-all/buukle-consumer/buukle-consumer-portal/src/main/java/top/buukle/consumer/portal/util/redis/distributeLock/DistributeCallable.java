package top.buukle.consumer.portal.util.redis.distributeLock;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/1/1.
 * @Description : 分布锁回调
 */
public abstract class DistributeCallable <T>{
     public abstract T execute() throws InterruptedException;
}
