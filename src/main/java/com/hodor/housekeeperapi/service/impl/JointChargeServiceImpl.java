package com.hodor.housekeeperapi.service.impl;

import com.hodor.housekeeperapi.dto.builder.JointChargeBuilder;
import com.hodor.housekeeperapi.dto.create.JointChargeCreateDto;
import com.hodor.housekeeperapi.dto.read.JointChargeReadDto;
import com.hodor.housekeeperapi.dto.update.JointChargeUpdateDto;
import com.hodor.housekeeperapi.repository.JointChargeRepository;
import com.hodor.housekeeperapi.service.JointChargeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JointChargeServiceImpl implements JointChargeService {

    private JointChargeRepository jointChargeRepository;
    private JointChargeBuilder jointChargeBuilder;

    @Override
    public JointChargeReadDto create(JointChargeCreateDto jointChargeCreateDto) {
        return null;
    }

    @Override
    public JointChargeReadDto readById(Integer id) {
        return null;
    }

    @Override
    public List<JointChargeReadDto> readAll() {
        return null;
    }

    @Override
    public JointChargeReadDto update(JointChargeUpdateDto jointChargeUpdateDto) {
        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return null;
    }
}
