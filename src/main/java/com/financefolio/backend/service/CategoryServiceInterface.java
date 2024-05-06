package com.financefolio.backend.service;

import com.financefolio.backend.dto.CategoryDTO;

import java.util.ArrayList;

public interface CategoryServiceInterface {
    ArrayList<CategoryDTO> getAllCategories();
    CategoryDTO getCategory(Long categoryId);
    void addCategory(CategoryDTO categoryDTO);
    void updateCategory(Long categoryId, CategoryDTO categoryDTO);
    void deleteCategory(Long categoryId);
}
