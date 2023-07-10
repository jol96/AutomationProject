package ui.stepDefinitions;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import ui.pages.CreateCategoryPage;

public class CreateCategoryPageSteps extends BaseSteps{

    private ContextSteps contextSteps;

    public WebDriver driver;
    public CreateCategoryPage createCategoryPage;

    public CreateCategoryPageSteps(ContextSteps contextSteps){
        this.contextSteps = contextSteps;
        driver = contextSteps.getDriver();
        createCategoryPage = new CreateCategoryPage(driver);
    }

    @When("I enter the category name \"(.*)\" and display order\"(.*)\"$")
    public void enterTheCategoryNameAndDisplayOrder(String categoryName, String displayOrder){
        createCategoryPage.populateCreateCategoryFields(categoryName, displayOrder);
        LOGGER.info("Given I enter the category name "+categoryName+" and display order "+displayOrder+" - Completed");
    }

    @When("I click the create button")
    public void clickTheCreateButton(){
        createCategoryPage.clickCreateBtn();
        LOGGER.info("When I click the create button - Completed");
    }

}
