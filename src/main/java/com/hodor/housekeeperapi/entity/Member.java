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
public class Member implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "household_id")
    private Household household;

    private String firstName;
    private String lastName;
    private String mail;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    @ToString.Exclude
    private List<Charge> charges;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    @ToString.Exclude
    private List<Loan> loans;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    @ToString.Exclude
    private List<Income> incomes = new ArrayList<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Member member = (Member) o;
        return id != null && Objects.equals(id, member.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}