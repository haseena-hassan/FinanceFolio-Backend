package com.financefolio.backend.model;

import com.financefolio.backend.dto.CategoryDTO;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue
    @Column(nullable = false, unique = true)
    private Long categoryId;

    @Column(nullable = false)
    private String categoryName;

    @Column(nullable = false)
    private String categoryType;

    @Column(nullable = false)
    private String userEmail;

    public Category(CategoryDTO categoryDTO){
        categoryName = categoryDTO.getCategoryName();
        categoryType = categoryDTO.getCategoryType();
    }
}
