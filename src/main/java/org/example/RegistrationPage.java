package org.example;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;


public class RegistrationPage extends Utils {

    LoadProp loadProp = new LoadProp();

    private By _radiobutton = By.xpath("//input[@id=\"gender-female\"]");
    private By _firstname = By.xpath("//input[@name='FirstName']");
    private By _lastname = By.id("LastName");
    private By _dateOfBirth = By.name("DateOfBirthDay");
    private By _dateOfBirthMonth = By.name("DateOfBirthMonth");
    private By _dateOfBirthyear = By.name("DateOfBirthYear");
    private By _Email = By.id("Email");
    private By _password = By.id("Password");
    private By _confirmPassword = By.id("ConfirmPassword");
    private By _registerButton = By.id("register-button");


    public void verifyUserIsOnRegistrationPage() {
        String actualRegistrationUrl = driver.getCurrentUrl();
        //Assert.assertTrue(actualRegistrationUrl.contains("registration"), " negative your registration url ");
        Assert.assertTrue(driver.getCurrentUrl().contains(loadProp.getProperty("UserIsOnRegisterPageContains")));
    }

    public void userEntersRegistrationDetails() {
        try {
            Thread.sleep(Long.parseLong("300"));
        }catch (InterruptedException e){

        }
        //select gender  female Radio button//////////////////////
        clickOnElement(_radiobutton);
        // enter firstname///////////////////////
        typeText(_firstname, loadProp.getProperty("FirstName"));
        //enter LastName;
        typeText(_lastname, loadProp.getProperty("LastName"));

        // select birthdate ////////////////
        Select BirthDay = new Select(driver.findElement(_dateOfBirth));
        BirthDay.selectByValue("24");
        // selectByDropdownIndexValue()
        //select month
        Select BirthMonth = new Select(driver.findElement(_dateOfBirthMonth));
        BirthMonth.selectByValue("8");

        //select year;
        Select BirthYear = new Select(driver.findElement(_dateOfBirthyear));
        BirthYear.selectByVisibleText("1984");

        //enter email address
        //typeText(By.id("Email"),"hetalpatel@gmail.com"+RandomDate() + "@gmail.com");
        //typeText(_Email,loadProp.getProperty("hetalpatel@gmail.com"+RandomDate() + "@gmail.com"));
//       driver.findElement(By.id("Email")).sendKeys("hetalpatel@gmail.com");
        //driver.findElement(By.id("Email")).sendKeys("hetal" + RandomDate() + "gmail.com");
        ////// typeText(_Email,(Email)); //("hetalpatel@gmail.com"));
        String email = loadProp.getProperty("Email1") + RandomDate() + loadProp.getProperty("Email2");
        System.out.println(email);
        typeText(By.id("Email"), email);


        // enter password
//
        typeText(_password, loadProp.getProperty("Password"));//hetal1234

        //confirm password
//
        typeText(_confirmPassword, loadProp.getProperty("ConfirmPassword"));//"hetal1234"

        //click register button

        clickOnElement(By.xpath("//button[@id=\"register-button\"]"));
        //clickOnElement(_registerButton,loadProp.getProperty("RegisterButton"));
    }
}
