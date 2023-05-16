package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class MyStepDetails {
    HomePage homePage=new HomePage();
    RegistrationPage registrationPage=new RegistrationPage();
    RegistrationResultPage registrationResultPage=new RegistrationResultPage();
    BuildAComputer buildAComputer=new BuildAComputer();
    ReferAProduct referAProduct=new ReferAProduct();
    RegistrationDetailsForLogin registrationDetailsForLogin=new RegistrationDetailsForLogin();
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


}
