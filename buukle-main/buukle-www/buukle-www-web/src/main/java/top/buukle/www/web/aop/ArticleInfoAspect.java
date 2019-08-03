package top.buukle.www.web.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ArticleInfoAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * @description 文章题目更新切面
     * @param proceedingJoinPoint
     * @return void
     * @Author elvin
     * @Date 2019/6/25
     */
    @Around("execution(public * top.buukle.www.dao.ArticleInfoMapper.updateByPrimaryKey(..))")
    public Object aroundUpdateByPrimaryKey(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object proceed = proceedingJoinPoint.proceed();
        logger.error("--------------------------文章题目更新了!------------------------");
        return proceed;
    }
}