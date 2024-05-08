package com.financefolio.backend.service.implementation;

import com.financefolio.backend.dto.IncomeDTO;
import com.financefolio.backend.exception.NotFoundException;
import com.financefolio.backend.model.Income;
import com.financefolio.backend.repository.IncomeRepository;
import com.financefolio.backend.service.IncomeServiceInterface;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.financefolio.backend.Utils.getUserEmail;

@Service
@AllArgsConstructor
@Slf4j(topic = "INCOME_SERVICE")
public class IncomeService implements IncomeServiceInterface {

    private final IncomeRepository incomeRepository;

    @Override
    public ArrayList<IncomeDTO> getAllIncomes() {
        ArrayList<IncomeDTO> incomes = new ArrayList<>();
        incomeRepository.findByUserEmail(getUserEmail()).forEach(income -> incomes.add(new IncomeDTO(income)));
        log.info("Incomes fetched successfully");
        return incomes;
    }

    @Override
    public IncomeDTO getIncome(Long incomeId) {
        Income income = incomeRepository.findById(incomeId).orElse(null);
        if (income == null) {
            throw new NotFoundException("Income not found with Id: " + incomeId);
        }
        log.info("Income fetched successfully");
        return new IncomeDTO(income);
    }

    @Override
    public void addIncome(IncomeDTO incomeDTO) {
        Income income = new Income(incomeDTO);
        income.setUserEmail(getUserEmail());
        incomeRepository.save(income);
        log.info("Income added successfully");
    }

    @Override
    public void updateIncome(Long incomeId, IncomeDTO incomeDTO) {
        Income income = incomeRepository.findById(incomeId).orElse(null);
        if (income == null) {
            throw new NotFoundException("Income not found with Id: " + incomeId);
        }
        income.setIncomeAmount(incomeDTO.getIncomeAmount());
        income.setAccountNumber(incomeDTO.getAccountNumber());
        income.setCategoryName(incomeDTO.getCategoryName());
        income.setDate(incomeDTO.getDate());
        income.setDescription(incomeDTO.getDescription());
        incomeRepository.save(income);
        log.info("Income updated successfully");
    }

    @Override
    public void deleteIncome(Long incomeId) {
        incomeRepository.deleteById(incomeId);
        log.info(String.format("Income %s deleted successfully", incomeId));
    }
}
