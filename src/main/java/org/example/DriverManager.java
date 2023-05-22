package org.example;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DriverManager extends BasePage {
    LoadProp loadProp = new LoadProp();

    MutableCapabilities sauceOptions = new MutableCapabilities();
    public String USERNAME = loadProp.getProperty("sauce_username");
    public String ACCESS_KEY = loadProp.getProperty("sauce-Access_key");
    public String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com/wd/hub";
    public boolean SAUCE_LAB = false;
    public String browserName = loadProp.getProperty("Browser");

    public void openBrowser() throws MalformedURLException {
    if (SAUCE_LAB) {
    System.out.println("Running in SauceLab.............with browser" + browserName);
    if (browserName.equalsIgnoreCase("Chrome")) {
    ChromeOptions browserOptions = new ChromeOptions();
    browserOptions.setExperimentalOption("w3c", true);
    browserOptions.setCapability("platformName", "Windows 10");
    browserOptions.setCapability("browserVersion", "112");
    browserOptions.setCapability("sauce:options", sauceOptions);
    try {
        driver = new RemoteWebDriver(new URL(URL), browserOptions);

    } catch (MalformedURLException e) {
        e.printStackTrace();
    }
    }
    else if (browserName.equalsIgnoreCase("Edge")) {
    EdgeOptions browserOptions = new EdgeOptions();
    browserOptions.setExperimentalOption("w3c", true);
    browserOptions.setCapability("platformName", "Windows 11");
    browserOptions.setCapability("browserVersion", "112");
    browserOptions.setCapability("sauce:options", sauceOptions);
    try {
        driver = new RemoteWebDriver(new URL(URL), browserOptions);
    } catch (MalformedURLException e) {
        e.printStackTrace();
    }
    }
    } else {
        if (browserName.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();

        } else if (browserName.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();

        } else {
            System.out.println("Your browser name is wrong or not implemented: " + browserName);
        }

    }
        //maximize the window
        driver.manage().window().maximize();
        //type Url
        driver.get(LoadProp.getProperty("url"));
        //apply the implicitly wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public void closeBrowser() {
    //close the browser
    driver.close();
    }
}

