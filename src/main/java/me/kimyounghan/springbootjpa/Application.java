package me.kimyounghan.springbootjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaRepositories(repositoryImplementationPostfix = "Default") // default "Impl"
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
