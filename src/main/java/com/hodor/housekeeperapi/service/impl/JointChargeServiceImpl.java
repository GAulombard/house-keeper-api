package com.hodor.housekeeperapi.service.impl;

import com.hodor.housekeeperapi.dto.builder.JointChargeBuilder;
import com.hodor.housekeeperapi.dto.create.JointChargeCreateDto;
import com.hodor.housekeeperapi.dto.read.JointChargeReadDto;
import com.hodor.housekeeperapi.dto.update.JointChargeUpdateDto;
import com.hodor.housekeeperapi.entity.Household;
import com.hodor.housekeeperapi.entity.JointCharge;
import com.hodor.housekeeperapi.entity.JointLoan;
import com.hodor.housekeeperapi.exception.HouseholdNotFoundException;
import com.hodor.housekeeperapi.exception.JointLoanNotFoundException;
import com.hodor.housekeeperapi.repository.HouseholdRepository;
import com.hodor.housekeeperapi.repository.JointChargeRepository;
import com.hodor.housekeeperapi.service.JointChargeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JointChargeServiceImpl implements JointChargeService {

    private JointChargeRepository jointChargeRepository;
    private JointChargeBuilder jointChargeBuilder;
    private HouseholdRepository householdRepository;

    private static final String HOUSEHOLD_NOT_FOUND = "Household not found.";
    private static final String JOINT_CHARGE_NOT_FOUND = "Joint charge not found.";

    @Override
    public JointChargeReadDto create(JointChargeCreateDto jointChargeCreateDto) throws HouseholdNotFoundException {
        Household household = householdRepository.findById(jointChargeCreateDto.getHouseholdId())
                .orElseThrow(() -> new HouseholdNotFoundException(HOUSEHOLD_NOT_FOUND));
        JointCharge jointCharge = jointChargeRepository.save(jointChargeBuilder.jointChargeCreateDtoToJointCharge(jointChargeCreateDto,household));
        return jointChargeBuilder.jointChargeToJointChargeReadDto(jointCharge);
    }

    @Override
    public JointChargeReadDto readById(Integer id) throws JointLoanNotFoundException {
        JointCharge jointCharge = jointChargeRepository.findById(id)
                .orElseThrow(() -> new JointLoanNotFoundException(JOINT_CHARGE_NOT_FOUND));
        return jointChargeBuilder.jointChargeToJointChargeReadDto(jointCharge);
    }

    @Override
    public List<JointChargeReadDto> readAll() {
        List<JointCharge> jointCharges = jointChargeRepository.findAll();
        return jointChargeBuilder.jointChargeToJointChargeReadDto(jointCharges);
    }

    @Override
    public JointChargeReadDto update(JointChargeUpdateDto jointChargeUpdateDto) throws JointLoanNotFoundException, HouseholdNotFoundException {
        if(!jointChargeRepository.existsById(jointChargeUpdateDto.getId())) throw new JointLoanNotFoundException(JOINT_CHARGE_NOT_FOUND);
        Household household = householdRepository.findById(jointChargeUpdateDto.getHouseholdId())
                .orElseThrow(() -> new HouseholdNotFoundException(HOUSEHOLD_NOT_FOUND));
        JointCharge jointCharge = jointChargeRepository.save(jointChargeBuilder.jointChargeUpdateDtoToJointCharge(jointChargeUpdateDto,household));
        return jointChargeBuilder.jointChargeToJointChargeReadDto(jointCharge);
    }

    @Override
    public Boolean deleteById(Integer id) throws JointLoanNotFoundException {
        if(!jointChargeRepository.existsById(id)) throw new JointLoanNotFoundException(JOINT_CHARGE_NOT_FOUND);
        jointChargeRepository.deleteById(id);
        return true;
    }
}
