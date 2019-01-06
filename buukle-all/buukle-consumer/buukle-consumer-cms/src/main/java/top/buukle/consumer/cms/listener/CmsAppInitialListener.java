package top.buukle.consumer.cms.listener;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import top.buukle.common.util.common.SpringAppInitialListener;
import top.buukle.common.util.common.SpringContextUtil;
import top.buukle.common.util.logger.BaseLogger;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/1/1.
 * @Description : CmsAppInitialListener application启动监听器
 */
@Component
public class CmsAppInitialListener extends SpringAppInitialListener {

    private static final BaseLogger LOGGER = BaseLogger.getLogger(CmsAppInitialListener.class);

    private Environment environment = SpringContextUtil.getBean(Environment.class);

    @Override
    protected void init() throws InterruptedException {
    }

}
