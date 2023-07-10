package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.utilities.UiHelperMethods;

public class DetailsPage {
    WebDriver driver;

    By CountField = By.id("Count");
    By AddToCartBtn = By.xpath("//button[contains(text(),'Add to Cart')]");

    public DetailsPage(WebDriver driver){
        this.driver = driver;
    }

    public void setCountField(String count){
        UiHelperMethods.clearField(driver, CountField, 10);
        UiHelperMethods.enterText(driver, CountField, 10, count);
    }

    public void clickAddToCartBtn(){
        UiHelperMethods.clickElement(driver, AddToCartBtn, 10);
    }
}
