package com.hodor.housekeeperapi.dto.create;

import com.hodor.housekeeperapi.enumaration.IncomeType;
import com.hodor.housekeeperapi.enumaration.RecurrenceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IncomeCreateDto implements Serializable {

    private Integer memberId;
    private String label;
    private Long value;
    private RecurrenceType recurrenceType;
    private IncomeType incomeType;
    private String reference;

}
