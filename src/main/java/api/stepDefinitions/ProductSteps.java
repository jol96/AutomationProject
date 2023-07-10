package api.stepDefinitions;

import api.ApiHelperMethods;
import api.gateways.ProductsGateway;
import api.models.ProductRequest;
import api.models.ProductResponse;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import org.apache.http.HttpResponse;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ProductSteps extends BaseSteps {

    private ApiContextSteps apiContextSteps;
    public ProductsGateway productsGateway;
    public ProductRequest productRequest;
    public ProductResponse productResponse;

    public ProductSteps(ApiContextSteps apiContextSteps, ProductsGateway productsGateway){
        this.apiContextSteps = apiContextSteps;
        this.productsGateway = productsGateway;
        productRequest = new ProductRequest();
    }
    @Given("I try create these product via the product API$")
    public void theProduct(DataTable dataTable) throws IOException {
        // Retrieve the table data as a List of Maps
        List<Map<String, String>> tableData = dataTable.asMaps();
        for (Map<String, String> row : tableData) {
            productRequest.setTitle(row.get("Title"));
            productRequest.setDescription(row.get("Description"));
            productRequest.setIsbn(row.get("ISBN"));
            productRequest.setAuthor(row.get("Author"));
            productRequest.setListPrice(Double.parseDouble(row.get("List Price")));
            productRequest.setPrice(Double.parseDouble(row.get("Price")));
            productRequest.setPrice50(Double.parseDouble(row.get("Price 50")));
            productRequest.setPrice100(Double.parseDouble(row.get("Price 100")));
            productRequest.setCategoryId(Integer.parseInt(row.get("Category Id")));
        }
        HttpResponse httpResponse = productsGateway.UpsertProduct(RestAssured.baseURI, productRequest);
        productResponse = ApiHelperMethods.deseriliazeProductResponse(httpResponse);

        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), 200);
    }

    @Then("the product \"(.*)\" is created successfully$")
    public void theProductIsCreatedSuccessfully(String title) throws IOException {
        HttpResponse httpResponse = productsGateway.GetProductById(RestAssured.baseURI, productResponse.getId());
        ProductResponse getProductResponse = ApiHelperMethods.deseriliazeProductResponse(httpResponse);

        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), 200);
        Assert.assertEquals(getProductResponse.getTitle(), title);
    }

    @Then("the product is deleted successfully")
    public void theProductIsDeletedSuccessfully() throws IOException {
        HttpResponse httpResponse = productsGateway.DeleteProductById(RestAssured.baseURI, productResponse.getId());
        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), 200);
    }
}
