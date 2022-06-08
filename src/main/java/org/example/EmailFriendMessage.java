package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class EmailFriendMessage extends Utils{


    public void userEmailAFriend(){
        //email a friend

        String actualMessage = driver.findElement(By.className("result")).getText();

        String expectedMessage = "Your message has been sent.";

        Assert.assertEquals(actualMessage, expectedMessage, " your message has not been sent");

        System.out.println("messege sent");
    }
}
