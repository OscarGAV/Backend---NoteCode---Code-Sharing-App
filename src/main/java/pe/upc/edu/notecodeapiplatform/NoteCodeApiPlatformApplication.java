package pe.upc.edu.notecodeapiplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NoteCodeApiPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoteCodeApiPlatformApplication.class, args);
    }
}
