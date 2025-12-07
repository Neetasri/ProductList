package com.example.Product.Mapper;

import com.example.Product.DTO.CategoryDTO;
import com.example.Product.Entity.Category;

public class CategoryMapper {
    public static Category toCategoryEntity(CategoryDTO categoryDTO) {
        Category category = new Category();
//        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());
        return category;
    }

    public static CategoryDTO toCategoryDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        if(category==null){
            return  null;
        }
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setProducts(category.getProducts().stream().
                map(ProductMapper::toProductDTO).toList());
        return categoryDTO;
    }
}
