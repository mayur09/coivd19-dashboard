package com.covid.dashboard.model;

import lombok.Data;

@Data
public class CaseReport {
    private String name;

    private long active;

    private long cured;

    private long death;

    private long total;


    @Override
    public String toString() {
        return "CaseCounts{" +
                "activeCases=" + active +
                ", recovered=" + cured +
                ", deaths=" + death +
                ", totalCases=" + total +
                '}';
    }
}
