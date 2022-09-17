package com.hodor.housekepperapi.entity;

import com.hodor.housekepperapi.enumaration.LoadType;
import com.hodor.housekepperapi.enumaration.RecurrenceType;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "joint_load")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class JointLoad {
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
    private LoadType loadType;
    private RecurrenceType recurrenceType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        JointLoad jointLoad = (JointLoad) o;
        return id != null && Objects.equals(id, jointLoad.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}