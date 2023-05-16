package org.example;


import org.openqa.selenium.By;
import org.testng.Assert;

public class RegistrationResultPage extends Utils{
    String expected="Your registration is completed";
    private By _result=By.xpath("//div[@class=\"result\"]");
    public void registrationComplete(){
        //verifying expected and actual message
        Assert.assertEquals(getTextFromElement(_result),expected);
        System.out.println(_result);


    }
}
