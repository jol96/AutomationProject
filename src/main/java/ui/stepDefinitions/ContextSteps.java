package ui.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ui.utilities.UiHelperMethods;

public class ContextSteps extends BaseSteps {
    private WebDriver driver;
    public ContextSteps(){}

    @Before
    public void setUp(){
        getConfiguation();
        if(browser.equalsIgnoreCase("CHROME")){
            if(runHeadless.equalsIgnoreCase("TRUE")){
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                driver = new ChromeDriver(options);
            }
            else {
                driver = new ChromeDriver();
            }
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    @Given("^I open the web app \"(.*)\"$")
    public void openApplication(String appUrl){
        driver = this.getDriver();
        driver.get(appUrl);
        LOGGER.info("Given I open the web app "+appUrl+" - Completed");
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            UiHelperMethods.captureScreenshot(driver, scenario);
        }
        driver.close();
    }
}
