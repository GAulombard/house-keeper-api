package com.hodor.housekeeperapi.dto.builder;

import com.hodor.housekeeperapi.dto.create.MemberCreateDto;
import com.hodor.housekeeperapi.dto.read.MemberCompactReadDto;
import com.hodor.housekeeperapi.dto.read.MemberReadDto;
import com.hodor.housekeeperapi.entity.Household;
import com.hodor.housekeeperapi.entity.Member;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberBuilder {

    public Member memberCreateDtoToMember(MemberCreateDto createDto, Household household) {
        Member member = new Member();
        member.setHousehold(household);
        member.setFirstName(createDto.getFirstName());
        member.setLastName(createDto.getLastName());
        member.setMail(createDto.getMail());
        return member;
    }

    public MemberReadDto memberToMemberReadDto(Member member) {
        MemberReadDto readDto = new MemberReadDto();
        readDto.setId(member.getId());
        readDto.setHousehold(member.getHousehold().getName());
        readDto.setFirstName(member.getFirstName());
        readDto.setLastName(member.getLastName());
        readDto.setMail(member.getMail());
        return readDto;
    }

    public List<MemberReadDto> memberToMemberReadDto(List<Member> members) {
        List<MemberReadDto> readDtos = new ArrayList<>();
        members.iterator().forEachRemaining(member -> {
            readDtos.add(memberToMemberReadDto(member));
        });
        return readDtos;
    }

    public MemberCompactReadDto memberToMemberCompactReadDto(Member member) {
        MemberCompactReadDto compactReadDto = new MemberCompactReadDto();
        compactReadDto.setId(member.getId());
        compactReadDto.setFirstName(member.getFirstName());
        compactReadDto.setLastName(member.getLastName());
        compactReadDto.setMail(member.getMail());
        return compactReadDto;
    }

    public List<MemberCompactReadDto> memberToMemberCompactReadDto(List<Member> members) {
        List<MemberCompactReadDto> readDtos = new ArrayList<>();
        members.iterator().forEachRemaining(member -> {
            readDtos.add(memberToMemberCompactReadDto(member));
        });
        return readDtos;
    }

}
