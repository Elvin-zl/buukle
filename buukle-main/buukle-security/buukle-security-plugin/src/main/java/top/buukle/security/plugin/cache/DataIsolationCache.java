package top.buukle.security.plugin.cache;

/**
 * 数据分离 : mybatis的mapper接口方法上注解的值的缓存vo
 * @author elvin
 */
public class DataIsolationCache {

	private String tableName;
	
	private String queryDimension;
	
	private String roleFieldName;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getQueryDimension() {
		return queryDimension;
	}

	public void setQueryDimension(String queryDimension) {
		this.queryDimension = queryDimension;
	}

	public String getRoleFieldName() {
		return roleFieldName;
	}

	public void setRoleFieldName(String roleFieldName) {
		this.roleFieldName = roleFieldName;
	}
}
