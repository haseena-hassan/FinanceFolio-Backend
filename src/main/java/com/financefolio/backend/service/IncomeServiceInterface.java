package com.financefolio.backend.service;

import com.financefolio.backend.dto.IncomeDTO;

import java.util.ArrayList;

public interface IncomeServiceInterface {

    ArrayList<IncomeDTO> getAllIncomes();

    IncomeDTO getIncome(Long incomeId);

    void addIncome(IncomeDTO incomeDTO);

    void updateIncome(Long incomeId, IncomeDTO incomeDTO);

    void deleteIncome(Long incomeId);
}
