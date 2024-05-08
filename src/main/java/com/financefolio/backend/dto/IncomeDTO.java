package com.financefolio.backend.dto;

import com.financefolio.backend.model.Income;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IncomeDTO {
    @NotBlank
    private Long incomeId;

    @NotBlank
    private String accountNumber;

    @NotBlank
    private double incomeAmount;

    @NotBlank
    private Date date;

    private String description;

    private String categoryName;

    public IncomeDTO(Income income) {
        incomeId = income.getIncomeId();
        accountNumber = income.getAccountNumber();
        incomeAmount = income.getIncomeAmount();
        date = income.getDate();
        description = income.getDescription();
        categoryName = income.getCategoryName();
    }
}
