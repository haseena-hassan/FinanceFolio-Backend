package com.financefolio.backend.repository;

import com.financefolio.backend.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByAccountNumber(String accountNumber);
    ArrayList<Account> findByUserEmail(String email);
}
