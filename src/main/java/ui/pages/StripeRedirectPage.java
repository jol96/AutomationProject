package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.utilities.UiHelperMethods;

public class StripeRedirectPage {
    WebDriver driver;

    By EmailField = By.xpath("//*[@inputmode='email']");
    By CardNumberField = By.id("cardNumber");
    By ExpireDateField = By.id("cardExpiry");
    By CvcField = By.id("cardCvc");
    By NameField = By.id("billingName");
    By PostCodeField = By.id("billingPostalCode");
    By PayBtn = By.xpath("//*[@class='SubmitButton SubmitButton--complete']");

    public StripeRedirectPage(WebDriver driver){
        this.driver = driver;
    }

    public void populateStripeFieldsAndClickPayBtn(){
        UiHelperMethods.enterText(driver, EmailField,10, "customer@email.com");
        UiHelperMethods.enterText(driver, CardNumberField,10, "4242424242424242");
        UiHelperMethods.enterText(driver, ExpireDateField,10, "1256");
        UiHelperMethods.enterText(driver, CvcField,10, "900");
        UiHelperMethods.enterText(driver, NameField,10, "Automation customer");
        UiHelperMethods.enterText(driver, PostCodeField,10, "BT96ER");
        UiHelperMethods.clickElement(driver, PayBtn, 10);
    }
}
