package com.example.Product.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
        name = "Product",description = "It's holds Product Info"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private  Long id;
     private String name;
     private double price;
     private String description;
     private Long categoryId;
}
