package top.buukle.gateway.configure;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.lang.reflect.Method;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/20.
 * @Description :
 */
@Configuration
@EnableCaching
@PropertySource(value = "classpath:/application.yml")
public class RedisConfigure extends CachingConfigurerSupport {

    private final static Logger LOGGER = LoggerFactory.getLogger(RedisConfigure.class);

    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;

    @Bean
    public KeyGenerator wiselyKeyGenerator(){
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for (Object obj : params) {
                    sb.append(obj.toString());
                }
                String s = sb.toString();
                return s;
            }
        };
    }

    @Bean
    @Override
    public CacheManager cacheManager() {
        // 初始化缓存管理器，在这里我们可以缓存的整体过期时间什么的，我这里默认没有配置
        RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(jedisConnectionFactory);
        return builder.build();
    }

    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        // 使用Jackson2JsonRedisSerialize 替换默认序列化
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);


        // 设置value的序列化规则和 key的序列化规则
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

        redisTemplate.setHashKeySerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);

        redisTemplate.setDefaultSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setEnableDefaultSerializer(true);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    @Override
    @Bean
    public CacheErrorHandler errorHandler() {
        // 异常处理，当Redis发生异常时，打印日志，但是程序正常走
        CacheErrorHandler cacheErrorHandler = new CacheErrorHandler() {
            @Override
            public void handleCacheGetError(RuntimeException e, Cache cache, Object key) {
                LOGGER.error("Redis occur handleCacheGetError：key -> [{}]", key, e);
            }

            @Override
            public void handleCacheEvictError(RuntimeException e, Cache cache, Object key)    {
                LOGGER.error("Redis occur handleCacheEvictError：key -> [{}]", key, e);
            }

            @Override
            public void handleCachePutError(RuntimeException e, Cache cache, Object key, Object value) {
                LOGGER.error("Redis occur handleCachePutError：key  -> [{}]；value -> [{}]", key, value, e);
            }


            @Override
            public void handleCacheClearError(RuntimeException e, Cache cache) {
                LOGGER.error("Redis occur handleCacheClearError：", e);
            }
        };
        return cacheErrorHandler;
    }

    /**
     * 此内部类就是把yml的配置数据，进行读取，创建JedisConnectionFactory和JedisPool，以供外部类初始化缓存管理器使用
     *
     */
    @ConfigurationProperties
    class DataJedisProperties{

        @Value("${spring.redis.database}")
        private  int database;
        @Value("${spring.redis.host}")
        private  String host;
        @Value("${spring.redis.port}")
        private  int port;
        @Value("${spring.redis.password}")
        private  String password;
        @Value("${spring.redis.timeout}")
        private  int timeout;
        @Value("${spring.redis.jedis.pool.max-active}")
        private int maxActive;
        @Value("${spring.redis.jedis.pool.max-idle}")
        private int maxIdle;
        @Value("${spring.redis.jedis.pool.max-wait}")
        private int maxWait;
        @Value("${spring.redis.jedis.pool.min-idle}")
        private int minIdle;

        private JedisPool jedisPoolTemp  = null ;
        @Bean
        JedisConnectionFactory jedisConnectionFactory() {
            LOGGER.info("Create JedisConnectionFactory successful");
            JedisConnectionFactory factory = new JedisConnectionFactory();
            factory.setDatabase(database);
            factory.setTimeout(timeout);
            factory.setPort(port);
            factory.setHostName(host);
            factory.setPassword(password);
            return factory;
        }
        @Bean
        public synchronized JedisPool redisPoolFactory() {
            LOGGER.info("JedisPool init successful，host -> [{}]；port -> [{}]", host, port);
            if(jedisPoolTemp == null){
                JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
                jedisPoolConfig.setMaxTotal(maxActive);
                jedisPoolConfig.setMaxWaitMillis(maxWait);
                jedisPoolConfig.setMaxIdle(maxIdle);
                jedisPoolConfig.setMinIdle(minIdle);
                jedisPoolTemp = new JedisPool(jedisPoolConfig, host, port, timeout, password);
                return jedisPoolTemp;
            }
            return jedisPoolTemp;
        }
    }

    /**
     * 注册redisTemplate 作为消息队列的发布者
     */
    @Bean
    public StringRedisTemplate getRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        return new StringRedisTemplate(redisConnectionFactory);
    }

}
