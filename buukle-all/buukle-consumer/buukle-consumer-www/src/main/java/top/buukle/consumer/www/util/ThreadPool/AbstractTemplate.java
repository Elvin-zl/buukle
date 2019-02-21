package top.buukle.consumer.www.util.ThreadPool;


import top.buukle.consumer.www.entity.AsyncTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/1/1.
 * @Description : 线程池模板类
 */
public abstract class AbstractTemplate {

    /*执行方法-前*/
    public abstract void before(LinkedBlockingQueue taskQueue, ExecutorService pool);
    /*执行方法 */
    public abstract void handle();
    /*执行方法-前*/
    public abstract void after(LinkedBlockingQueue taskQueue, ExecutorService pool, AsyncTask task,Integer status);

}
