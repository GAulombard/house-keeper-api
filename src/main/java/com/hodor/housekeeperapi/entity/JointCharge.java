package com.hodor.housekeeperapi.entity;

import com.hodor.housekeeperapi.enumaration.ChargeType;
import com.hodor.housekeeperapi.enumaration.RecurrenceType;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "joint_charge")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JointCharge extends RootEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "household_id")
    private Household household;

    private String label;
    private Long value;
    private String reference;
    @Enumerated(EnumType.STRING)
    private ChargeType chargeType;
    @Enumerated(EnumType.STRING)
    private RecurrenceType recurrenceType;

}