package com.hodor.housekeeperapi.service;

import com.hodor.housekeeperapi.dto.create.HouseholdCreateDto;
import com.hodor.housekeeperapi.dto.read.HouseholdReadDto;
import com.hodor.housekeeperapi.entity.Household;
import com.hodor.housekeeperapi.exception.HouseholdNotFindException;

import java.util.List;
import java.util.Optional;

public interface HouseholdService {
    HouseholdReadDto create(HouseholdCreateDto createDto);

    HouseholdReadDto readById(Integer id) throws HouseholdNotFindException;

    List<HouseholdReadDto> readAll();
}
