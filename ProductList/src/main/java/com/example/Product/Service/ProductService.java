package com.example.Product.Service;

import com.example.Product.DTO.ProductDTO;
import com.example.Product.Entity.Category;
import com.example.Product.Entity.Product;
import com.example.Product.Exception.CategoryNotFoundException;
import com.example.Product.Mapper.ProductMapper;
import com.example.Product.Repository.CategoryRepository;
import com.example.Product.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public ProductDTO createProductDTO(ProductDTO productDTO) {
        Category category=categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(()->new CategoryNotFoundException("Category id "+ productDTO.getCategoryId()  +" not found"));

        Product product=ProductMapper.toProductEntity(productDTO,category);
        product= productRepository.save(product);
        return  ProductMapper.toProductDTO(product);
    }

    public List<ProductDTO> getAllProduct() {
        return productRepository.findAll().stream().map(ProductMapper:: toProductDTO).toList();
    }

    public ProductDTO getProductById(Long id) {
        Product product=productRepository.findById(id).orElseThrow(()->new RuntimeException("product not found"));
        return  ProductMapper.toProductDTO(product);
    }


    public String deleteById(Long id) {
        productRepository.findById(id).orElseThrow(()->new RuntimeException("product not found"));
        productRepository.deleteById(id);
        return "Deleted successfully";
    }

    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
          Product product= productRepository.findById(id).orElseThrow(()->new RuntimeException("product not found"));
          Category category=categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(()->new RuntimeException("Category not found"));
          product.setName(productDTO.getName());
          product.setPrice(productDTO.getPrice());
          product.setDescription(productDTO.getDescription());
          product.setCategory(category);
        return ProductMapper.toProductDTO(productRepository.save(product));
    }
}
