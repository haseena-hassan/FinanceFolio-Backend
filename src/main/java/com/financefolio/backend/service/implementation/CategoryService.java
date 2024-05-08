package com.financefolio.backend.service.implementation;

import com.financefolio.backend.dto.CategoryDTO;
import com.financefolio.backend.model.Category;
import com.financefolio.backend.repository.CategoryRepository;
import com.financefolio.backend.service.CategoryServiceInterface;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.financefolio.backend.Utils.getUserEmail;

@Service
@AllArgsConstructor
@Slf4j(topic = "CATEGORY_SERVICE")
public class CategoryService implements CategoryServiceInterface {

    private final CategoryRepository categoryRepository;

    @Override
    public ArrayList<CategoryDTO> getAllCategories() {
        ArrayList<CategoryDTO> categories = new ArrayList<>();
        categoryRepository.findByUserEmail(getUserEmail())
                          .forEach(category ->
                                categories.add(new CategoryDTO(category)
                          ));
        log.info("All categories fetched successfully");
        return categories;
    }


    @Override
    public void addCategory(CategoryDTO categoryDTO) {
        Category category = new Category(categoryDTO);
        category.setUserEmail(getUserEmail());
        categoryRepository.save(category);
        log.info(String.format("Category %s added successfully", category.getCategoryName()));
    }

    @Override
    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
        log.info(String.format("Category %s deleted successfully", categoryId));
    }
}
