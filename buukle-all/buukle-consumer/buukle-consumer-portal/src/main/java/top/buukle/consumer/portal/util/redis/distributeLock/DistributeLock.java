package top.buukle.consumer.portal.util.redis.distributeLock;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/1/1.
 * @Description : redis分布式锁
 */
public class DistributeLock extends DistributeTemplate{

    public DistributeLock(String lockName, Long expireTime ,DistributeCallable callable) {
        super.lockName = lockName;
        super.expireTime = expireTime;
        super.callable = callable;
    }

}
