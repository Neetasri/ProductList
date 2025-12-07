package com.example.Product.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Product> products=new ArrayList<>();
}
