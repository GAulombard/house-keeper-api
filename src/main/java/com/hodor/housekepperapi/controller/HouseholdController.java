package com.hodor.housekepperapi.controller;

import com.hodor.housekepperapi.entity.Household;
import com.hodor.housekepperapi.service.HouseholdService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/household")
@AllArgsConstructor
public class HouseholdController {

    private HouseholdService householdService;

    @PostMapping("/1.0/create")
    public ResponseEntity<Household> create(@RequestBody Household household) {
        return new ResponseEntity<>(householdService.create(household), HttpStatus.CREATED);
    }
}
