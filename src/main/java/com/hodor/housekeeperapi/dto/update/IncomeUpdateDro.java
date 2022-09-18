package com.hodor.housekeeperapi.dto.update;

import com.hodor.housekeeperapi.enumaration.IncomeType;
import com.hodor.housekeeperapi.enumaration.RecurrenceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class IncomeUpdateDro implements Serializable {

    private Integer id;
    private Integer memberId;
    private String label;
    private Long value;
    private RecurrenceType recurrenceType;
    private IncomeType incomeType;
    private String reference;

}
