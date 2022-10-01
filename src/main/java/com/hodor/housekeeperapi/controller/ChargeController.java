package com.hodor.housekeeperapi.controller;

import com.hodor.housekeeperapi.dto.create.ChargeCreateDto;
import com.hodor.housekeeperapi.dto.read.ChargeReadDto;
import com.hodor.housekeeperapi.dto.update.ChargeUpdateDto;
import com.hodor.housekeeperapi.exception.HouseholdNotFoundException;
import com.hodor.housekeeperapi.exception.ChargeNotFoundException;
import com.hodor.housekeeperapi.exception.JointLoanNotFoundException;
import com.hodor.housekeeperapi.exception.MemberNotFoundException;
import com.hodor.housekeeperapi.service.ChargeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/charge")
@AllArgsConstructor
public class ChargeController {

    private ChargeService chargeService;

    @PostMapping("/1.0/create")
    public ResponseEntity<ChargeReadDto> create(@RequestBody ChargeCreateDto chargeCreateDto) throws MemberNotFoundException {
        return new ResponseEntity<>(chargeService.create(chargeCreateDto), HttpStatus.CREATED);
    }

    @GetMapping("/1.0/read/{id}")
    public ResponseEntity<ChargeReadDto> readById(@PathVariable("id") Integer id) throws ChargeNotFoundException {
        return new ResponseEntity<>(chargeService.readById(id),HttpStatus.OK);
    }

    @GetMapping("/1.0/read-all")
    public ResponseEntity<List<ChargeReadDto>> readAll() {
        return new ResponseEntity<>(chargeService.readAll(),HttpStatus.OK);
    }

    @PutMapping("/1.0/update")
    public ResponseEntity<ChargeReadDto> update(@RequestBody ChargeUpdateDto chargeUpdateDto) throws ChargeNotFoundException, MemberNotFoundException {
        return new ResponseEntity<>(chargeService.update(chargeUpdateDto),HttpStatus.OK);
    }

    @DeleteMapping("/1.0/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Integer id) throws ChargeNotFoundException {
        return new ResponseEntity<>(chargeService.deleteById(id), HttpStatus.OK);
    }
}
