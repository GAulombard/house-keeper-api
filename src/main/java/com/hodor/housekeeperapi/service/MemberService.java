package com.hodor.housekeeperapi.service;

import com.hodor.housekeeperapi.dto.create.MemberCreateDto;
import com.hodor.housekeeperapi.dto.read.MemberReadDto;
import com.hodor.housekeeperapi.dto.update.MemberUpdateDto;
import com.hodor.housekeeperapi.exception.HouseholdNotFoundException;
import com.hodor.housekeeperapi.exception.MemberNotFoundException;

import java.util.List;

public interface MemberService {
    MemberReadDto create(MemberCreateDto createDto) throws HouseholdNotFoundException;

    MemberReadDto readById(Integer id) throws MemberNotFoundException;

    List<MemberReadDto> readAll();

    MemberReadDto update(MemberUpdateDto updateDto) throws MemberNotFoundException, HouseholdNotFoundException;

    Boolean deleteById(Integer id) throws MemberNotFoundException;
}
