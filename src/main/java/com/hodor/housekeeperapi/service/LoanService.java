package com.hodor.housekeeperapi.service;

import com.hodor.housekeeperapi.dto.create.LoanCreateDto;
import com.hodor.housekeeperapi.dto.read.LoanReadDto;
import com.hodor.housekeeperapi.dto.update.LoanUpdateDto;
import com.hodor.housekeeperapi.exception.LoanNotFoundException;
import com.hodor.housekeeperapi.exception.MemberNotFoundException;

import java.util.List;

public interface LoanService {

    LoanReadDto create(LoanCreateDto loanCreateDto) throws MemberNotFoundException;

    LoanReadDto readById(Integer id) throws LoanNotFoundException;

    List<LoanReadDto> readAll();

    LoanReadDto update(LoanUpdateDto loanUpdateDto) throws LoanNotFoundException, MemberNotFoundException;

    Boolean deleteById(Integer id) throws LoanNotFoundException;
}
