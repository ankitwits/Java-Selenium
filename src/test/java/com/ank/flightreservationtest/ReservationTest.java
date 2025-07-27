package com.ank.flightreservationtest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ank.CommonTest;
import com.ank.pages.flightreservation.FlightSearchPage;
import com.ank.pages.flightreservation.RegistrationConfirmationPage;
import com.ank.pages.flightreservation.RegistrationPage;



public class ReservationTest extends CommonTest {
    
   
    private WebDriver driver;
    private String firstName;
    private String lastName;



    @BeforeTest

    @Parameters({"firstName", "lastName"})
    public void setDriver(String firstName , String lastName){

      this.firstName= firstName;
      this.lastName= lastName;
      
     
    }   
    

    @Test
    public void userRegistrationTest(){

       RegistrationPage registrationPage = new RegistrationPage(driver);
      
        registrationPage.goTo("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/reservation-app/index.html");
        Assert.assertTrue(registrationPage.isAt());

        registrationPage.enterUserDetails(firstName, lastName);
        registrationPage.enterUserCredentials("test@gmail.com","paswordtest");
        registrationPage.enterAddress("addresstest","citytest","ziptest");
        registrationPage.register();
      }

     @Test(dependsOnMethods = "userRegistrationTest")
      public void ragistrationconfirmationTest()
      {
       RegistrationConfirmationPage ragistrationconfirmation = new RegistrationConfirmationPage(driver);
       Assert.assertTrue(ragistrationconfirmation.isAt());
       ragistrationconfirmation.goToFlightsSearch();
      }

      @Test(dependsOnMethods = "ragistrationconfirmationTest")
       public void flightsearchTest()
       {

        FlightSearchPage flightsearch = new FlightSearchPage(driver);
        Assert.assertTrue(flightsearch.isAt());
        flightsearch.selectPassengers("2");
        flightsearch.searchFlights();
       }  

   
  
  }
