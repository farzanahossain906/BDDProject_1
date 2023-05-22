Feature: category

  Background:
    Given I am on demonopcommerce home page

    @category
    Scenario Outline:
      When I click on "<button_name>" button
      When I do hover action
      Then I should be able to verify that I am navigated to related page "<page_url>" successfully
      And I should be able to verify that the page title is "<page_title>"
      Examples:
        | button_name       | page_url                                       | page_title        |
        | Computers         | https://demo.nopcommerce.com/computers         | Computers         |
#        | Electronics       | https://demo.nopcommerce.com/electronics       | Electronics       |
#        | Apparel           | https://demo.nopcommerce.com/apparel           | Apparel           |
#        | Digital downloads | https://demo.nopcommerce.com/digital-downloads | Digital downloads |
#        | Books             | https://demo.nopcommerce.com/books             | Books             |
#        | Jewelry           | https://demo.nopcommerce.com/jewelry           | Jewelry           |
#        | Gift Cards        | https://demo.nopcommerce.com/gift-cards        | Gift Cards        |

  @hoverCategory
  Scenario: hoverActions
  When I hover over "Computers" category link
  When I click "Notebooks" link
  Then I should be able to verify that I am navigated to "/notebook" page

