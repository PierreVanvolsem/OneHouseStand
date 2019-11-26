package com.example.demo.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends AbstractPage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage CreateUserTibo(){
        driver.findElement(By.id("username")).sendKeys("tibo");
        driver.findElement(By.id("password")).sendKeys("tibo");
        driver.findElement(By.id("firstName")).sendKeys("tibo");
        driver.findElement(By.id("lastName")).sendKeys("tibo");
        driver.findElement(By.id("email")).sendKeys("tibo@gmail.com");
        driver.findElement(By.name("registreer")).click();
        return new LoginPage(driver);
    }
}
