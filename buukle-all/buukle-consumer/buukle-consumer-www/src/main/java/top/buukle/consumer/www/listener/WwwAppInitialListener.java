package top.buukle.consumer.www.listener;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import top.buukle.common.util.common.SpringAppInitialListener;
import top.buukle.common.util.common.SpringContextUtil;
import top.buukle.common.util.common.StringUtil;
import top.buukle.common.util.logger.BaseLogger;
import top.buukle.consumer.www.constants.AsyncTaskConstants;
import top.buukle.consumer.www.util.ThreadPool.FixedTaskPoolHandler;
import top.buukle.consumer.www.util.ThreadPool.FixedTaskPoolWorker;
import top.buukle.consumer.www.util.wechat.WechatApiUtil;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/1/1.
 * @Description : PortalAppInitialListener application启动监听器
 */
@Component
public class WwwAppInitialListener extends SpringAppInitialListener {

    private static final BaseLogger LOGGER = BaseLogger.getLogger(WwwAppInitialListener.class);

    private Environment environment = SpringContextUtil.getBean(Environment.class);

    @Override
    protected void init() throws InterruptedException {
        // Worker 检查任务收集器开关并收集任务
        this.checkTaskWorker();
        // Handler 检查任务处理器开关并处理任务
        this.checkTaskHandler();
        // Geter 检查微信授权码开关并获取授权码
        this.checkWechatAccessTokenGeter();
        // Geter 检查微信jsapi通行证开关并获取通行证
        this.checkJsApiTicketGeter();
    }


    /**
     * 检查微信jsapi通行证开关并获取通行证
     */
    private void checkJsApiTicketGeter() {
        String online = environment.getProperty("wechat.online");
        if(StringUtil.isEmpty(online)){
            LOGGER.info("wechat.online 配置失败!");
            return;
        }
        if(Integer.parseInt(online) == 1){
            LOGGER.info("开始执行检查微信jsapi通行证开关并获取通行证任务!" );
            Executors.newSingleThreadExecutor().execute(WechatApiUtil::requestAndCacheJsApiTicket);
        }
    }

    /**
     * 检查微信授权码开关并获取授权码
     */
    private void checkWechatAccessTokenGeter() {
        String online = environment.getProperty("wechat.online");
        if(StringUtil.isEmpty(online)){
            LOGGER.info("wechat.online 配置失败!");
            return;
        }
        if(Integer.parseInt(online) == 1){
            LOGGER.info("开始执行检查微信授权码开关并获取授权码任务!" );
            Executors.newSingleThreadExecutor().execute(()-> WechatApiUtil.requestAndCacheAccessToken(environment.getProperty("wechat.appid"),environment.getProperty("wechat.appsecret")));
        }
    }

    /**
     * 检查任务处理器开关并处理任务
     */
    private void checkTaskHandler() {
        String online = environment.getProperty("task.online");
        if(StringUtil.isEmpty(online)){
            LOGGER.info("task.online 配置失败!");
            return;
        }
        if(Integer.parseInt(online) == 1){
            LOGGER.info("开始执行handle轮询任务处理!" );
            Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> FixedTaskPoolHandler.instance().handle(),200,200, TimeUnit.MILLISECONDS);
        }
    }

    /**
     * 检查任务收集器开关并收集任务
     * @throws InterruptedException
     */
    private void checkTaskWorker() throws InterruptedException {
        String online = environment.getProperty("task.online");
        String delaySize =  StringUtil.isEmpty(environment.getProperty("task.delaySize")) ? AsyncTaskConstants.DEFAULT_DELAY_SIZE+"" : environment.getProperty("task.delaySize");
        String delayTime =  StringUtil.isEmpty(environment.getProperty("task.delayTime")) ? AsyncTaskConstants.DEFAULT_DELAY_TIME+"" : environment.getProperty("task.delayTime");
        if(StringUtil.isEmpty(online)){
            LOGGER.info("task.online 配置失败!");
            return;
        }
        LOGGER.info("online配置,online :{} ,delaySize :{},delayTime: {}" ,online,delaySize,delayTime);
        if(Integer.parseInt(online) == 1){
            LOGGER.info("开始执行worker轮询任务采集!" );
            Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> FixedTaskPoolWorker.work(Integer.parseInt(delaySize)),2000,Long.parseLong(delayTime), TimeUnit.MILLISECONDS);
        }
    }
}
