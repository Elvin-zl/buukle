package top.buukle.consumer.portal.util.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/1/1.
 * @Description : 线程池工厂类
 */
public  class ThreadPoolFactory {

    private static ExecutorService FIXED_THREADPOOL = Executors.newFixedThreadPool(ThreadPoolConstants.DEFAULT_FIXED_POOL_SIZE);

    private static ExecutorService CACHE_THREADPOOL = Executors.newCachedThreadPool();

    /*私有化构造*/
    private ThreadPoolFactory(){

    }

    /**
     * 获取线程池
     * @param type
     * @return
     */
     public static ExecutorService getPool(Integer type){
         if(type == null){
             return FIXED_THREADPOOL;
         }

         if(type.equals(ThreadPoolConstants.THREAD_POOL_TYPE_FIXED)){
             return FIXED_THREADPOOL;
         }

         if(type.equals(ThreadPoolConstants.THREAD_POOL_TYPE_CACHE)){
             return CACHE_THREADPOOL;
         }
         return null;
     }
}
