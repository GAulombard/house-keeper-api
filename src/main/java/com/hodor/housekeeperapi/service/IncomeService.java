package com.hodor.housekeeperapi.service;

import com.hodor.housekeeperapi.dto.create.IncomeCreateDto;
import com.hodor.housekeeperapi.dto.read.IncomeReadDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface IncomeService {

    IncomeReadDto create(IncomeCreateDto createDto);
}
