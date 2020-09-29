package kpi.trspo.client.controllers;

import kpi.trspo.client.models.Order;
import kpi.trspo.client.payloads.OrderPayload;
import kpi.trspo.client.requests.Request;
import kpi.trspo.client.utils.FData;
import kpi.trspo.client.utils.Logging;
import org.apache.http.client.methods.HttpPost;

import java.io.IOException;
import java.util.Random;

public class OrderTest {
    private final String endPoint = "http://localhost:8080/api/orders";

    private final Random rand = new Random();

    private final MaterialTest materialTest = new MaterialTest();

    public void createOrders(int ordersNumber) throws IOException {
        for (int i=0; i<ordersNumber; i++){
            Request post = Request.builder()
                    .type(new HttpPost(endPoint))
                    .body(new OrderPayload(materialTest.getRandomMaterial().getMaterial_id(),
                            FData.getVolume(),
                            FData.getPrice()))
                    .response(Order.class).build();
            Logging.printObject(post.send(), "Creating Order");
        }
    }

    public void testService() throws IOException{
        System.out.println("Orders service testing".toUpperCase());
        createOrders(2);
    }
}
