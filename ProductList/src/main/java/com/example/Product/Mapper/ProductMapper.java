package com.example.Product.Mapper;
import com.example.Product.DTO.ProductDTO;
import com.example.Product.Entity.Category;
import com.example.Product.Entity.Product;

public class ProductMapper {
    public static Product toProductEntity(ProductDTO productDTO,Category category) {
        Product product = new Product();
        product.setName(product.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        return  product;
    }

    public static ProductDTO toProductDTO(Product product) {
        return  new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getId());

    }
}
