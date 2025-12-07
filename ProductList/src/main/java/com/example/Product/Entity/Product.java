package com.example.Product.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String name;
    private  double price;
    private  String description;

   @ManyToOne
   @JoinColumn(name = "category_id", nullable = false)
    private Category category;

}
