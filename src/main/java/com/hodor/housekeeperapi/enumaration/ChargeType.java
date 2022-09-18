package com.hodor.housekeeperapi.enumaration;

public enum ChargeType {
    VARIABLE("variable"),
    FIXED("fixed");

    private String label;

    ChargeType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
