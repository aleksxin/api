package bg.keit.api;

import org.firebirdsql.gds.impl.GDSType;
import org.firebirdsql.management.FBManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "bg.keit")
@EntityScan("bg.keit.model.message")
public class MessagesApp {
   // @Autowired

        public static void main(String[] args) {
            try {



                SpringApplication.run(MessagesApp.class, args);
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }

}
