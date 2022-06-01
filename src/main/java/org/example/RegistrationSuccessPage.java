package org.example;
import org.testng.Assert;
import org.openqa.selenium.By;

public class RegistrationSuccessPage extends Utils{


    public void verifyUserRegisteredSuccessfully(){

        // result verification/////////////////////
        //  String actualMessage = getTextFromElement(By.className("result"));

        String actualMessage = driver.findElement(By.xpath("//div[contains(text(),\"Your registration completed\")]")).getText();
        String expectedMessage = "Your registration completed";
        //System.out.println("Actual Message:" + actualMessage);
        Assert.assertEquals(actualMessage,expectedMessage,"Registration is not successful");
    }

}
