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
public class Household extends RootEntity implements Serializable {

    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "household",cascade = CascadeType.ALL)
    private List<Member> members = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "household",cascade = CascadeType.ALL)
    private List<JointCharge> charges = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "household",cascade = CascadeType.ALL)
    private List<JointLoan> loans = new ArrayList<>();

}
