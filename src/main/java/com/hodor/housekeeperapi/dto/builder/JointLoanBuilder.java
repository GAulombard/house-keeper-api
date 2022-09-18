package com.hodor.housekeeperapi.dto.builder;

import com.hodor.housekeeperapi.dto.create.JointLoanCreateDto;
import com.hodor.housekeeperapi.dto.read.JointLoanReadDto;
import com.hodor.housekeeperapi.dto.update.JointLoanUpdateDto;
import com.hodor.housekeeperapi.entity.Household;
import com.hodor.housekeeperapi.entity.JointLoan;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class JointLoanBuilder {
    public JointLoan jointLoanCreateDtoToJointLoan(JointLoanCreateDto jointLoanCreateDto, Household household) {
        JointLoan jointLoan = new JointLoan();
        jointLoan.setLabel(jointLoanCreateDto.getLabel());
        jointLoan.setOriginalDate(jointLoanCreateDto.getOriginalDate());
        jointLoan.setLoanType(jointLoanCreateDto.getLoanType());
        jointLoan.setHousehold(household);
        jointLoan.setFinalDate(jointLoanCreateDto.getFinalDate());
        jointLoan.setRecurrenceType(jointLoanCreateDto.getRecurrenceType());
        jointLoan.setReference(jointLoanCreateDto.getReference());
        jointLoan.setValue(jointLoanCreateDto.getValue());
        return jointLoan;
    }

    public JointLoanReadDto jointLoanToJointLoanReadDto(JointLoan jointLoan) {
        JointLoanReadDto readDto = new JointLoanReadDto();
        readDto.setFinalDate(jointLoan.getFinalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        readDto.setOriginalDate(jointLoan.getOriginalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        readDto.setReference(jointLoan.getReference());
        readDto.setLoanType(jointLoan.getLoanType().getLabel());
        readDto.setLabel(jointLoan.getLabel());
        readDto.setValue(jointLoan.getValue());
        readDto.setRecurrenceType(jointLoan.getRecurrenceType().getLabel());
        readDto.setHouseholdId(jointLoan.getHousehold().getId());
        readDto.setId(jointLoan.getId());
        return readDto;
    }

    public List<JointLoanReadDto> jointLoanToJointLoanReadDto(List<JointLoan> jointLoans) {
        List<JointLoanReadDto> readDtos = new ArrayList<>();
        jointLoans.iterator().forEachRemaining(jointLoan ->
                readDtos.add(jointLoanToJointLoanReadDto(jointLoan)));
        return readDtos;
    }

    public JointLoan jointLoanUpdateDtoToJointLoan(JointLoanUpdateDto jointLoanUpdateDto, Household household) {
        JointLoan jointLoan = new JointLoan();
        jointLoan.setId(jointLoanUpdateDto.getId());
        jointLoan.setLabel(jointLoanUpdateDto.getLabel());
        jointLoan.setOriginalDate(jointLoanUpdateDto.getOriginalDate());
        jointLoan.setLoanType(jointLoanUpdateDto.getLoanType());
        jointLoan.setHousehold(household);
        jointLoan.setFinalDate(jointLoanUpdateDto.getFinalDate());
        jointLoan.setRecurrenceType(jointLoanUpdateDto.getRecurrenceType());
        jointLoan.setReference(jointLoanUpdateDto.getReference());
        jointLoan.setValue(jointLoanUpdateDto.getValue());
        return jointLoan;
    }
}
