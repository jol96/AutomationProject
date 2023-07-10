package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.utilities.UiHelperMethods;

public class OrderConfirmationPage {
    WebDriver driver;

    By OrderConfirmationMessage = By.xpath("//*[contains(text(),'Order Placed Successfully!')]");

    public OrderConfirmationPage(WebDriver driver){
        this.driver = driver;
    }

    public void validateOrderSuccessful(){
        UiHelperMethods.waitForElementToBeVisible(driver, OrderConfirmationMessage, 25);
    }
}
