package kpi.trspo.client.payloads;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StoragePayload {
    private String material;
    private double volume;
    private double purchase_price = 0.0;
}
