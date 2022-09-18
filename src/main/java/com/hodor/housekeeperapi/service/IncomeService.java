package com.hodor.housekeeperapi.service;

import com.hodor.housekeeperapi.dto.create.IncomeCreateDto;
import com.hodor.housekeeperapi.dto.read.IncomeReadDto;
import com.hodor.housekeeperapi.dto.update.IncomeUpdateDro;
import com.hodor.housekeeperapi.exception.IncomeNotFoundException;
import com.hodor.housekeeperapi.exception.MemberNotFoundException;

import java.util.List;

public interface IncomeService {

    IncomeReadDto create(IncomeCreateDto createDto) throws MemberNotFoundException;

    IncomeReadDto readById(Integer id) throws IncomeNotFoundException;

    List<IncomeReadDto> readAll();

    IncomeReadDto update(IncomeUpdateDro updateDto) throws IncomeNotFoundException, MemberNotFoundException;

    Boolean deleteById(Integer id) throws IncomeNotFoundException;
}
