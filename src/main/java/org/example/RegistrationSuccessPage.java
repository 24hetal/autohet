package org.example;
import org.testng.Assert;
import org.openqa.selenium.By;


public class RegistrationSuccessPage extends Utils
{
    private By _clickOnContinueButton = By.xpath("//a[@class='button-1 register-continue-button']");

    public void verifyUserRegistrationSuccessfully()
    {
        String actualMassage = driver.findElement(By.className("result")).getText();
        String expectedMassage = "Your registration completed";
        Assert.assertEquals(actualMassage,expectedMassage,"Your registration completed");
    }
//    public void clickOnContinueButton(){
//        //click on continue//
//        clickOnElement(_clickOnContinueButton);
//    }
}
//public class RegistrationSuccessPage extends Utils{
//
//    private By _clickOnContinueButton = By.xpath("//a[@class='button-1 register-continue-button']");
//
//    public void verifyUserRegisteredSuccessfully(){
//
//        // result verification/////////////////////
//        //  String actualMessage = getTextFromElement(By.className("result"));
//
//        String actualMessage = driver.findElement(By.xpath("//div[contains(text(),\"Your registration completed\")]")).getText();
//        String expectedMessage = "Your registration completed";
//        //System.out.println("Actual Message:" + actualMessage);
//        Assert.assertEquals(actualMessage,expectedMessage,"Registration is not successful");
//    }
//    public void clickOnContinueButton(){
//        //click on continue//
//        clickOnElement(_clickOnContinueButton);
//    }
//}

