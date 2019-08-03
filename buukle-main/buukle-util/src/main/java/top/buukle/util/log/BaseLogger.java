package top.buukle.util.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/23.
 * @Description :
 */
public class BaseLogger {

    public Logger logger;

    private BaseLogger(Logger logger) {
        super();
        this.logger = logger;
    }

    /**
     * 获取ElogLogger
     * @param clazz
     * @return
     */
    public static BaseLogger getLogger(Class<?> clazz){
        Logger logger = LoggerFactory.getLogger(clazz);
        return new BaseLogger(logger);
    }

    /**
     * 获取sessionid
     * @return
     */
    public String getSessionId(){
        long currentId=-1;
        try {
            ServletRequestAttributes servletRequestAttributes = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
            if(servletRequestAttributes!=null){
                HttpServletRequest request = servletRequestAttributes.getRequest();
                HttpSession session=request.getSession();
                return session.getId();
            }

            Thread current = Thread.currentThread();
            currentId = current.getId();
        } catch (Exception e) {

        }
        return "[currentId="+currentId+"]";
    }

    public Logger getLogger() {
        return logger;
    }
    public void setLogger(Logger logger) {
        this.logger = logger;
    }
    public String getSidStr(String msg) {
        StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<stacks.length;i++){
            if(logger.getName().equals(stacks[i].getClassName())){
                sb.append(stacks[i].getClassName());
                sb.append( "." );
                sb.append(stacks[i].getMethodName());
                sb.append("(");
                sb.append(stacks[i].getFileName());
                sb.append(":");
                sb.append(stacks[i].getLineNumber());
                sb.append(")");
                break;
            }
        }
        sb.append("[sid:");
        sb.append(getSessionId());
        sb.append("] ");
        sb.append(msg);
        return sb.toString();
    }

    public void debug(String msg,Object... args){
        logger.debug(getSidStr(msg),args);
    }

    /**
     * 位置0：sid
     * "位置1：{}位置2：{}","a","b"
     * @param msg
     * @param args
     */
    public void info(String msg,Object... args){
        logger.info(getSidStr(msg),args);
    }

    public void warn(String msg,Object... args){
        logger.warn(getSidStr(msg),args);
    }

    public void error(String msg,Object... args){
        logger.error(getSidStr(msg),args);
    }

    /**
     * 异常日志
     * @param msg
     * @param t
     */
    public void error(String msg,Throwable t){
        logger.error(getSidStr(msg),t);
    }
}
