package top.buukle.cms.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

@MapperScan("top.buukle.cms.dao")
@SpringBootApplication(scanBasePackages={"top.buukle.cms.*"})
@EnableFeignClients(basePackages = {"top.buukle.*"})
@EnableRedisHttpSession
public class CmsApplication {
    private static volatile boolean RUNNING = true;
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CmsApplication.class, args);
        System.out.println("启动成功");
        synchronized (CmsApplication.class) {
            while (RUNNING) {
                try {
                    CmsApplication.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    SpringApplication.exit(context);
                }
            }
        }
    }

    /**
     * @description 配置共享session 的domain,cookie
     * @param
     * @return org.springframework.session.web.http.CookieSerializer
     * @Author elvin
     * @Date 2019/7/30
     */
    @Bean
    public CookieSerializer cookieSerializer() {
        DefaultCookieSerializer defaultCookieSerializer = new DefaultCookieSerializer();
        defaultCookieSerializer.setDomainName("buukle.top");
        defaultCookieSerializer.setCookieName("BUUKLEUID");
        defaultCookieSerializer.setCookiePath("/");
        return defaultCookieSerializer;
    }
}