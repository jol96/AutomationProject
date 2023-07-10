package ui.stepDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import ui.pages.OrderSummaryPage;

public class OrderSummarySteps extends BaseSteps{
    private ContextSteps contextSteps;

    public WebDriver driver;
    public OrderSummaryPage orderSummaryPage;

    public OrderSummarySteps(ContextSteps contextSteps){
        this.contextSteps = contextSteps;
        driver = contextSteps.getDriver();
        orderSummaryPage = new OrderSummaryPage(driver);
    }

    @Given("I click the Place Order button on the order summary page$")
    public void clickThePlaceOrderBtn(){
        orderSummaryPage.clickPlaceOrderBtn();
        LOGGER.info("Given I click the Place Order button on the order summary page - Completed");
    }
}
