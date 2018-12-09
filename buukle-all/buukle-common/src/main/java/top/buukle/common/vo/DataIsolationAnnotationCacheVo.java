package top.buukle.common.vo;

/**
 * 业务员数据分离 : mybatis的mapper接口方法上注解的值的缓存vo
 * @author elvin
 */
public class DataIsolationAnnotationCacheVo {

	private String tableName;
	
	private String queryDimension;
	
	private String creatorFiledName;
	
	private String bak01FiledName;

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

	public String getCreatorFiledName() {
		return creatorFiledName;
	}

	public void setCreatorFiledName(String creatorFiledName) {
		this.creatorFiledName = creatorFiledName;
	}

	public String getBak01FiledName() {
		return bak01FiledName;
	}

	public void setBak01FiledName(String bak01FiledName) {
		this.bak01FiledName = bak01FiledName;
	}
}
