package com.financefolio.backend.model;

import com.financefolio.backend.dto.IncomeDTO;
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
@Table(name = "income")
public class Income {
    @Id
    @GeneratedValue
    @Column(nullable = false, unique = true)
    private Long incomeId;

    @Column(nullable = false)
    private String accountNumber;

    @Column(nullable = false)
    private double incomeAmount;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private String userEmail;

    @Column
    private String description;

    @Column
    private String categoryName;

    public Income(IncomeDTO incomeDTO){
        accountNumber = incomeDTO.getAccountNumber();
        incomeAmount = incomeDTO.getIncomeAmount();
        date = incomeDTO.getDate();
        description = incomeDTO.getDescription();
        categoryName = incomeDTO.getCategoryName();
    }
}
