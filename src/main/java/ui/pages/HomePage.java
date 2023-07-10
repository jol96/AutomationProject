package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.utilities.UiHelperMethods;

public class HomePage {

    WebDriver driver;
    // Locators
    By LoginBtn = By.id("login");
    By LogoutBtn = By.id("logout");
    By ContentManagementDD = By.xpath("//*[contains(text(),'Content')]");
    By Category = By.xpath("//*[contains(text(),'Category')]");
    By CartIcon = By.xpath("//a[contains(@href, 'Cart')]");

    By DetailsBtn;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickLogin(){
        UiHelperMethods.clickElement(driver, LoginBtn, 10);
    }
    public void clickLogout(){
        UiHelperMethods.clickElement(driver, LogoutBtn, 10);
    }

    public void clickContentManagementDD(){
        UiHelperMethods.clickElement(driver, ContentManagementDD, 10);
    }

    public void clickCategory(){
        UiHelperMethods.clickElement(driver, Category, 10);
    }


    public  void clickDetailsBtn(String productName){
        DetailsBtn = By.xpath("//*[contains(text(),'"+productName+"')]//..//../following-sibling::div[*]//*[contains(text(),'Details')]");
        UiHelperMethods.clickElement(driver, DetailsBtn, 20);
    }

    public void clickCartIcon(){
        UiHelperMethods.clickElement(driver, CartIcon, 10);
    }
}
