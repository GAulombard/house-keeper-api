package com.hodor.housekepperapi.repository;

import com.hodor.housekepperapi.entity.JointCharge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JointChargeRepository extends JpaRepository<JointCharge, Integer> {
}