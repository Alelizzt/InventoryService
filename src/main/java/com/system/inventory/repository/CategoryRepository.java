package com.system.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.inventory.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
