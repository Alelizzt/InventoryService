package com.system.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.inventory.model.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

}
