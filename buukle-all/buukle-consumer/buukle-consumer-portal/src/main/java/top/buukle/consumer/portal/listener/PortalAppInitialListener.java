package top.buukle.consumer.portal.listener;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import top.buukle.common.util.common.SpringAppInitialListener;
import top.buukle.common.util.common.SpringContextUtil;
import top.buukle.common.util.common.StringUtil;
import top.buukle.common.util.jedis.RedisZSet;
import top.buukle.common.util.logger.BaseLogger;
import top.buukle.consumer.portal.constants.AsyncTaskConstants;
import top.buukle.consumer.portal.constants.CacheConstants;
import top.buukle.consumer.portal.service.ArticleInfoService;
import top.buukle.consumer.portal.util.ThreadPool.FixedTaskPoolHandler;
import top.buukle.consumer.portal.util.ThreadPool.FixedTaskPoolWorker;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/1/1.
 * @Description : PortalAppInitialListener application启动监听器
 */
@Component
public class PortalAppInitialListener extends SpringAppInitialListener {

    private static final BaseLogger LOGGER = BaseLogger.getLogger(PortalAppInitialListener.class);

    private Environment environment = SpringContextUtil.getBean(Environment.class);

    @Override
    protected void init() throws InterruptedException {
        // Worker 检查任务收集器
        this.checkTaskWorker();
        // Handler 检查任务处理器
        this.checkTaskHandler();
    }

    /**
     * 检查任务处理器
     */
    private void checkTaskHandler() {
        String online = environment.getProperty("task.online");
        if(Integer.parseInt(online) == 1){
            LOGGER.info("开始执行handle轮询任务!" );
            Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> FixedTaskPoolHandler.instance().handle(),200,200, TimeUnit.MILLISECONDS);
        }
    }

    /**
     * 检查任务收集器
     * @throws InterruptedException
     */
    private void checkTaskWorker() throws InterruptedException {
        String online = environment.getProperty("task.online");
        String delaySize =  StringUtil.isEmpty(environment.getProperty("task.delaySize")) ? AsyncTaskConstants.DEFAULT_DELAY_SIZE+"" : environment.getProperty("task.delaySize");
        String delayTime =  StringUtil.isEmpty(environment.getProperty("task.delayTime")) ? AsyncTaskConstants.DEFAULT_DELAY_TIME+"" : environment.getProperty("task.delayTime");
        if(StringUtil.isEmpty(online)){
            LOGGER.info("online配置失败!");
            return;
        }

        LOGGER.info("online配置,online :{} ,delaySize :{},delayTime: {}" ,online,delaySize,delayTime);
        if(Integer.parseInt(online) == 1){
            LOGGER.info("开始执行worker轮询任务!" );
            Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> FixedTaskPoolWorker.work(Integer.parseInt(delaySize)),2000,Long.parseLong(delayTime), TimeUnit.MILLISECONDS);
        }
    }
}
