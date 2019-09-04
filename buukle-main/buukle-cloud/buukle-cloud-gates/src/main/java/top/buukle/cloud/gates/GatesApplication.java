package top.buukle.cloud.gates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages={"top.buukle.cloud.gates"})
@EnableEurekaClient
public class GatesApplication {
    private static volatile boolean RUNNING = true;
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(GatesApplication.class, args);
        System.out.println("启动成功");
        synchronized (GatesApplication.class) {
            while (RUNNING) {
                try {
                    GatesApplication.class.wait();
                } catch (InterruptedException e) {
                } finally {
                    SpringApplication.exit(context);
                }
            }
        }
    }
}
