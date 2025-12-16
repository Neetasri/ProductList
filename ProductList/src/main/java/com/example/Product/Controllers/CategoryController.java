package com.example.Product.Controllers;
import com.example.Product.DTO.CategoryDTO;
import com.example.Product.Service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name="Category REST API CRUD Operation",
        description = "CREATE, UPDATE, READ and DELETE operations for Category REST API"
)
@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;
    //get all category
    @Operation(summary = "Fetch all categories",description = "Rest API to fetch all Categories")
    @GetMapping("/allcategories")
    public ResponseEntity<List<CategoryDTO>> getAllCategories(){
        return  new ResponseEntity<>(categoryService.getAllCategoryDTO(),HttpStatus.OK);
    }


    //create category
    @Operation(summary = "Create Category",description = "Rest API to Create Category")
    @ApiResponse(responseCode = "201", description = "CREATED")
    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
        return  new ResponseEntity<>(categoryService.createcategoryDTO(categoryDTO), HttpStatus.CREATED);
    }

    //get by id
    @Operation(summary = "Fetch Category By Id",description = "Rest API to fetch Category By Id")
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryByID(@PathVariable Long id){
        return  new ResponseEntity<>(categoryService.getCategoryById(id),HttpStatus.OK);
    }

    // Delete by id
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @Operation(summary = "Delete Category By Id",description = "Rest API to delete Category By Id")
    @DeleteMapping("/delete/{id}")
    public String deleteCategoryByID(@PathVariable Long id){
        categoryService.deleteById(id);
        return  "deleted Successfully";
    }

}
