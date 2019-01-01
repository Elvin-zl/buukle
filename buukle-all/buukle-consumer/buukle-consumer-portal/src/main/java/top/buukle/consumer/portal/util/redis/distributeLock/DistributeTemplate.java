package top.buukle.consumer.portal.util.redis.distributeLock;

import top.buukle.common.util.common.NumberUtil;
import top.buukle.common.util.common.StringUtil;
import top.buukle.common.util.logger.BaseLogger;
import top.buukle.consumer.portal.util.redis.commonFrameWork.RedisString;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/1/1.
 * @Description : 分布所模板类
 */
public class DistributeTemplate<T> {

    private static final BaseLogger LOGGER = BaseLogger.getLogger(DistributeTemplate.class);
    /*锁的名字*/
    String lockName;
    /*锁的失效时间*/
    Long expireTime;
    /*回调实体*/
    DistributeCallable<T> callable;

    /*执行方法*/
    public T execute() throws InterruptedException {
        try{
            // 尝试获取锁
            if(getLock()){
                T execute = callable.execute();
                LOGGER.info("线程 : {} 执行方法完毕,尝试释放锁.",Thread.currentThread());
                delete();
                return execute;
            }
        }catch (Exception e){
            LOGGER.info("线程 : {} 执行方法时出现异常,尝试释放锁.",Thread.currentThread());
            delete();
        }
        return null;
    }

    /**
     * 释放锁
     */
    private void delete() {
        if((System.currentTimeMillis()) > Long.parseLong(RedisString.get(this.lockName))){
            RedisString.delete(this.lockName);
            LOGGER.info("线程 : {} 释放锁.",Thread.currentThread());
        }
        LOGGER.info("线程 : {} 没有主动释放锁,其他线程将等待锁失效.",Thread.currentThread());
    }

    /**
     * 获取锁
     * @return
     * @throws InterruptedException
     */
    protected Boolean getLock() throws InterruptedException {
       int count = 0;
        while(true){
            count ++ ;
            Long longExpire = System.currentTimeMillis() + this.expireTime;
           LOGGER.info("线程 : {} 第 :{}次获取锁时,尝试直接获取锁...",Thread.currentThread(),count);
           Long hasLocked = RedisString.setnx(this.lockName, longExpire.toString());
           if(hasLocked.equals(NumberUtil.LONG_ZERO)){
               LOGGER.info("线程 : {} 第 :{}次获取锁时,直接获取失败,将根据锁的超时时间处理...",Thread.currentThread(),count);
               String oldExpirePre = RedisString.get(this.lockName);
               if(StringUtil.isEmpty(oldExpirePre) || Long.parseLong(oldExpirePre) < System.currentTimeMillis()){
                   LOGGER.info("线程 : {} 第 :{}次获取锁时,当前锁已经失效,尝试替换失效锁...",Thread.currentThread(),count);
                   Long newExpire = System.currentTimeMillis() + this.expireTime;
                   String oldExpireTimeAfter = RedisString.getSet(this.lockName,newExpire.toString());
                   if(Long.parseLong(oldExpirePre) != Long.parseLong(oldExpireTimeAfter)){
                       //该锁已经被别人用了
                       LOGGER.info("线程 : {} 第 :{}次获取锁时,替换失效锁失败,睡眠设定的超时时间后,将继续重试...",Thread.currentThread(),count);
                       Thread.sleep(this.expireTime);
                   }
                   else{
                       LOGGER.info("线程 : {} 第 :{}次获取锁时,替换失效锁成功,将执行回调方法!",Thread.currentThread(),count);
                       return true;
                   }
               }
               LOGGER.info("线程 : {} 第 :{}次获取锁时还有锁未超时, 睡眠设定的超时时间后,将继续重试...",Thread.currentThread(),count);
               Thread.sleep(this.expireTime);
           }else{
               LOGGER.info("线程 : {} 第 :{}次获取锁时,直接获取锁成功,将执行回调方法!",Thread.currentThread(),count);
               return true;
           }
       }
    }
}
