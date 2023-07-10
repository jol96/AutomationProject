package ui.stepDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import ui.pages.DetailsPage;

public class DetailsPageSteps extends BaseSteps{
    private ContextSteps contextSteps;

    public WebDriver driver;
    public DetailsPage detailsPage;

    public DetailsPageSteps(ContextSteps contextSteps){
        this.contextSteps = contextSteps;
        driver = contextSteps.getDriver();
        detailsPage = new DetailsPage(driver);
    }

    @Given("I set the count to \"(.*)\"$")
    public void setTheCount(String count){
        detailsPage.setCountField(count);
        LOGGER.info("Given I set the count to "+count+" - Completed");
    }

    @Given("I click the Add To Cart button$")
    public void clickTheAddToCartButton(){
        detailsPage.clickAddToCartBtn();
        LOGGER.info("Given I click the Add To Cart button - Completed");
    }
}
