package kpi.trspo.client.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientPayload {
    private String name;
    private String surname;
    private String phone_number;
}
