package top.buukle.consumer.portal.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/1/4.
 * @Description : 访问拦截器
 */
public class VisitorInterceptor implements HandlerInterceptor {

    /*文章访问uri*/
    private static final String ARTICLE_VISIT_URI = "/articleInfo/detail";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //初始化参数
        String remoteAddr = request.getRemoteAddr();
        String uri = request.getRequestURI();

        if(uri.startsWith(ARTICLE_VISIT_URI)){

        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}
