package com.hodor.housekeeperapi.entity;

import com.hodor.housekeeperapi.enumaration.LoanType;
import com.hodor.housekeeperapi.enumaration.RecurrenceType;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "joint_loan")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JointLoan extends RootEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "household_id")
    private Household household;

    private String label;
    private Long value;
    private String reference;
    @Enumerated(EnumType.STRING)
    private LoanType loanType;
    @Enumerated(EnumType.STRING)
    private RecurrenceType recurrenceType;
    private LocalDate originalDate;
    private LocalDate finalDate;

}