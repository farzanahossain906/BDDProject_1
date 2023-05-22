package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class MyStepDetails extends Utils {
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationResultPage registrationResultPage = new RegistrationResultPage();
    BuildAComputer buildAComputer = new BuildAComputer();
    ReferAProduct referAProduct = new ReferAProduct();
    RegistrationDetailsForLogin registrationDetailsForLogin = new RegistrationDetailsForLogin();

    @Given("I am on registration page")
    public void i_am_on_registration_page() {
        homePage.clickOnRegisterButton();

    }

    @When("I enter registration details")
    public void i_enter_registration_details() {
        registrationPage.fillRegistrationDetails();
    }

    @Then("I should be able to registered successfully")
    public void i_should_be_able_to_registered_successfully() {
        registrationResultPage.registrationComplete();
    }

    @Given("I am on the homepage")
    public void i_am_on_the_homepage() {
        homePage.clickOnRegisterButton();
    }

    @When("I enter required registration details")
    public void i_enter_required_registration_details() {
        registrationDetailsForLogin.fillRegistrationDetails();

    }

    @When("I click on continue")
    public void i_click_on_continue() {
        homePage.clickContinue();
    }

    @When("I add build a computer on the cart")
    public void i_add_build_a_computer_on_the_cart() {
        homePage.addToCartBuildAComputer();
    }

    @When("I click on Mail a friend button")
    public void i_click_on_mail_a_friend_button() {
        buildAComputer.clickMailButton();
    }

    @Then("I should be able to send the message successfully")
    public void i_should_be_able_to_send_the_message_successfully() {

        referAProduct.referProductToFriend();

    }
    @Given("I am on demonopcommerce home page")
    public void iAmOnDemonopcommerceHomePage() {

    }
    @When("I do hover action")
    public void i_do_hover_action() {
       homePage.hoverAction("Computers");
    }


    @When("I click on {string} button")
    public void iClickOnButton(String button_name) {
     clickElement(By.xpath("//a[text()='"+button_name+" ']"));
    }

    @Then("I should be able to verify that I am navigated to related page {string} successfully")
    public void iShouldBeAbleToVerifyThatIAmNavigatedToRelatedPageSuccessfully(String page_url) {
        Assert.assertEquals(getUrl(),page_url);

    }

    @And("I should be able to verify that the page title is {string}")
    public void iShouldBeAbleToVerifyThatThePageTitleIs(String page_title) {
     Assert.assertEquals(getTextFromElement(By.tagName("h1")),page_title);
    }
    @When("I hover over {string} category link")
    public void i_hover_over_category_link(String string) {
   homePage.hoverAction("Computers");
    }
    @When("I click {string} link")
    public void i_click_link(String string) {
        homePage.verifySubCategory("Notebooks");
    }
    @Then("I should be able to verify that I am navigated to {string} page")
    public void i_should_be_able_to_verify_that_i_am_navigated_to_page(String string) {
        homePage.verifySubCategoryPageUrl("https://demo.nopcommerce.com/notebooks");
    }


}