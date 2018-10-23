package top.buukle.clould;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication()
@EnableEurekaServer
public class ClouldApplication {
    private static volatile boolean RUNNING = true;
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ClouldApplication.class, args);
        System.out.println("启动成功");
        synchronized (ClouldApplication.class) {
            while (RUNNING) {
                try {
                    ClouldApplication.class.wait();
                } catch (InterruptedException e) {
                } finally {
                    SpringApplication.exit(context);
                }
            }
        }
    }
}
