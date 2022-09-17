package com.hodor.housekeeperapi.repository;

import com.hodor.housekeeperapi.entity.JointCharge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JointChargeRepository extends JpaRepository<JointCharge, Integer> {
}