package com.example.Product.Controllers;
import com.example.Product.DTO.CategoryDTO;
import com.example.Product.Service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;
    //get all category
    @GetMapping("/allcategories")
    public ResponseEntity<List<CategoryDTO>> getAllCategories(){
        return  new ResponseEntity<>(categoryService.getAllCategoryDTO(),HttpStatus.OK);
    }


    //create category
    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
        return  new ResponseEntity<>(categoryService.getcategoryDTO(categoryDTO), HttpStatus.CREATED);
    }

    //get by id
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryByID(@PathVariable Long id){
        return  new ResponseEntity<>(categoryService.getCategoryById(id),HttpStatus.OK);
    }

    // Delete by id
    @DeleteMapping("/delete/{id}")
    public String deleteCategoryByID(@PathVariable Long id){
        categoryService.deleteById(id);
        return  "deleted Successfully";
    }

}
