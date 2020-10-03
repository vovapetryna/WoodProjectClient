package kpi.trspo.client.models;

import lombok.Data;

@Data
public class Order {
    private String order_id;
    private String dateCreated;
    private Material product;
    private double volume;
    private double price;
    private Client client;
}
