package com.system.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.inventory.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
