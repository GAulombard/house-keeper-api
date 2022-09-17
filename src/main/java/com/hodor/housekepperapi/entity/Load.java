package com.hodor.housekepperapi.entity;

import com.hodor.housekepperapi.enumaration.LoadType;
import com.hodor.housekepperapi.enumaration.RecurrenceType;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "load")
public class Load {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private String label;
    private Long value;
    private String reference;
    private LoadType loadType;
    private RecurrenceType recurrenceType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Load load = (Load) o;
        return id != null && Objects.equals(id, load.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}