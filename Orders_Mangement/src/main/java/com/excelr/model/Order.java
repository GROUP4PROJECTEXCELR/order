package com.excelr.model;

import java.time.LocalDateTime;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private User user; // Assuming you have a User entity
    
    private String status; // e.g., "Placed", "Shipped", "Delivered"
    private LocalDateTime orderDate;
    
    @OneToMany(mappedBy = "order")
    private List<OrderItem> items; // Assuming you have an OrderItem entity
    
    // Getters and Setters
}