package com.hodor.housekeeperapi.entity;

import com.hodor.housekeeperapi.enumaration.LoanType;
import com.hodor.housekeeperapi.enumaration.RecurrenceType;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "joint_loan")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JointLoan implements Serializable {
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
    private LoanType loanType;
    private RecurrenceType recurrenceType;
    private LocalDateTime originalDate;
    private LocalDateTime finalDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        JointLoan jointLoan = (JointLoan) o;
        return id != null && Objects.equals(id, jointLoan.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}