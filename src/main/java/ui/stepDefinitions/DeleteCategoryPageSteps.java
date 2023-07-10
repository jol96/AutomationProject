package ui.stepDefinitions;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import ui.pages.DeleteCategoryPage;

public class DeleteCategoryPageSteps extends BaseSteps{

    private ContextSteps contextSteps;
    public WebDriver driver;
    public DeleteCategoryPage deleteCategoryPage;


    public DeleteCategoryPageSteps(ContextSteps contextSteps){
        this.contextSteps = contextSteps;
        driver = contextSteps.getDriver();
        deleteCategoryPage = new DeleteCategoryPage(driver);
    }

    @When("I click the delete button on the delete category page$")
    public void clickTheDeleteButtonOnTheDeleteCategoryPage(){
        deleteCategoryPage.clickDeleteBtn();
        LOGGER.info("Given I click the delete button on the delete category page - Completed");
    }
}
