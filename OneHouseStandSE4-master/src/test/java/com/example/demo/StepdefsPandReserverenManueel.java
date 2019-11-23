package com.example.demo;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import cucumber.api.java.nl.Gegeven;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class StepdefsPandReserverenManueel {
    private WebDriver driver;

    @Before
    public void setUp() {
        //todo clean data

        String pathToGeckoDriver = "C:\\Users\\Pierre\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe";
        //Setting webdriver.gecko.driver property
        System.setProperty("webdriver.gecko.driver", pathToGeckoDriver );
        //Instantiating driver object and launching browser
        driver = new FirefoxDriver();
    }

    @After
    public void end(){
        this.driver.quit();
    }

    @Gegeven("^er is een bestaand pand met id (\\d+) die goedgekeurd is en die geen reservering heeft$")
    public void erIsEenBestaandPandMetIdDieGoedgekeurdIsEnDieGeenReserveringHeeft(int arg0) {
        //run script
    }

    @En("^er is een huurder Tibo ingelogd\\.$")
    public void erIsEenHuurderTiboIngelogd() {
        driver.navigate().to("http://localhost:8080/");

        driver.findElement(By.name("logout")).click();

        new WebDriverWait(driver, 10).until(ExpectedConditions
                .textToBePresentInElementLocated(By.tagName("body"), "Je bent uitgelogd"));
        driver.navigate().to("http://localhost:8080/login");

        new WebDriverWait(driver, 10).until(ExpectedConditions
                .textToBePresentInElementLocated(By.tagName("body"), "login page"));

        driver.findElement(By.id("username")).sendKeys("tibo");
        driver.findElement(By.id("password")).sendKeys("tibo");
        driver.findElement(By.name("submit")).click();

        new WebDriverWait(driver, 2); //pagina kan varieren, dus kan niet dynamisch
    }

    @En("^Tibo is op de pagina van het pand met id (\\d+)$")
    public void tiboIsOpDePaginaVanDePandMetId(int id) {
        driver.navigate().to("http://localhost:8080/pand?id="+id);
    }

    @Als("^Tibo het veld \"([^\"]*)\" invuld met (\\d+)$")
    public void tiboHetVeldInvuldMet(String elementname, int inhoud) throws Throwable {
        driver.findElement(By.name(elementname)).sendKeys(Integer.toString(inhoud));
    }

    @En("^Tibo het veld \"([^\"]*)\" invuld  met \"([^\"]*)\"$")
    public void tiboHetVeldInvuldMet(String elementid, String inhoud) throws Throwable {
        if (elementid == "einddatum"){
            //inhoud = inhoud.replace("/","");
            //driver.findElement(By.id(elementid)).click();
        }
        driver.findElement(By.id(elementid)).sendKeys("20112020");
    }

    @Dan("^staat er een nieuwe lijn onder Bestaande reservaties met \"([^\"]*)\"$")
    public void staatErEenNieuweLijnOnderBestaandeReservatiesMet(String reservatie) throws Throwable {
        String bodytext = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(bodytext.contains(reservatie));
    }

    @Dan("^staat er op de error pagina \"([^\"]*)\"$")
    public void staatErOpDeErrorPagina(String errorbericht) throws Throwable {
        String bodytext = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(bodytext.contains(errorbericht));
    }

    @Gegeven("^de pand met id (\\d+) heeft één reservatie met datum \"([^\"]*)\" en aantal personen (\\d+)$")
    public void dePandMetIdHeeftÉénReservatieMetDatumEnAantalPersonen(int arg0, String arg1, int arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        //todo script
    }

    @En("^Tibo op reserveer Klikt$")
    public void tiboOpReserveerKlikt() {
        driver.findElement(By.name("submit")).click();
    }


}
