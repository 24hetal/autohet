package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepDefs {
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationSuccessPage registrationSuccessPage = new RegistrationSuccessPage();

    @Given("I am on registration page")
    public void i_am_on_registration_page() {
        // Write code here that turns the phrase above into concrete actions
       homePage.clickOnRegisterButton();
    }
    @When("I enter required registration details")
    public void i_enter_required_registration_details() {
        // Write code here that turns the phrase above into concrete actions
        registrationPage.userEnterRegistrationDetails();
    }
    @When("I click on register submit button")
    public void i_click_on_register_submit_button() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("I should able to registered successfully")
    public void i_should_able_to_registered_successfully() {
        // Write code here that turns the phrase above into concrete actions
      registrationSuccessPage.verifyUserRegistrationSuccessfully();

    }
    @Given("I am on homepage page")
        public void i_am_on_homepage_page() {
            // Write code here that turns the phrase above into concrete actions
            homePage.verifyuserOnHomepage();
    }
    @When("I click on \"<category_name>\" link from top menu header")
        public void i_click_on_link_from_top_menu_header(String category_name) {
            // Write code here that turns the phrase above into concrete actions
            homePage.clickOnCategoryLink(category_name);
    }
    @Then("I should able to successfully navigated {string} with same category name")
        public void i_should_able_to_successfully_navigated_with_same_category_name(String category_url) {
            // Write code here that turns the phrase above into concrete actions

        Utils.verifyCurrentUrl(category_url);
    }

    }


