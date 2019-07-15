package top.buukle.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages={"top.buukle.common", "top.buukle.plugin.upload","top.buukle.consumer.www","top.buukle.consumer.timeline","top.buukle.plugin.security"})
@EnableFeignClients(basePackages = {"top.buukle.consumer.www.invoker","top.buukle.plugin.security.invoker","top.buukle.plugin.upload.invoker"})
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
