package top.buukle.cms.web.configure;


import feign.Request;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/23.
 * @Description : AppConfigure Mvc系统配置类
 */
@Configuration
public class AppConfigure implements WebMvcConfigurer {

    /** feign-http 链接超時時間*/
    public static int connectTimeOutMillis = 3000;
    /** feign-http 等待超时时间*/
    public static int readTimeOutMillis = 6000;

    /**
     * 重写静态资源处理
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/");
    }

    /**
     * 注册 feign-http 超时设置实体
     * @return
     */
    @Bean
    public Request.Options options() {
        return new Request.Options(connectTimeOutMillis, readTimeOutMillis);
    }

    /**
     * 注册 feign-http 重试机制设置实体
     * @return
     */
    @Bean
    public Retryer feignRetryer() {
        // 超时后每隔200ms ~ 2000ms 重试一次,最多重试0次;
        return new Retryer.Default(200,2000,0);
    }

//    /**
//     * 注册 buukle-security 拦截器插件实体
//     * */
//    @Bean
//    SecurityInterceptor getSecurityInterceptor() {
//        return new SecurityInterceptor();
//    }

//    /**
//     * 配置插入 buukle-security 拦截器插件
//     * @param registry
//     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(getSecurityInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/static/**")
//                // 放行錯誤請求
//                .excludePathPatterns("/error")
//        ;
//    }

}
