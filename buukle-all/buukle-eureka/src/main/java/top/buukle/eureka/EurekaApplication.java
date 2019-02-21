package top.buukle.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication()
@EnableEurekaServer
@RestController
public class EurekaApplication {

    private static volatile boolean RUNNING = true;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(EurekaApplication.class, args);
        System.out.println("启动成功");
        synchronized (EurekaApplication.class) {
            while (RUNNING) {
                try {
                    EurekaApplication.class.wait();
                } catch (InterruptedException e) {
                } finally {
                    SpringApplication.exit(context);
                }
            }
        }
    }

    @RequestMapping("/hello")
    public String hello() {
        return "<h1>Hello Spring-Boot Maven Docker</h1>";
    }
}
