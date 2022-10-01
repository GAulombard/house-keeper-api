package com.hodor.housekeeperapi.dto.read;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IncomeCompactReadDto implements Serializable {

    private Integer id;
    private String label;
    private Long value;

}
