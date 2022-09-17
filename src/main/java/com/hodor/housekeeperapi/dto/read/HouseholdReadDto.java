package com.hodor.housekeeperapi.dto.read;

import com.hodor.housekeeperapi.entity.JointCharge;
import com.hodor.housekeeperapi.entity.JointLoan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HouseholdReadDto implements Serializable {

    private Integer id;
    private String name;
    private List<MemberCompactReadDto> members;
    private List<JointCharge> charges;
    private List<JointLoan> loans;

}
