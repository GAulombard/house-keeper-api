package com.hodor.housekeeperapi.service;

import com.hodor.housekeeperapi.dto.create.HouseholdCreateDto;
import com.hodor.housekeeperapi.dto.read.HouseholdReadDto;
import com.hodor.housekeeperapi.exception.HouseholdNotFoundException;

import java.util.List;

public interface HouseholdService {
    HouseholdReadDto create(HouseholdCreateDto createDto);

    HouseholdReadDto readById(Integer id) throws HouseholdNotFoundException;

    List<HouseholdReadDto> readAll();
}
