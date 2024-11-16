package com.hodor.housekeeperapi.entity;

import com.hodor.housekeeperapi.enumaration.ChargeType;
import com.hodor.housekeeperapi.enumaration.RecurrenceType;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "charge")
public class Charge extends RootEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private String label;
    private Long value;
    private String reference;
    @Enumerated(EnumType.STRING)
    private ChargeType chargeType;
    @Enumerated(EnumType.STRING)
    private RecurrenceType recurrenceType;

}