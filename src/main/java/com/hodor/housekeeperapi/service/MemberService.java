package com.hodor.housekeeperapi.service;

import com.hodor.housekeeperapi.dto.create.MemberCreateDto;
import com.hodor.housekeeperapi.dto.read.MemberReadDto;
import com.hodor.housekeeperapi.entity.Member;
import com.hodor.housekeeperapi.exception.HouseholdNotFindException;
import com.hodor.housekeeperapi.exception.MemberNotFindException;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    MemberReadDto create(MemberCreateDto createDto) throws HouseholdNotFindException;

    MemberReadDto readById(Integer id) throws MemberNotFindException;

    List<MemberReadDto> readAll();
}
