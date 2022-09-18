package com.hodor.housekeeperapi.enumaration;

public enum LoanType {
    HOUSE_LOAN("house loan"),
    WORK_LOAN("work loan"),
    VEHICLE_LOAN("vehicle loan"),
    CONSUMER_CREDIT("consumer credit");

    private String label;

    LoanType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
