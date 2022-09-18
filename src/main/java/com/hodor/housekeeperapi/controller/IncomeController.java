package com.hodor.housekeeperapi.controller;

import com.hodor.housekeeperapi.dto.create.IncomeCreateDto;
import com.hodor.housekeeperapi.dto.read.IncomeReadDto;
import com.hodor.housekeeperapi.exception.IncomeNotFoundException;
import com.hodor.housekeeperapi.exception.MemberNotFoundException;
import com.hodor.housekeeperapi.service.IncomeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/income")
@AllArgsConstructor
@Slf4j
public class IncomeController {

    private IncomeService incomeService;

    @PostMapping("/1.0/create")
    public ResponseEntity<IncomeReadDto> create(@RequestBody IncomeCreateDto createDto) throws MemberNotFoundException {
        return new ResponseEntity<>(incomeService.create(createDto), HttpStatus.CREATED);
    }

    @GetMapping("/1.0/read/{id}")
    public ResponseEntity<IncomeReadDto> readById(@PathVariable("id") Integer id) throws IncomeNotFoundException {
        return new ResponseEntity<>(incomeService.readById(id), HttpStatus.OK);
    }

    @GetMapping("/1.0/read-all")
    public ResponseEntity<List<IncomeReadDto>> readAll() {
        return new ResponseEntity<>(incomeService.readAll(),HttpStatus.OK);
    }

}
