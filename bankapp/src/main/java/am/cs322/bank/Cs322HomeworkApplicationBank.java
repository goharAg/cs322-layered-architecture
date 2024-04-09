package am.cs322.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan( {"am.cs322.bank", "am.cs322.data"})
public class Cs322HomeworkApplicationBank {

    public static void main(String[] args) {
        SpringApplication.run(Cs322HomeworkApplicationBank.class, args);
    }
}
