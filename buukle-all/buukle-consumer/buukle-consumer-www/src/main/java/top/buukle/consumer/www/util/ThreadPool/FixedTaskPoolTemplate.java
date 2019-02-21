package top.buukle.consumer.www.util.ThreadPool;

import org.apache.commons.collections.CollectionUtils;
import top.buukle.common.util.common.JsonUtil;
import top.buukle.common.util.logger.BaseLogger;
import top.buukle.consumer.www.constants.AsyncTaskConstants;
import top.buukle.consumer.www.entity.AsyncTask;
import top.buukle.consumer.www.util.reflect.ReflectUtil;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/1/1.
 * @Description : FIXED_POOL 模板类
 */
public abstract class FixedTaskPoolTemplate extends AbstractTemplate{

    /* 定长线程池的任务队列*/
    public final static LinkedBlockingQueue FIXED_TASK_QUEUE = new LinkedBlockingQueue();

    /* 获取线程池*/
    public final static ExecutorService FIXED_POOL =  ThreadPoolFactory.getPool(ThreadPoolConstants.THREAD_POOL_TYPE_FIXED);

    private static final BaseLogger LOGGER = BaseLogger.getLogger(FixedTaskPoolTemplate.class);


    /**
     * 执行入口
     */
    @Override
    public void handle() {
        this.before(FIXED_TASK_QUEUE,FIXED_POOL);
        ArrayList<AsyncTask> list = new ArrayList<>();
        FIXED_TASK_QUEUE.drainTo(list);
        if(CollectionUtils.isNotEmpty(list)){
            for ( AsyncTask asyncTask: list) {
                FIXED_POOL.execute(() -> {
                    try {
                        long startTime = System.currentTimeMillis();
                        this.handle(asyncTask);
                        this.after(FIXED_TASK_QUEUE,FIXED_POOL,asyncTask, AsyncTaskConstants.STATUS_SUCCESS);
                        long endTime = System.currentTimeMillis();
                        LOGGER.info("单次任务处理完成,任务耗时:{}",(endTime -startTime));
                    } catch (Exception e) {
                        LOGGER.info("处理任务出现异常! 任务信息 : {},异常信息 :{}", JsonUtil.toJSON(asyncTask),e.getMessage());
                        this.after(FIXED_TASK_QUEUE,FIXED_POOL,asyncTask,AsyncTaskConstants.STATUS_FAILED);
                        e.printStackTrace();
                    }
                });
            }
        }
    }

    /**
     * 执行处理
     * @param asyncTask
     */
    protected void handle(AsyncTask asyncTask) throws Exception {
        ReflectUtil.invoke(asyncTask);
    }
}
