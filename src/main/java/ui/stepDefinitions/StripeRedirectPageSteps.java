package ui.stepDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import ui.pages.StripeRedirectPage;

public class StripeRedirectPageSteps extends BaseSteps {

    private ContextSteps contextSteps;
    public WebDriver driver;
    public StripeRedirectPage stripeRedirectPage;

    public StripeRedirectPageSteps(ContextSteps contextSteps){
        this.contextSteps = contextSteps;
        driver = contextSteps.getDriver();
        stripeRedirectPage = new StripeRedirectPage(driver);
    }

    @Given("I enter the credit card details on the stripe redirect page and click pay$")
    public void enterCreditCardDetailsAndPay(){
        stripeRedirectPage.populateStripeFieldsAndClickPayBtn();
        LOGGER.info("Given I enter the credit card details on the stripe redirect page and click pay - Completed");
    }
}
