package com.hodor.housekeeperapi.controller;

import com.hodor.housekeeperapi.dto.create.MemberCreateDto;
import com.hodor.housekeeperapi.dto.read.MemberReadDto;
import com.hodor.housekeeperapi.dto.update.MemberUpdateDto;
import com.hodor.housekeeperapi.exception.HouseholdNotFoundException;
import com.hodor.housekeeperapi.exception.MemberNotFoundException;
import com.hodor.housekeeperapi.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
@AllArgsConstructor
public class MemberController {

    private MemberService memberService;

    @PostMapping("/1.0/create")
    public ResponseEntity<MemberReadDto> create(@RequestBody MemberCreateDto createDto) throws HouseholdNotFoundException {
        return new ResponseEntity<>(memberService.create(createDto), HttpStatus.CREATED);
    }

    @GetMapping("/1.0/read/{id}")
    public ResponseEntity<MemberReadDto> readById(@PathVariable("id") Integer id) throws MemberNotFoundException {
        return new ResponseEntity<>(memberService.readById(id), HttpStatus.OK);
    }

    @GetMapping("/1.0/read-all")
    public ResponseEntity<List<MemberReadDto>> readAll() {
        return new ResponseEntity<>(memberService.readAll(), HttpStatus.OK);
    }

    @PutMapping("/1.0/update")
    public ResponseEntity<MemberReadDto> update(@RequestBody MemberUpdateDto updateDto) throws HouseholdNotFoundException, MemberNotFoundException {
        return new ResponseEntity<>(memberService.update(updateDto),HttpStatus.OK);
    }

    @DeleteMapping("/1.0/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Integer id) throws MemberNotFoundException {
        return new ResponseEntity<>(memberService.deleteById(id),HttpStatus.OK);
    }
}
