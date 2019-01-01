package top.buukle.common.util.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/5/19.
 * @Description : ApplicationInitListener app 启动监听器,用于项目启动后初始化一些默认后台任务
 */
public abstract class SpringAppInitialUtil implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringAppInitialUtil.class);
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        LOGGER.info("top.buukle.common.util.common.ApplicationInitialUtil : 应用启动完毕!");
        try {
            init();
        } catch (InterruptedException e) {
            LOGGER.info("top.buukle.common.util.common.ApplicationInitialUtil : 应用启动任务失败 .. ");
            e.printStackTrace();
        }
    }

    protected abstract void init() throws InterruptedException;
}
