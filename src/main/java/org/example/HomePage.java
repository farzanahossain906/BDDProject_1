package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage extends Utils {
    private By _registerButton = By.xpath("//a[@href=\"/register?returnUrl=%2F\"]");

    public void clickOnRegisterButton() {
        //click register button
        clickElement(_registerButton);
    }
    private By _continueButton = By.xpath("//a[@class='button-1 register-continue-button']");

    public void clickContinue() {
        //click continue button
        clickElement(_continueButton);
    }

    private By _addToCartBuildComputer = By.xpath("//div[@class='buttons']//button[@class='button-2 product-box-add-to-cart-button']");

    public void addToCartBuildAComputer() {
        //add to cart build a product button
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));
        clickElement(_addToCartBuildComputer);

    }
    public void hoverAction(String category){
        WebElement element= driver.findElement(By.linkText(category));
        System.out.println("Before hover color of category: "+element.getCssValue("color"));

        Actions action=new Actions(driver);
        action.moveToElement(element).perform();

        System.out.println("After hover color of category: "+element.getCssValue("color"));

        action.moveToElement(driver.findElement(By.linkText("Notebooks"))).perform();


    }
    public void verifySubCategory(String subcategory){
        clickElement(By.linkText(subcategory));
    }
    public void verifySubCategoryPageUrl(String subcategoryUrl){
        Assert.assertTrue(getUrl().contains(subcategoryUrl));
    }



}
