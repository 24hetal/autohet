package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;


public class Utils extends BasePage {
    public static void clickOnElement(By by) {
        clickOnElement(by);
    }

    public static void typeText(By by, String text) {
        driver.findElement(by).sendKeys(text);

    }

    public static String getTextFromElement(By by) {
        driver.findElement(by).getText();

        return null;
    }
    //driver.findElement(by).getText()

    public static String RandomDate () {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
        return formatter.format(date);
    }


    public static void DriverWaitsUntillURLTobe ( int time, String url){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
    }

    public static void driverWaitsUntillURLTobeClickable (By by, int time){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void driverWait ( int time, String urlFraction){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlContains(urlFraction));
    }

    public static void driveWait ( int time, String Attribute, String value, By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.attributeContains(by, Attribute, value));
    }

    public static void driverWaitUrlContains ( int time, By by, String urlName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlContains(urlName));
    }

    public static void DriverWaitSelectElement ( int time, By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));

    }

    public static void DriverWaitPresenceOfAllElementsLocatedBy ( int time, By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public static void DriverWaitVisibilityOf ( int time, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public static void DriverWaitUntilInvisibilityOfWebElement ( int time, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }


    public static void DriverWaitElementToBeSelected ( int time, By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeSelected(by));

    }
    public static void DriverWait ( int time, String name){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.titleIs(name));
    }

    public static void takeSnapShot(String a){
        //Convert web driver object to TakeScreenshot

        TakesScreenshot srcShot = ((TakesScreenshot) driver);

        //call getScreenshotAs method to create image file

        File srcFile=srcShot.getScreenshotAs(OutputType.FILE);


        //copy file at destination

        try {
            FileUtils.copyFile( srcFile,new File("Screenshots\\"+a+".png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
