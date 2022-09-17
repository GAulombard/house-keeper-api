package com.hodor.housekeeperapi.controller;

import com.hodor.housekeeperapi.dto.create.HouseholdCreateDto;
import com.hodor.housekeeperapi.dto.read.HouseholdReadDto;
import com.hodor.housekeeperapi.entity.Household;
import com.hodor.housekeeperapi.exception.HouseholdNotFindException;
import com.hodor.housekeeperapi.service.HouseholdService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/household")
@AllArgsConstructor
public class HouseholdController {

    private HouseholdService householdService;

    @PostMapping("/1.0/create")
    public ResponseEntity<HouseholdReadDto> create(@RequestBody HouseholdCreateDto createDto) {
        return new ResponseEntity<>(householdService.create(createDto), HttpStatus.CREATED);
    }

    @GetMapping("/1.0/read/{id}")
    public ResponseEntity<HouseholdReadDto> readById(@PathVariable("id") Integer id) throws HouseholdNotFindException {
        return new ResponseEntity<>(householdService.readById(id), HttpStatus.OK);
    }

    @GetMapping("/1.0/read-all")
    public ResponseEntity<List<HouseholdReadDto>> readAll() {
        return new ResponseEntity<>(householdService.readAll(), HttpStatus.OK);
    }
}
