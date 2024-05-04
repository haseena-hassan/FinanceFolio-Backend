package com.financefolio.backend.model;

import com.financefolio.backend.dto.ExpenseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "expense")
public class Expense {
    @Id
    @GeneratedValue
    @Column(nullable = false, unique = true)
    private String expenseId;

    @Column(nullable = false)
    private String accountNumber;

    @Column(nullable = false)
    private double expenseAmount;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private String userEmail;

    @Column
    private String description;

    @Column
    private String categoryName;

    public Expense(ExpenseDTO expenseDTO){
        accountNumber = expenseDTO.getAccountNumber();
        expenseAmount = expenseDTO.getExpenseAmount();
        date = expenseDTO.getDate();
        description = expenseDTO.getDescription();
        categoryName = expenseDTO.getCategoryName();
    }
}
