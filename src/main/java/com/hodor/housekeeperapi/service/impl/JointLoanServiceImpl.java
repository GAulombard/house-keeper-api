package com.hodor.housekeeperapi.service.impl;

import com.hodor.housekeeperapi.dto.builder.JointLoanBuilder;
import com.hodor.housekeeperapi.dto.create.JointLoanCreateDto;
import com.hodor.housekeeperapi.dto.read.JointLoanReadDto;
import com.hodor.housekeeperapi.dto.update.JointLoanUpdateDto;
import com.hodor.housekeeperapi.entity.Household;
import com.hodor.housekeeperapi.entity.JointLoan;
import com.hodor.housekeeperapi.exception.HouseholdNotFoundException;
import com.hodor.housekeeperapi.exception.JointLoanNotFoundException;
import com.hodor.housekeeperapi.repository.HouseholdRepository;
import com.hodor.housekeeperapi.repository.JointLoanRepository;
import com.hodor.housekeeperapi.service.JointLoanService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class JointLoanServiceImpl implements JointLoanService {

    private JointLoanRepository jointLoanRepository;
    private HouseholdRepository householdRepository;
    private JointLoanBuilder jointLoanBuilder;
    private static final String HOUSEHOLD_NOT_FOUND = "Household not found.";
    private static final String JOINT_LOAN_NOT_FOUND = "Joint loan not found.";

    @Override
    public JointLoanReadDto create(JointLoanCreateDto jointLoanCreateDto) throws HouseholdNotFoundException {
        Household household = householdRepository.findById(jointLoanCreateDto.getHouseholdId())
                .orElseThrow(() -> new HouseholdNotFoundException(HOUSEHOLD_NOT_FOUND));
        JointLoan jointLoan = jointLoanRepository.save(jointLoanBuilder.jointLoanCreateDtoToJointLoan(jointLoanCreateDto,household));
        return jointLoanBuilder.jointLoanToJointLoanReadDto(jointLoan);
    }

    @Override
    public JointLoanReadDto readById(Integer id) throws JointLoanNotFoundException {
        JointLoan jointLoan = jointLoanRepository.findById(id)
                .orElseThrow(() -> new JointLoanNotFoundException(JOINT_LOAN_NOT_FOUND));
        return jointLoanBuilder.jointLoanToJointLoanReadDto(jointLoan);
    }

    @Override
    public List<JointLoanReadDto> readAll() {
        List<JointLoan> jointLoans = jointLoanRepository.findAll();
        return jointLoanBuilder.jointLoanToJointLoanReadDto(jointLoans);
    }

    @Override
    public JointLoanReadDto update(JointLoanUpdateDto jointLoanUpdateDto) throws JointLoanNotFoundException, HouseholdNotFoundException {
        if(!jointLoanRepository.existsById(jointLoanUpdateDto.getId())) throw new JointLoanNotFoundException(JOINT_LOAN_NOT_FOUND);
        Household household = householdRepository.findById(jointLoanUpdateDto.getHouseholdId())
                .orElseThrow(() -> new HouseholdNotFoundException(HOUSEHOLD_NOT_FOUND));
        JointLoan jointLoan = jointLoanRepository.save(jointLoanBuilder.jointLoanUpdateDtoToJointLoan(jointLoanUpdateDto,household));
        return jointLoanBuilder.jointLoanToJointLoanReadDto(jointLoan);
    }

    @Override
    public Boolean deleteById(Integer id) throws JointLoanNotFoundException {
        if(!jointLoanRepository.existsById(id)) throw new JointLoanNotFoundException(JOINT_LOAN_NOT_FOUND);
        jointLoanRepository.deleteById(id);
        return true;
    }
}
