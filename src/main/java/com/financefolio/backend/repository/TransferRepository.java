package com.financefolio.backend.repository;

import com.financefolio.backend.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {
    ArrayList<Transfer> findByUserEmail(String email);
}
