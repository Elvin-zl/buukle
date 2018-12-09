package top.buukle.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/6.
 * @Description :
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface InvokerLoggingAnnotation {

    /** 打印日志*/
    public static final String PRINT_TRUE = "0";

    /** 不打印日志*/
    public static final String PRINT_FALSE = "1";

    String value() default PRINT_TRUE;
}
