package com.system.inventory.controller;

import com.system.inventory.model.Category;
import com.system.inventory.model.Product;
import com.system.inventory.repository.CategoryRepository;
import com.system.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

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
}
