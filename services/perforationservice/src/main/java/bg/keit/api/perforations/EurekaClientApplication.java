package bg.keit.api.perforations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = "bg.keit")
@EntityScan("bg.keit.model.domain")

public class EurekaClientApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(EurekaClientApplication.class, args);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}