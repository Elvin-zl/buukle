package top.buukle.security.plugin.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @author elvin
 */
@Target({ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataIsolationAnnotation {

	/** 角色*/
	public static String DIMENSION_ROLE = "0";

	/**
     * 角色字段名：在不同的表中，角色字段名可能会不一样，这里根据不同的表注解方法注明即可。
     * @return
     */
    String roleFieldName() default "creator_role_id";


    /**
     * 查询唯度 : 此值在应用时必须用当前注解静态常量指定 目前只支持 DIMENSION_ROLE
     * @return
     */
    String queryDimension() default DataIsolationAnnotation.DIMENSION_ROLE;
    
    /**
     * 查询表名
     * @return
     */
    String tableName() default "";
    
    /**
     * 查询表别名（针对复杂查询备用处理属性）
     * @return
     */
    String tableAlias() default "";
}
