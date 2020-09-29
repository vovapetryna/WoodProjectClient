package kpi.trspo.client.controllers;

import kpi.trspo.client.models.Analysis;
import kpi.trspo.client.payloads.ProductionPayload;
import kpi.trspo.client.payloads.StoragePayload;
import kpi.trspo.client.payloads.UniPayload;
import kpi.trspo.client.requests.Request;
import kpi.trspo.client.utils.Logging;
import org.apache.http.client.methods.HttpPost;

import java.io.IOException;
import java.util.Random;

public class ProductionTest {
    private final String endPoint = "http://localhost:8080/api/production";

    private final Random rand = new Random();

    private final MaterialTest materialTest = new MaterialTest();

    private final WorkerTest workerTest = new WorkerTest();

    public void createSingleProductProduction() throws IOException {
        materialTest.getRandomMaterial();

        UniPayload errorWorker = new UniPayload("2a4222b9-1e4a-46d8-8a17-dc0c587e8e84", 0.0);

        Request post = Request.builder()
                .type(new HttpPost(endPoint))
                .body(new ProductionPayload(materialTest.getRandomMaterial().toStoragePayload(),
                        new StoragePayload[]{materialTest.getRandomMaterial().toStoragePayload()},
                        new UniPayload[]{errorWorker}))
                .response(Analysis.class).build();
        Logging.printObject(post.send(), "Adding single Production");
    }

    public void testService() throws IOException{
        System.out.println("Production service testing".toUpperCase());
        createSingleProductProduction();
        createSingleProductProduction();
        createSingleProductProduction();
    }
}
