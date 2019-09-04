package top.buukle.tc.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@MapperScan("top.buukle.security.dao")
@SpringBootApplication(scanBasePackages={"top.buukle.*"})
@EnableFeignClients(basePackages = {"top.buukle.*"})
@EnableRedisHttpSession
public class TcApplication {
    private static volatile boolean RUNNING = true;
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(TcApplication.class, args);
        System.out.println("启动成功");
        synchronized (TcApplication.class) {
            while (RUNNING) {
                try {
                    TcApplication.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    SpringApplication.exit(context);
                }
            }
        }
    }
}
