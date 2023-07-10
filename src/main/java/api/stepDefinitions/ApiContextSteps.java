package api.stepDefinitions;

import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class ApiContextSteps extends BaseSteps{

    @Before
    public void setup() {
        getConfiguation();
        RestAssured.baseURI = BaseApi;
    }
}
