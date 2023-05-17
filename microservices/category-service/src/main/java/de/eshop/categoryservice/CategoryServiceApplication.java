package de.eshop.categoryservice;

import de.eshop.categoryservice.models.Category;
import de.eshop.categoryservice.repositories.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class CategoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CategoryServiceApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(CategoryRepository repository) {
		return (args) -> {
			repository.save(new Category(1L, "Test"));
		};
	}

}
