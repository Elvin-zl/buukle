package top.buukle.provider.security.configure;


import feign.Request;
import feign.Retryer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.buukle.common.filter.BaseResponseParamHandlerFilter;
import top.buukle.common.util.common.NumberUtil;
import top.buukle.plugin.security.configure.SecurityConfigure;
import top.buukle.plugin.security.plugins.SecurityInterceptor;
import top.buukle.common.filter.BaseRequestParamValidateFilter;
import top.buukle.provider.security.util.RequestValidator;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/23.
 * @Description : AppConfigure Mvc系统配置类
 */
@Configuration
public class AppConfigure implements WebMvcConfigurer {

    /** feign-http 链接超時時間*/
    public static int connectTimeOutMillis = NumberUtil.INTEGER_THOUSAND * NumberUtil.INTEGER_THREE;
    /** feign-http 等待超时时间*/
    public static int readTimeOutMillis = NumberUtil.INTEGER_THOUSAND * NumberUtil.INTEGER_SIX;

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
        //超时后每隔200ms ~ 2000ms 重试一次,最多重试0次;
        return new Retryer.Default(200,2000,0);
    }

    /**
     * 注册 buukle-security 拦截器插件实体
     * */
    @Bean
    SecurityInterceptor getSecurityInterceptor() {
        return new SecurityInterceptor(SecurityConfigure.DEFAULT_PARAMETERS);
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
                //放行錯誤請求
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
        registration.setFilter(new BaseRequestParamValidateFilter(new RequestValidator()));
        registration.addUrlPatterns("/api/*");
        registration.setName("BaseRequestParamValidateFilter");
        registration.setOrder(1);
        return registration;
    }
    /**
     * 注册 全局api请求参数校验 过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean2() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new BaseResponseParamHandlerFilter());
        registration.addUrlPatterns("/api/*");
        registration.setName("BaseResponseParamHandlerFilter");
        registration.setOrder(2);
        return registration;
    }

    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(responseBodyConverter());
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
    }
}