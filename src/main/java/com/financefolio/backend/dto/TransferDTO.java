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
public class TransferDTO {
    @NotBlank
    private Long transferId;

    @NotBlank
    private String sourceAccount;

    @NotBlank
    private String targetAccount;

    @NotBlank
    private double transferAmount;

    @NotBlank
    private Date date;

    private String description;
}
