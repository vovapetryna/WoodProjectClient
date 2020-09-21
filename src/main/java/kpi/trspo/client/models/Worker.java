package kpi.trspo.client.models;

import kpi.trspo.client.payloads.UniPayload;
import lombok.Data;

@Data
public final class Worker {
    private String worker_id;
    private String dateCreated;
    private String name;
    private String surname;
    private double balance;

    public UniPayload toUniPayload(){ return new UniPayload(worker_id, balance);}
}