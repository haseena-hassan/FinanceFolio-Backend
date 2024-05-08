package com.financefolio.backend.dto;

import com.financefolio.backend.model.Account;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
    @NotBlank
    private String accountNumber;

    @NotBlank
    private String bankName;

    @NotBlank
    private String accountType;

    @NotBlank
    private double balance;

    public AccountDTO(Account account) {
        accountNumber = account.getAccountNumber();
        bankName = account.getBankName();
        accountType = account.getAccountType();
        balance = account.getBalance();
    }
}
