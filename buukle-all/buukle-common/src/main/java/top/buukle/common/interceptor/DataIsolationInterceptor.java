package top.buukle.common.interceptor;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import top.buukle.common.annotation.DataIsolationAnnotation;
import top.buukle.common.dataIsolation.IsolationSqlHandler;
import top.buukle.common.util.common.StringUtil;
import top.buukle.common.util.logger.BaseLogger;
import top.buukle.common.vo.DataIsolationAnnotationCacheVo;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/11/30.
 * @Description : 数据隔离查询拦截器
 */
@Intercepts(
        {
                @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
                @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}),
        }
)
public class DataIsolationInterceptor implements Interceptor {

    private static final BaseLogger LOGGER = BaseLogger.getLogger(DataIsolationInterceptor.class);

    /** select sql 匹配正则*/
    private final static String SQL_SELECT = "(?is)^\\s*SELECT.*$".toLowerCase();

    /** 是否需要重置 sql  KEY*/
    private final static String IS_NEED_RESET_KEY = "IS_NEED_RESET_KEY";

    /** 是否需要重置sql 真值*/
    private final static String IS_NEED_RESET_TRUE = "1";

    /** 是否需要重置sql 否值*/
    private final static String IS_NEED_RESET_FALSE = "0";

    /** 重置 sql  KEY*/
    private final static String RESET_SQL_KEY = "RESET_SQL_KEY";

    /** count sql 匹配正则*/
    private final static String SQL_COUNT = "(?is)^\\s*SELECT\\s+COUNT\\s*\\(\\s*(?:\\*|\\w+)\\s*\\).*$".toLowerCase();

    /** queryArgs[] 对象索引 : 原始 mappedStatement 请求语句对象索引*/
    private static int MAPPED_STATEMENT_INDEX = 0;
    /** queryArgs[] 对象索引 : parameter 参数管理对象索引*/
    private static int PARAMETER_INDEX = 1;
    /** queryArgs[] 对象索引 : parameter ROW_BOUNDS 对象索引*/
    private static int ROW_BOUNDS_INDEX = 2;
    /** queryArgs[] 对象索引 : parameter RESULT_HANDLER 对象索引*/
    private static int RESULT_HANDLER_INDEX = 3;
    /** queryArgs[] 对象索引 : parameter CACHE_KEY 对象索引*/
    private static int CACHE_KEY_INDEX = 4;
    /** queryArgs[] 对象索引 : parameter BOUND_SQL_INDEX 对象索引*/
    private static int BOUND_SQL_INDEX = 5;

