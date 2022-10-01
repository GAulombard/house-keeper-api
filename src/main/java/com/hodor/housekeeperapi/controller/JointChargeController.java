package com.hodor.housekeeperapi.controller;

import com.hodor.housekeeperapi.dto.create.JointChargeCreateDto;
import com.hodor.housekeeperapi.dto.read.JointChargeReadDto;
import com.hodor.housekeeperapi.dto.update.JointChargeUpdateDto;
import com.hodor.housekeeperapi.exception.HouseholdNotFoundException;
import com.hodor.housekeeperapi.exception.JointChargeNotFoundException;
import com.hodor.housekeeperapi.exception.JointLoanNotFoundException;
import com.hodor.housekeeperapi.service.JointChargeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/joint-charge")
@AllArgsConstructor
public class JointChargeController {

    private JointChargeService jointChargeService;

    @PostMapping("/1.0/create")
    public ResponseEntity<JointChargeReadDto> create(@RequestBody JointChargeCreateDto jointChargeCreateDto) throws HouseholdNotFoundException {
        return new ResponseEntity<>(jointChargeService.create(jointChargeCreateDto), HttpStatus.CREATED);
    }

    @GetMapping("/1.0/read/{id}")
    public ResponseEntity<JointChargeReadDto> readById(@PathVariable("id") Integer id) throws JointChargeNotFoundException, JointLoanNotFoundException {
        return new ResponseEntity<>(jointChargeService.readById(id),HttpStatus.OK);
    }

    @GetMapping("/1.0/read-all")
    public ResponseEntity<List<JointChargeReadDto>> readAll() {
        return new ResponseEntity<>(jointChargeService.readAll(),HttpStatus.OK);
    }

    @PutMapping("/1.0/update")
    public ResponseEntity<JointChargeReadDto> update(@RequestBody JointChargeUpdateDto jointChargeUpdateDto) throws HouseholdNotFoundException, JointChargeNotFoundException, JointLoanNotFoundException {
        return new ResponseEntity<>(jointChargeService.update(jointChargeUpdateDto),HttpStatus.OK);
    }

    @DeleteMapping("/1.0/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Integer id) throws JointChargeNotFoundException, JointLoanNotFoundException {
        return new ResponseEntity<>(jointChargeService.deleteById(id), HttpStatus.OK);
    }
}
