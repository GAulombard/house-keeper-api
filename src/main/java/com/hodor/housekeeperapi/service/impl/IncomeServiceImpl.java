package com.hodor.housekeeperapi.service.impl;

import com.hodor.housekeeperapi.dto.builder.IncomeBuilder;
import com.hodor.housekeeperapi.dto.create.IncomeCreateDto;
import com.hodor.housekeeperapi.dto.read.IncomeReadDto;
import com.hodor.housekeeperapi.entity.Income;
import com.hodor.housekeeperapi.repository.IncomeRepository;
import com.hodor.housekeeperapi.service.IncomeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class IncomeServiceImpl implements IncomeService {

    private IncomeRepository incomeRepository;
    private IncomeBuilder incomeBuilder;

    @Override
    public IncomeReadDto create(IncomeCreateDto createDto) {
        Income income = incomeRepository.save(incomeBuilder.incomeCreateDtoToIncome(createDto));
        return incomeBuilder.incomeToIncomeReadDto(income);
    }
}
