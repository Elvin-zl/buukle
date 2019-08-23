/**
 * Copyright (C), 2015-2019  http://www.jd.com
 * FileName: ZKConfigures
 * Author:   zhanglei1102
 * Date:     2019/8/23 15:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.util.zk;

import org.apache.curator.framework.CuratorFramework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.buukle.util.SpringContextUtil;

/**
 * @description 〈〉
 * @author zhanglei1102
 * @create 2019/8/23
 * @since 1.0.0
 */
@Configuration
public class ZKConfigures {
    @Autowired
    SpringContextUtil springContextUtil;
    @Bean
    CuratorFramework zkClient() throws Exception {
        return CuratorFrameworkFactory.getInstance(springContextUtil);
    }
}