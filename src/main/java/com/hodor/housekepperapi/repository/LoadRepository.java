package com.hodor.housekepperapi.repository;

import com.hodor.housekepperapi.entity.Load;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoadRepository extends JpaRepository<Load, Integer> {
}