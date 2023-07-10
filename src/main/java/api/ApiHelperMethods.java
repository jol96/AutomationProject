package api;

import api.models.ProductResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ApiHelperMethods {
    public static ProductResponse deseriliazeProductResponse(HttpResponse response) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        HttpEntity httpEntity = response.getEntity();
        String responseBody = EntityUtils.toString(httpEntity);
        ProductResponse responseProduct = objectMapper.readValue(responseBody, ProductResponse.class);

        return responseProduct;
    }
}
