package com.hodor.housekeeperapi.entity;

import com.hodor.housekeeperapi.enumaration.LoanType;
import com.hodor.housekeeperapi.enumaration.RecurrenceType;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "loan")
public class Loan extends RootEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

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