package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends Utils {

    private By _genderFemale = By.id("gender-female");
    private By _firstname = By.id("FirstName");
    private By _lastname = By.id("LastName");
    private By _dateOfBirthDay = By.name("DateOfBirthDay");
    private By _dateOfBirthMonth = By.name("DateOfBirthMonth");
    private By _dateOfBirthYear = By.name("DateOfBirthYear");
    private By _Email = By.id("Email");
    private By _Password = By.id("Password");
    private By _ConfirmPassword = By.id("ConfirmPassword");
    private By _registerbutton = By.id("registerbutton");

    public void userEnterRegistrationDetails() {
        //select gender male or female Radio button
        clickOnElement(_genderFemale); //radio button

        //Enter First Name------------------------
        //
        typeText(_firstname, "Hetal");

        //Enter Last Name-------------------------
        typeText(By.id("LastName"), "Patel");

        //Date of birth day----------------------
        Select birthDay = new Select(driver.findElement(By.name("DateOfBirthDay")));//select on the day
        birthDay.selectByIndex(24);

        //Date of birth month---------------------
        Select birtMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));//select on month
        birtMonth.selectByIndex(8);

        //Date of birth year--------------------
        Select birthYear = new Select(driver.findElement(By.name("DateOfBirthYear")));//select on year
        birthYear.selectByVisibleText("1990");

        //Enter Email----------------------------
        System.out.println(RandomDate());
        typeText(By.id("Email"), "hetal.patel" +RandomDate() + "@gmail.com");//without locater

        //Enter password
        typeText(_Password,"Test1234" );

        //Enter confirm password
        typeText(_ConfirmPassword,"Test1234" );

        //Click on register button------------------------
        //
        clickOnElement(By.id("register-button"));
    }
}