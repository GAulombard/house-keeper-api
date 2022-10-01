package com.hodor.housekeeperapi.service;

import com.hodor.housekeeperapi.dto.create.ChargeCreateDto;
import com.hodor.housekeeperapi.dto.read.ChargeReadDto;
import com.hodor.housekeeperapi.dto.update.ChargeUpdateDto;
import com.hodor.housekeeperapi.exception.ChargeNotFoundException;
import com.hodor.housekeeperapi.exception.JointLoanNotFoundException;
import com.hodor.housekeeperapi.exception.MemberNotFoundException;

import java.util.List;

public interface ChargeService {

    ChargeReadDto create(ChargeCreateDto chargeCreateDto) throws MemberNotFoundException;

    ChargeReadDto readById(Integer id) throws ChargeNotFoundException;

    List<ChargeReadDto> readAll();

    ChargeReadDto update(ChargeUpdateDto chargeUpdateDto) throws ChargeNotFoundException, MemberNotFoundException;

    Boolean deleteById(Integer id) throws ChargeNotFoundException;
}
