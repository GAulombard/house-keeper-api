package com.hodor.housekeeperapi.repository;

import com.hodor.housekeeperapi.entity.Household;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseholdRepository extends JpaRepository<Household, Integer> {
}