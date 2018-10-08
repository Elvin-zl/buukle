package top.buukle.generator.hibernate.config;

public class DataSourceConfig {
	
	//for mysql
	/** 用户名*/
	private  String username = "root";
	/** 密码*/
	private  String password = "A987654321b/";
	/** 方言*/
	private  String dialect = "org.hibernate.dialect.MySQL5Dialect";
	/** 创建策略*/
	private  String generateStrategy = "create";
	/** 驱动*/
	private  String driver = "com.mysql.jdbc.Driver";
	/** 主键*/
	private  String primareyStrategy = "native";
	/** url*/
	private  String jdbcUrl = "jdbc:mysql://47.95.13.7:3654/test";

	//for postgreySQL
//	private  String jdbcUrl = "jdbc:postgresql://localhost:5432/GEO";
//	private  String username = "postgres";
//	private  String password = "zxcvbnmKO),.";
//	private  String generateStrategy = "create";
//	private  String dialect = "org.hibernate.dialect.PostgreSQLDialect";
//
//	private  String driver = "org.postgresql.Driver";
//	private  String primareyStrategy = "native";

	public String getJdbcUrl() {
		return jdbcUrl;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getGenerateStrategy() {
		return generateStrategy;
	}
	public String getDialect() {
		return dialect;
	}
	public String getDriver() {
		return driver;
	}
	public String getPrimareyStrategy() {
		return primareyStrategy;
	}
	
}
