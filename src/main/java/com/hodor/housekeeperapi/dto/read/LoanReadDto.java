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
public class LoanReadDto implements Serializable {

    private Integer id;
    private Integer memberId;
    private String label;
    private Long value;
    private String reference;
    private String loanType;
    private String recurrenceType;
    private String originalDate;
    private String finalDate;

}
