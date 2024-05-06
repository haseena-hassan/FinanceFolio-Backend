package com.financefolio.backend.service;

import com.financefolio.backend.dto.TransferDTO;

import java.util.ArrayList;

public interface TransferServiceInterface {

    ArrayList<TransferDTO> getAllTransfers();

    TransferDTO getTransfer(Long transferId);

    void addTransfer(TransferDTO transferDTO);

    void updateTransfer(Long transferId, TransferDTO transferDTO);

    void deleteTransfer(Long transferId);
}
