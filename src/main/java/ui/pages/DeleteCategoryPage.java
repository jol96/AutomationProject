package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.utilities.UiHelperMethods;

public class DeleteCategoryPage {
    WebDriver driver;

    By deleteBtn = By.xpath("//button[contains(text(),'Delete')]");

    public DeleteCategoryPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickDeleteBtn(){
        UiHelperMethods.clickElement(driver, deleteBtn, 10);
    }
}
