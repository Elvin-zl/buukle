package top.buukle.provider.security.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.buukle.common.util.common.SpringAppInitialListener;
import top.buukle.common.util.logger.BaseLogger;
import top.buukle.provider.security.service.UserService;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/18.
 * @Description :
 */
@Component
public class SecurityApplicationInitialListener extends SpringAppInitialListener {

    final static private BaseLogger LOGGER = BaseLogger.getLogger(SecurityApplicationInitialListener.class);
    @Autowired
    private UserService userService;
    /**
     * 项目初始化完成后的一些动作
     */
    @Override
    protected void init() {
        // 缓存全局角色列表信息
        userService.getGlobalRole();
        LOGGER.info("缓存全局角色列表信息完成!");
        userService.getGlobalGroups();
        LOGGER.info("缓存全局组别列表信息完成!");
    }
}
