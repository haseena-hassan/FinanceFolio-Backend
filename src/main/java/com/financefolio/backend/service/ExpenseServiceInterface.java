package com.financefolio.backend.service;

import com.financefolio.backend.dto.ExpenseDTO;

import java.util.ArrayList;

public interface ExpenseServiceInterface {

    ArrayList<ExpenseDTO> getAllExpenses();

    ExpenseDTO getExpense(Long expenseId);

    void addExpense(ExpenseDTO expenseDTO);

    void updateExpense(Long expenseId, ExpenseDTO expenseDTO);

    void deleteExpense(Long expenseId);
}
