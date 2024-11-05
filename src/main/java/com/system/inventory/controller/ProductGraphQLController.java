package com.system.inventory.controller;

import com.system.inventory.dto.ProductRequest;
import com.system.inventory.model.Category;
import com.system.inventory.model.Product;
import com.system.inventory.repository.CategoryRepository;
import com.system.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public class ProductGraphQLController {
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@QueryMapping
	public List<Product> showProducts() {
		return productRepository.findAll();
	}

	@QueryMapping
	public Product showProductById(@Argument String id) {
		return productRepository.findById(id).orElseThrow(
				() -> new RuntimeException(String.format("Product %s not found ",id))
		);
	}

	@QueryMapping
	public List<Category> showCategories() {
		return categoryRepository.findAll();
	}

	@QueryMapping
	public Category showCategoryById(@Argument Long id) {
		return categoryRepository.findById(id).orElseThrow(
				() -> new RuntimeException(String.format("Category %s not found ",id))
		);
	}


	@MutationMapping
	public Product saveProduct(@Argument ProductRequest productRequest) {
		Category category = categoryRepository.findById(productRequest.getCategoryId()).orElse(null);
		Product productDB = new Product();
		productDB.setId(UUID.randomUUID().toString());
		productDB.setName(productRequest.getName());
		productDB.setPrice(productRequest.getPrice());
		productDB.setQuantity(productRequest.getQuantity());
		productDB.setCategory(category);

		return productRepository.save(productDB);
	}

	@MutationMapping
	public Product updateProduct(@Argument String id, @Argument ProductRequest productRequest) {
		Category category = categoryRepository.findById(productRequest.getCategoryId()).orElse(null);
		Product productDB = new Product();
		productDB.setId(id);
		productDB.setName(productRequest.getName());
		productDB.setPrice(productRequest.getPrice());
		productDB.setQuantity(productRequest.getQuantity());
		productDB.setCategory(category);

		return productRepository.save(productDB);
	}

	@MutationMapping
	public void deleteProduct(@Argument String id) {
		productRepository.deleteById(id);
	}
}
