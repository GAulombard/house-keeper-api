package com.hodor.housekeeperapi.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Household implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "household",cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Member> members = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "household",cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<JointCharge> charges = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "household",cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<JointLoan> loans = new ArrayList<>();

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
