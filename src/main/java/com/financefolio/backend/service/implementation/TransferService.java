package com.financefolio.backend.service.implementation;

import com.financefolio.backend.dto.TransferDTO;
import com.financefolio.backend.exception.NotFoundException;
import com.financefolio.backend.model.Transfer;
import com.financefolio.backend.repository.TransferRepository;
import com.financefolio.backend.service.TransferServiceInterface;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import static com.financefolio.backend.Utils.getUserEmail;

@Service
@AllArgsConstructor
@Slf4j(topic = "TRANSFER_SERVICE")
public class TransferService implements TransferServiceInterface {

    private final TransferRepository transferRepository;

    @Override
    public ArrayList<TransferDTO> getAllTransfers() {
        ArrayList<TransferDTO> accountTransfers = new ArrayList<>();
        transferRepository.findByUserEmail(getUserEmail()).forEach(transfer -> accountTransfers.add(new TransferDTO(transfer)));
        log.info("Account Transfers fetched successfully");
        return accountTransfers;
    }

    @Override
    public TransferDTO getTransfer(Long transferId) {
        Transfer accountTransfer = transferRepository.findById(transferId).orElse(null);
        if (accountTransfer == null) {
            throw new NotFoundException("Account Transfer not found with Id: " + transferId);
        }
        log.info("Account Transfer fetched successfully");
        return new TransferDTO(accountTransfer);
    }

    @Override
    public void addTransfer(TransferDTO transferDTO) {
        Transfer transfer = new Transfer(transferDTO);
        transfer.setUserEmail(getUserEmail());
        transferRepository.save(transfer);
        log.info("Account Transfer added successfully");
    }

    @Override
    public void updateTransfer(Long transferId, TransferDTO transferDTO) {
        Transfer transfer = transferRepository.findById(transferId).orElse(null);
        if (transfer == null) {
            throw new NotFoundException("Account Transfer not found with Id: " + transferId);
        }
        transfer.setTransferId(transferDTO.getTransferId());
        transfer.setTransferAmount(transferDTO.getTransferAmount());
        transfer.setSourceAccount(transferDTO.getSourceAccount());
        transfer.setTargetAccount(transferDTO.getTargetAccount());
        transfer.setDate(transferDTO.getDate());
        transfer.setDescription(transferDTO.getDescription());
        transferRepository.save(transfer);
        log.info("Account Transfer updated successfully");
    }

    @Override
    public void deleteTransfer(Long transferId) {
        transferRepository.deleteById(transferId);
        log.info(String.format("Account Transfer %s deleted successfully", transferId));
    }
}
