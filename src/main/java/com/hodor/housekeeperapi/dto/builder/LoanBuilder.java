package com.hodor.housekeeperapi.dto.builder;

import com.hodor.housekeeperapi.dto.create.LoanCreateDto;
import com.hodor.housekeeperapi.dto.read.LoanReadDto;
import com.hodor.housekeeperapi.dto.update.LoanUpdateDto;
import com.hodor.housekeeperapi.entity.Member;
import com.hodor.housekeeperapi.entity.Loan;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class LoanBuilder {

    public Loan loanCreateDtoToLoan(LoanCreateDto loanCreateDto, Member member) {
        Loan loan = new Loan();
        loan.setLabel(loanCreateDto.getLabel());
        loan.setOriginalDate(loanCreateDto.getOriginalDate());
        loan.setLoanType(loanCreateDto.getLoanType());
        loan.setMember(member);
        loan.setFinalDate(loanCreateDto.getFinalDate());
        loan.setRecurrenceType(loanCreateDto.getRecurrenceType());
        loan.setReference(loanCreateDto.getReference());
        loan.setValue(loanCreateDto.getValue());
        return loan;
    }

    public LoanReadDto loanToLoanReadDto(Loan loan) {
        LoanReadDto readDto = new LoanReadDto();
        readDto.setFinalDate(loan.getFinalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        readDto.setOriginalDate(loan.getOriginalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        readDto.setReference(loan.getReference());
        readDto.setLoanType(loan.getLoanType().getLabel());
        readDto.setLabel(loan.getLabel());
        readDto.setValue(loan.getValue());
        readDto.setRecurrenceType(loan.getRecurrenceType().getLabel());
        readDto.setMemberId(loan.getMember().getId());
        readDto.setId(loan.getId());
        return readDto;
    }

    public List<LoanReadDto> loanToLoanReadDto(List<Loan> loans) {
        List<LoanReadDto> readDtos = new ArrayList<>();
        loans.iterator().forEachRemaining(loan ->
                readDtos.add(loanToLoanReadDto(loan)));
        return readDtos;
    }

    public Loan loanUpdateDtoToLoan(LoanUpdateDto loanUpdateDto, Member member) {
        Loan loan = new Loan();
        loan.setId(loanUpdateDto.getId());
        loan.setLabel(loanUpdateDto.getLabel());
        loan.setOriginalDate(loanUpdateDto.getOriginalDate());
        loan.setLoanType(loanUpdateDto.getLoanType());
        loan.setMember(member);
        loan.setFinalDate(loanUpdateDto.getFinalDate());
        loan.setRecurrenceType(loanUpdateDto.getRecurrenceType());
        loan.setReference(loanUpdateDto.getReference());
        loan.setValue(loanUpdateDto.getValue());
        return loan;
    }

}
