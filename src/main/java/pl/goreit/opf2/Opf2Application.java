package pl.goreit.opf2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import pl.goreit.opf2.config.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class Opf2Application {

    public static void main(String[] args) {
        SpringApplication.run(Opf2Application.class, args);
    }

}
