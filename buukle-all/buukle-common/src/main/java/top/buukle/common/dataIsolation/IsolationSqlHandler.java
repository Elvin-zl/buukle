package top.buukle.common.dataIsolation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.CollectionUtils;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;
import top.buukle.common.util.common.JsonUtil;
import top.buukle.common.util.common.StringUtil;
import top.buukle.common.util.logger.BaseLogger;

public class IsolationSqlHandler {

	private final static BaseLogger LOGGER = BaseLogger.getLogger(IsolationSqlHandler.class);
	
	/** 没有成员列表时,默认的 in条件 */
	private static final String NO_CODE_LIST = "NO_RECORD";

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

	/** 等级信息 NPE*/
	private static final String EXCEPTION_MSG_RELATION_NULL = "查询失败,用户等级信息为空!";

    /**
	 * 构建查询条件,调用解析方法
	 * @param sql
	 * @param tableName
	 * @param isolationFiledName
	 * @return
	 * @throws Exception
	 */
	public static String handleSQL(String sql, String tableName, String isolationFiledName) throws Exception {
		// 校验参数
		validateParam(tableName);
        tableName = tableName.trim();
        isolationFiledName = StringUtil.isEmpty(isolationFiledName) ? isolationFiledName :  isolationFiledName.trim();
        LOGGER.info("解析拼接sql开始,原始sql :{},表名 :{},查询唯度 :{}",  sql, tableName, isolationFiledName);
		String codeInCondition = StringUtil.EMPTY;
		// 从本地线程参数对象获取等级,以及下级列表
		IsolationRelation isolationRelation = IsolationRelationThreadLocal.getSchemas();
		// 等级信息和自定义隔离字段为空
        if((null == isolationRelation || isolationRelation.getUserLevel() == null) && StringUtil.isEmpty(isolationFiledName)){
            throw new Exception(EXCEPTION_MSG_RELATION_NULL);
        }
        //具有自定义隔离字段
        if(StringUtil.notEmpty(isolationFiledName)){
            codeInCondition = new StringBuilder(isolationFiledName).append(CODE_IN_PREFIX).append(getCodeStringSeparatedByComma(isolationRelation.getSubCodeList())).append(CODE_IN_SUFFIX).toString();
        }else{
            // 等级信息 : boss级别
            if (isolationRelation.getUserLevel().equals(IsolationConstants.USER_LEVEL_BOSS)) {
                LOGGER.info("用户等级为:[boss],下级列表为: relation : {}",JsonUtil.toJSONString(isolationRelation));
                LOGGER.info("解析拼接sql完成,处理后sql :{}",sql);
                return sql;
            }
            // 等级信息 : 平台级别
            if (isolationRelation.getUserLevel().equals(IsolationConstants.USER_LEVEL_PLATFORM)) {
                LOGGER.info("用户等级为:[平台],下级列表为: relation : {}",JsonUtil.toJSONString(isolationRelation));
                codeInCondition = new StringBuilder(IsolationConstants.USER_LEVEL_PLATFORM_FILED).append(CODE_IN_PREFIX).append(getCodeStringSeparatedByComma(isolationRelation.getSubCodeList())).append(CODE_IN_SUFFIX).toString();
            }
            // 等级信息 : 代理级别
            if (isolationRelation.getUserLevel().equals(IsolationConstants.USER_LEVEL_AGENT)) {
                LOGGER.info("用户等级为:[代理],下级列表为: relation : {}",JsonUtil.toJSONString(isolationRelation));
                codeInCondition = new StringBuilder(IsolationConstants.USER_LEVEL_AGENT_FILED).append(CODE_IN_PREFIX).append(getCodeStringSeparatedByComma(isolationRelation.getSubCodeList())).append(CODE_IN_SUFFIX).toString();
            }
            // 等级信息 : 区域级别
            if (isolationRelation.getUserLevel().equals(IsolationConstants.USER_LEVEL_GROUP)) {
                LOGGER.info("用户等级为:[区域],下级列表为: relation : {}",JsonUtil.toJSONString(isolationRelation));
                codeInCondition = new StringBuilder(IsolationConstants.USER_LEVEL_GROUP_FILED).append(CODE_IN_PREFIX).append(getCodeStringSeparatedByComma(isolationRelation.getSubCodeList())).append(CODE_IN_SUFFIX).toString();
            }
            // 等级信息 : 业务员级别
            if (isolationRelation.getUserLevel().equals(IsolationConstants.USER_LEVEL_SALESMAN)) {
                LOGGER.info("用户等级为:[业务员],下级列表为: relation : {}",JsonUtil.toJSONString(isolationRelation));
                codeInCondition = new StringBuilder(IsolationConstants.USER_LEVEL_SALESMAN_FILED).append(CODE_IN_PREFIX).append(getCodeStringSeparatedByComma(isolationRelation.getSubCodeList())).append(CODE_IN_SUFFIX).toString();
            }
            // 等级信息 : 小白级别
            if (isolationRelation.getUserLevel().equals(IsolationConstants.USER_LEVEL_CREATOR)) {
                LOGGER.info("用户等级为:[创建者],下级列表为: relation : {}",JsonUtil.toJSONString(isolationRelation));
                codeInCondition = new StringBuilder(IsolationConstants.USER_LEVEL_CREATOR_FILED).append(CODE_IN_PREFIX).append(getCodeStringSeparatedByComma(isolationRelation.getSubCodeList())).append(CODE_IN_SUFFIX).toString();
            }
        }
		String finalSql = parseSplicingSql(sql, tableName, codeInCondition);
		LOGGER.info("解析拼接sql完成,处理后sql :{}",finalSql);
		return finalSql;
	}

