package bg.keit.api.perforations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = "bg.keit")
@EntityScan("bg.keit.model.domain")

public class EurekaClientApplication {


    public static void main(String[] args) {
        try {
         //   System.out.println("  ....    Path is "+userBucketPath+" | "+userBucketPath1+" | "+userBucketPath2);
            SpringApplication.run(EurekaClientApplication.class, args);
         //   System.out.println("  ....    Path is "+userBucketPath);


        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}