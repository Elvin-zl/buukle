package top.buukle.www.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

@MapperScan("top.buukle.www.dao")
@SpringBootApplication(scanBasePackages={"top.buukle.www.*"})
@EnableFeignClients(basePackages = {"top.buukle.*"})
public class WwwApplication {
    private static volatile boolean RUNNING = true;
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(WwwApplication.class, args);
        System.out.println("启动成功");
        synchronized (WwwApplication.class) {
            while (RUNNING) {
                try {
                    WwwApplication.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    SpringApplication.exit(context);
                }
            }
        }
    }
}