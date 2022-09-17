package com.hodor.housekepperapi.repository;

import com.hodor.housekepperapi.entity.JointLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JointLoanRepository extends JpaRepository<JointLoan, Integer> {
}