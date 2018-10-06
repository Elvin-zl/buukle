package top.buukle.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages={"top.buukle.common", "top.buukle.provider.security", "top.buukle.plugin.security"})
@ImportResource(locations = {"classpath:config/spring/springBootContext.xml"})
@EnableEurekaClient
@EnableFeignClients(basePackages = {"top.buukle.plugin.security.invoker"})
@MapperScan("top.buukle.provider.security.dao")
public class SecurityApplication {

    /** 应用逻辑开关监听*/
    private static volatile boolean RUNNING = true;
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SecurityApplication.class, args);
        System.out.println("启动成功");
        synchronized (SecurityApplication.class) {
            while (RUNNING) {
                try {
                    SecurityApplication.class.wait();
                } catch (InterruptedException e) {
                } finally {
                    SpringApplication.exit(context);
                }
            }
        }
    }
}
