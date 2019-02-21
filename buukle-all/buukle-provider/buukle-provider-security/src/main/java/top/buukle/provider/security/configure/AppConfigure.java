package top.buukle.provider.security.configure;


import feign.Request;
import feign.Retryer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.buukle.common.filter.reqestAndResponseParameterFilter.BaseResponseParamHandlerFilter;
import top.buukle.common.util.common.NumberUtil;
import top.buukle.plugin.security.plugins.SecurityInterceptor;
import top.buukle.common.filter.reqestAndResponseParameterFilter.BaseRequestParamValidateFilter;
import top.buukle.provider.security.filter.validatorAndHanler.ApiSignRequestValidator;
import top.buukle.provider.security.filter.validatorAndHanler.ApiSignResponseHandler;
import top.buukle.provider.security.filter.validatorAndHanler.DataIsolationRequestValidator;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/23.
 * @Description : AppConfigure Mvc系统配置类
 */
@Configuration
public class AppConfigure implements WebMvcConfigurer {

    /** feign-http 链接超時時間*/
    public static int CONNECT_TIMEOUT_MILLIS = NumberUtil.INTEGER_THOUSAND * NumberUtil.INTEGER_TEN;
    /** feign-http 等待超时时间*/
    public static int READ_TIMEOUT_MILLIS = NumberUtil.INTEGER_THOUSAND * NumberUtil.INTEGER_FIVE * NumberUtil.INTEGER_TWO ;

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
        return new Request.Options(CONNECT_TIMEOUT_MILLIS, READ_TIMEOUT_MILLIS);
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

    /**
     * 注册 buukle-security 拦截器插件实体
     * */
    @Bean
    SecurityInterceptor getSecurityInterceptor() {
        return new SecurityInterceptor();
    }

    /**
     * 配置插入 buukle-security 拦截器插件
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getSecurityInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/static/**")
                // 放行錯誤請求
                .excludePathPatterns("/error")
        ;
    }

    /**
     * 注册 全局api请求参数校验 过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean1() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new BaseRequestParamValidateFilter(new ApiSignRequestValidator()));
        registration.addUrlPatterns("/api/*");
        registration.setName("BaseRequestParamValidateFilter");
        registration.setOrder(1);
        return registration;
    }

    /**
     * 注册 全局api返回参数校验 过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean2() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new BaseResponseParamHandlerFilter(new ApiSignResponseHandler()));
        registration.addUrlPatterns("/api/*");
        registration.setName("BaseResponseParamHandlerFilter");
        registration.setOrder(2);
        return registration;
    }

    /**
     * 注册 全局数据隔离请求参数校验 过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean3() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new BaseRequestParamValidateFilter(new DataIsolationRequestValidator()));
        registration.addUrlPatterns("/*");
        registration.setName("BaseResponseParamHandlerFilter2");
        registration.setOrder(3);
        return registration;
    }
}
