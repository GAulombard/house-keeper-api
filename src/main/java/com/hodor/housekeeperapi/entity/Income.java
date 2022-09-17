package com.hodor.housekeeperapi.entity;

import com.hodor.housekeeperapi.enumaration.IncomeType;
import com.hodor.housekeeperapi.enumaration.RecurrenceType;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "income")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Income implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private String label;
    private Long value;
    private RecurrenceType recurrenceType;
    private IncomeType incomeType;
    private String reference;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Income income = (Income) o;
        return id != null && Objects.equals(id, income.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}