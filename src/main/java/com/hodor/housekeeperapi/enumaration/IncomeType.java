package com.hodor.housekeeperapi.enumaration;

public enum IncomeType {
    SALARY("salary"),
    OTHER("other");

    private String label;

    IncomeType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
