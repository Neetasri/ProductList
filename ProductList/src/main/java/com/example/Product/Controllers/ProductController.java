package com.example.Product.Controllers;

import com.example.Product.DTO.ProductDTO;
import com.example.Product.Service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(
        name="Product REST API CRUD Operation",
        description = "CREATE, UPDATE, READ and DELETE operations for Product REST API"
)

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    //create product
    @Operation(summary = "Create Product",description = "Rest API to create product")
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        return  new ResponseEntity<>(productService.createProductDTO(productDTO), HttpStatus.CREATED);
    }
    //get product
    @Operation(summary = "Fetch all Products",description = "Rest API to fetch all products")
    @GetMapping("/allproducts")
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProduct(),HttpStatus.OK);
    }
    //get product by id
    @Operation(summary = "Fetch Product By ID",description = "Rest API to fetch product By Id")
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id){
        return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
    }
    //delete by id
    @Operation(summary = "Delete Product by ID",description = "Rest API to delete product By ID")
    @DeleteMapping("delete/{id}")
    public String deleteProductById(@PathVariable Long id){
        productService.deleteById(id);
        return  "Recorded is sucessfully deleted";
    }
    //update the product
    @Operation(summary = "Update Product By Id",description = "Rest API to update product By Id")
    @PutMapping("/update/{id}")
    public ResponseEntity<ProductDTO> updateProductById(@PathVariable Long id,@RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(productService.updateProduct(id,productDTO),HttpStatus.OK);
    }

}
