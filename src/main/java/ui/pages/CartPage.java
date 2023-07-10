package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.utilities.UiHelperMethods;

public class CartPage {
    WebDriver driver;

    By SummaryBtn = By.xpath("//*[contains(text(),'Summary')]");

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickSummaryBtn(){
        UiHelperMethods.clickElement(driver, SummaryBtn,10);
    }

}
