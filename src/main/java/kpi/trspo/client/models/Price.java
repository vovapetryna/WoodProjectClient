package kpi.trspo.client.models;

import lombok.Data;

@Data
public class Price {
    private String production_price_id;
    private Material[] material_product;
    private double main_price;
    private double secondary_price;
}
