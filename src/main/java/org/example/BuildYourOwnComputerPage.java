package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BuildYourOwnComputerPage extends Utils {
    private By _processor = By.name("product_attribute_1");
    private By _RAM= By.name("product_attribute_2");
    private By _HDD = By.name("product_attribute_3");
    private By _OS = By.name("product_attribute_4");
    private By _software = By.xpath("//input[@name=\"product_attribute_5\"]");
    private By _addToCart = By.xpath("//button[@id=\"add-to-cart-button-1\"]");

    public void BuildYourOwnComputerPage() { //select processor


        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']"));

        //  click on desktop
        clickOnElement(By.xpath("//img[@alt=\"Picture for category Desktops\"]"));

        //   click on Build your own computer
        clickOnElement(By.xpath("//h2[@class=\"product-title\"]/a[@href=\"/build-your-own-computer\"]"));

        //select on processor 2.2GHZ
        Select Processor = new Select(driver.findElement(By.id("product_attribute_1")));
        Processor.selectByValue("1");

        //select on RAM  2 GB
        Select Ram = new Select(driver.findElement(By.id("product_attribute_2")));
        Ram.selectByValue("3");

        //click on radio 320gb
        clickOnElement(By.xpath("//label[@for=\"product_attribute_3_6\"]"));

        //click on vista primium
        clickOnElement(By.xpath("//label[@for=\"product_attribute_4_9\"]"));

        //tick  on Microsoft Office [+$50.00]
        clickOnElement(By.xpath("//label[@for=\"product_attribute_5_11\"] "));

        //tick  on Acrobat Reader [+$10.00]
        clickOnElement(By.xpath("//input[@value=\"12\"]"));

        //tick on  Total Commander [+$5.00]
        clickOnElement(By.xpath("//button[@id=\"add-to-cart-button-1\"]"));

        //click on Add to CART
        clickOnElement(By.xpath("//span[@class=\"cart-label\"]"));

    }

    }
