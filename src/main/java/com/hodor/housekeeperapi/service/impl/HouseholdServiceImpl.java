package com.hodor.housekeeperapi.service.impl;

import com.hodor.housekeeperapi.dto.builder.HouseholdBuilder;
import com.hodor.housekeeperapi.dto.builder.MemberBuilder;
import com.hodor.housekeeperapi.dto.create.HouseholdCreateDto;
import com.hodor.housekeeperapi.dto.read.HouseholdReadDto;
import com.hodor.housekeeperapi.dto.read.MemberCompactReadDto;
import com.hodor.housekeeperapi.entity.Household;
import com.hodor.housekeeperapi.exception.HouseholdNotFindException;
import com.hodor.housekeeperapi.repository.HouseholdRepository;
import com.hodor.housekeeperapi.service.HouseholdService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class HouseholdServiceImpl implements HouseholdService {

    private HouseholdRepository householdRepository;
    private HouseholdBuilder householdBuilder;
    private MemberBuilder memberBuilder;
    @Override
    public HouseholdReadDto create(HouseholdCreateDto createDto) {
        Household household = householdRepository.save(householdBuilder.householdCreateDtoToHousehold(createDto));
        return householdBuilder.householdToHouseholdReadDto(household,null);
    }

    @Override
    public HouseholdReadDto readById(Integer id) throws HouseholdNotFindException {
        Household household = householdRepository.findById(id)
                .orElseThrow(() -> new HouseholdNotFindException("household not find"));

        List<MemberCompactReadDto> compactReadDtos = memberBuilder.memberToMemberCompactReadDto(household.getMembers());

        return householdBuilder.householdToHouseholdReadDto(household,compactReadDtos);
    }

    @Override
    public List<HouseholdReadDto> readAll() {
        List<Household> households = householdRepository.findAll();
        List<HouseholdReadDto> readDtos = new ArrayList<>();

        households.iterator().forEachRemaining(household -> {
            List<MemberCompactReadDto> compactReadDtos = memberBuilder.memberToMemberCompactReadDto(household.getMembers());
            readDtos.add(householdBuilder.householdToHouseholdReadDto(household,compactReadDtos));
        });

        return readDtos;
    }
}