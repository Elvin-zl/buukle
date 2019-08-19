package top.buukle.security.plugin.client;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.core.env.Environment;
import top.buukle.security.plugin.annotation.DataIsolationAnnotation;
import top.buukle.security.plugin.cache.DataIsolationCache;
import top.buukle.security.plugin.constants.SecurityInterceptorConstants;
import top.buukle.security.plugin.util.DataIsolationSqlUtil;
import top.buukle.util.StringUtil;
import top.buukle.util.log.BaseLogger;


/**
 * 数据隔离插件
 */
@Intercepts({@Signature(
        type = Executor.class,
        method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}
), @Signature(
        type = Executor.class,
        method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}
)})
public class DataIsolationInterceptor implements Interceptor {


	private Environment env;


    public DataIsolationInterceptor(Environment env) {
        this.env = env;
    }

    private final static BaseLogger LOGGER = BaseLogger.getLogger(DataIsolationInterceptor.class);

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
	static int MAPPED_STATEMENT_INDEX = 0;
	
	/** queryArgs[] 对象索引 : parameter 参数管理对象索引*/
	static int PARAMETER_INDEX = 1;

	/** 本地缓存MAP==> key : mappedStatement的id属性值; value : 该id所映射的mapper方法上注解值 */
	private final static ConcurrentHashMap<String, DataIsolationCache> MAPPER_ID_ANNOTATION_CACHE_MAP = new ConcurrentHashMap<>();

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
        
