package com.hodor.housekepperapi.repository;

import com.hodor.housekepperapi.entity.Household;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseholdRepository extends JpaRepository<Household, Integer> {
}