package com.system.inventory.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@AllArgsConstructor
@Data
@Builder
public class Product {

	@Id
	private String id;
	private String name;
	private double price;
	private double quantity;
	
	@ManyToOne
	private Category category;
}
