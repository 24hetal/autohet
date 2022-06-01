package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestSuit extends BaseTest {

    HomePage homePage = new HomePage();

    RegistrationPage registrationPage = new RegistrationPage();

    RegistrationSuccessPage registrationSuccessPage = new RegistrationSuccessPage();

    ShoppingCart shoppingCart = new ShoppingCart();
    BuildYourOwnComputerPage buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    EmailAfriend emailAfriend = new EmailAfriend();
    EmailAFriendDetailsPage emailAFriendDetailsPage = new EmailAFriendDetailsPage();
    CurrencySuccessPage currencySuccessPage = new CurrencySuccessPage();

    // all your test cases with @Test#

    @Test
    public void userShouldBeAbleToRegisterSuccessfully() {
        // click on register button//////////////////
        homePage.clickOnRegisterButton();
        //enter registration details
        registrationPage.userEntersRegistrationDetails();
        // verify user registered successfully
        registrationSuccessPage.verifyUserRegisteredSuccessfully();
    }

    @Test
    public void userShouldBeAbleToAddProductToAddToCart() {
        homePage.clickOnComputers();
        homePage.clickOnDesktop();
        buildYourOwnComputerPage.BuildYourOwnComputerPage();
        shoppingCart.UserAddedProductToShoppingCart();

    }

    @Test
    public void userShouldBeAbleToSReferAProductToAFriendThrouhEmail() {
        homePage.clickOnComputers();
        homePage.clickOnDesktop();
        buildYourOwnComputerPage.BuildYourOwnComputerPage();
        emailAfriend.userEmailAFriend();
        emailAFriendDetailsPage.UserCanEmailADetailsOnThisPage();

    }

    @Test
    public void CurrencyForProduct() {
        //select currency
        homePage.clickOnCurrency();
        currencySuccessPage.userCanSeeMessage();
    }

        @Test
        public void registerUserShouldBeAbleToVote(){

                //Verify that user is not able to vote without being registered
            homePage.verifyWithoutRegisterUserAbleToVote();

                //click on register button
            homePage.clickOnRegisterButton();

            // click on register button//////////////////
            homePage.clickOnRegisterButton();
            //enter registration details
            registrationPage.userEntersRegistrationDetails();
            // verify user registered successfully
            registrationSuccessPage.verifyUserRegisteredSuccessfully();
                //verify registered user is able to vote
            homePage.verifyWithoutRegisterUserAbleToVote();

    }

    }



