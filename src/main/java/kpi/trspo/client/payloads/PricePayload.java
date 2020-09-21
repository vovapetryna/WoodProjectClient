package kpi.trspo.client.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PricePayload {
    private String material;
    private String product;
    private double main_price;
    private double secondary_price;
}
