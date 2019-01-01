package top.buukle.consumer.portal.util.ThreadPool;

import top.buukle.common.util.common.SpringContextUtil;
import top.buukle.consumer.portal.constants.AsyncTaskConstants;
import top.buukle.consumer.portal.entity.AsyncTask;
import top.buukle.consumer.portal.entity.vo.AsyncTaskQuery;
import top.buukle.consumer.portal.service.AsyncTaskService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/1/1.
 * @Description : 线程池任务处理类
 */
public class FixedTaskPoolHandler extends FixedTaskPoolTemplate {

    /**
     * 私有化构造方法
     */
    private FixedTaskPoolHandler(){

    }

    private static final FixedTaskPoolHandler HANDLER = new FixedTaskPoolHandler();

    private static final AsyncTaskService TASK_SERVICE = SpringContextUtil.getBean(AsyncTaskService.class);


    public static FixedTaskPoolHandler instance(){
        return HANDLER;
    }
    /**
     * 实现执行之前
     * @param taskQueue
     * @param pool
     */
    @Override
    public void before(LinkedBlockingQueue taskQueue, ExecutorService pool) {

    }

    /**
     * 执行模板方法
     */
    @Override
    public void handle() {
        super.handle();
    }

    /**
     * 实现执行之后
     * @param taskQueue
     * @param pool
     */
    @Override
    public void after(LinkedBlockingQueue taskQueue, ExecutorService pool, AsyncTask task,Integer status) {
        AsyncTaskQuery asyncTaskQuery = new AsyncTaskQuery();
        asyncTaskQuery.setId(task.getId());
        if(task.getType().equals(AsyncTaskConstants.TYPE_REAL_TIME)){
            return;
        }
        if(status.equals(AsyncTaskConstants.STATUS_FAILED)){
            if(task.getType().equals(AsyncTaskConstants.TYPE_REPEAT)){
                asyncTaskQuery.setStatus(AsyncTaskConstants.STATUS_WAITING);
                TASK_SERVICE.updateAsyncTaskForTask(asyncTaskQuery);
            }
        }

        if(status.equals(AsyncTaskConstants.STATUS_SUCCESS)){
            asyncTaskQuery.setStatus(AsyncTaskConstants.STATUS_SUCCESS);
            TASK_SERVICE.updateAsyncTaskForTask(asyncTaskQuery);
        }
    }
}
