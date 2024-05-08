package com.financefolio.backend.dto;

import com.financefolio.backend.model.Category;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    @NotBlank
    private Long categoryId;

    @NotBlank
    private String categoryName;

    @NotBlank
    private String categoryType;

    public CategoryDTO(Category category) {
        categoryId = category.getCategoryId();
        categoryName = category.getCategoryName();
        categoryType = category.getCategoryType();
    }
}
