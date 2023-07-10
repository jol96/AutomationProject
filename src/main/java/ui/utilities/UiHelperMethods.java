package ui.utilities;

import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

public class UiHelperMethods {

    protected static final Logger LOGGER = Logger.getLogger(UiHelperMethods.class.getName());
    public static void waitForElementToBeVisible(WebDriver driver, By element, int waitTime){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void waitForElementToBeClickable(WebDriver driver, By element, int waitTime){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void clickElement(WebDriver driver, By element, int waitTime) {
        waitForElementToBeVisible(driver, element, waitTime);
        waitForElementToBeClickable(driver, element, waitTime);
        driver.findElement(element).click();
    }

    public static void enterText(WebDriver driver, By element, int waitTime, String text){
        waitForElementToBeVisible(driver, element, waitTime);
        driver.findElement(element).sendKeys(text);
    }

    public static void clearField(WebDriver driver, By element, int waitTime){
        waitForElementToBeVisible(driver, element, waitTime);
        driver.findElement(element).clear();
    }

    public static void scrollToElementByXPath(WebDriver driver, String xpath) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.evaluate(\"" + xpath + "\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.scrollIntoView();");
    }

    public static void setZoom(WebDriver driver, int zoom){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom = '"+zoom+"%'");
    }

    public static void captureScreenshot(WebDriver driver, Scenario scenario){
        try{
            TakesScreenshot ts =(TakesScreenshot) driver;
            String fileName = "./Screenshots/"+scenario.getName()+"_"+getDateTime()+".png";
            //File source = ts.getScreenshotAs(OutputType.FILE);
            //FileUtils.copyFile(source, new File(fileName));
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", fileName);
            LOGGER.info("Screen shot taken: "+fileName);
        }
        catch(Exception e){
            LOGGER.info("Exception while taking screenshot " +e.getMessage());
        }
    }

    public static String getDateTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyHHmm");
        return now.format(formatter);
    }
}
