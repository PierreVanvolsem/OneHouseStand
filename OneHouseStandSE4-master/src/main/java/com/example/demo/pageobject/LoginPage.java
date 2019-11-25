package com.example.demo.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(){
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .textToBePresentInElementLocated(By.tagName("body"), "login page"));
        driver.findElement(By.id("username")).sendKeys("tibo");
        driver.findElement(By.id("password")).sendKeys("tibo");
        driver.findElement(By.name("submit")).click();

        new WebDriverWait(driver, 2); //pagina kan varieren, dus kan niet dynamisch
    }

    public PandPage navigateToAanbod(int id){
        driver.navigate().to("http://localhost:8080/pand?id="+id);
        return new PandPage(driver);
    }
}
