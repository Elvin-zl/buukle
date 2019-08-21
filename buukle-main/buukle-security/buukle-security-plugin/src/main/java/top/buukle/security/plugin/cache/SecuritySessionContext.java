package top.buukle.security.plugin.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import top.buukle.security.entity.User;
import top.buukle.security.plugin.util.SessionUtil;
import top.buukle.util.JsonUtil;
import top.buukle.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
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
    private static final String SERIALIZE_PREFIX = "{" ;
    private static final String USER_CLASS = "{\"@class\": \""+ User.class.getName() +"\",";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

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
     * @description 操作【指定用户】
     * @param userId
     * @return void
     * @Author elvin  User.class.getName()
     * @Date 2019/8/21
     */
    public void setUserSessionOperate(String userId,User user) {
        String oldSid = stringRedisTemplate.opsForValue().get(SessionUtil.SECURITY_SESSION_CONTEXT_KEY_PREFIX + userId);
        String replace = JsonUtil.toJSONString(user).replace(SERIALIZE_PREFIX, USER_CLASS);
        if(!StringUtil.isEmpty(oldSid)){
            stringRedisTemplate.opsForHash().put(SPRING_SESSION_KEY_PREFIX + oldSid, SESSION_ATTR_PREFIX + SessionUtil.USER_SESSION_KEY, replace);
        }
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