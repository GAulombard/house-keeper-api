package com.hodor.housekeeperapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class RootEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreatedDate
    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdDate = LocalDateTime.now();

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModifiedDate = LocalDateTime.now();

//    @CreatedBy
//    @Column(nullable = false, updatable = false)
//    private Integer createdBy;
//
//    @LastModifiedBy
//    @Column(insertable = false)
//    private Integer lastModifiedBy;
}
