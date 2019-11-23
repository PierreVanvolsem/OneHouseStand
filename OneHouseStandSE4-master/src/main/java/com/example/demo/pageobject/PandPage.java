package com.example.demo.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PandPage extends AbstractPage {
    public PandPage(WebDriver driver) {
        super(driver);
    }

    public PandPage enterAantalPersonenVanReservatie(String aantalpersonen){
        driver.findElement(By.name("aantalPersonen")).sendKeys(aantalpersonen);
        return this;
    }

    public PandPage enterDatumReservatie(String datum){
        driver.findElement(By.name("einddatum")).sendKeys(datum);
        return this;
    }

    public Boolean verifyBestaandereservatie(String reservatie){
        String bodytext = this.getPageText();
        return bodytext.contains(reservatie);
    }

    public PandPage reserveer(){
        driver.findElement(By.name("Reserveer")).click();
        return new PandPage(driver);
    }
}
