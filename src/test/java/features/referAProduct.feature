Feature: referAProduct
  @referAProduct
  Scenario: As a user when I am registered, I should be able to refer a product successfully
    Given I am on the homepage
    When I enter required registration details
    When I click on continue
    When I add build a computer on the cart
    When I click on Mail a friend button
    Then I should be able to send the message successfully
