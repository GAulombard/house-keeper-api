package com.hodor.housekeeperapi.dto.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberUpdateDto implements Serializable {

    private Integer id;
    private Integer household;
    private String firstName;
    private String lastName;
    private String mail;

}
