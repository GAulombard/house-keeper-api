package com.hodor.housekeeperapi.dto.create;

import com.hodor.housekeeperapi.enumaration.LoanType;
import com.hodor.housekeeperapi.enumaration.RecurrenceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JointLoanCreateDto implements Serializable {

    private Integer householdId;
    private String label;
    private Long value;
    private String reference;
    private LoanType loanType;
    private RecurrenceType recurrenceType;
    private LocalDateTime originalDate;
    private LocalDateTime finalDate;

}
