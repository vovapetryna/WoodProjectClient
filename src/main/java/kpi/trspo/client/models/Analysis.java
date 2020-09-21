package kpi.trspo.client.models;

import lombok.Data;

@Data
public class Analysis {
    private double material_price;
    private double products_average_price;
    private double production_price;
    private double expected_profit;
}
