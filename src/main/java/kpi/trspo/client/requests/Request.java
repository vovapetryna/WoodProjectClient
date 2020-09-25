package kpi.trspo.client.requests;

import com.google.gson.Gson;
import kpi.trspo.client.payloads.ErrorPayload;
import kpi.trspo.client.utils.Logging;
import lombok.Builder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

@Builder
public class Request {
    private final HttpUriRequest type;
    private final Object body;
    private final Class response;

    public Object send() throws IOException {
        String result = "";

        if (type instanceof HttpPost)
            ((HttpPost)type).setEntity(new StringEntity(makeJson()));
        else if (type instanceof HttpPut)
            ((HttpPut)type).setEntity(new StringEntity(makeJson()));

        type.addHeader("content-type", "application/json");
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(type)) {
            result = checkResponse(response);
        }

        return (!result.equals("")) ? makeObject(result, response) : null;
    }

    private String checkResponse(CloseableHttpResponse response) throws IOException {
        HttpEntity entity = response.getEntity();
        String result = "";
        if (entity != null)
            result = EntityUtils.toString(entity);

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            return result;
        }else {
            if (!result.equals(""))
                Logging.printError(makeObject(result, ErrorPayload.class));
            else
                Logging.unhendeledError();
        }

        return result;
    }

    private String makeJson(){ Gson gson = new Gson(); return gson.toJson(body); }

    private Object makeObject(String json, Class objClass){
       Gson gson = new Gson(); return gson.fromJson(json, objClass);
    }
}
