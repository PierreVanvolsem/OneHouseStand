package com.example.demo.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PandPage extends AbstractPage {
    public PandPage(WebDriver driver) {
        super(driver);
    }

    public PandPage enterAantalPersonenVanReservatie(int aantalpersonen){
        driver.findElement(By.name("aantalPersonen")).sendKeys(Integer.toString(aantalpersonen));
        return this;
    }

    public PandPage enterDatumReservatie(String inhoud){
        String[] parts = inhoud.split("/");
        inhoud = parts[2] +"-"+parts[1]+"-"+parts[0];
        driver.findElement(By.id("einddatum")).click();
        driver.findElement(By.id("einddatum")).sendKeys(inhoud);
        return this;
    }

    public Boolean verifyBestaandereservatie(String reservatie){
        String bodytext = this.getPageText();
        return bodytext.contains(reservatie);
    }

    public Boolean verifyError(String errormessage){
        String bodytext = this.getPageText();
        return bodytext.contains(errormessage);
    }

    public PandPage reserveer(){
        driver.findElement(By.name("submit")).click();
        return new PandPage(driver);
    }
}
