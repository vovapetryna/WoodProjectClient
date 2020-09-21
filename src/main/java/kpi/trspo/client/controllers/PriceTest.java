package kpi.trspo.client.controllers;

import kpi.trspo.client.models.Material;
import kpi.trspo.client.models.Price;
import kpi.trspo.client.payloads.PricePayload;
import kpi.trspo.client.requests.Request;
import kpi.trspo.client.utils.FData;
import kpi.trspo.client.utils.Logging;
import org.apache.http.client.methods.HttpPost;

import java.io.IOException;
import java.util.Random;

public class PriceTest {
    private final String endPoint = "http://localhost:8080/api/prices";

    private final Random rand = new Random();

    private final MaterialTest materialTest = new MaterialTest();

    private void createPrices() throws IOException {
        Material[] materials = materialTest.getAllMaterials();

        for (int i=0; i<materials.length; i++){
            for (int j=0; j<materials.length; j++){
                if (i != j){
                    Request post = Request.builder()
                            .type(new HttpPost(endPoint))
                            .body(new PricePayload(materials[i].getMaterial_id(),
                                    materials[j].getMaterial_id(),
                                    FData.getPPrice(), FData.getPPrice()))
                            .response(Price.class).build();
                    Logging.printObject(post.send(), "Creating Price Pair");
                }
            }
        }
    }

    public void testService() throws IOException{
        System.out.println("Price service testing".toUpperCase());
        createPrices();
    }
}
