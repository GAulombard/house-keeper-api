package com.hodor.housekepperapi.repository;

import com.hodor.housekepperapi.entity.Charge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargeRepository extends JpaRepository<Charge, Integer> {
}