package com.hodor.housekeeperapi.dto.builder;

import com.hodor.housekeeperapi.dto.create.ChargeCreateDto;
import com.hodor.housekeeperapi.dto.read.ChargeReadDto;
import com.hodor.housekeeperapi.dto.update.ChargeUpdateDto;
import com.hodor.housekeeperapi.entity.Member;
import com.hodor.housekeeperapi.entity.Charge;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ChargeBuilder {

    public Charge chargeCreateDtoToCharge(ChargeCreateDto createDto, Member member) {
        Charge Charge = new Charge();
        Charge.setMember(member);
        Charge.setLabel(createDto.getLabel());
        Charge.setValue(createDto.getValue());
        Charge.setRecurrenceType(createDto.getRecurrenceType());
        Charge.setReference(createDto.getReference());
        Charge.setChargeType(createDto.getChargeType());
        return Charge;
    }

    public ChargeReadDto chargeToChargeReadDto(Charge charge) {

        ChargeReadDto readDto = new ChargeReadDto();
        readDto.setId(charge.getId());
        readDto.setChargeType(charge.getChargeType());
        readDto.setMemberId(charge.getMember().getId());
        readDto.setReference(charge.getReference());
        readDto.setLabel(charge.getLabel());
        readDto.setValue(charge.getValue());
        readDto.setRecurrenceType(charge.getRecurrenceType());
        return readDto;
    }

    public List<ChargeReadDto> chargeToChargeReadDto(List<Charge> charges) {
        List<ChargeReadDto> readDtos = new ArrayList<>();
        charges.iterator().forEachRemaining(charge ->
                readDtos.add(chargeToChargeReadDto(charge)));
        return readDtos;
    }

    public Charge chargeUpdateDtoToCharge(ChargeUpdateDto chargeUpdateDto, Member member) {
        Charge joinCharge = new Charge();
        joinCharge.setId(chargeUpdateDto.getId());
        joinCharge.setChargeType(chargeUpdateDto.getChargeType());
        joinCharge.setMember(member);
        joinCharge.setReference(chargeUpdateDto.getReference());
        joinCharge.setLabel(chargeUpdateDto.getLabel());
        joinCharge.setValue(chargeUpdateDto.getValue());
        joinCharge.setRecurrenceType(chargeUpdateDto.getRecurrenceType());
        return joinCharge;
    }
}
