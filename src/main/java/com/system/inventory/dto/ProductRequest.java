package com.system.inventory.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductRequest {
    private String id;
    private String name;
    private double price;
    private int quantity;
    private Long categoryId;
}
