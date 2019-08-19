/**
 * Copyright (C), 2015-2019  http://www.buukle.top
 * FileName: MvcConfigure
 * Author:   elvin
 * Date:     2019/8/17 16:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.security.plugin.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.buukle.security.plugin.thymleafDialect.HpDialect;

/**
 * @description 〈〉
 * @author elvin
 * @create 2019/8/17
 * @since 1.0.0
 */
@Configuration
public class SecurityPluginConfigureMvcConfigure implements WebMvcConfigurer {
    /**
     * @description 配置自定义方言处理器
     * @param
     * @return top.buukle.security.plugin.thymleafDialect.HpDialect
     * @Author elvin
     * @Date 2019/8/17
     */
    @Bean
    public HpDialect hpDialect(){
        return new HpDialect();
    }
}