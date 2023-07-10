package ui.stepDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import ui.pages.OrderConfirmationPage;

public class OrderConfirmationPageSteps extends BaseSteps{

    private ContextSteps contextSteps;

    public WebDriver driver;
    public OrderConfirmationPage orderConfirmationPage;

    public OrderConfirmationPageSteps(ContextSteps contextSteps){
        this.contextSteps = contextSteps;
        driver = contextSteps.getDriver();
        orderConfirmationPage = new OrderConfirmationPage(driver);
    }

    @Given("I am notified the order is placed successfully$")
    public void orderIsPlacedSuccessfully(){
        orderConfirmationPage.validateOrderSuccessful();
        LOGGER.info("Given I am notified the order is placed successfully - Completed");
    }
}
