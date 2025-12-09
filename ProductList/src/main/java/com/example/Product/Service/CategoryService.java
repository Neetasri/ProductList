package com.example.Product.Service;

import com.example.Product.DTO.CategoryDTO;
import com.example.Product.Entity.Category;
import com.example.Product.Mapper.CategoryMapper;
import com.example.Product.Repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;

    public  String deleteById(Long id) {
        categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Category not found"));
        categoryRepository.deleteById(id);
        return  "deleted Successfully";
    }

    public CategoryDTO getcategoryDTO(CategoryDTO categoryDTO) {
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category= categoryRepository.save(category);
        return  CategoryMapper.toCategoryDTO(category);
    }

    public List<CategoryDTO> getAllCategoryDTO() {
//        List<Category> categoryList = categoryRepository.findAll();
//        List<CategoryDTO> categoryDTOS= new ArrayList<>();
//        for(Category category : categoryList){
//            categoryDTOS.add(CategoryMapper.toCategoryDTO(category));
//        }
//        return categoryDTOS;

        return categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDTO).toList();
    }


    public CategoryDTO getCategoryById(Long id) {
//        return  categoryRepository.findById(id)
//                .map(CategoryMapper::toCategoryDTO).
//                orElseGet(() -> CategoryMapper.toCategoryDTO(new Category()));

        Category category= categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Category not found"));
        return  CategoryMapper.toCategoryDTO(category);
   }
}
