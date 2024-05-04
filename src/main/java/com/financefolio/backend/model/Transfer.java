package com.financefolio.backend.model;

import com.financefolio.backend.dto.TransferDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transfer")
public class Transfer {
    @Id
    @GeneratedValue
    @Column(nullable = false, unique = true)
    private String transferId;

    @Column(nullable = false)
    private String sourceAccount;

    @Column(nullable = false)
    private String targetAccount;

    @Column(nullable = false)
    private double transferAmount;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private String userEmail;

    @Column
    private String description;

    public Transfer(TransferDTO transferDTO){
        sourceAccount = transferDTO.getSourceAccount();
        targetAccount = transferDTO.getTargetAccount();
        transferAmount = transferDTO.getTransferAmount();
        date = transferDTO.getDate();
        description = transferDTO.getDescription();
    }
}
