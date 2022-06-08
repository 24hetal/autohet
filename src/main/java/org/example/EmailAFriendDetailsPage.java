package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

import static org.example.BasePage.driver;
import static org.example.Utils.clickOnElement;
import static org.example.Utils.typeText;


public class EmailAFriendDetailsPage {
    public void UserCanEmailADetailsOnThisPage()
    {

        //email a friend BUTTON
        clickOnElement(By.xpath("//button[@class=\"button-2 email-a-friend-button\"]"));

        //email a friend details
        typeText(By.xpath("//*[@id=\"FriendEmail\"]"),"zzz@yaoo.com");

        //your email address

        typeText(By.xpath("//*[@id=\"YourEmailAddress\"]"),"");

        //personal message
        typeText(By.id("PersonalMessage"),"GOOD PRODUCT TO BUY");

        //click on send email Button
        clickOnElement(By.name("send-email"));

    }
}

