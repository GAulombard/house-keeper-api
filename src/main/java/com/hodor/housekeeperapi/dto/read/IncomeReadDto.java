package com.hodor.housekeeperapi.dto.read;

import com.hodor.housekeeperapi.enumaration.IncomeType;
import com.hodor.housekeeperapi.enumaration.RecurrenceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IncomeReadDto implements Serializable {

    private Integer id;
    private MemberCompactReadDto memberCompactReadDto;
    private String label;
    private Long value;
    private String recurrenceType;
    private String incomeType;
    private String reference;

}