		if (invocation.getTarget() instanceof Executor) {
        	if(!SecurityInterceptorConstants.OPEN_ISOL_TRUE.equals(env.getProperty("security.openIsol"))){
				// 放行
				return invocation.proceed();
			}
        	//初始化准备参数对象
        	//拦截参数数组
        	final Object[] queryArgs = invocation.getArgs(); 
        	//请求语句(sql)管理对象
        	final MappedStatement mappedStatement = (MappedStatement)queryArgs[MAPPED_STATEMENT_INDEX]; 
        	//绑定sql信息管理对象
        	final BoundSql boundSql = mappedStatement.getBoundSql(queryArgs[PARAMETER_INDEX]);
        	// 獲取原始sql
        	String originalSql = getOriginalSQL(boundSql);
			// sql为空,不做处理
			if(StringUtils.isBlank(originalSql)){ return invocation.proceed(); }
			// 处理sql
			Map<String, String> handleSQLMap = this.handleSQL(originalSql,mappedStatement);
			if(StringUtil.notEmpty(handleSQLMap.get(IS_NEED_RESET_KEY)) && handleSQLMap.get(IS_NEED_RESET_KEY).equals(IS_NEED_RESET_TRUE)){
				// 重置sql
				this.resetSQL(handleSQLMap.get(RESET_SQL_KEY),mappedStatement,boundSql,queryArgs);
			}
			// 放行
			return invocation.proceed();
		}
		return invocation.proceed();
	}

	/**
	 * 获取原始sql
	 * @param boundSql
	 * @return
	 */
	private String getOriginalSQL(BoundSql boundSql) {
		//统一转成小写处理
		return boundSql.getSql().toLowerCase();
	}

	/**
	 * 处理sql
	 * @param originalSql
	 * @param mappedStatement
	 * @return
	 * @throws Exception
	 */
	private Map<String , String> handleSQL(String originalSql, MappedStatement mappedStatement) throws Exception {
		Map<String, String> result = new HashMap<String, String>();
		if(MAPPER_ID_ANNOTATION_CACHE_MAP.containsKey(mappedStatement.getId())){
			LOGGER.info("命中本地缓存===========> mapper方法 : {} ,准备处理sql", mappedStatement.getId());
			// 匹配 sql,并调用解析方法
			String resultSql = this.matchSql(originalSql,null,MAPPER_ID_ANNOTATION_CACHE_MAP.get(mappedStatement.getId()));
			result.put(IS_NEED_RESET_KEY, IS_NEED_RESET_TRUE);
			result.put(RESET_SQL_KEY, resultSql);
			return result;
		}else{
			// 通过id 反射找到mapper接口代理类,并可通过反射寻访被自定义注解标记的指定方法
			Class<?> mapperClassType = Class.forName(mappedStatement.getId().substring(0, mappedStatement.getId().lastIndexOf(StringUtil.DOT)));
			String methodName = mappedStatement.getId().substring(mappedStatement.getId().lastIndexOf(StringUtil.DOT) + 1,mappedStatement.getId().length());
			for (Method method : mapperClassType.getDeclaredMethods()) {
				if (method.isAnnotationPresent(DataIsolationAnnotation.class) && methodName.equals(method.getName())) {
					if (originalSql.matches(SQL_SELECT) || Pattern.matches(SQL_COUNT, originalSql)) {
						// 此处直接new ,缓存后会被...CACHE_MAP 一直引用,下次不再执行反射和循环,空间换时间吧
						DataIsolationCache sCacheVo = new DataIsolationCache();
						sCacheVo.setRoleFieldName(method.getAnnotation(DataIsolationAnnotation.class).roleFieldName());
						sCacheVo.setQueryDimension(method.getAnnotation(DataIsolationAnnotation.class).queryDimension());
						sCacheVo.setTableName(method.getAnnotation(DataIsolationAnnotation.class).tableName());
						// 本地MAP缓存mapper接口方法id ,以及该方法上注解的值;
						MAPPER_ID_ANNOTATION_CACHE_MAP.put(mappedStatement.getId(), sCacheVo);
						// 匹配 sql,并调用解析方法
						String resultSql = this.matchSql(originalSql,method,null);
						result.put(IS_NEED_RESET_KEY, IS_NEED_RESET_TRUE);
						result.put(RESET_SQL_KEY, resultSql);
						return result;
					}
				}
			}
		}
		//没有被注解的方法,直接返回即可
		result.put(IS_NEED_RESET_KEY, IS_NEED_RESET_FALSE);
		result.put(RESET_SQL_KEY, originalSql);
		return result;
	}
	
	/**
	 * 匹配 sql,并调用解析方法
	 * @param sql
	 * @param method 
	 * @throws Exception
	 */
	private String matchSql(String sql, Method method, DataIsolationCache vo) throws Exception {
		if(null != method){
			String matchSql = DataIsolationSqlUtil.matchSql(env.getProperty("spring.application.name"),sql,
					method.getAnnotation(DataIsolationAnnotation.class).tableName(),
					method.getAnnotation(DataIsolationAnnotation.class).queryDimension(),
					method.getAnnotation(DataIsolationAnnotation.class).roleFieldName());
			return matchSql;
		}
		String matchSql = DataIsolationSqlUtil.matchSql(env.getProperty("spring.application.name"),sql,
				vo.getTableName(), 
				vo.getQueryDimension(), 
				vo.getRoleFieldName()
				);
		return matchSql;
	}
	/**
	 * 重置sql 
	 * @param resultSql
	 * @param mappedStatement
	 * @param boundSql
	 * @param queryArgs
	 */
	private void resetSQL(String resultSql, MappedStatement mappedStatement, BoundSql boundSql, Object[] queryArgs) {
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
		MappedStatement newMs = copyFromMappedStatement(mappedStatement,new BoundSqlSqlSource(newBoundSql));
		// 把新的MappedStatement放到queryArgs里
		queryArgs[MAPPED_STATEMENT_INDEX] = newMs; 
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

	@Override
	public Object plugin(Object target) {
        if (target instanceof Executor) {
            return Plugin.wrap(target, this);
        }
        return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties arg0) {

	}
	
	/**
	 * BoundSqlSqlSource 内部类
	 * @author elvin
	 *
	 */
	public static class BoundSqlSqlSource implements SqlSource {
		private BoundSql boundSql;
		public BoundSqlSqlSource(BoundSql boundSql) {
			this.boundSql = boundSql;
		}
		public BoundSql getBoundSql(Object parameterObject) {
			return boundSql;
			}
		}
}
