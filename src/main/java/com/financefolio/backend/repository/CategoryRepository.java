package com.financefolio.backend.repository;

import com.financefolio.backend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    ArrayList<Category> findByUserEmail(String email);
}