    /** 本地缓存MAP==> key : mappedStatement的id属性值; value : 该id所映射的mapper方法上注解值 */
    private final static ConcurrentHashMap<String, DataIsolationAnnotationCacheVo> MAPPER_ID_ANNOTATION_CACHE_MAP = new ConcurrentHashMap<>();

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        if (invocation.getTarget() instanceof Executor) {
            Object[] args = invocation.getArgs();
            MappedStatement ms = (MappedStatement) args[MAPPED_STATEMENT_INDEX];
            Object parameter = args[PARAMETER_INDEX];
            RowBounds rowBounds = (RowBounds) args[ROW_BOUNDS_INDEX];
            ResultHandler resultHandler = (ResultHandler) args[RESULT_HANDLER_INDEX];
            Executor executor = (Executor) invocation.getTarget();
            CacheKey cacheKey;
            BoundSql boundSql;
            // 4个参数时
            if(args.length == 4){
                boundSql = ms.getBoundSql(parameter);
                cacheKey = executor.createCacheKey(ms, parameter, rowBounds, boundSql);
            }
            // 6个参数时
            else {
                cacheKey = (CacheKey) args[CACHE_KEY_INDEX];
                boundSql = (BoundSql) args[BOUND_SQL_INDEX];
            }
            // 獲取原始sql
            String originalSql = getOriginalSQL(boundSql);
            // sql为空,放行
            if(StringUtil.isEmpty(originalSql)){ return invocation.proceed(); }
            // 处理sql
            Map<String, String> handleSQLMap = this.handleSQL(originalSql,ms);
            // 不需要重置,放行
            if(StringUtil.isEmpty(handleSQLMap.get(IS_NEED_RESET_KEY)) || handleSQLMap.get(IS_NEED_RESET_KEY).equals(IS_NEED_RESET_FALSE)){ return invocation.proceed();}
            // 需要重置,重置
            MappedStatement mappedStatement = this.resetSQL(handleSQLMap.get(RESET_SQL_KEY), ms, boundSql, args);
            // 放行
            return executor.query(mappedStatement, parameter, rowBounds, resultHandler, cacheKey, mappedStatement.getBoundSql(parameter));
        }
        return invocation.proceed();
    }

    /**
     * 获取原始sql
     * @param boundSql
     * @return
     */
    private String getOriginalSQL(BoundSql boundSql) {
        // 统一转成小写,并处理回车,制表符,等
        return boundSql.getSql().toLowerCase().replace(StringUtil.NEW_LINE, StringUtil.BLANK).replace(StringUtil.TABULACTOR, StringUtil.BLANK);
    }

    /**
     * 处理sql
     * @param originalSql
     * @param mappedStatement
     * @return
     * @throws Exception
     */
    private Map<String , String> handleSQL(String originalSql, MappedStatement mappedStatement) throws Exception {
        Map<String, String> result = new HashMap<>();
        if(MAPPER_ID_ANNOTATION_CACHE_MAP.containsKey(mappedStatement.getId())){
            LOGGER.info("数据隔离查询sql命中本地缓存,mapper方法 : {} ,准备处理sql", mappedStatement.getId());
            // 匹配 sql,并调用解析方法
            String resultSql = this.handleSQL(originalSql,null,MAPPER_ID_ANNOTATION_CACHE_MAP.get(mappedStatement.getId()));
            result.put(IS_NEED_RESET_KEY, IS_NEED_RESET_TRUE);
            result.put(RESET_SQL_KEY, resultSql);
            return result;
        }else{
            // 通过id 反射找到mapper接口代理类,并可通过反射寻访被自定义注解标记的指定方法
            Class<?> mapperClassType = Class.forName(mappedStatement.getId().substring(0, mappedStatement.getId().lastIndexOf(StringUtil.DOT)));
            String methodName = mappedStatement.getId().substring(mappedStatement.getId().lastIndexOf(StringUtil.DOT) + 1,mappedStatement.getId().length());
            for (Method method : mapperClassType.getDeclaredMethods()) {
                if ((method.isAnnotationPresent(DataIsolationAnnotation.class) && methodName.equals(method.getName())) || (method.isAnnotationPresent(DataIsolationAnnotation.class) && methodName.equals(method.getName() + "_COUNT"))) {
                    if (originalSql.matches(SQL_SELECT) || Pattern.matches(SQL_COUNT, originalSql)) {
                        // 此处直接new ,缓存后会被...CACHE_MAP 一直引用,下次不再执行反射和循环,空间换时间吧
                        DataIsolationAnnotationCacheVo cacheVo = new DataIsolationAnnotationCacheVo();
                        cacheVo.setQueryDimension(method.getAnnotation(DataIsolationAnnotation.class).isolationFiledName());
                        cacheVo.setTableName(method.getAnnotation(DataIsolationAnnotation.class).tableName());
                        // 本地MAP缓存mapper接口方法id ,以及该方法上注解的值;
                        MAPPER_ID_ANNOTATION_CACHE_MAP.put(mappedStatement.getId(), cacheVo);
                        // 匹配 sql,并调用解析方法
                        String resultSql = this.handleSQL(originalSql,method,null);
                        result.put(IS_NEED_RESET_KEY, IS_NEED_RESET_TRUE);
                        result.put(RESET_SQL_KEY, resultSql);
                        return result;
                    }
                }
            }
        }
        // 没有被注解的方法,直接返回即可
        result.put(IS_NEED_RESET_KEY, IS_NEED_RESET_FALSE);
        result.put(RESET_SQL_KEY, originalSql);
        return result;
    }
    /**
     * 匹配 sql,并调用解析方法
     * @param sql
     * @param method
     * @param vo
     * @throws Exception
     */
    private String handleSQL(String sql, Method method, DataIsolationAnnotationCacheVo vo) throws Exception {
        if(null != method){
            String handleSQL = IsolationSqlHandler.handleSQL(sql,
                    method.getAnnotation(DataIsolationAnnotation.class).tableName(),
                    method.getAnnotation(DataIsolationAnnotation.class).isolationFiledName()
                    );
            return handleSQL;
        }
        String handleSQL = IsolationSqlHandler.handleSQL(sql,
                vo.getTableName(),
                vo.getQueryDimension()
        );
        return handleSQL;
    }
    /**
     * 重置sql
     * @param resultSql
     * @param mappedStatement
     * @param boundSql
     * @param queryArgs
     */
    private MappedStatement resetSQL(String resultSql, MappedStatement mappedStatement, BoundSql boundSql, Object[] queryArgs) {
        // 重新new一个查询语句对像
        BoundSql newBoundSql = new BoundSql(mappedStatement.getConfiguration(), resultSql, boundSql.getParameterMappings(), boundSql.getParameterObject());
        // copy设置参数(这很重要!)
        for (ParameterMapping mapping : boundSql.getParameterMappings()) {
            String prop = mapping.getProperty();
            if (boundSql.hasAdditionalParameter(prop)) {
                newBoundSql.setAdditionalParameter(prop, boundSql.getAdditionalParameter(prop));
            }
        }
        // 把新的查询放到statement里
        return copyFromMappedStatement(mappedStatement,new BoundSqlSqlSource(newBoundSql));
    }

    /**
     * 拷贝 MappedStatement 对象
     * @param mappedStatement
     * @param newSqlSource
     * @return
     */
    private MappedStatement copyFromMappedStatement(MappedStatement mappedStatement, BoundSqlSqlSource newSqlSource) {
        MappedStatement.Builder builder = new MappedStatement.Builder(mappedStatement.getConfiguration(), mappedStatement.getId(), newSqlSource, mappedStatement.getSqlCommandType());
        builder.resource(mappedStatement.getResource());
        builder.fetchSize(mappedStatement.getFetchSize());
        builder.statementType(mappedStatement.getStatementType());
        builder.keyGenerator(mappedStatement.getKeyGenerator());
        if (mappedStatement.getKeyProperties() != null && mappedStatement.getKeyProperties().length > 0) {
            builder.keyProperty(mappedStatement.getKeyProperties()[0]);
        }
        builder.timeout(mappedStatement.getTimeout());
        builder.parameterMap(mappedStatement.getParameterMap());
        builder.resultMaps(mappedStatement.getResultMaps());
        builder.resultSetType(mappedStatement.getResultSetType());
        builder.cache(mappedStatement.getCache());
        builder.flushCacheRequired(mappedStatement.isFlushCacheRequired());
        builder.useCache(mappedStatement.isUseCache());
        return builder.build();
    }

    /**
     * BoundSqlSqlSource 内部类
     * @author elvin
     *
     */
    public static class BoundSqlSqlSource implements SqlSource {
        private BoundSql boundSql;
        BoundSqlSqlSource(BoundSql boundSql) {
            this.boundSql = boundSql;
        }
        @Override
        public BoundSql getBoundSql(Object parameterObject) {
            return boundSql;
        }
    }

    @Override
        public Object plugin(final Object target) {
            if (target instanceof Executor) {
                return Plugin.wrap(target, this);
            } else {
                return target;
            }
    }

    @Override
    public void setProperties(Properties properties) {

    }
}


