package dev.project.smart_fridge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "dev.project.smart_fridge.model") // <- ESSENCIAL
@EnableJpaRepositories(basePackages = "dev.project.smart_fridge.repository")
@ComponentScan(basePackages = "dev.project.smart_fridge")
public class SmartFridgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartFridgeApplication.class, args);
	}

}
