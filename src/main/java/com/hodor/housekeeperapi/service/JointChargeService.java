package com.hodor.housekeeperapi.service;

import com.hodor.housekeeperapi.dto.create.JointChargeCreateDto;
import com.hodor.housekeeperapi.dto.read.JointChargeReadDto;
import com.hodor.housekeeperapi.dto.update.JointChargeUpdateDto;
import com.hodor.housekeeperapi.exception.HouseholdNotFoundException;
import com.hodor.housekeeperapi.exception.JointLoanNotFoundException;

import java.util.List;

public interface JointChargeService {
    JointChargeReadDto create(JointChargeCreateDto jointChargeCreateDto) throws HouseholdNotFoundException;

    JointChargeReadDto readById(Integer id) throws JointLoanNotFoundException;

    List<JointChargeReadDto> readAll();

    JointChargeReadDto update(JointChargeUpdateDto jointChargeUpdateDto) throws JointLoanNotFoundException, HouseholdNotFoundException;

    Boolean deleteById(Integer id) throws JointLoanNotFoundException;
}
