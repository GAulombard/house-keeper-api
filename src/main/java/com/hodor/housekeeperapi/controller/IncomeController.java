package com.hodor.housekeeperapi.controller;

import com.hodor.housekeeperapi.dto.builder.IncomeBuilder;
import com.hodor.housekeeperapi.dto.create.IncomeCreateDto;
import com.hodor.housekeeperapi.dto.read.IncomeReadDto;
import com.hodor.housekeeperapi.service.IncomeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/income")
@AllArgsConstructor
@Slf4j
public class IncomeController {

    private IncomeService incomeService;

    @PostMapping("/1.0/create")
    public ResponseEntity<IncomeReadDto> create(@RequestBody IncomeCreateDto createDto) {
        return new ResponseEntity<>(incomeService.create(createDto), HttpStatus.CREATED);
    }

}
