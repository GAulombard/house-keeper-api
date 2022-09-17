package com.hodor.housekeeperapi.repository;

import com.hodor.housekeeperapi.entity.Charge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargeRepository extends JpaRepository<Charge, Integer> {
}