package am.cs322.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"am.cs322.user"})
public class Cs322HomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(Cs322HomeworkApplication.class, args);
    }
}
