package kpi.trspo.client.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public final class Logging {
    public static String beautiflJson(String json){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(json);
        return gson.toJson(je);
    }

    public static void printObject(Object object, String message){
        Gson gson = new Gson();
        String json = gson.toJson(object);
        System.out.println(message);
        System.out.println(beautiflJson(json));
    }
}
