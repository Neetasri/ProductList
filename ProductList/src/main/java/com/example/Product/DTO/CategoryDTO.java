package com.example.Product.DTO;
import com.example.Product.Entity.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Schema(
        name = "Category",description = "It's holds Category Info"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private  Long id;
    private  String name;
    private  List<ProductDTO> products;


}
