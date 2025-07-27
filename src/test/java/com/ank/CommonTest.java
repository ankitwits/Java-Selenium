package com.ank;

import java.nio.charset.MalformedInputException;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;

import java.net.MalformedURLException;
import java.net.URL;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class CommonTest {

    protected WebDriver driver;

    @BeforeTest
    public void setDriver() throws MalformedURLException
    {
        if(Boolean.getBoolean("selenium.grid.enabled"))
        {
          this.driver=getDriverfroseleniumgrid();
        }

        else{this.driver= getdriverforLocalRun();}
        this.driver=new ChromeDriver();

    }

    @SuppressWarnings("deprecation")
    private WebDriver getDriverfroseleniumgrid() throws  MalformedURLException
    {

        Capabilities capabilties;

        if (System.getProperty("browser").equals("chrome"))
        {
            capabilties = new ChromeOptions();            
        }
        else { capabilties = new EdgeOptions();
        }
         return new RemoteWebDriver(new URL("http://localhost:4444"), capabilties);
        
    }

    private WebDriver getdriverforLocalRun()
    {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    @AfterTest
    public void quitdriver()
    {
        this.driver.quit();
    }
}
