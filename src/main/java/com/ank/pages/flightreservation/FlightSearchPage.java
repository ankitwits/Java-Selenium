package com.ank.pages.flightreservation;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ank.CommonPage;

public class FlightSearchPage extends CommonPage{
     @FindBy(id = "passengers")
    private WebElement passengerSelect;

     @FindBy(id = "search Flights")    
    private WebElement searchFlightsButton;

  // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  // WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Search Flights']")));

    public FlightSearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.passengerSelect));
        return this.passengerSelect.isDisplayed();
    }

    public void selectPassengers(String noOfPassengers){
        Select passengers = new Select(this.passengerSelect);
        passengers.selectByValue(noOfPassengers);
    }

    public void searchFlights(){

       // System.err.println("elemnt found:"+ element.getText());
       // this.element.click();

        WebElement element = driver.findElement(By.xpath("//button[text()='Search Flights']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

}   
