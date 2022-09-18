package com.hodor.housekeeperapi.service;

import com.hodor.housekeeperapi.dto.create.JointChargeCreateDto;
import com.hodor.housekeeperapi.dto.read.JointChargeReadDto;
import com.hodor.housekeeperapi.dto.update.JointChargeUpdateDto;

import java.util.List;

public interface JointChargeService {
    JointChargeReadDto create(JointChargeCreateDto jointChargeCreateDto);

    JointChargeReadDto readById(Integer id);

    List<JointChargeReadDto> readAll();

    JointChargeReadDto update(JointChargeUpdateDto jointChargeUpdateDto);

    Boolean deleteById(Integer id);
}
