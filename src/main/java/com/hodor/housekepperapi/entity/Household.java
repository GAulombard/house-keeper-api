package com.hodor.housekepperapi.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Household implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "household")
    private List<Member> members = new java.util.ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "household")
    private List<JointCharge> charges = new java.util.ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "household")
    private List<JointLoan> loans = new java.util.ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Household household = (Household) o;
        return id != null && Objects.equals(id, household.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
