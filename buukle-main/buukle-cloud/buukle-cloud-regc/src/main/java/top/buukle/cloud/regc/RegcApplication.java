package top.buukle.cloud.regc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication()
@EnableEurekaServer
@RestController
public class RegcApplication {

    private static volatile boolean RUNNING = true;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(RegcApplication.class, args);
        System.out.println("启动成功");
        synchronized (RegcApplication.class) {
            while (RUNNING) {
                try {
                    RegcApplication.class.wait();
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
