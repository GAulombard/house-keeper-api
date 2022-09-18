package com.hodor.housekeeperapi.dto.read;

import com.hodor.housekeeperapi.entity.Charge;
import com.hodor.housekeeperapi.entity.Income;
import com.hodor.housekeeperapi.entity.Loan;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link com.hodor.housekeeperapi.entity.Member} entity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberReadDto implements Serializable {
    private Integer id;
    private String household;
    private String firstName;
    private String lastName;
    private String mail;
    private List<Charge> charges;
    private List<Loan> loans;
    private List<Income> incomes;
}