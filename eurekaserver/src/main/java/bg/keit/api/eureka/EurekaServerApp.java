package bg.keit.api.eureka;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer

public class EurekaServerApp {
    public static void main(String[] args) throws Exception{

        // runApplication<EurekaServerApp>(*args);
        SpringApplication.run(EurekaServerApp.class, args);
    }

}
