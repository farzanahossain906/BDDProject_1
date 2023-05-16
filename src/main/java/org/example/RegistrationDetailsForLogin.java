package org.example;

import org.openqa.selenium.By;

public class RegistrationDetailsForLogin extends Utils{
    LoadProp loadProp=new LoadProp();
    //declaring x path locators
    private By _firstname=(By.xpath("//div[@class=\"inputs\"][2]//input[@type='text']"));
    private By _lastName=(By.id("LastName"));
    private By _email=(By.xpath("//div[@class=\"inputs\"][4]//input[@type=\"email\"]"));
    private By _password=(By.xpath("//input[@type=\"password\"][1]"));
    private By _confirmPassword=(By.id("ConfirmPassword"));
    private By _clickSubmitButton =(By.xpath("//div[@class='buttons']//button[@type='submit']"));
    private By _selectGender=(By.xpath("//span[@class='female']//input[@id='gender-female']"));
    private By _selectDate=(By.xpath("//select[@name='DateOfBirthDay']"));
    private By _selectMonth=(By.xpath("//select[@name='DateOfBirthMonth']"));
    private By _selectYear=(By.xpath("//select[@name='DateOfBirthYear']"));

    public void fillRegistrationDetails(){
        //selecting gender

        //type firstname
        textType(_firstname, loadProp.getProperty("firstName"));
        //type last name
        textType(_lastName,loadProp.getProperty("lastName"));
        //select date of birth
        selectElementFromIndex(_selectDate, Integer.parseInt(loadProp.getProperty("dateOfBirth")));
        selectElementByText(_selectMonth, loadProp.getProperty("monthOfBirth"));
        selectElementFromValue(_selectYear,loadProp.getProperty("yearOfBirth"));

        //type email address
        textType(_email,"test1@gmail.com");
        //type password
        textType(_password,loadProp.getProperty("password"));
        //confirm password
        textType(_confirmPassword,(loadProp.getProperty("confirmPassword")));
        //click on register button
        clickElement(_clickSubmitButton);



    }

}
