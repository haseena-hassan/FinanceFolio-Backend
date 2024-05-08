package com.financefolio.backend.service.implementation;

import com.financefolio.backend.dto.ExpenseDTO;
import com.financefolio.backend.exception.NotFoundException;
import com.financefolio.backend.model.Expense;
import com.financefolio.backend.repository.ExpenseRepository;
import com.financefolio.backend.service.ExpenseServiceInterface;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import static com.financefolio.backend.Utils.getUserEmail;

@Service
@AllArgsConstructor
@Slf4j(topic = "EXPENSE_SERVICE")
public class ExpenseService implements ExpenseServiceInterface {

    private final ExpenseRepository expenseRepository;

    @Override
    public ArrayList<ExpenseDTO> getAllExpenses() {
        ArrayList<ExpenseDTO> expenses = new ArrayList<>();
        expenseRepository.findByUserEmail(getUserEmail()).forEach(expense -> expenses.add(new ExpenseDTO(expense)));
        log.info("Expenses fetched successfully");
        return expenses;
    }

    @Override
    public ExpenseDTO getExpense(Long expenseId) {
        Expense expense = expenseRepository.findById(expenseId).orElse(null);
        if (expense == null) {
            throw new NotFoundException("Expense not found with Id: " + expenseId);
        }
        log.info("Expense fetched successfully");
        return new ExpenseDTO(expense);
    }

    @Override
    public void addExpense(ExpenseDTO expenseDTO) {
        Expense expense = new Expense(expenseDTO);
        expense.setUserEmail(getUserEmail());
        expenseRepository.save(expense);
        log.info("Expense added successfully");
    }

    @Override
    public void updateExpense(Long expenseId, ExpenseDTO expenseDTO) {
        Expense expense = expenseRepository.findById(expenseId).orElse(null);
        if (expense == null) {
            throw new NotFoundException("Expense not found with Id: " + expenseId);
        }
        expense.setExpenseAmount(expenseDTO.getExpenseAmount());
        expense.setAccountNumber(expenseDTO.getAccountNumber());
        expense.setCategoryName(expenseDTO.getCategoryName());
        expense.setDate(expenseDTO.getDate());
        expense.setDescription(expenseDTO.getDescription());
        expenseRepository.save(expense);
        log.info("Expense updated successfully");
    }

    @Override
    public void deleteExpense(Long expenseId) {
        expenseRepository.deleteById(expenseId);
        log.info(String.format("Expense %s deleted successfully", expenseId));
    }
}
