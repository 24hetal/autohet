package org.example;

import org.testng.annotations.Test;

import static java.lang.System.getProperty;

public class TestSuit extends BaseTest {

    HomePage homePage = new HomePage();

    RegistrationPage registrationPage = new RegistrationPage();

    RegistrationSuccessPage registrationSuccessPage = new RegistrationSuccessPage();

    ShoppingCart shoppingCart = new ShoppingCart();

    BuildYourOwnComputerPage buildYourOwnComputerPage = new BuildYourOwnComputerPage();

    EmailFriendMessage emailFriendMessage = new EmailFriendMessage();

    EmailAFriendDetailsPage emailAFriendDetailsPage = new EmailAFriendDetailsPage();

    CurrencySuccessPage currencySuccessPage = new CurrencySuccessPage();

    BuildComputer desktopBuildComputer = new BuildComputer();

    DesktopPage desktopPage = new DesktopPage();

    NopCommerceNewPage nopCommerceNewPage = new NopCommerceNewPage();

    // all your test cases with @Test#

    @Test(priority = 1)
    public void userShouldBeAbleToRegisterSuccessfully() {
        // click on register button
        homePage.clickOnRegisterButton();
        //enter registration details
        registrationPage.userEntersRegistrationDetails();
        // verify user registered successfully
        registrationSuccessPage.verifyUserRegisteredSuccessfully();
    }

    @Test(priority = 2)
    public void userShouldBeAbleToAddProductToAddToCart() {
        //
        homePage.clickOnComputers();
        homePage.clickOnDesktop();
        buildYourOwnComputerPage.BuildYourOwnComputerPage();
        shoppingCart.UserAddedProductToShoppingCart();

    }

    @Test(priority = 3)
    public void userShouldBeAbleToSReferAProductToAFriendThroughEmail() {
        userShouldBeAbleToRegisterSuccessfully();
        homePage.clickOnComputers();
        homePage.clickOnDesktop();
        desktopBuildComputer.clickOnBuildComputer();
        emailAFriendDetailsPage.UserCanEmailADetailsOnThisPage();
        emailFriendMessage.userEmailAFriend();

    }

    @Test(priority = 4)
    public void CurrencyForProduct() {
        //select currency
        homePage.clickOnCurrency();

    }

    @Test(priority = 5)
    public void registerUserShouldBeAbleToVote() {
        homePage.verifyIfNonRegisteredUserIsAbleToVote();
        userShouldBeAbleToRegisterSuccessfully();
        homePage.verifyRegisteredUserIsAbleToVote();
    }

    @Test(priority = 6)
    public void productTitle() {
        // get product title
        homePage.getProductTitle();
    }

//    public void verifyMyLoadProp(){
//        System.out.println( getProperty("url"));

    @Test (priority = 7)
    public void userShouldBeAbleToSeePopUp(){
        // verify user can see alert popup
        homePage.voteAlertPopup();
    }

    @Test (priority = 8)

    //click on facebook icon
    public void UserShouldBeAbleToNavigateToTheFacebookPage(){
        homePage.ClickOnFacebookIcon();
    }


    @Test (priority = 9)
    //search text box enter nike
    public void UserShouldBeAbleToSearchProductByProductName(){
        homePage.enterWordInSearchTextBox("Nike"); //Apple
    }

    @Test
    //user able to sort by product by Z to A
    public void UserShouldBeAbleToVerifyProductAccordingAlphabeticallyZToA(){
        homePage.clickOnComputers();
        homePage.clickOnDesktop();
        //select Z to A option in sort by
        desktopPage.clickOnSortByZtoAOption();
        //verify all product in Z to A
        desktopPage.verifyProductListInZtoAFormat();

    }
    @Test (priority = 10)
    public void verifyUsersCommentHasSuccessfullyAddedTotheCommentList(){

        //NonCommerceNewRelease
        homePage.clickOnDetailsButtons();
        //nopcommerce new release assert Point
        nopCommerceNewPage.checkURLOfThePage();
        //Enter Title
        nopCommerceNewPage.enterTitle();
        //Enter comment
        nopCommerceNewPage.enterComment();

    }
}








