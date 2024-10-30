package com.system.inventory;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.system.inventory.model.Category;
import com.system.inventory.model.Product;
import com.system.inventory.repository.CategoryRepository;
import com.system.inventory.repository.ProductRepository;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CategoryRepository categoryRepository, ProductRepository productRepository) {
		Random random = new Random();
		return args -> {
			List.of("Computers", "Printers", "Smartphones").forEach(cat -> {
				Category category = Category.builder().name(cat).build();
				categoryRepository.save(category);
			});;
			categoryRepository.findAll().forEach(category -> {
				for(int i=0; i<10; i++) {
					Product product = Product.builder()
							.id(UUID.randomUUID().toString())
							.name("Computer " + i)
							.price(100 + Math.random()*50000)
							.quantity(random.nextInt(100))
							.category(category)
							.build();
					productRepository.save(product);
				}
			});
		};
	}
}
