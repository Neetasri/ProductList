package com.example.Product.Controllers;
import com.example.Product.DTO.CategoryDTO;
import com.example.Product.Service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDTO> getCategory(@RequestBody CategoryDTO categoryDTO) {
        return  new ResponseEntity<>(categoryService.getcategoryDTO(categoryDTO), HttpStatus.CREATED);
    }

}
