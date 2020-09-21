package kpi.trspo.client.models;

import lombok.Data;

@Data
public class Client {
    private String client_id;
    private String dateCreated;
    private String name;
    private String surname;
    private String phone_number;
}
