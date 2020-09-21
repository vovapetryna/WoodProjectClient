package kpi.trspo.client.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UniPayload {
    private String uuid;
    private double money;
}
