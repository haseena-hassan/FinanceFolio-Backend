package com.financefolio.backend.service;

import com.financefolio.backend.dto.CategoryDTO;

import java.util.ArrayList;

public interface CategoryServiceInterface {

    ArrayList<CategoryDTO> getAllCategories();

    void addCategory(CategoryDTO categoryDTO);

    void deleteCategory(Long categoryId);
}
