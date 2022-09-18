package com.hodor.housekeeperapi.enumaration;

public enum RecurrenceType {
    MONTHLY("monthly",1),
    QUARTERLY("quarterly",3),
    ANNUAL("annual",12),
    BI_ANNUAL("bi-annual",6),
    EVERY_TWO_YEARS("every two years",24);

    private String label;
    private Integer recurrence;

    RecurrenceType(String label, Integer recurrence) {
        this.recurrence = recurrence;
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public Integer getRecurrence() {
        return recurrence;
    }
}
