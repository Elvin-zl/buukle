package top.buukle.consumer.www.util.ThreadPool;


import org.springframework.util.CollectionUtils;
import top.buukle.common.util.common.JsonUtil;
import top.buukle.common.util.common.NumberUtil;
import top.buukle.common.util.common.SpringContextUtil;
import top.buukle.common.util.logger.BaseLogger;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.consumer.www.constants.AsyncTaskConstants;
import top.buukle.consumer.www.entity.AsyncTask;
import top.buukle.consumer.www.entity.vo.AsyncTaskQuery;
import top.buukle.consumer.www.service.AsyncTaskService;
import top.buukle.common.vo.page.PageBounds;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/1/1.
 * @Description : 线程池任务收集类
 */
public class FixedTaskPoolWorker extends FixedTaskPoolTemplate {

    private static final AsyncTaskService ASYNC_TASK_SERVICE = SpringContextUtil.getBean(AsyncTaskService.class);
    private static final BaseLogger LOGGER = BaseLogger.getLogger(FixedTaskPoolWorker.class);

    @Override
    public void before(LinkedBlockingQueue taskQueue, ExecutorService pool) {

    }

    @Override
    public void after(LinkedBlockingQueue taskQueue, ExecutorService pool, AsyncTask task, Integer status) {

    }

    /**
     * 实时收集任务
     * @param task
     */
    public static void work(AsyncTask task) {
        FIXED_TASK_QUEUE.add(task);
        LOGGER.info("任务成功加入队列! 信息 : {}", JsonUtil.toJSONString(task));
    }

    /**
     * 延时轮询收集任务
     * @param delaySize  延时取任务的个数
     * @throws InterruptedException
     */
    public static void work(Integer delaySize){
        try {
            LOGGER.info("开始延时收集任务!");
            AsyncTaskQuery asyncTaskQuery = new AsyncTaskQuery();
            asyncTaskQuery.setStatus(AsyncTaskConstants.STATUS_WAITING);
            PageResponse<AsyncTask> asyncTaskList = ASYNC_TASK_SERVICE.getAsyncTaskList(asyncTaskQuery, new PageBounds(NumberUtil.INTEGER_ONE, delaySize));
            if(!CollectionUtils.isEmpty(asyncTaskList.getData())){
                for (AsyncTask asyncTask: asyncTaskList.getData()) {
                    AsyncTaskQuery query = new AsyncTaskQuery();
                    query.setId(asyncTask.getId());
                    query.setStatus(AsyncTaskConstants.STATUS_HANDLING);
                    ASYNC_TASK_SERVICE.updateAsyncTaskForTask(query);
                }
                FIXED_TASK_QUEUE.addAll(asyncTaskList.getData());
            }
            LOGGER.info("本次延时收集任务完成!");
        } catch (Exception e) {
            LOGGER.info("延时收集任务出现异常,信息 :{}",e.getMessage());
            e.printStackTrace();
        }
    }
}
