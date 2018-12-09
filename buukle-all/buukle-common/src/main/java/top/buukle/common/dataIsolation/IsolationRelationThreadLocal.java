package top.buukle.common.dataIsolation;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/12/2.
 * @Description : 数据隔离线程本地变量
 */
public class IsolationRelationThreadLocal {

    /** 初始化线程本地变量*/
    private static final ThreadLocal<IsolationRelation> IsolationRelationThreadLocal = new ThreadLocal<>();

    /** 数据隔离关系对象在请求中的key*/
    private static final String ISOLATION_RELATION_KEY = "ISOLATION_RELATION_KEY";


    /**
     * 设置schemas
     * @param schemas
     */
    public static void setSchemas(IsolationRelation schemas) {
        try {
            ServletRequestAttributes servletRequestAttributes = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
            if(servletRequestAttributes!=null){
                HttpServletRequest request = servletRequestAttributes.getRequest();
                request.setAttribute(ISOLATION_RELATION_KEY, schemas);
            }else{
                IsolationRelationThreadLocal.set(schemas);
            }
        } catch (Exception e) {

        }
    }

    /**
     * 获取schemas
     * @return
     */
    public static IsolationRelation getSchemas() {
        try {
            ServletRequestAttributes servletRequestAttributes = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
            if(servletRequestAttributes!=null){
                HttpServletRequest request = servletRequestAttributes.getRequest();
                return (IsolationRelation) request.getAttribute(ISOLATION_RELATION_KEY);
            }else{
                return IsolationRelationThreadLocal.get();
            }
        } catch (Exception e) {

        }
        return null;
    }
}
