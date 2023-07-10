package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.utilities.UiHelperMethods;

public class OrderSummaryPage {
    WebDriver driver;

    By PlaceOrderBtn = By.xpath("//button[contains(text(),'Place Order')]");

    public OrderSummaryPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickPlaceOrderBtn(){
        //UiHelperMethods.setZoom(driver, 90);
        UiHelperMethods.waitForElementToBeVisible(driver, PlaceOrderBtn, 20);
        UiHelperMethods.waitForElementToBeClickable(driver, PlaceOrderBtn, 20);
        UiHelperMethods.clickElement(driver, PlaceOrderBtn,20);
    }
}
