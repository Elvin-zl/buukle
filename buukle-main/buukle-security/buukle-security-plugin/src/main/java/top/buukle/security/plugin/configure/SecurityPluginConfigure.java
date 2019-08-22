package top.buukle.security.plugin.configure;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;
import top.buukle.security.entity.User;
import top.buukle.security.plugin.client.DataIsolationInterceptor;
import top.buukle.security.plugin.constants.SecurityInterceptorConstants;
import top.buukle.util.JsonUtil;
import top.buukle.util.log.BaseLogger;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Properties;

@Configuration
public class SecurityPluginConfigure {

    private static final BaseLogger LOGGER = BaseLogger.getLogger(SecurityPluginConfigure.class);
    @Autowired
    private List<SqlSessionFactory> sqlSessionFactoryList;
    @Autowired
    private Environment env;

    @Bean
    @ConfigurationProperties(prefix = "pagehelper")
    public Properties pageHelperProperties() {
        return new Properties();
    }

    @PostConstruct
    public void addMysqlInterceptor() {
        //数据权限拦截器
        DataIsolationInterceptor dataIsolationInterceptor = new DataIsolationInterceptor(env);
        //分页拦截器
        PageInterceptor pageInterceptor = new PageInterceptor();
        pageInterceptor.setProperties(this.pageHelperProperties());
        for (SqlSessionFactory sqlSessionFactory : sqlSessionFactoryList) {
            sqlSessionFactory.getConfiguration().addInterceptor(pageInterceptor);
            sqlSessionFactory.getConfiguration().addInterceptor(dataIsolationInterceptor);
        }
    }

    /**
     * @description 配置共享session 的domain,cookie
     * @param
     * @return org.springframework.session.web.http.CookieSerializer
     * @Author elvin
     * @Date 2019/7/30
     */
    @Bean
    public CookieSerializer cookieSerializer() {
        DefaultCookieSerializer defaultCookieSerializer = new DefaultCookieSerializer();
        defaultCookieSerializer.setUseBase64Encoding(false);
        defaultCookieSerializer.setUseHttpOnlyCookie(true);
        defaultCookieSerializer.setCookieName(SecurityInterceptorConstants.LOGIN_COOKIE_NAME);
        defaultCookieSerializer.setDomainName(SecurityInterceptorConstants.LOGIN_COOKIE_DOMAIN);
        defaultCookieSerializer.setCookiePath("/");
        return defaultCookieSerializer;
    }
    @Bean("springSessionDefaultRedisSerializer")
    public RedisSerializer<Object> defaultRedisSerializer(){
        LOGGER.debug("自定义Redis Session序列化加载成功");
        return valueSerializer();
    }

    private RedisSerializer<Object> valueSerializer() {
        return new GenericFastJsonRedisSerializer();
    }
}