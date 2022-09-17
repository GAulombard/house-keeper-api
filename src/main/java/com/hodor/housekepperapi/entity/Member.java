package com.hodor.housekepperapi.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Member {

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
    private List<Load> loads;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    private List<Loan> loans;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    private List<Income> incomes = new java.util.ArrayList<>();


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