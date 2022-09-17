package com.hodor.housekepperapi.entity;

import com.hodor.housekepperapi.enumaration.ChargeType;
import com.hodor.housekepperapi.enumaration.RecurrenceType;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "charge")
public class Charge implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private String label;
    private Long value;
    private String reference;
    private ChargeType chargeType;
    private RecurrenceType recurrenceType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Charge charge = (Charge) o;
        return id != null && Objects.equals(id, charge.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}