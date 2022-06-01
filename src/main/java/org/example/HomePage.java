package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HomePage extends Utils {
        public void clickOnRegisterButton() {
            //click on register button
            driver.findElement(By.className("ico-register")).click();
        }
        public void clickOnComputers() {
            //click on computer
            clickOnElement(By.linkText("Computers"));
        }
        public void clickOnDesktop() {

            //click on Desktop
            clickOnElement(By.linkText("Desktops"));
        }

    public void clickOnCurrency(){

    //click on currency
    clickOnElement(By.xpath("//select[@id=\"customerCurrency\"]"));

    //select USDollar
    Select USDollar = new Select(driver.findElement(By.xpath("//select[@name=\"customerCurrency\"]")));
    USDollar.selectByIndex(0);
    clickOnElement(By.xpath("//span[contains(text(),'$1,200.00')]"));

    String expectedMessage  = "$1,200.00";
    String actualMessage = driver.findElement(By.xpath("//span[contains(text(),'$1,200.00')]")).getText();
    System.out.println("Actual message:" +actualMessage);
    Assert.assertEquals(actualMessage,expectedMessage,"price doesnt match");

    Select euro = new Select(driver.findElement(By.xpath("//select[@name=\"customerCurrency\"]")));
    euro.selectByIndex(1);
    clickOnElement(By.xpath("//select[@name=\"customerCurrency\"]"));

    String expectedMessage1 = "€1032.00";
    String actualMessage1 = driver.findElement(By.xpath("//span[contains(text(),'€1032.00')]")).getText();
    System.out.println("Actual Message:"+actualMessage1);
    Assert.assertEquals(actualMessage1,expectedMessage1,"Price does not match");

}

    public void verifyWithoutRegisterUserAbleToVote(){
        //click on radio button of good option//
        clickOnElement(By.id("pollanswers-2"));
        //click on vote button//
        clickOnElement(By.id("vote-poll-1"));

    }


    }