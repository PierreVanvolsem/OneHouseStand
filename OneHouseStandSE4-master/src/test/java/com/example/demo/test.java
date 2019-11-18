package com.example.demo;

import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.Gegeven;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class test {
    @Gegeven("^er is een bestaande pand$")
    public void erIsEenBestaandePand() {
        //Creating a driver object referencing WebDriver interface
        WebDriver driver;
        String pathToGeckoDriver = "C:\\Users\\Pierre\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe";

        //Setting webdriver.gecko.driver property
        System.setProperty("webdriver.gecko.driver", pathToGeckoDriver ); //+ "\\geckodriver.exe"

        //Instantiating driver object and launching browser
        driver = new FirefoxDriver();

        //Using get() method to open a webpage
        driver.get("http://localhost:8080/");

        //Closing the browser
        driver.quit();
    }

    @Als("^sdkvjnsdv$")
    public void sdkvjnsdv() {
    }

    @Dan("^sdjkvjskd$")
    public void sdjkvjskd() {
    }
}
