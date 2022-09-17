package com.hodor.housekeeperapi.repository;

import com.hodor.housekeeperapi.entity.JointLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JointLoanRepository extends JpaRepository<JointLoan, Integer> {
}