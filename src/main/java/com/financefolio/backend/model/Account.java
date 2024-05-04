package com.financefolio.backend.model;

import com.financefolio.backend.dto.AccountDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="account")
public class Account {
    @Id
    @Column(nullable = false, unique = true)
    private String accountNumber;

    @Column(nullable = false)
    private String bankName;

    @Column(nullable = false)
    private String accountType;

    @Column(nullable = false)
    private double balance;

    @Column(nullable = false)
    private String userEmail;

    public Account(AccountDTO accountDTO){
        accountNumber = accountDTO.getAccountNumber();
        bankName = accountDTO.getBankName();
        accountType = accountDTO.getAccountType();
        balance = accountDTO.getBalance();
    }
}
