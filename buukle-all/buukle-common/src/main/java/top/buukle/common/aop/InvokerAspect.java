package top.buukle.common.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import top.buukle.common.annotation.InvokerLoggingAnnotation;
import top.buukle.common.util.common.StringUtil;
import top.buukle.common.util.common.ThreadLocalUtil;
import top.buukle.common.util.logger.BaseLogger;
import top.buukle.common.vo.ThreadParam;

/**
 * 全局invoker(feign-client)日志参数打印切面
 */
@Aspect
@Component
public class InvokerAspect {

    private final static BaseLogger LOGGER =  BaseLogger.getLogger(InvokerAspect.class);

    /**
     * Pointcut定义切点
     */
    @Pointcut("execution(* top.buukle..invoker.*Invoker.*(..))")
    public void pointcuts(){

    }

    @Before("pointcuts()")
    public void doBefore(JoinPoint joinPoint) throws ClassNotFoundException {
        InvokerLoggingAnnotation annotation = ((MethodSignature) joinPoint.getSignature()).getMethod().getAnnotation(InvokerLoggingAnnotation.class);
        if(null == annotation){
            this.logging(joinPoint);
            return;
        }
        String isLogging =  annotation.value();
        if(StringUtil.isEmpty(isLogging) || isLogging.equals(InvokerLoggingAnnotation.PRINT_FALSE)){
            return;
        }
        this.logging(joinPoint);
    }

    /**
     * 执行打印日志
     * @param joinPoint
     */
    private void logging(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        Object[] args = joinPoint.getArgs();
        if(null == args || args.length < 1 || null == ((MethodSignature) joinPoint.getSignature()).getMethod().getAnnotation(PostMapping.class) || ((MethodSignature) joinPoint.getSignature()).getMethod().getAnnotation(PostMapping.class).value().length < 1){
            return;
        }
        String api= ((MethodSignature) joinPoint.getSignature()).getMethod().getAnnotation(PostMapping.class).value()[0];
        ThreadParam threadParam = new ThreadParam.Biulder().setParameter(className+"调用"+api+"接口结束:" ).build();
        ThreadLocalUtil.set(threadParam);
        LOGGER.info(className+"调用:{}接口开始:", api);
        LOGGER.info("请求参数:{}", JSON.toJSONString(joinPoint.getArgs()[0]));

    }

    @After("pointcuts()")
    public void doAfter(JoinPoint joinPoint){
    }

    @AfterReturning(returning="result", pointcut="pointcuts()")
    public void doAfterReturnint(Object result){
        ThreadParam threadParam = ThreadLocalUtil.get();
        ThreadLocalUtil.clear();
        if(threadParam == null || StringUtil.isEmpty(threadParam.getParameter())){
            return;
        }
        LOGGER.info(threadParam.getParameter());
        LOGGER.info("返回结果:{}",null == result ? "" : JSON.toJSONString(result));
    }
}
