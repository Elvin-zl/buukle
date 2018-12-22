package top.buukle.consumer.cms.configure;
import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import top.buukle.common.interceptor.DataIsolationInterceptor;
import top.buukle.common.util.common.NumberUtil;

import javax.sql.DataSource;

/**
 *
 * Created by Administrator on 2017/11/18.
 */

@Configuration
@MapperScan(basePackages = "top.buukle.consumer.cms.dao")
class DataSourceConfigure {

    @Autowired
    private Environment env;

    /**
     * destroy-method="close"的作用是当数据库连接不使用的时候,就把该连接重新放到数据池中,方便下次使用调用.
     * @return
     */
    @Bean(destroyMethod =  "close")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        //用户名
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        //密码
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        //初始化时建立物理连接的个数
        dataSource.setInitialSize(NumberUtil.INTEGER_TWO);
        //最小连接池数量
        dataSource.setMinIdle(NumberUtil.INTEGER_ZERO);
        //最大连接池数量
        dataSource.setMaxActive(NumberUtil.INTEGER_THOUSAND * NumberUtil.INTEGER_TWO);
        //获取连接时最大等待时间，单位毫秒。
        dataSource.setMaxWait(60000);
        //用来检测连接是否有效的sql
        dataSource.setValidationQuery("SELECT 1");
        //申请连接时执行validationQuery检测连接是否有效
        dataSource.setTestOnBorrow(false);
        //建议配置为true，不影响性能，并且保证安全性。
        dataSource.setTestWhileIdle(true);
        //是否缓存preparedStatement，也就是PSCache
        dataSource.setPoolPreparedStatements(false);
        return dataSource;
    }

    /**
     * 配置 DataIsolationAnnotation 数据隔离插件
     * @return
     */
    @Bean
    public DataIsolationInterceptor getGroupsInterceptor(){
        return  new DataIsolationInterceptor();
    }
}
