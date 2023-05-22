package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.apache.commons.io.FileUtils;



public class Utils extends DriverManager {
    static Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    public static void clickElement(By by) {
        driver.findElement(by).click();
    }

    public static void textType(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public static String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public static long timeStamp() {
        Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
        return timestamp1.getTime();
    }
    public static void selectElementByText(By by, String text) {
        Select selectText = new Select(driver.findElement(by));
        selectText.selectByVisibleText(text);

    }

    public static void selectElementFromIndex(By by, int number) {
        Select selectIndex = new Select(driver.findElement(by));
        selectIndex.selectByIndex(number);
    }

    public static void selectElementFromValue(By by, String value) {
        Select selectValue = new Select(driver.findElement(by));
        selectValue.selectByValue(value);
    }

    public static void waitForClickable(By by, int timeInSec) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSec));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public static String getUrl() {
        return driver.getCurrentUrl();
    }
    public static String currentTimeStamp() {
        Date date = new Date();
        SimpleDateFormat sdf = new
                SimpleDateFormat("DdMmYyHhSs");
        return sdf.format(date);

    }

    public static void captureScreenshot( String fileName)
    {
//Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot
                =((TakesScreenshot)driver);
//Call getScreenshotAs method to create image file
        File
                SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
//Move image file to new destination
        File destFile=new
                File("src\\test\\Screenshots\\"+fileName+""+currentTimeStamp()
             +".png");
//Copy file at destination
        try {
            FileUtils.copyFile(SrcFile, destFile);
//            FileUtils.copyFile(SrcFile, destFile );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}