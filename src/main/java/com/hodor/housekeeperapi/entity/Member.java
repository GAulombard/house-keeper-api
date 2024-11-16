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
public class Member extends RootEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "household_id")
    private Household household;

    private String firstName;
    private String lastName;
    private String mail;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member",cascade = CascadeType.ALL)
    private List<Charge> charges;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member",cascade = CascadeType.ALL)
    private List<Loan> loans;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member",cascade = CascadeType.ALL)
    private List<Income> incomes = new ArrayList<>();

}