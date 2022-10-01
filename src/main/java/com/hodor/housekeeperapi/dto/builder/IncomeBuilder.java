package com.hodor.housekeeperapi.dto.builder;

import com.hodor.housekeeperapi.dto.create.IncomeCreateDto;
import com.hodor.housekeeperapi.dto.read.IncomeReadDto;
import com.hodor.housekeeperapi.dto.read.MemberCompactReadDto;
import com.hodor.housekeeperapi.dto.update.IncomeUpdateDro;
import com.hodor.housekeeperapi.entity.Income;
import com.hodor.housekeeperapi.entity.Member;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IncomeBuilder {
    public Income incomeCreateDtoToIncome(IncomeCreateDto createDto, Member member) {
        Income income = new Income();
        income.setLabel(createDto.getLabel());
        income.setIncomeType(createDto.getIncomeType());
        income.setMember(member);
        income.setReference(createDto.getReference());
        income.setValue(createDto.getValue());
        income.setRecurrenceType(createDto.getRecurrenceType());
        return  income;
    }

    public IncomeReadDto incomeToIncomeReadDto(Income income, MemberCompactReadDto member) {
        IncomeReadDto readDto = new IncomeReadDto();
        readDto.setId(income.getId());
        readDto.setLabel(income.getLabel());
        readDto.setIncomeType(income.getIncomeType().getLabel());
        readDto.setReference(income.getReference());
        readDto.setValue(income.getValue());
        readDto.setMember(member);
        readDto.setRecurrenceType(income.getRecurrenceType().getLabel());
        return readDto;
    }

    public Income incomeUpdateDtoToIncome(IncomeUpdateDro updateDto, Member member) {
        Income income = new Income();
        income.setId(updateDto.getId());
        income.setRecurrenceType(updateDto.getRecurrenceType());
        income.setIncomeType(updateDto.getIncomeType());
        income.setMember(member);
        income.setLabel(updateDto.getLabel());
        income.setValue(updateDto.getValue());
        income.setReference(updateDto.getReference());
        return income;
    }
}