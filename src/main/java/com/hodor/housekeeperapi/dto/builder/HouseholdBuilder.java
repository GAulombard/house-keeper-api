package com.hodor.housekeeperapi.dto.builder;

import com.hodor.housekeeperapi.dto.create.HouseholdCreateDto;
import com.hodor.housekeeperapi.dto.read.HouseholdReadDto;
import com.hodor.housekeeperapi.dto.read.MemberCompactReadDto;
import com.hodor.housekeeperapi.dto.update.HouseholdUpdateDto;
import com.hodor.housekeeperapi.entity.Household;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseholdBuilder {

    public Household householdCreateDtoToHousehold(HouseholdCreateDto createDto) {
        Household household = new Household();
        household.setName(createDto.getName());
        return household;
    }

    public HouseholdReadDto householdToHouseholdReadDto(Household household, List<MemberCompactReadDto> members) {
        HouseholdReadDto readDto = new HouseholdReadDto();
        readDto.setId(household.getId());
        readDto.setName(household.getName());
        readDto.setMembers(members);
        readDto.setCharges(household.getCharges());
        readDto.setLoans(household.getLoans());
        return readDto;
    }

    public Household householdUpdateDtoToHousehold(HouseholdUpdateDto updateDto) {
        Household household = new Household();
        household.setId(updateDto.getId());
        household.setName(updateDto.getName());
        return household;
    }
}
