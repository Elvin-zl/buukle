package top.buukle.security.plugin.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import top.buukle.security.entity.User;
import top.buukle.security.plugin.util.SessionUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/**
 * @description session 引用缓存
 * @Author zhanglei1102
 * @Date 2019/8/19
 */
@Component
public class SecuritySessionContext {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static ConcurrentHashMap<String,HttpSession> USER_ID_SESSION_MAP = new ConcurrentHashMap();

    public static void RegisterSession(HttpServletRequest request, HttpServletResponse response) {
        USER_ID_SESSION_MAP.put(SessionUtil.getOperator(request,response).getUserId(), request.getSession(false));
    }

    public static void removeSession(HttpServletRequest request, HttpServletResponse response) {
        USER_ID_SESSION_MAP.remove(SessionUtil.getOperator(request,response).getUserId());
    }

    public static HttpSession getSession(String userId) {
        return USER_ID_SESSION_MAP.get(userId);
    }

    // 初始化userId session 映射
    public void init() {
        List<Object> hashList = stringRedisTemplate.opsForHash().values("spring:session:sessions:*");
        for (Object obj: hashList) {
            HttpSession httpSession = (HttpSession) obj;
            USER_ID_SESSION_MAP.put(((User) httpSession.getAttribute(SessionUtil.USER_SESSION_KEY)).getUserId(),httpSession);
        }
    }
}