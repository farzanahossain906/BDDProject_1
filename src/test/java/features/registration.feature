Feature: register
  @register
  Scenario: As a user I should be able  tto register successfully so that I can use all user features
    Given I am on registration page
    When I enter registration details
    Then I should be able to registered successfully