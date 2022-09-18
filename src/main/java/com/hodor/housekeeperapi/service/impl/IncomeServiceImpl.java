package com.hodor.housekeeperapi.service.impl;

import com.hodor.housekeeperapi.dto.builder.IncomeBuilder;
import com.hodor.housekeeperapi.dto.builder.MemberBuilder;
import com.hodor.housekeeperapi.dto.create.IncomeCreateDto;
import com.hodor.housekeeperapi.dto.read.IncomeReadDto;
import com.hodor.housekeeperapi.dto.update.IncomeUpdateDro;
import com.hodor.housekeeperapi.entity.Income;
import com.hodor.housekeeperapi.entity.Member;
import com.hodor.housekeeperapi.exception.IncomeNotFoundException;
import com.hodor.housekeeperapi.exception.MemberNotFoundException;
import com.hodor.housekeeperapi.repository.IncomeRepository;
import com.hodor.housekeeperapi.repository.MemberRepository;
import com.hodor.housekeeperapi.service.IncomeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class IncomeServiceImpl implements IncomeService {

    private IncomeRepository incomeRepository;
    private MemberRepository memberRepository;
    private IncomeBuilder incomeBuilder;
    private MemberBuilder memberBuilder;

    private static final String INCOME_NOT_FOUND = "Income not found.";
    private static final String MEMBER_NOT_FOUND = "Member not found.";

    @Override
    public IncomeReadDto create(IncomeCreateDto createDto) throws MemberNotFoundException {

        Member member = memberRepository.findById(createDto.getMemberId())
                .orElseThrow(() -> new MemberNotFoundException(MEMBER_NOT_FOUND));
        Income income = incomeRepository.save(incomeBuilder.incomeCreateDtoToIncome(createDto,member));

        return incomeBuilder.incomeToIncomeReadDto(income,memberBuilder.memberToMemberCompactReadDto(member));
    }

    @Override
    public IncomeReadDto readById(Integer id) throws IncomeNotFoundException {
        Income income = incomeRepository.findById(id)
                .orElseThrow(() -> new IncomeNotFoundException(INCOME_NOT_FOUND));

        return incomeBuilder.incomeToIncomeReadDto(income,memberBuilder.memberToMemberCompactReadDto(income.getMember()));
    }

    @Override
    public List<IncomeReadDto> readAll() {
        List<Income> incomes = incomeRepository.findAll();
        List<IncomeReadDto> readDtos = new ArrayList<>();

        incomes.iterator().forEachRemaining(income -> readDtos.add(incomeBuilder.incomeToIncomeReadDto(income,
                memberBuilder.memberToMemberCompactReadDto(income.getMember()))));

        return readDtos;
    }

    @Override
    public IncomeReadDto update(IncomeUpdateDro updateDto) throws IncomeNotFoundException, MemberNotFoundException {
        if(!incomeRepository.existsById(updateDto.getId())) throw new IncomeNotFoundException(INCOME_NOT_FOUND);
        Member member = memberRepository.findById(updateDto.getMemberId())
                .orElseThrow(() -> new MemberNotFoundException(MEMBER_NOT_FOUND));
        Income income = incomeRepository.save(incomeBuilder.incomeUpdateDtoToIncome(updateDto,member));
        return incomeBuilder.incomeToIncomeReadDto(income,memberBuilder.memberToMemberCompactReadDto(income.getMember()));
    }

    @Override
    public Boolean deleteById(Integer id) throws IncomeNotFoundException {
        if(!incomeRepository.existsById(id)) throw new IncomeNotFoundException(INCOME_NOT_FOUND);
        incomeRepository.deleteById(id);
        return true;
    }
}
