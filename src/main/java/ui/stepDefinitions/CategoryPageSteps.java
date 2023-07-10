package ui.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ui.pages.CategoryPage;

public class CategoryPageSteps extends BaseSteps{
    private ContextSteps contextSteps;

    public WebDriver driver;
    public CategoryPage categoryPage;

    public CategoryPageSteps(ContextSteps contextSteps){
        this.contextSteps = contextSteps;
        driver = contextSteps.getDriver();
        categoryPage = new CategoryPage(driver);
    }

    @When("I click the Create New Category button")
    public void clickCreateNewCategoryBtn(){
        categoryPage.clickCreateNewCategoryBtn();
        LOGGER.info("Given I click the Create New Category button - Completed");
    }

    @When("I click the delete button for category \"(.*)\"$")
    public void clickTheDeleteButton(String category){
        categoryPage.clickDeleteCategoryBtn(category);
        LOGGER.info("Given I click the Create New Category button "+category+" - Completed");
    }

    @Then("the category \"(.*)\" has been deleted successfully$")
    public void thenTheCategoryHasBeenDeletedSuccessfully(String categoryName){
        Boolean isCategoryDeleted = categoryPage.isCategoryNameDisplayed(categoryName);
        Assert.assertEquals(isCategoryDeleted.booleanValue(), true);
        LOGGER.info("Then the category "+categoryName+" has been deleted successfully - Completed");
    }
}
