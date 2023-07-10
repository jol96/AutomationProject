package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.utilities.UiHelperMethods;

public class CategoryPage {
    WebDriver driver;
    // Locators
    By createNewCategoryBtn = By.xpath("//*[@href='/Admin/Category/Create']");
    By deleteCategoryBtn;
    By categoryNameColumnValue;

    public CategoryPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickCreateNewCategoryBtn(){
        UiHelperMethods.clickElement(driver, createNewCategoryBtn, 10);
    }

    public void clickDeleteCategoryBtn(String Category){

        deleteCategoryBtn = By.xpath("//*[contains(text(),'"+Category+"')]/following-sibling::td[*]//a[contains(@href, '/Admin/Category/Delete')]");

        UiHelperMethods.clickElement(driver, deleteCategoryBtn, 10);
    }

    public Boolean isCategoryNameDisplayed(String categoryName){
        categoryNameColumnValue = By.xpath("//td[text()='"+categoryName+"']");

        return driver.findElements(categoryNameColumnValue).size() < 1;
    }
}
