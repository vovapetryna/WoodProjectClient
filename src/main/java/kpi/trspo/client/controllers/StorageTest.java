package kpi.trspo.client.controllers;
import kpi.trspo.client.models.StorageRecord;
import kpi.trspo.client.payloads.StoragePayload;
import kpi.trspo.client.requests.Request;
import kpi.trspo.client.utils.FData;
import kpi.trspo.client.utils.Logging;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;

import java.io.IOException;
import java.util.Random;

public class StorageTest {
    private final String endPoint = "http://localhost:8080/api/storage";

    private final Random rand = new Random();

    private final MaterialTest materialTest = new MaterialTest();

    public void createStorageRecord(int storageRecordsNumber) throws IOException{
        for (int i=0; i<storageRecordsNumber; i++){
            Request put = Request.builder()
                    .type(new HttpPut(endPoint + "/income"))
                    .body(new StoragePayload(materialTest.getRandomMaterial().getMaterial_id(),
                            FData.getVolume(), FData.getPrice()))
                    .response(StorageRecord.class).build();
            Logging.printObject(put.send(), "Adding materials to storage");
        }
    }

    public StorageRecord getRandomRecord() throws IOException {
        Request get = Request.builder()
                .type(new HttpGet(endPoint))
                .body(null)
                .response(StorageRecord[].class).build();
        StorageRecord[] storageRecords = (StorageRecord[]) get.send();
        System.out.println(storageRecords[0].toString());
        return storageRecords[rand.nextInt(storageRecords.length)];
    }

    public void testService() throws IOException{
        System.out.println("Storage service testing".toUpperCase());
        createStorageRecord(2);
    }
}
