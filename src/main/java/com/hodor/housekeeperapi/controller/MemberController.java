package com.hodor.housekeeperapi.controller;

import com.hodor.housekeeperapi.dto.create.MemberCreateDto;
import com.hodor.housekeeperapi.dto.read.MemberReadDto;
import com.hodor.housekeeperapi.entity.Member;
import com.hodor.housekeeperapi.exception.HouseholdNotFindException;
import com.hodor.housekeeperapi.exception.MemberNotFindException;
import com.hodor.housekeeperapi.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/member")
@AllArgsConstructor
public class MemberController {

    private MemberService memberService;

    @PostMapping("/1.0/create")
    public ResponseEntity<MemberReadDto> create(@RequestBody MemberCreateDto createDto) throws HouseholdNotFindException {
        return new ResponseEntity<>(memberService.create(createDto), HttpStatus.CREATED);
    }

    @GetMapping("/1.0/read/{id}")
    public ResponseEntity<MemberReadDto> readById(@PathVariable("id") Integer id) throws MemberNotFindException {
        return new ResponseEntity<>(memberService.readById(id), HttpStatus.OK);
    }

    @GetMapping("/1.0/read-all")
    public ResponseEntity<List<MemberReadDto>> readAll() {
        return new ResponseEntity<>(memberService.readAll(), HttpStatus.OK);
    }
}
