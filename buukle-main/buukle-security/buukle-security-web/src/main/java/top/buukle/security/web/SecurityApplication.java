package top.buukle.security.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;
import top.buukle.security.plugin.constants.SecurityInterceptorConstants;

@MapperScan("top.buukle.security.dao")
@SpringBootApplication(scanBasePackages={"top.buukle.*"})
@EnableFeignClients(basePackages = {"top.buukle.*"})
@EnableRedisHttpSession
public class SecurityApplication {
    private static volatile boolean RUNNING = true;
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SecurityApplication.class, args);
        System.out.println("启动成功");
        synchronized (SecurityApplication.class) {
            while (RUNNING) {
                try {
                    SecurityApplication.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    SpringApplication.exit(context);
                }
            }
        }
    }
}
