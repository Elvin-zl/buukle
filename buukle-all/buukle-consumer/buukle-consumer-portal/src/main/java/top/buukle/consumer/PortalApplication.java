package top.buukle.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages={"top.buukle.common","top.buukle.consumer.portal","top.buukle.plugin.security"})
@EnableFeignClients(basePackages = {"top.buukle.consumer.portal.invoker","top.buukle.plugin.security.invoker"})
public class PortalApplication {
    private static volatile boolean RUNNING = true;
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(PortalApplication.class, args);
        System.out.println("启动成功");
        synchronized (PortalApplication.class) {
            while (RUNNING) {
                try {
                    PortalApplication.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    SpringApplication.exit(context);
                }
            }
        }
    }
}
