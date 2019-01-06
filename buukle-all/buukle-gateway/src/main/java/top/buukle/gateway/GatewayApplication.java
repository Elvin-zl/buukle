package top.buukle.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages={"top.buukle.common","top.buukle.gateway"})
//@EnableFeignClients(basePackages = {"top.buukle.gateway.invoker","top.buukle.plugin.security.invoker"})
@EnableEurekaClient
public class GatewayApplication {
    private static volatile boolean RUNNING = true;
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(GatewayApplication.class, args);
        System.out.println("启动成功");
        synchronized (GatewayApplication.class) {
            while (RUNNING) {
                try {
                    GatewayApplication.class.wait();
                } catch (InterruptedException e) {
                } finally {
                    SpringApplication.exit(context);
                }
            }
        }
    }
}
