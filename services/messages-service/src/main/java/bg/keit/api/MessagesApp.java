package bg.keit.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "bg.keit")
@EntityScan("bg.keit.model.message")
public class MessagesApp {

        public static void main(String[] args) {
            try {
                SpringApplication.run(MessagesApp.class, args);
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }

}
