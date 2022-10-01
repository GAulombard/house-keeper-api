package com.hodor.housekeeperapi.dto.builder;

import com.hodor.housekeeperapi.dto.create.JointChargeCreateDto;
import com.hodor.housekeeperapi.dto.read.JointChargeReadDto;
import com.hodor.housekeeperapi.dto.read.JointLoanReadDto;
import com.hodor.housekeeperapi.dto.update.JointChargeUpdateDto;
import com.hodor.housekeeperapi.entity.Household;
import com.hodor.housekeeperapi.entity.JointCharge;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class JointChargeBuilder {

    public JointCharge jointChargeCreateDtoToJointCharge(JointChargeCreateDto createDto, Household household) {
        JointCharge jointCharge = new JointCharge();
        jointCharge.setHousehold(household);
        jointCharge.setLabel(createDto.getLabel());
        jointCharge.setValue(createDto.getValue());
        jointCharge.setRecurrenceType(createDto.getRecurrenceType());
        jointCharge.setReference(createDto.getReference());
        jointCharge.setChargeType(createDto.getChargeType());
        return jointCharge;
    }

    public JointChargeReadDto jointChargeToJointChargeReadDto(JointCharge jointCharge) {

        JointChargeReadDto readDto = new JointChargeReadDto();
        readDto.setId(jointCharge.getId());
        readDto.setChargeType(jointCharge.getChargeType());
        readDto.setHouseholdId(jointCharge.getHousehold().getId());
        readDto.setReference(jointCharge.getReference());
        readDto.setLabel(jointCharge.getLabel());
        readDto.setValue(jointCharge.getValue());
        readDto.setRecurrenceType(jointCharge.getRecurrenceType());
        return readDto;
    }

    public List<JointChargeReadDto> jointChargeToJointChargeReadDto(List<JointCharge> jointCharges) {
        List<JointChargeReadDto> readDtos = new ArrayList<>();
        jointCharges.iterator().forEachRemaining(jointCharge ->
                readDtos.add(jointChargeToJointChargeReadDto(jointCharge)));
        return readDtos;
    }

    public JointCharge jointChargeUpdateDtoToJointCharge(JointChargeUpdateDto jointChargeUpdateDto, Household household) {
        JointCharge joinCharge = new JointCharge();
        joinCharge.setId(jointChargeUpdateDto.getId());
        joinCharge.setChargeType(jointChargeUpdateDto.getChargeType());
        joinCharge.setHousehold(household);
        joinCharge.setReference(jointChargeUpdateDto.getReference());
        joinCharge.setLabel(jointChargeUpdateDto.getLabel());
        joinCharge.setValue(jointChargeUpdateDto.getValue());
        joinCharge.setRecurrenceType(jointChargeUpdateDto.getRecurrenceType());
        return joinCharge;
    }
}
