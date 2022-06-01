package org.example;

import org.openqa.selenium.By;

public class EmailAfriend extends Utils{

    public void userEmailAFriend(){
        //email a friend
        clickOnElement(By.xpath("//button[@class=\"button-2 email-a-friend-button\"]"));
    }
}
