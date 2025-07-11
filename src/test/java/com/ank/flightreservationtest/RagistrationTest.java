package com.ank.flightreservationtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ank.pages.flightreservation.RegistrationPage;

import io.github.bonigarcia.wdm.WebDriverManager;


public class RagistrationTest {

    private WebDriver driver;
    @BeforeTest
    public void setDriver(){

      WebDriverManager.chromedriver().setup();
      this.driver=new ChromeDriver();

    }

    @Test
    public void userRegistrationTest(){

       RegistrationPage registrationPage = new RegistrationPage(driver);
      
        registrationPage.goTo("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/reservation-app/index.html");
        Assert.assertTrue(registrationPage.isAt());

        registrationPage.enterUserDetails("test1", "test2");
        //registrationPage.enterUserCredentials(testData.email(), testData.password());
        //registrationPage.enterAddress(testData.street(), testData.city(), testData.zip());
        registrationPage.register();


    }

}
