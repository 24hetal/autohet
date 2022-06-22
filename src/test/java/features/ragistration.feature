@RegisTestCase
  Feature: Registration

      //regiser  successfully
    Scenario: As a user, i should able to register successfully so that  I can able to use all
            feature on DemoNopCommerce Website

      Given I am on registration page
      When I enter required registration details
      And I click on register submit button
      Then I should able to registered successfully
