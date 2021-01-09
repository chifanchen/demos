/**
 * @description:
 * @author: 范晨
 * @date: Created in 2021/1/8 21:45
 * @version:
 * @modified By:
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("vertx_kafka")
public class ClientTestApplication {
    public static void main(String[] args) {
        new SpringApplication(ClientTestApplication.class).run(args);
    }
}
