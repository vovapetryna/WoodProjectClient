package kpi.trspo.client.controllers;

import kpi.trspo.client.models.Material;
import kpi.trspo.client.payloads.MaterialPayload;
import kpi.trspo.client.requests.Request;
import kpi.trspo.client.utils.FData;
import kpi.trspo.client.utils.Logging;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import java.io.IOException;
import java.util.Random;

public class MaterialTest {
    private final String endPoint = "http://localhost:8080/api/materials";

    private final Random rand = new Random();

    public void createMaterials(int materialsNumber){
        for (int i=0; i<materialsNumber; i++){
            Request post = Request.builder()
                    .type(new HttpPost(endPoint))
                    .body(new MaterialPayload(FData.getMaterial(), FData.getPrice()))
                    .response(Material.class).build();
            try{
                Logging.printObject(post.send(), "Creating Material");
            }catch (IOException e){
                System.out.println("Material with this name already exist");
            }
        }
    }

    public Material getRandomMaterial() throws IOException {
        Request get = Request.builder()
                .type(new HttpGet(endPoint))
                .body(null)
                .response(Material[].class).build();
        Material[] materials = (Material[]) get.send();
        return materials[rand.nextInt(materials.length)];
    }

    public Material[] getAllMaterials() throws IOException {
        Request get = Request.builder()
                .type(new HttpGet(endPoint))
                .body(null)
                .response(Material[].class).build();
        return (Material[]) get.send();
    }

    public void testService() throws IOException{
        System.out.println("Materials service testing".toUpperCase());
        createMaterials(3);
    }
}
