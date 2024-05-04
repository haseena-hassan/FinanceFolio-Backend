package com.financefolio.backend.dto;

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
public class ExpenseDTO {
    @NotBlank
    private Long expenseId;

    @NotBlank
    private String accountNumber;

    @NotBlank
    private double expenseAmount;

    @NotBlank
    private Date date;

    private String description;

    private String categoryName;
}
