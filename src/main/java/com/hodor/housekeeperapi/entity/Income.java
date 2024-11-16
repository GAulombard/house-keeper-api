package com.hodor.housekeeperapi.entity;

import com.hodor.housekeeperapi.enumaration.IncomeType;
import com.hodor.housekeeperapi.enumaration.RecurrenceType;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "income")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Income extends RootEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private String label;
    private Long value;
    private String reference;
    @Enumerated(EnumType.STRING)
    private RecurrenceType recurrenceType;
    @Enumerated(EnumType.STRING)
    private IncomeType incomeType;

}