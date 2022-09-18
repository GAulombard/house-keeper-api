package com.hodor.housekeeperapi.dto.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HouseholdUpdateDto implements Serializable {

    private Integer id;
    private String name;

}
