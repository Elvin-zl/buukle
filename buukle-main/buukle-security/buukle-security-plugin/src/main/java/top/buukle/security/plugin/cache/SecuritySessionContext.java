package top.buukle.security.plugin.cache;

import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import top.buukle.common.call.CommonResponse;
import top.buukle.security.entity.User;
import top.buukle.security.plugin.util.SessionUtil;
import top.buukle.util.JsonUtil;
import top.buukle.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * @description session 实时在线session操作
 * @Author zhanglei1102
 * @Date 2019/8/19
 */
@Component
public class SecuritySessionContext<T> {

    private static final String SPRING_SESSION_KEY_PREFIX = "spring:session:sessions:";
    private static final String SPRING_SESSION_KEY_EXPIRE_PREFIX = "spring:session:sessions:expires:";
    public static final String SESSION_ATTR_PREFIX = "sessionAttr:";
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * @description 失效指定user session
     * @param userId
     * @return void
     * @Author elvin
     * @Date 2019/8/21
     */
    public void deleteSession(String userId) {
        stringRedisTemplate.delete(SPRING_SESSION_KEY_PREFIX + stringRedisTemplate.opsForValue().get(SessionUtil.SECURITY_SESSION_CONTEXT_KEY_PREFIX+userId));
    }
    /**
     * @description 踢掉指定user 
     * @param userId
     * @return void
     * @Author elvin
     * @Date 2019/8/21
     */
    public void kickOutUser(String userId, User user, int expire ) {
        String oldSid = stringRedisTemplate.opsForValue().get(SessionUtil.SECURITY_SESSION_CONTEXT_KEY_PREFIX + userId);
        if(!StringUtil.isEmpty(oldSid)){
            stringRedisTemplate.opsForHash().put(SPRING_SESSION_KEY_PREFIX + oldSid, SESSION_ATTR_PREFIX + SessionUtil.USER_SESSION_KEY, JsonUtil.toJSONString(user, SerializerFeature.WriteClassName));
            stringRedisTemplate.expire(SPRING_SESSION_KEY_PREFIX + oldSid,expire,TimeUnit.SECONDS);
        }
    }
    /**
     * @description 刷新指定user session信息
     * @param userId
     * @param k
     * @param v
     * @param expire
     * @return void
     * @Author elvin
     * @Date 2019/8/23
     */
    public void refreshSession(String userId, String k, T v, int expire) {
        String oldSid = stringRedisTemplate.opsForValue().get(SessionUtil.SECURITY_SESSION_CONTEXT_KEY_PREFIX + userId);
        if(!StringUtil.isEmpty(oldSid)){
            stringRedisTemplate.opsForHash().put(SPRING_SESSION_KEY_PREFIX + oldSid, SESSION_ATTR_PREFIX + k, JsonUtil.toJSONString(v, SerializerFeature.WriteClassName));
            stringRedisTemplate.expire(SPRING_SESSION_KEY_PREFIX + oldSid,expire,TimeUnit.SECONDS);
        }
    }
    /**
     * @description 刷新指定user session 过期时间
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
     * @description 将 指定user userId 和 sessionId 绑定
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
     * @description 将 指定user userId 和 sessionId 解绑
     * @param userId
     * @return void
     * @Author elvin
     * @Date 2019/8/21
     */
    public void removeFromSessionContext(String userId) {
        stringRedisTemplate.delete(SessionUtil.SECURITY_SESSION_CONTEXT_KEY_PREFIX + userId);
    }
    /**
     * @description 统计实时在线人数
     * @return int
     * @Author zhanglei1102
     * @Date 2019/8/22
     */
    public CommonResponse countSessionContext() {
        CommonResponse commonResponse = new CommonResponse.Builder().buildSuccess();
        commonResponse.getHead().setMsg(stringRedisTemplate.keys(SessionUtil.SECURITY_SESSION_CONTEXT_KEY_PREFIX + "*").size()+StringUtil.EMPTY);
        return  commonResponse;
    }

}