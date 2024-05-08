package com.financefolio.backend.service.implementation;

import com.financefolio.backend.dto.AccountDTO;
import com.financefolio.backend.exception.NotFoundException;
import com.financefolio.backend.model.Account;
import com.financefolio.backend.repository.AccountRepository;
import com.financefolio.backend.service.AccountServiceInterface;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import static com.financefolio.backend.Utils.getUserEmail;


@Service
@AllArgsConstructor
@Slf4j(topic = "ACCOUNT_SERVICE")
public class AccountService implements AccountServiceInterface {

    private final AccountRepository accountRepository;


    @Override
    public ArrayList<AccountDTO> getAllAccounts() {
        ArrayList<AccountDTO> accounts = new ArrayList<>();
        accountRepository.findByUserEmail(getUserEmail())
                         .forEach(account ->
                                 accounts.add(new AccountDTO(account)
                         ));
        if(accounts.isEmpty()){
            throw new NotFoundException("No Accounts found for the user");
        }
        log.info("Accounts fetched successfully");
        return accounts;
    }


    @Override
    public AccountDTO getAccount(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if(account == null){
            throw new NotFoundException(String.format("Account %s does not exist", accountNumber));
        }
        log.info(String.format("Account %s fetched successfully", accountNumber));
        return new AccountDTO(account);
    }



    @Override
    public void addAccount(AccountDTO accountDTO) {
        String accountNumber = accountDTO.getAccountNumber();
        if(accountRepository.findByAccountNumber(accountNumber) != null){
            throw new NotFoundException(String.format("Account %s already exist for the user", accountNumber));
        }
        Account account = new Account(accountDTO);
        account.setUserEmail(getUserEmail());
        accountRepository.save(account);
        log.info(String.format("Account %s added successfully", accountNumber));
    }


    @Override
    public void updateAccount(AccountDTO accountDTO) {
        String accountNumber = accountDTO.getAccountNumber();
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if(account == null){
            throw new NotFoundException(String.format("Account %s does not exist", accountNumber));
        }
        account.setAccountNumber(accountDTO.getAccountNumber());
        account.setBankName(accountDTO.getBankName());
        account.setAccountType(accountDTO.getAccountType());
        account.setBalance(accountDTO.getBalance());
        accountRepository.save(account);
        log.info(String.format("Account %s is updated successfully", accountNumber));
    }


    @Override
    public void deleteAccount(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if(account == null){
            throw new NotFoundException(String.format("Account %s does not exist", accountNumber));
        }
        accountRepository.delete(account);
        log.info(String.format("Account %s deleted successfully", accountNumber));
    }
}
