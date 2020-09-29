package kpi.trspo.client.controllers;

import kpi.trspo.client.models.Worker;
import kpi.trspo.client.payloads.WorkerPayload;
import kpi.trspo.client.requests.Request;
import kpi.trspo.client.utils.FData;
import kpi.trspo.client.utils.Logging;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import java.io.IOException;
import java.util.Random;

public class WorkerTest {
    private final String endPoint = "http://localhost:8080/api/workers";

    private final Random rand = new Random();

    public void createWorkers(int workersNumber) throws IOException {
        for (int i=0; i<workersNumber; i++){
            Request post = Request.builder()
                    .type(new HttpPost(endPoint))
                    .body(new WorkerPayload(FData.getName(), FData.getSurname()))
                    .response(Worker.class).build();
            Logging.printObject(post.send(), "Creating Worker");
        }
    }

    public Worker getRandomWorker() throws IOException {
        Request get = Request.builder()
                .type(new HttpGet(endPoint + "?page=0&size=1000"))
                .body(null)
                .response(Worker[].class).build();
        Worker[] workers = (Worker[]) get.send();
        return workers[rand.nextInt(workers.length)];
    }

    public void testService() throws IOException{
        System.out.println("Worker service testing".toUpperCase());
        createWorkers(2);
    }
}
