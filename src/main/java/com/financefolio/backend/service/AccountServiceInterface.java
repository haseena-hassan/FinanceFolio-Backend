package com.financefolio.backend.service;

import com.financefolio.backend.dto.AccountDTO;

import java.util.ArrayList;

public interface AccountServiceInterface {

    ArrayList<AccountDTO> getAllAccounts();

    AccountDTO getAccount(String accountNumber);

    void addAccount(AccountDTO accountDTO);

    void updateAccount(AccountDTO accountDTO);

    void deleteAccount(String accountNumber);
}
