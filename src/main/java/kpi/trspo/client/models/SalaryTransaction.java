package kpi.trspo.client.models;

import lombok.Data;

@Data
public class SalaryTransaction {
    private Worker worker;
    private double salary_change;
    private String dateCreated;
}
