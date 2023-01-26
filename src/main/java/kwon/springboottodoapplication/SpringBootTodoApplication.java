package kwon.springboottodoapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringBootTodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTodoApplication.class, args);
	}

}
