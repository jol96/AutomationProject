package api.gateways;

import api.models.ProductRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class ProductsGateway {

    public ProductsGateway(){}

    public HttpResponse UpsertProduct(String baseUrl, ProductRequest product ) throws IOException {
        // 1. Create client
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 2. Create request URI
        HttpPost request = new HttpPost(baseUrl + "/api/productsapi/upsert");

        // 3. Create request body
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(product);
        StringEntity entity = new StringEntity(jsonString);
        request.addHeader("content-type", "application/json");
        request.setEntity(entity);

        // 4. Execute request
        HttpResponse response = httpClient.execute(request);
        return response;
    }

    public HttpResponse GetProductById(String baseUrl, int id) throws IOException {
        // 1. Create client
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 2. Create request URI
        HttpGet request = new HttpGet(baseUrl + "/api/productsapi/get?id=" + id);
        request.addHeader("content-type", "application/json");

        // 4. Execute request
        HttpResponse response = httpClient.execute(request);
        return response;
    }

    public HttpResponse DeleteProductById(String baseUrl, int id) throws IOException {
        // 1. Create client
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 2. Create request URI
        HttpDelete request = new HttpDelete(baseUrl + "/api/productsapi/delete?id=" + id);
        request.addHeader("content-type", "application/json");

        // 4. Execute request
        HttpResponse response = httpClient.execute(request);
        return response;
    }
}
