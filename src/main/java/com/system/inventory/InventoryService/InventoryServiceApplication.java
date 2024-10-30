package com.system.inventory.InventoryService;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.system.inventory.entities.Category;
import com.system.inventory.repository.CategoryRepository;
import com.system.inventory.repository.ProductRepository;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	CommandLineRunner commandLineRunner(CategoryRepository categoryRepository, ProductRepository productRepository) {
		return args -> {
			List.of("Computers", "Printers", "Smartphones").forEach(cat -> {
				Category category = Category.builder().name(cat).build();
				categoryRepository.save(category);
			});;
		};
	}
}
