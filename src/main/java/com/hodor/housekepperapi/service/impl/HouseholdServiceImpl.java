package com.hodor.housekepperapi.service.impl;

import com.hodor.housekepperapi.entity.Household;
import com.hodor.housekepperapi.repository.HouseholdRepository;
import com.hodor.housekepperapi.service.HouseholdService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class HouseholdServiceImpl implements HouseholdService {

    private HouseholdRepository householdRepository;
    @Override
    public Household create(Household household) {
        return householdRepository.save(household);
    }
}
