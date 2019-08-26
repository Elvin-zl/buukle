package top.buukle.security.plugin.util;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.CollectionUtils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.buukle.security.entity.Role;
import top.buukle.security.plugin.annotation.DataIsolationAnnotation;
import top.buukle.security.plugin.enums.SecurityExceptionEnum;
import top.buukle.security.plugin.exception.SecurityPluginException;
import top.buukle.util.JsonUtil;
import top.buukle.util.StringUtil;
import top.buukle.util.log.BaseLogger;

public class DataIsolationSqlUtil {

	private final static BaseLogger LOGGER = BaseLogger.getLogger(DataIsolationSqlUtil.class);
	
	/** 无记录时默认in条件 */
	private static final String NO_CODE_LIST = "NO_CODE_LIST";

	/** in条件前缀 */
	private static final String CODE_IN_PREFIX = " in ( ";

	/** in条件后缀 */
	private static final String CODE_IN_SUFFIX = " )";
	
	/** 拼接片段常量 : where */
	private static final String SPLICING_WHERE = " where ";
	
	/** 拼接片段常量 : and */
	private static final String SPLICING_AND = " and ";
	
	/** 拼接片段常量 : group */
	private static final String SPLICING_GROUP = " group ";
	
	/** 拼接片段常量 : order */
	private static final String SPLICING_ORDER = " order ";

	/**
	 * 构建查询条件,调用解析方法
	 * @param sql
	 * @param tableName
	 * @param queryDimension
	 * @return
	 * @throws Exception 
	 */
	public static String matchSql(String applicationCode, String sql, String tableName, String queryDimension, String roleFiledName) throws Exception {
		// 校验参数
		validateParam(tableName,queryDimension,roleFiledName);
		// 处理 :回车,制表符,等
		sql = sql.replace(StringUtil.NEW_LINE, StringUtil.BLANK).replace(StringUtil.TABULACTOR, StringUtil.BLANK);
		LOGGER.info("解析sql,拼接开始:原始sql :{},表名 :{},查询唯度 :{},角色字段名 :{},",sql, tableName,queryDimension,
				StringUtil.isEmpty(roleFiledName) ? StringUtil.BLANK : roleFiledName);
		String codeInCondition = StringUtil.EMPTY;
		// 从session获取当前用户下辖角色信息
        Map<String,List<Role>> userSubRolesMap = (Map<String, List<Role>>) SessionUtil.get(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest(), SessionUtil.USER_ROLE_SUB_MAP_KEY);
        // 初次登录,放行
        if(userSubRolesMap == null ){
            return sql;
        }
        List<Role> userSubRoles = userSubRolesMap.get(applicationCode);
		// 没有所辖角色信息
		if (CollectionUtils.isEmpty(userSubRoles)) {
		    throw new SecurityPluginException(SecurityExceptionEnum.AUTH_WRONG_DATA_ISOLATION_NO_ROLE_SUBS);
		}
		LOGGER.info("所辖角色信息 : userSubRoles : {}", JsonUtil.toJSONString(userSubRoles));
		// 角色维度
		if(StringUtil.notEmpty(queryDimension) && queryDimension.equals(DataIsolationAnnotation.DIMENSION_ROLE)){
			codeInCondition = new StringBuilder(roleFiledName).append(CODE_IN_PREFIX).append(getIdStringSaperatedByComma(userSubRoles)).append(CODE_IN_SUFFIX).toString();
		}
		String finalSql = matchSql(sql, tableName, codeInCondition);
		LOGGER.info("解析sql,拼接结束 :finalSql:{}",finalSql);
		return finalSql;
	}
	
