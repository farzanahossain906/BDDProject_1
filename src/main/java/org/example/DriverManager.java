package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager extends BasePage{
    LoadProp loadProp=new LoadProp();
    String browserName="chrome";
    public void openBrowser(){
        //appropriate browser should open
        if (browserName.equalsIgnoreCase("chrome")){
            driver=new ChromeDriver();
        }else if (browserName.equalsIgnoreCase("firefox")){
            driver=new FirefoxDriver();
        }else if (browserName.equalsIgnoreCase("edge")){
            driver=new EdgeDriver();
        }else {
            System.out.println("The browser name you entered is incorrect."+browserName);
        }
        driver.get(loadProp.getProperty("url"));
        //command to maximize screen
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void closeBrowser() {
        driver.close();
    }
}
