package com.hodor.housekeeperapi.controller;

import com.hodor.housekeeperapi.dto.create.LoanCreateDto;
import com.hodor.housekeeperapi.dto.read.LoanReadDto;
import com.hodor.housekeeperapi.dto.update.LoanUpdateDto;
import com.hodor.housekeeperapi.exception.LoanNotFoundException;
import com.hodor.housekeeperapi.exception.MemberNotFoundException;
import com.hodor.housekeeperapi.service.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan")
@AllArgsConstructor
public class LoanController {

    private LoanService loanService;

    @PostMapping("/1.0/create")
    public ResponseEntity<LoanReadDto> create(@RequestBody LoanCreateDto loanCreateDto) throws MemberNotFoundException {
        return new ResponseEntity<>(loanService.create(loanCreateDto), HttpStatus.CREATED);
    }

    @GetMapping("/1.0/read/{id}")
    public ResponseEntity<LoanReadDto> readById(@PathVariable("id") Integer id) throws LoanNotFoundException {
        return new ResponseEntity<>(loanService.readById(id),HttpStatus.OK);
    }

    @GetMapping("/1.0/read-all")
    public ResponseEntity<List<LoanReadDto>> readAll() {
        return new ResponseEntity<>(loanService.readAll(),HttpStatus.OK);
    }

    @PutMapping("/1.0/update")
    public ResponseEntity<LoanReadDto> update(@RequestBody LoanUpdateDto loanUpdateDto) throws MemberNotFoundException, LoanNotFoundException {
        return new ResponseEntity<>(loanService.update(loanUpdateDto),HttpStatus.OK);
    }

    @DeleteMapping("/1.0/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Integer id) throws LoanNotFoundException {
        return new ResponseEntity<>(loanService.deleteById(id), HttpStatus.OK);
    }
}
