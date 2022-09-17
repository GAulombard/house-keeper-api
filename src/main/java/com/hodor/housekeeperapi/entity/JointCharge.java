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
public class JointCharge implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "household_id")
    private Household household;

    private String label;
    private Long value;
    private String reference;
    private ChargeType chargeType;
    private RecurrenceType recurrenceType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        JointCharge jointCharge = (JointCharge) o;
        return id != null && Objects.equals(id, jointCharge.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}