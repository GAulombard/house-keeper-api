package com.hodor.housekeeperapi.service.impl;

import com.hodor.housekeeperapi.dto.builder.ChargeBuilder;
import com.hodor.housekeeperapi.dto.create.ChargeCreateDto;
import com.hodor.housekeeperapi.dto.create.ChargeCreateDto;
import com.hodor.housekeeperapi.dto.read.ChargeReadDto;
import com.hodor.housekeeperapi.dto.read.ChargeReadDto;
import com.hodor.housekeeperapi.dto.update.ChargeUpdateDto;
import com.hodor.housekeeperapi.dto.update.ChargeUpdateDto;
import com.hodor.housekeeperapi.entity.Member;
import com.hodor.housekeeperapi.entity.Charge;
import com.hodor.housekeeperapi.exception.ChargeNotFoundException;
import com.hodor.housekeeperapi.exception.MemberNotFoundException;
import com.hodor.housekeeperapi.exception.JointLoanNotFoundException;
import com.hodor.housekeeperapi.repository.ChargeRepository;
import com.hodor.housekeeperapi.repository.MemberRepository;
import com.hodor.housekeeperapi.service.ChargeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ChargeServiceImpl implements ChargeService {

    private ChargeRepository chargeRepository;
    private MemberRepository memberRepository;
    private ChargeBuilder chargeBuilder;
    private static final String MEMBER_NOT_FOUND = "Member not found.";
    private static final String CHARGE_NOT_FOUND = "Charge not found.";

    @Override
    public ChargeReadDto create(ChargeCreateDto chargeCreateDto) throws MemberNotFoundException {
        Member member = memberRepository.findById(chargeCreateDto.getMemberId())
                .orElseThrow(() -> new MemberNotFoundException(MEMBER_NOT_FOUND));
        Charge charge = chargeRepository.save(chargeBuilder.chargeCreateDtoToCharge(chargeCreateDto,member));
        return chargeBuilder.chargeToChargeReadDto(charge);
    }

    @Override
    public ChargeReadDto readById(Integer id) throws ChargeNotFoundException {
        Charge charge = chargeRepository.findById(id)
                .orElseThrow(() -> new ChargeNotFoundException(CHARGE_NOT_FOUND));
        return chargeBuilder.chargeToChargeReadDto(charge);
    }

    @Override
    public List<ChargeReadDto> readAll() {
        List<Charge> charges = chargeRepository.findAll();
        return chargeBuilder.chargeToChargeReadDto(charges);
    }

    @Override
    public ChargeReadDto update(ChargeUpdateDto chargeUpdateDto) throws ChargeNotFoundException, MemberNotFoundException {
        if(!chargeRepository.existsById(chargeUpdateDto.getId())) throw new ChargeNotFoundException(CHARGE_NOT_FOUND);
        Member member = memberRepository.findById(chargeUpdateDto.getMemberId())
                .orElseThrow(() -> new MemberNotFoundException(MEMBER_NOT_FOUND));
        Charge charge = chargeRepository.save(chargeBuilder.chargeUpdateDtoToCharge(chargeUpdateDto,member));
        return chargeBuilder.chargeToChargeReadDto(charge);
    }

    @Override
    public Boolean deleteById(Integer id) throws ChargeNotFoundException {
        if(!chargeRepository.existsById(id)) throw new ChargeNotFoundException(CHARGE_NOT_FOUND);
        chargeRepository.deleteById(id);
        return true;
    }
}