	/**
	 * 解析sql,调用拼接方法
	 * @param sql
	 * @param tableName
	 * @param codeInCondition
	 * @return
	 */
	public static String parseSplicingSql(String sql, String tableName, String codeInCondition) {
		Matcher matcher;
		if (sql.startsWith("select")) {
			matcher = Pattern.compile("select\\s.+from\\s" + tableName + "\\s(.*)where\\s(.*)").matcher(sql);
			if (matcher.find()) {
				String match = matcher.group(1).trim();
				return splicingSql(match,sql,codeInCondition);
			} else {
				matcher = Pattern.compile("select\\s.+from\\s(.*)" + tableName + "\\s(.*)where\\s(.*)").matcher(sql);
				if (matcher.find()) {
					String match = matcher.group(2).trim();
					if (StringUtil.isEmpty(match)) {
						return splicingSql(sql, codeInCondition);
					} else {
						int index = match.indexOf(StringUtil.BLANK);
						if (index > 0) {
							match = match.substring(0, index);
							return splicingSql(sql, match + StringUtil.DOT + codeInCondition);
						} else {
							return splicingSql(sql, match + StringUtil.DOT + codeInCondition);
						}
					}
				} else {
					matcher = Pattern.compile("select\\s.+from\\s" + tableName + "\\s(.*)").matcher(sql);
					if (matcher.find()) {
						String match = matcher.group(1).trim();
                        return splicingSql(match,sql,codeInCondition);
					} else {
						matcher = Pattern.compile("select\\s.+from\\s(.*)" + tableName + "\\s(.*)").matcher(sql);
						if (matcher.find()) {
							String match = matcher.group(2).trim();
                            return splicingSql(match,sql,codeInCondition);
						}

					}
				}
			}
		}
		return sql;
	}

    /**
     * 拼接sql 第1步
     * @param match
     * @param sql
     * @param codeInCondition
     * @return
     */
	private static String splicingSql(String match, String sql, String codeInCondition) {
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
	 * 拼接sql 第2步
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
	 * 获取下级成员列表 字符串,逗号分隔
	 * @param codeNoList
	 * @return
	 */
	private static String getCodeStringSeparatedByComma(List<String> codeNoList) {
		// 下级列表为空,默认in查询一个没有的串,返回结果集合是空就行
		if (CollectionUtils.isEmpty(codeNoList)) {
			codeNoList = new ArrayList();
			codeNoList.add(NO_CODE_LIST);
		}
		StringBuilder sb = new StringBuilder();
		for (String code : codeNoList) { 
			sb.append(StringUtil.SINGLE_QUOTE).append(code).append(StringUtil.SINGLE_QUOTE).append(StringUtil.COMMA);
		}
		return sb.toString().substring(0,sb.toString().lastIndexOf(StringUtil.COMMA));
	}

	/**
	 * 参数校验
     * @param tableName
     *
     */
	private static void validateParam(String tableName) {
		if(StringUtil.isEmpty(tableName)){
			throw new BaseException(BaseResponseCode.ISOLATION_TABLE_NAME_NULL);
		}
	}
}