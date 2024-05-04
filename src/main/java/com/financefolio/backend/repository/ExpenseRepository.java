package com.financefolio.backend.repository;

import com.financefolio.backend.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    ArrayList<Expense> findByUserEmail(String email);
}
