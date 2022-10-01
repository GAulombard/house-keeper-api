package com.hodor.housekeeperapi.dto.create;

import com.hodor.housekeeperapi.enumaration.ChargeType;
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
public class JointChargeCreateDto implements Serializable {

    private Integer householdId;
    private String label;
    private Long value;
    private String reference;
    private ChargeType chargeType;
    private RecurrenceType recurrenceType;

}
