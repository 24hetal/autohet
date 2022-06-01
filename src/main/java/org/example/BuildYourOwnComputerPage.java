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
    private By _addtocart = By.xpath("//button[@id=\"add-to-cart-button-1\"]");

    public void BuildYourOwnComputerPage() { //select processor


        Select processor = new Select(driver.findElement(By.name("product_attribute_1")));
        processor.selectByIndex(1);

        //select RAM
        Select ram = new Select(driver.findElement(By.name("product_attribute_2")));
        ram.selectByIndex(1);

        //select HDD
        clickOnElement(By.name("product_attribute_3"));

        //select OS
        clickOnElement(By.name("product_attribute_4"));

        //select software
        List<WebElement> elements = driver.findElements(By.xpath("//input[@name=\"product_attribute_5\"]"));
        System.out.println(Integer.toString(elements.size()));
        for (WebElement el : elements)
            el.click();

            //click add to cart button
            clickOnElement(By.xpath("//button[@id=\"add-to-cart-button-1\"]"));

            //click on add to cart
            clickOnElement(By.xpath("//div/div[1]/div/div[2]/div[3]/div[2]/button[@class=\"button-2 product-box-add-to-cart-button\"]"));
        }

    }
