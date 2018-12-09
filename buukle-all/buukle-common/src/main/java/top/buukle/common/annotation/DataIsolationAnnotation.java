package top.buukle.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/11/30.
 * @Description : 数据隔离注解
 */
@Target({ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataIsolationAnnotation {

    /**
     * 隔离的字段名 : 为了标识查询的隔离条件,可由用户自行制定(不指定默认按照用户本身的的级别进行隔离)
     * @return
     */
    String isolationFiledName() default "";

    /**
     * 查询表名
     * @return
     */
    String tableName() default "";

    /**
     * 查询表别名
     * @return
     */
    String tableAlias() default "";
}