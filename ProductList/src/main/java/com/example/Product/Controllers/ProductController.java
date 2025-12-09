package com.example.Product.Controllers;

import com.example.Product.DTO.ProductDTO;
import com.example.Product.Service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    //create product
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        return  new ResponseEntity<>(productService.getProductDTO(productDTO), HttpStatus.CREATED);
    }
    //get product
    @GetMapping("/allproducts")
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProduct(),HttpStatus.OK);
    }
    //get product by id
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id){
        return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
    }
    //delete by id
    @DeleteMapping("delete/{id}")
    public String deleteProductById(@PathVariable Long id){
        productService.deleteById(id);
        return  "Recorded is sucessfully deleted";
    }
    //update the product
    @PutMapping("/update/{id}")
    public ResponseEntity<ProductDTO> updateProductById(@PathVariable Long id,@RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(productService.updateProduct(id,productDTO),HttpStatus.OK);
    }

}
