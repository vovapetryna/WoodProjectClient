package kpi.trspo.client.models;

import kpi.trspo.client.payloads.StoragePayload;
import kpi.trspo.client.utils.FData;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Material {
    private String material_id;
    private String name;
    private double average_price;

    public StoragePayload toStoragePayload(){
        return new StoragePayload(material_id, FData.getVolume(), FData.getPrice());
    }
}
