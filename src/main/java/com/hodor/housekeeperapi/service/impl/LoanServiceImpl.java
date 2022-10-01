package com.hodor.housekeeperapi.service.impl;

import com.hodor.housekeeperapi.dto.builder.LoanBuilder;
import com.hodor.housekeeperapi.dto.create.LoanCreateDto;
import com.hodor.housekeeperapi.dto.read.LoanReadDto;
import com.hodor.housekeeperapi.dto.update.LoanUpdateDto;
import com.hodor.housekeeperapi.entity.Member;
import com.hodor.housekeeperapi.entity.Loan;
import com.hodor.housekeeperapi.exception.MemberNotFoundException;
import com.hodor.housekeeperapi.exception.LoanNotFoundException;
import com.hodor.housekeeperapi.repository.MemberRepository;
import com.hodor.housekeeperapi.repository.LoanRepository;
import com.hodor.housekeeperapi.service.LoanService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class LoanServiceImpl implements LoanService {

    private LoanRepository loanRepository;
    private MemberRepository memberRepository;
    private LoanBuilder loanBuilder;
    private static final String MEMBER_NOT_FOUND = "Member not found.";
    private static final String JOINT_LOAN_NOT_FOUND = "Joint loan not found.";

    @Override
    public LoanReadDto create(LoanCreateDto loanCreateDto) throws MemberNotFoundException {
        Member member = memberRepository.findById(loanCreateDto.getMemberId())
                .orElseThrow(() -> new MemberNotFoundException(MEMBER_NOT_FOUND));
        Loan loan = loanRepository.save(loanBuilder.loanCreateDtoToLoan(loanCreateDto,member));
        return loanBuilder.loanToLoanReadDto(loan);
    }

    @Override
    public LoanReadDto readById(Integer id) throws LoanNotFoundException {
        Loan loan = loanRepository.findById(id)
                .orElseThrow(() -> new LoanNotFoundException(JOINT_LOAN_NOT_FOUND));
        return loanBuilder.loanToLoanReadDto(loan);
    }

    @Override
    public List<LoanReadDto> readAll() {
        List<Loan> loans = loanRepository.findAll();
        return loanBuilder.loanToLoanReadDto(loans);
    }

    @Override
    public LoanReadDto update(LoanUpdateDto loanUpdateDto) throws LoanNotFoundException, MemberNotFoundException {
        if(!loanRepository.existsById(loanUpdateDto.getId())) throw new LoanNotFoundException(JOINT_LOAN_NOT_FOUND);
        Member member = memberRepository.findById(loanUpdateDto.getMemberId())
                .orElseThrow(() -> new MemberNotFoundException(MEMBER_NOT_FOUND));
        Loan loan = loanRepository.save(loanBuilder.loanUpdateDtoToLoan(loanUpdateDto,member));
        return loanBuilder.loanToLoanReadDto(loan);
    }

    @Override
    public Boolean deleteById(Integer id) throws LoanNotFoundException {
        if(!loanRepository.existsById(id)) throw new LoanNotFoundException(JOINT_LOAN_NOT_FOUND);
        loanRepository.deleteById(id);
        return true;
    }

}
