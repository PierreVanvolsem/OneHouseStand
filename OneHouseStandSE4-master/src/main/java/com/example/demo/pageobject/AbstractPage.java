package com.example.demo.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver driver;

    public  AbstractPage(WebDriver driver){
        this.driver = driver;
    }

    public HomePage navigateToHomePage(){
        driver.navigate().to("http://localhost:8080/");
        return new HomePage(driver);
    }

    public String getPageText(){
        return  driver.findElement(By.tagName("body")).getText();
    }

    public LoginPage navigateToLoginPage(){
        driver.navigate().to("http://localhost:8080/login");
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .textToBePresentInElementLocated(By.tagName("body"), "login page"));
        return new LoginPage(driver);
    }

    public void logout(){
        driver.findElement(By.name("logout")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .textToBePresentInElementLocated(By.tagName("body"), "Je bent uitgelogd"));
    }

    public  void closeBrowser(){
        driver.quit();
    }
}
