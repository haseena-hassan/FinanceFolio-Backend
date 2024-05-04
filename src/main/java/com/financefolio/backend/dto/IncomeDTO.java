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
}
