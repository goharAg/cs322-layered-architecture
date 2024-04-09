package am.cs322.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan( {"am.cs322.user", "am.cs322.data"})
public class Cs322HomeworkApplication {
    public static void main(String[] args) {
        SpringApplication.run(Cs322HomeworkApplication.class, args);
    }
}
