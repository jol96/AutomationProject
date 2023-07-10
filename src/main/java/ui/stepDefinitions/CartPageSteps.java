package ui.stepDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import ui.pages.CartPage;

public class CartPageSteps extends BaseSteps{
    private ContextSteps contextSteps;

    public WebDriver driver;
    public CartPage cartPage;

    public CartPageSteps(ContextSteps contextSteps){
        this.contextSteps = contextSteps;
        driver = contextSteps.getDriver();
        cartPage = new CartPage(driver);
    }

    @Given("I click the Summary button on the shopping cart page$")
    public void clickTheSummaryButton(){
        cartPage.clickSummaryBtn();
        LOGGER.info("Given I click the Summary button on the shopping cart page - Completed");
    }
}