	/**
	 * 解析sql,调用拼接方法
	 * @param sql
	 * @param tableName
	 * @param codeInCondition
	 * @return
	 */
	public static String matchSql(String sql, String tableName,String codeInCondition) {
		Matcher matcher;
		if (sql.startsWith("select")) {
			matcher = Pattern.compile("select\\s.+from\\s" + tableName + "\\s(.*)where\\s(.*)").matcher(sql);
			if (matcher.find()) {
				return match(matcher.group(1).trim(),sql,codeInCondition);
			} else {
				matcher = Pattern.compile("select\\s.+from\\s(.*)" + tableName + "\\s(.*)where\\s(.*)").matcher(sql);
				if (matcher.find()) {
					if (StringUtil.isEmpty(matcher.group(2).trim())) {
						return splicingSql(sql, codeInCondition);
					} else {
						int index = matcher.group(2).trim().indexOf(StringUtil.BLANK);
						if (index > 0) {
							return splicingSql(sql, matcher.group(2).trim().substring(0, index) + StringUtil.DOT + codeInCondition);
						} else {
							return splicingSql(sql, matcher.group(2).trim() + StringUtil.DOT + codeInCondition);
						}

					}
				} else {
					matcher = Pattern.compile("select\\s.+from\\s" + tableName + "\\s(.*)").matcher(sql);
					if (matcher.find()) {
                        return match(matcher.group(1).trim(),sql,codeInCondition);
					} else {
						matcher = Pattern.compile("select\\s.+from\\s(.*)" + tableName + "\\s(.*)").matcher(sql);
						if (matcher.find()) {
                            return match(matcher.group(2).trim(),sql,codeInCondition);
						}

					}
				}
			}
		}
		return sql;
	}

    private static String match(String match, String sql, String codeInCondition) {
        if (StringUtil.isEmpty(match)) {
            return splicingSql(sql, codeInCondition);
        } else {
            if (match.indexOf(StringUtil.BLANK) > 0) {
                match = match.substring(0, match.indexOf(StringUtil.BLANK));
                return splicingSql(sql, match + StringUtil.DOT + codeInCondition);
            } else {
                return splicingSql(sql, match + StringUtil.DOT + codeInCondition);
            }
        }
    }

    /**
	 * 拼接
	 * @param sql
	 * @param tableNameAndCondition
	 * @return
	 */
	public static String splicingSql(String sql, String tableNameAndCondition) {
		int index = sql.indexOf(SPLICING_WHERE);
		//处理 where
		if (index > 0) {
			return sql.replace(SPLICING_WHERE, SPLICING_WHERE + tableNameAndCondition + SPLICING_AND);
		} else {
			//处理 group by
			index = sql.indexOf(SPLICING_GROUP);
			if (index > 0) {
				return sql.replace(SPLICING_GROUP, SPLICING_WHERE + tableNameAndCondition + SPLICING_GROUP);
			}
			//处理 order by
			index = sql.indexOf(SPLICING_ORDER);
			if (index > 0) {
				return sql.replace(SPLICING_ORDER, SPLICING_WHERE + tableNameAndCondition + SPLICING_ORDER);
			} 
			//处理 默认情况
			else {
				return sql + SPLICING_WHERE + tableNameAndCondition;
			}
		}
	}

	/**
	 * 获取所辖角色 字符串,逗号分隔
	 *
	 * @return
     * @param subRoleList
	 */
	private static String getIdStringSaperatedByComma(List<Role> subRoleList) {
		if (CollectionUtils.isEmpty(subRoleList)) {
		    return NO_CODE_LIST;
		}
		StringBuilder sb = new StringBuilder();
		for (Role ro : subRoleList) {
			sb.append(StringUtil.SINGLE_QUOTE).append(ro.getId()).append(StringUtil.SINGLE_QUOTE).append(StringUtil.COMMA);
		}
		return sb.toString().substring(0,sb.toString().lastIndexOf(StringUtil.COMMA));
	}

	/**
	 * 参数校验
	 * @param tableName
	 * @param queryDimension
	 */
	private static void validateParam(String tableName, String queryDimension,String roleFiledName) {
	}

}