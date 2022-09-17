package com.hodor.housekepperapi.entity;

import jdk.jshell.execution.LoaderDelegate;
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
    @Column(nullable = false, updatable = false)
    private Integer id;
    private String name;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "household")
    private List<Member> members = new java.util.ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "household")
    private List<Load> loads = new java.util.ArrayList<>();
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "household")
    private List<Loan> loans = new java.util.ArrayList<>();

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
