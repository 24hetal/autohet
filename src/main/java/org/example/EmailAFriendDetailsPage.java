package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

import static org.example.BasePage.driver;
import static org.example.Utils.clickOnElement;
import static org.example.Utils.typeText;

public class EmailAFriendDetailsPage {
    public void UserCanEmailADetailsOnThisPage()
    {
        //email a friend details
        typeText(By.xpath("//*[@id=\"FriendEmail\"]"),"zzz@yaoo.com");

        //your email address
       // typeText(By.id("YourEmailAddress"),"");

        //personal message
        //driver.findElement(By.xpath("//*[@id=\"PersonalMessage\"]")).sendKeys("GOOD PRODUCT TO BUY");
        typeText(By.id("PersonalMessage"),"GOOD PRODUCT TO BUY");

        //click on send email Button
        clickOnElement(By.name("send-email"));

        //check  verify message sent
        String actualMessage = driver.findElement(By.className("result")).getText();
        String expectedMessage = "Your message has been sent.";
        Assert.assertEquals(actualMessage, expectedMessage, " your message has not been sent");
        System.out.println("message sent");
    }
}

