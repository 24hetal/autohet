package org.example;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends Utils{


    public void verifyUserIsOnRegistrationPage(){
      String actualRegistrationUrl = driver.getCurrentUrl();

      Assert.assertTrue(actualRegistrationUrl.contains("registration"), " negative your registration url ");
    }
    public void userEntersRegistrationDetails() {

        //select gender  female Radio button//////////////////////
        clickOnElement(By.xpath("//input[@id=\"gender-female\"]"));

        // enter firstname///////////////////////
        //driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("Hetal");
        clickOnElement(By.xpath("//input[@name='FirstName']"));
        typeText(By.xpath("//input[@name='FirstName']"), "Hhhhh");

        //select last name
        //enter lastname
        //driver.findElement(By.id("LastName")).sendKeys("Patel");
        typeText(By.id("LastName"), "Patel");
        clickOnElement(By.id("LastName"));

        // select birthdate ////////////////
        Select birthDay = new Select(driver.findElement(By.name("DateOfBirthDay")));
        birthDay.selectByValue("24");

        //select month
        Select BirthMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        BirthMonth.selectByValue("8");

        //select year;
        Select BirthYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
        BirthYear.selectByVisibleText("1984");

        //enter email address
//       driver.findElement(By.id("Email")).sendKeys("hetalpatel@gmail.com");
        driver.findElement(By.id("Email")).sendKeys("eeeee" + RandomDate() + "gmail.com");
        typeText(By.id("Email"), "hetalpatel@gmail.com");

        // enter password
//        driver.findElement(By.id("Password")).sendKeys("hetalllll");
        //driver.findElement(By.xpath("//input[@id=\"Password\"]")).sendKeys("ooooooooo");
        typeText(By.id("Password"), "hetalllll");

        //confirm password
//        driver.findElement(By.id("ConfirmPassword")).sendKeys("hetalllll");
        // driver.findElement(By.xpath("//input[@id=\"ConfirmPassword\"]")).sendKeys("ooooooooo");
        typeText(By.id("ConfirmPassword"), "hetalllll");

        ///click register button
        // driver.findElement(By.id("register-button")).click();
        //gettext from(By.id("//button[@id=\"register-button\"]"));
        clickOnElement(By.xpath("//button[@id=\"register-button\"]"));
    }}
