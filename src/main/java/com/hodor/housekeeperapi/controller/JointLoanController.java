package com.hodor.housekeeperapi.controller;

import com.hodor.housekeeperapi.dto.create.JointLoanCreateDto;
import com.hodor.housekeeperapi.dto.read.JointLoanReadDto;
import com.hodor.housekeeperapi.dto.update.JointLoanUpdateDto;
import com.hodor.housekeeperapi.exception.HouseholdNotFoundException;
import com.hodor.housekeeperapi.exception.JointLoanNotFoundException;
import com.hodor.housekeeperapi.service.JointLoanService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/joint-loan")
@AllArgsConstructor
public class JointLoanController {

    private JointLoanService jointLoanService;

    @PostMapping("/1.0/create")
    public ResponseEntity<JointLoanReadDto> create(@RequestBody JointLoanCreateDto jointLoanCreateDto) throws HouseholdNotFoundException {
        return new ResponseEntity<>(jointLoanService.create(jointLoanCreateDto), HttpStatus.CREATED);
    }

    @GetMapping("/1.0/read/{id}")
    public ResponseEntity<JointLoanReadDto> readById(@PathVariable("id") Integer id) throws JointLoanNotFoundException {
        return new ResponseEntity<>(jointLoanService.readById(id),HttpStatus.OK);
    }

    @GetMapping("/1.0/read-all")
    public ResponseEntity<List<JointLoanReadDto>> readAll() {
        return new ResponseEntity<>(jointLoanService.readAll(),HttpStatus.OK);
    }

    @PutMapping("/1.0/update")
    public ResponseEntity<JointLoanReadDto> update(@RequestBody JointLoanUpdateDto jointLoanUpdateDto) throws HouseholdNotFoundException, JointLoanNotFoundException {
        return new ResponseEntity<>(jointLoanService.update(jointLoanUpdateDto),HttpStatus.OK);
    }

    @DeleteMapping("/1.0/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Integer id) throws JointLoanNotFoundException {
        return new ResponseEntity<>(jointLoanService.deleteById(id), HttpStatus.OK);
    }

}
