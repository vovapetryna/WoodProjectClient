package kpi.trspo.client.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderPayload {
    private String product;
    private double volume;
    private double price;
    private String client;
}
