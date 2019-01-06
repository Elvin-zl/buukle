package top.buukle.common.util.jedis;

import org.springframework.data.redis.core.StringRedisTemplate;
import top.buukle.common.util.common.SpringContextUtil;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/1/7.
 * @Description :
 */
public class JedisFactory {

    /** springBoot redis 操作api 实例*/
    static StringRedisTemplate stringRedisTemplate = SpringContextUtil.getBean(StringRedisTemplate.class);

    private JedisFactory(){

    }

    public static StringRedisTemplate getTemplate() {
        return stringRedisTemplate;
    }

}
