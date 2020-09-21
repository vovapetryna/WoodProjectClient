package kpi.trspo.client.models;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class StorageRecord {
    private String record_id;
    private String dateCreated;
    private boolean change_type;
    private double purchase_price;
    private double volume;
    private Material material;
}
