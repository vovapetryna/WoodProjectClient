package kpi.trspo.client.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductionPayload {
    StoragePayload material;
    private StoragePayload[] products;
    private UniPayload[] workers;
}
