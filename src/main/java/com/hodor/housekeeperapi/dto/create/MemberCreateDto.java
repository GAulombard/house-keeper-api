package com.hodor.housekeeperapi.dto.create;

import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link com.hodor.housekeeperapi.entity.Member} entity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberCreateDto implements Serializable {
    private Integer household;
    private String firstName;
    private String lastName;
    private String mail;
}