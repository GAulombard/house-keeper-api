package com.hodor.housekeeperapi.service.impl;

import com.hodor.housekeeperapi.dto.builder.MemberBuilder;
import com.hodor.housekeeperapi.dto.create.MemberCreateDto;
import com.hodor.housekeeperapi.dto.read.MemberReadDto;
import com.hodor.housekeeperapi.entity.Household;
import com.hodor.housekeeperapi.entity.Member;
import com.hodor.housekeeperapi.exception.HouseholdNotFoundException;
import com.hodor.housekeeperapi.exception.MemberNotFoundException;
import com.hodor.housekeeperapi.repository.HouseholdRepository;
import com.hodor.housekeeperapi.repository.MemberRepository;
import com.hodor.housekeeperapi.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;
    private HouseholdRepository householdRepository;
    private MemberBuilder memberBuilder;

    @Override
    public MemberReadDto create(MemberCreateDto createDto) throws HouseholdNotFoundException {

        Household household = householdRepository.findById(createDto.getHousehold())
                .orElseThrow(() -> new HouseholdNotFoundException("household not found"));

        Member member = memberRepository.save(memberBuilder.memberCreateDtoToMember(createDto,household));

        return memberBuilder.memberToMemberReadDto(member);
    }

    @Override
    public MemberReadDto readById(Integer id) throws MemberNotFoundException {

        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException("member not found"));

        return memberBuilder.memberToMemberReadDto(member);
    }

    @Override
    public List<MemberReadDto> readAll() {
        List<Member> members = memberRepository.findAll();
        return memberBuilder.memberToMemberReadDto(members);
    }
}
