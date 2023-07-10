package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.utilities.UiHelperMethods;

public class CreateCategoryPage {

    WebDriver driver;

    By categoryNameField = By.xpath("//*[@id='Name']");
    By displayOrderField = By.xpath("//*[@id='DisplayOrder']");
    By createBtn = By.xpath("//button[contains(text(),'Create')]");

    public CreateCategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void populateCreateCategoryFields(String categoryNameValue, String displayOrderValue){
        UiHelperMethods.enterText(driver, categoryNameField, 10, categoryNameValue);
        UiHelperMethods.enterText(driver, displayOrderField, 10, displayOrderValue);
    }

    public void clickCreateBtn(){
        UiHelperMethods.clickElement(driver, createBtn, 10);
    }
}
