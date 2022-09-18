package com.hodor.housekeeperapi.service;

import com.hodor.housekeeperapi.dto.create.JointLoanCreateDto;
import com.hodor.housekeeperapi.dto.read.JointLoanReadDto;
import com.hodor.housekeeperapi.dto.update.JointLoanUpdateDto;
import com.hodor.housekeeperapi.exception.HouseholdNotFoundException;
import com.hodor.housekeeperapi.exception.JointLoanNotFoundException;

import java.util.List;

public interface JointLoanService {
    JointLoanReadDto create(JointLoanCreateDto jointLoanCreateDto) throws HouseholdNotFoundException;

    JointLoanReadDto readById(Integer id) throws JointLoanNotFoundException;

    List<JointLoanReadDto> readAll();

    JointLoanReadDto update(JointLoanUpdateDto jointLoanUpdateDto) throws JointLoanNotFoundException, HouseholdNotFoundException;

    Boolean deleteById(Integer id) throws JointLoanNotFoundException;
}
