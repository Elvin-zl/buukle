/**
 * Copyright (C), 2015-2019  http://www.jd.com
 * FileName: ZKConfigure
 * Author:   zhanglei1102
 * Date:     2019/8/23 15:22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.util.zk;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @description 〈〉
 * @author zhanglei1102
 * @create 2019/8/23
 * @since 1.0.0
 */
@Component
@ConfigurationProperties( prefix = "spring.zk")
public class CuratorFrameworkConfigureProperties {

    private String host;
    private Integer baseSleepTimeMs;
    private Integer zkMaxRetries;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getBaseSleepTimeMs() {
        return baseSleepTimeMs;
    }

    public void setBaseSleepTimeMs(Integer baseSleepTimeMs) {
        this.baseSleepTimeMs = baseSleepTimeMs;
    }

    public Integer getZkMaxRetries() {
        return zkMaxRetries;
    }

    public void setZkMaxRetries(Integer zkMaxRetries) {
        this.zkMaxRetries = zkMaxRetries;
    }
}