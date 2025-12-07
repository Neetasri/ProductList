package com.example.Product.Service;

import com.example.Product.DTO.CategoryDTO;
import com.example.Product.Entity.Category;
import com.example.Product.Mapper.CategoryMapper;
import com.example.Product.Repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryDTO getcategoryDTO(CategoryDTO categoryDTO) {
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category= categoryRepository.save(category);
        return  CategoryMapper.toCategoryDTO(category);
    }
}
