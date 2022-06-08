package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class CurrencySuccessPage extends Utils {
    public void userCanSeeMessage() {
        String expectedMessage = "$1,200.00";
        String actualMessage = driver.findElement(By.xpath("//span[contains(text(),'$1,200.00')]")).getText();
        System.out.println("Actual message:" + actualMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "price not matched");
    }
}