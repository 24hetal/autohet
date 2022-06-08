package org.example;

import org.openqa.selenium.By;

public class BuildComputer extends Utils{
    public void clickOnBuildComputer(){
        clickOnElement(By.xpath("//h2[@class=\"product-title\"]/a[@href=\"/build-your-own-computer\"]"));

    }



}
