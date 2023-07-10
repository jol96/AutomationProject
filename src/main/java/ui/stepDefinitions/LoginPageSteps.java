package ui.stepDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import ui.pages.LoginPage;

public class LoginPageSteps extends BaseSteps{
    private ContextSteps contextSteps;

    public WebDriver driver;
    public LoginPage loginPage;

    public LoginPageSteps(ContextSteps contextSteps){
        this.contextSteps = contextSteps;
        driver = contextSteps.getDriver();
        loginPage = new LoginPage(driver);
    }

    @Given("^I enter the username \"(.*)\" and password \"(.*)\"$")
    public void enterTheUserNameAndPassword(String username, String password) {
        loginPage.enterLoginCredentialsAndLogin(username, password);
        LOGGER.info("Given I enter the username "+username+" and password "+password+" - Completed");
    }
}
