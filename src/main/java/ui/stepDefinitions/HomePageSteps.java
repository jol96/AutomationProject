package ui.stepDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import ui.pages.HomePage;

public class HomePageSteps extends BaseSteps {
    private ContextSteps contextSteps;

    public WebDriver driver;
    public HomePage homePage;

    public HomePageSteps(ContextSteps contextSteps){
        this.contextSteps = contextSteps;
        driver = contextSteps.getDriver();
        homePage = new HomePage(driver);
    }

    @Given("^I click the login link$")
    public void clickTheLoginLink(){
        homePage.clickLogin();
        LOGGER.info("Given I click the login link - Completed");
    }

    @Given("I click the content management drop down")
    public void clickTheContentManagementDropDown(){
        homePage.clickContentManagementDD();
        LOGGER.info("Given I click the content management drop down - Completed");
    }

    @Given("I select Category in the content management drop down$")
    public void selectCategoryInTheContentManagementDD(){
        homePage.clickCategory();
        LOGGER.info("Given I select Category in the content management drop down - Completed");
    }

    @Given("I click the details button for product \"(.*)\"$")
    public void clickTheDetailsBtn(String productName){
        homePage.clickDetailsBtn(productName);
        LOGGER.info("Given I click the details button for product "+productName+" - Completed");
    }

    @Given("I click the cart icon$")
    public void clickTheCartIcon(){
        homePage.clickCartIcon();
        LOGGER.info("Given I click the cart icon - Completed");
    }
}
