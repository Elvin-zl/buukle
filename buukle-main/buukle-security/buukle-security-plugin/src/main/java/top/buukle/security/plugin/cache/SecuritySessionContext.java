package top.buukle.security.plugin.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Component;
import top.buukle.security.plugin.util.SessionUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * @description session 引用缓存
 * @Author zhanglei1102
 * @Date 2019/8/19
 */
@Component
public class SecuritySessionContext {

    private static final String SPRING_SESSION_KEY_PREFIX = "spring:session:sessions:";
    private static final String SPRING_SESSION_KEY_EXPIRE_PREFIX = "spring:session:sessions:expires:";
    public static final String SESSION_ATTR_PREFIX = "sessionAttr:";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private JdkSerializationRedisSerializer jdkSerializationRedisSerializer = new JdkSerializationRedisSerializer();
    /**
     * @description 失效【指定用户】session
     * @param userId
     * @return void
     * @Author elvin
     * @Date 2019/8/21
     */
    public void deleteSession(String userId) {
        stringRedisTemplate.delete(SPRING_SESSION_KEY_PREFIX + stringRedisTemplate.opsForValue().get(SessionUtil.SECURITY_SESSION_CONTEXT_KEY_PREFIX+userId));
    }

    /**
     * @description 踢掉【指定用户】
     * @param userId
     * @return void
     * @Author elvin
     * @Date 2019/8/21
     */
    public void setUserSessionOperate(String userId,String v) {
        stringRedisTemplate.opsForHash().put(SPRING_SESSION_KEY_PREFIX + stringRedisTemplate.opsForValue().get(SessionUtil.SECURITY_SESSION_CONTEXT_KEY_PREFIX+userId),
                SESSION_ATTR_PREFIX + SessionUtil.USER_SESSION_OPERATED_KEY,
                v);
    }

    public String getUserSessionOperate(String userId) {
        return (String) stringRedisTemplate.opsForHash().get(SPRING_SESSION_KEY_PREFIX + stringRedisTemplate.opsForValue().get(SessionUtil.SECURITY_SESSION_CONTEXT_KEY_PREFIX+userId),
                SESSION_ATTR_PREFIX + SessionUtil.USER_SESSION_OPERATED_KEY);
    }

    /**
     * @description 刷新【指定用户】session 过期时间
     *@param userId
     * @param expire   @return void
     * @Author elvin
     * @Date 2019/8/21
     */
    public void refreshDDL( String userId, int expire) {
        stringRedisTemplate.expire(SPRING_SESSION_KEY_PREFIX + stringRedisTemplate.opsForValue().get(SessionUtil.SECURITY_SESSION_CONTEXT_KEY_PREFIX+userId),expire,TimeUnit.SECONDS);
        stringRedisTemplate.expire(SPRING_SESSION_KEY_EXPIRE_PREFIX + stringRedisTemplate.opsForValue().get(SessionUtil.SECURITY_SESSION_CONTEXT_KEY_PREFIX+userId),expire,TimeUnit.SECONDS);
    }

    /**
     * @description 将 【指定用户】userId 和 sessionId 绑定
     * @param request
     * @param userId
     * @return void
     * @Author elvin
     * @Date 2019/8/21
     */
    public void registerInSessionContext(HttpServletRequest request, String userId,Integer expire) {
        stringRedisTemplate.opsForValue().set(SessionUtil.SECURITY_SESSION_CONTEXT_KEY_PREFIX + userId, request.getSession().getId());
        stringRedisTemplate.expire(SessionUtil.SECURITY_SESSION_CONTEXT_KEY_PREFIX + userId, expire, TimeUnit.SECONDS);
    }
    /**
     * @description 将 【指定用户】userId 和 sessionId 解绑
     * @param userId
     * @return void
     * @Author elvin
     * @Date 2019/8/21
     */
    public void removeFromSessionContext(String userId) {
        stringRedisTemplate.delete(SessionUtil.SECURITY_SESSION_CONTEXT_KEY_PREFIX + userId);
    }


}